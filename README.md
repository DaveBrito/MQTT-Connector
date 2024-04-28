# MQTT-Connector

Projeto designado para a disciplina de `Programação para Dispositivos Moveis I` , com orientações e explicações do professor, Paulo Rogerio da Silva.



# Configuração do Cluster
Acesse o site da [HIVEMQ](https://www.hivemq.com/) , faça a criação da sua conta para continuar no processo de conexão do site com o protocolo MQTT, através das etapas a seguir.
- Todas as etapas a seguir foram retiradas da Fonte [Oficial](https://www.hivemq.com/blog/how-to-get-started-with-mqtt/) , caso queria ver e ter mais esclarecimentos. 

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
