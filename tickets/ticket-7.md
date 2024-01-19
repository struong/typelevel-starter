## Ticket-7

Add a GET endpoint to get all quizzes (from the stub database)
We will implement filters later but let's pass them through for now.

#### Request

`GET /api/quiz/all?offset=x&limit=y`

    http http://localhost:8080/api/quiz/all?offset=x&limit=y

#### Response

    200
    [{
      quid-id: uuid,
      name: "test-quiz-1"
      description: "test-description",
      ...,
      quid-id: uuid,
      name: "test-quiz-2"
      description: "test-description",
      ...,
    }]

