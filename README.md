# Machine Tracking Application

## Overview

This repository contains a Java Spring Boot application for tracking machine events using Kafka

## Prerequisites

Before you begin, ensure you have the following prerequisites:

- **Java Development Kit (JDK)**
- **Apache Kafka**
- **Docker and Docker Compose** 


## Running Kafka

### Start ZooKeeper (if not already running)

```
bin/zookeeper-server-start.sh config/zookeeper.properties
```

### Start Kafka

```
bin/kafka-server-start.sh config/server.properties
```
## Running MySql in Docker 

```
docker run -d --name mysql-machine-events -e MYSQL_ROOT_PASSWORD=mysecretpassword -e MYSQL_DATABASE=machine_events -p 3306:3306 mysql:latest
```

## Application Configuration

Before running the application, make sure to configure the necessary properties in `src/main/resources/application.properties`.


## Build application and Running Locally

Clone this repository:
```
git clone https://github.com/shivudu1994/machine_tracking.git
cd machine-tracking-app
```

Build the application:

```
./mvnw clean install
```

Build the application for docker :
```
docker build -t <your-spring-boot-app-image> .
```
Run the application

```
docker run -p 8080:8080 your-spring-boot-app-image
```

You can run following file to send the messages to Queue

```
src/main/java/com/johndeere/machine_tracking/KafkaProducerExample.java
```


## Testing the Endpoints
You can use tools like Postman or curl to test the following endpoints:

Get aggregated events by session ID:

```
GET http://localhost:8080/aggregated/bySessionId?sessionId=yourSessionId
```
Get aggregated events by machine ID:

```
GET http://localhost:8080/aggregated?machineId=yourMachineId
```

Please feel free to contact me at `sivabathala5279@gmail.com` for queries.
