package com.example.mqtt_connector;

import static com.hivemq.client.mqtt.MqttGlobalPublishFilter.ALL;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.hivemq.client.mqtt.mqtt5.Mqtt5BlockingClient;
import com.hivemq.client.mqtt.mqtt5.Mqtt5Client;

import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {
    private Mqtt5BlockingClient client;
    private TextView textViewMessages;
    private EditText editTextMessage;
    private Button buttonSend;
    private static final String TOPIC = "T1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewMessages = findViewById(R.id.textViewMessages);
        editTextMessage = findViewById(R.id.editTextMessage);
        buttonSend = findViewById(R.id.buttonSend);

        setupMqttClient();

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });

        client.toAsync().publishes(ALL, publish -> {
            String receivedMessage = new String(publish.getPayloadAsBytes(), StandardCharsets.UTF_8);
            runOnUiThread(() -> {
                // Verifica se a mensagem foi enviada pelo usuário ou recebida do site
                if (receivedMessage.startsWith("[User]:")) {
                    // Mensagem enviada pelo usuário
                    textViewMessages.append("\n" + receivedMessage);
                } else {
                    // Mensagem recebida do site
                    textViewMessages.append("\n[Site]: " + receivedMessage);
                }
            });
        });
    }

    private void setupMqttClient() {
        String host = "85365865bf8349b997dc8e88c5337c3a.s1.eu.hivemq.cloud";
        String username = "DaviBrito"; // Seu username
        String password = "--------------"; //Utlize sua senha criada

        client = Mqtt5Client.builder()
                .serverHost(host) // Define o host do servidor
                .serverPort(8883) // Define a porta do servidor
                .sslWithDefaultConfig() // Configuração padrão para SSL
                .buildBlocking(); // Constrói o cliente de forma bloqueante

        client.connectWith()
                .simpleAuth() // Usa autenticação simples
                .username(username) // Define o nome de usuário
                .password(StandardCharsets.UTF_8.encode(password)) // Define a senha
                .applySimpleAuth() // Aplica autenticação
                .send(); // Envia a conexão

        client.subscribeWith()
                .topicFilter(TOPIC) // Inscreve-se no tópico especificado
                .send(); // Envia a inscrição
    }

    private void sendMessage() {
        // Obtém o texto digitado pelo usuário no campo de texto
        String message = editTextMessage.getText().toString();
        if (!message.isEmpty()) {
            String userMessage = "[User]: " + message;     // Formata a mensagem do usuário com o prefixo "[User]: "
            
            client.publishWith() // Publica a mensagem formatada no tópico especificado
                    .topic(TOPIC)
                    .payload(StandardCharsets.UTF_8.encode(userMessage))
                    .send();
            
            editTextMessage.setText("");     // Limpa o campo de texto após o envio da mensagem
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (client != null) {
            client.disconnect();
        }
    }
}
