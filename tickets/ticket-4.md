## Ticket-4

Add a GET endpoint to retrieve a quiz by ID (from the stub database)

#### Request

`GET /api/quiz/:id`

    http http://localhost:8080/api/quiz/1 

#### Response

    200
    {
      quid-id: uuid,
      name: "test-quiz"
      description: "test-description",
      ...
    }

    404 
    {
      "error": "Quiz not found"
    }
