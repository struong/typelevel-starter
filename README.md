# Quiz 

A project to learn Typelevel

### Prerequisites
- Scala 2.13.8
- Java 11
- sbt +1.3

### Running the application

```sbt
sbt run
```

### Running the tests

```sbt
sbt test
```

### Existing endpoint:

#### Request

`GET /api/hello`

    curl -i -H 'Accept: application/json' http://localhost:8080/api/health
    http http://localhost:8080/api/hello/test-name (httpie) 

#### Response 
    200 
    {
      "message": "Hello, test-name"
    }

### Exercises

Are located in the Tickets folder. 
