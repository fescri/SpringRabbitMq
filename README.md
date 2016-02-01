# RabbitMq Producer Example

Producer to a RabbitMq Broker SSL External configurated 3 messages and wait for a minute.

Consume with listeners the 3 messages produced

### Jar with dependencies
```
mvn clean install
```
Under target directory copy (and rename) SpringRabbitMq-1.0-SNAPSHOT-jar-with-dependencies.jar with all dependencies included in the directory desired in order to exec it.

### Configuration

Where jar will be executed create by convention a directory called /var/properties/memento/ if not exists and localize then 
 
* 
* int-memento-full-stack.devopenp.com.keycert.jks 

* 
