## Ticket-3

Add a POST endpoint to create a quiz. It will create a new object containing
the quiz information below and create a unique ID for it.

You will need to dive into how JSON is encoded and decoded in http4s (using `circe`):
https://http4s.org/v1/docs/json.html 

Take advantage of using the automatic generic encoder:
```scala
import io.circe.generic.auto._
```

To help you implement the routes, store the information in a stub database for now.

```scala
val database = mutable.Map[UUID, Quiz]()
```

#### Request

`POST /api/quiz/create`

    http http://localhost:8080/api/create
    body: {
      "name": "test-quiz",
      "description": "test-description",
      "questions": [
        {
          "question": "test-question",
          "options": [
            {
              "answer": "test-answer",
              "correct": true
            }, 
            {
              "answer": "test-answer",
              "correct": false
            }
          ]
        }
      ]
    }

#### Response

    200
    {
      quiz-id: uuid
    }
