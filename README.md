# MQTT-Connector

Projeto designado para o aprendizado de Broker MQTT (Message Queuing Telemetry Transport) com um servidor do HiveMQ.

# Configuração do Cluster
Acesse o site da [HIVEMQ](https://www.hivemq.com/) , faça a criação da sua conta para continuar no processo de conexão do site com o protocolo MQTT, através das etapas a seguir.
- Todas as etapas a seguir, foram retiradas da [Fonte Oficial](https://www.hivemq.com/blog/how-to-get-started-with-mqtt/), caso queria ver e ter mais esclarecimentos. 

## 1° Etapa de Configuração
Após finalizado o cadastro na plataforma da HIVEMQ, será necessário criar um servidor em nuvem, nossa única opção no momento é o Clouder Provider AWS. 
- Faça a captura da URL, será necessária para realizar a integração com o projeto.
<img src="https://github.com/DaveBrito/MQTT-Connector/raw/main/Cluster-URL.png" width="70%" height="70%">



## 2° Etapa
- Faça a criação do Username e crie uma Senha para ter o acesso.
<img src="https://github.com/DaveBrito/MQTT-Connector/raw/main/CriacaoCredenciais.png" width="70%" height="70%">

- Finalizado a criação, será exibido o username e o tipo de permissão.

<img src="https://github.com/DaveBrito/MQTT-Connector/raw/main/CriacaoFeita.png" width="70%" height="70%">

## 3° Etapa
- Navegando ate a aba de Web Client, terá que fazer o login com suas credenciais criadas no passo anterior.
- Dentro do campo `Topic Subscriptions` , fiz a criação com o nome de `T1` como exemplo para esse projeto.
<img src="https://github.com/DaveBrito/MQTT-Connector/raw/main/WebClient.png" width="70%" height="70%">


# Dependências do Android-Studio
-  Após feito todos os passos dentro do site do HiveMQ, apenas falta as dependências dentro do projeto.
-  Adicione essa implementação dentro do arquivo, `build.gradle.kts`
```kts
dependencies {
    implementation("com.hivemq:hivemq-mqtt-client:1.2.1")
   
}
```

- No arquivo `MainActivity.java` , adicione essas variavéis como globais para fazer a ligação com o Web Client.
```java
private static final String TOPIC = "T1"; // Atribuido o mesmo nome que foi digitado no Topic Subscriptions
 String host = "85365865bf8349b997dc8e88c5337c3a.s1.eu.hivemq.cloud"; //URL 
        String username = "DaviBrito"; 
        String password = "----------"; // Utilize a senha que foi criada no site
```


Além da dependências que foram citadas acima, é necessário adicionar a permissão de uso de internet ao projeto, na aba `AndroidManifest.xml`.
```xml
<manifest
<uses-permission android:name="android.permission.INTERNET" />
</manifest>
```

# Possíveis Erros 

- Durante a criação do projeto, me deparei com o seguinte erro :
```java
2024-04-28 17:30:57.386 16273-16273 libc    com.example.mqtt_connector    E  socket(AF_INET, SOCK_DGRAM | SOCK_CLOEXEC) failed in ifaddrs: Operation not permitted
```
- Esse erro refere-se a operação de permissão negada, consegui resolver apenas adicionando a última dependência de `uses-permission` .


# Exibição de Telas

- Ao iniciar o projeto, será exibido a tela para o Usuário digitar a mensagem desejada, para se comunicar com o site/servidor.
- Ao ser digitado a mensagem por essa tela, é reconhecido e declarado como 'User'. 
<img src="https://github.com/DaveBrito/MQTT-Connector/raw/main/Captura.png" width="40%" height="40%">

## Consultar Envio/Recebimento
- Após feito o envio da mensagem, é feito uma consulta para verificar se a mensagem foi enviada ou recebida como esperado no servidor.
<img src="https://github.com/DaveBrito/MQTT-Connector/raw/main/Exibição-User.png" width="90%" height="90%">

- Será feito o envio de mensagem atráves do servidor, para ter certeza que a mensagem também será recebida e exibida para a tela do usuário.
<img src="https://github.com/DaveBrito/MQTT-Connector/raw/main/Envio-MSG.png" width="70%" height="70%">

- Finalizado a publicação da mensagem pelo servidor, é feito o mesmo passo anterior, verificar o recebimento da mesma como esperado.
<img src="https://github.com/DaveBrito/MQTT-Connector/raw/main/Recebimento-MSG.png" width="40%" height="40%">

  
