## Ticket-5

Add a DELETE endpoint to delete a quiz by ID (from the stub database)

#### Request

`DELETE /api/quiz/:id`

    http DELETE http://localhost:8080/api/quiz/1

#### Response

    204

    404 
    {
      "error": "Quiz not found"
    }


