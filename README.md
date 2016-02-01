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

Where jar will be executed create by convention a directory called __/var/properties/memento/__ if not exists and locate it: 
* memento-rabbit-ge-client.keycert.p12 client certificate .p12 file. 
* int-memento-full-stack.devopenp.com.keycert.jks trusted certificates store in jks. 
* ssl.properties can be copied from /src/main/resources


