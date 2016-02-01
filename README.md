# RabbitMq Producer Example

Producer to a RabbitMq Broker (Federated) SSL External configurated, 3 messages and wait for a minute.

Consume with listeners the 3 messages produced in order to verify connection with the broker/s

### Install jar with dependencies

From pom.xml directory

```
mvn clean install
```

Under target directory copy (and rename) SpringRabbitMq-1.0-SNAPSHOT-jar-with-dependencies.jar with all dependencies included in the directory desired in order to execute it.

### Configuration 

This configuration is been showed configurated to DEV-INT Environment by example

Where jar will be executed create by convention a directory called __/var/properties/memento/__ if not exists and locate in: 

* __memento-rabbit-ge-client.keycert.p12__ client certificate .p12 file. 
* __int-memento-full-stack.devopenp.com.keycert.jks__ trusted certificates store in jks. 
* __ssl.properties__ can be copied from /src/main/resources

```
# client certificate store
keyStore=file:/var/properties/memento/memento-rabbit-ge-client.keycert.p12

# java trust store with all the trusted server certificates
trustStore=file:/var/properties/memento/int-memento-full-stack.devopenp.com.keycert.jks

# client certificate password
keyStore.passPhrase=rabbit

# java trust store with all the trusted server certificates password
trustStore.passPhrase=rabbit

# connection addresses hostname:port separated with commas
connection.addresses=52.19.140.69:5673
```

To test with more than one RabbitMQ Federated broker in __connection.addresses__ include all __hostname:port__ brokers separated with commas

For more detail, please see https://redmine.digitalservices.es/projects/event-subscription/wiki/Rabbitmq_ssl

### Execution

```
java -jar SpringRabbitMq-1.0-SNAPSHOT.jar 
```

Output
```
MESSAGE CONSUMED: Message 1 queued with key
MESSAGE CONSUMED: Message 2 queued with key
MESSAGE CONSUMED: Message 3 queued with key
```
After 60 secs program exits(0)
