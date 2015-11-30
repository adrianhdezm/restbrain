# restbrain
Java framework for creating RESTful web services based on Swagger Specifications.

### Prerequisites
You need the following installed and available in your $PATH:

* [Java 7+](http://java.oracle.com)

* [Apache maven 3.0.3 or greater](http://maven.apache.org/)


### Install
```
$ git clone https://github.com/adrianhdezm/restbrain
$ cd restbrain
$ mvn clean install
```

### Usage

```
$ java -jar -Dconfig=./config/inflector.yaml -DswaggerUrl=./config/swagger.yaml ./target/restbrain-0.1.jar 
```