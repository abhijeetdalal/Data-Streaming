# Data Streaming Producer
This project contains Spring boot application that represents the Stream producer

**Running locally:** (Maintain sequence of execution for smooth start!)
* Download [Apache ZooKeeper](https://zookeeper.apache.org/) -> [Here!](https://zookeeper.apache.org/releases.html)
  * Running ZooKeeper: 
    On cmd/terminal, change directory to zookeeper bin directory and run below command
    ````
       > zkServer
    ````
* Download [Apache Kafka](https://kafka.apache.org/) -> [Here!](https://kafka.apache.org/downloads)
  * Running Kafka: On cmd/terminal, change directory to kafka home directory and run below command
    ````
    > .\bin\windows\kafka-server-start .\config\server.properties
    ````
* Run this spring boot application
  * Pre-requisite: 
  * A [web socket server](./../websocket-server), which this application will listen to.
  * Put the web socket URL as value of variable -> [MEETUP_RSVPS_ENDPOINT](src/main/java/com/data/stream/DataStreamProducerApplication.java) 
  * Run the spring boot application
  ````
      > mvn clean install
      > java -jar target/dataStreamProducer-0.0.1-SNAPSHOT.jar
  ````
