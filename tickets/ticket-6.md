## Ticket-6

Add a PUT endpoint to update a quiz by ID (from the stub database)

#### Request

`PUT /api/quiz/:id`

    http PUT http://localhost:8080/api/quiz/1
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
      quid-id: uuid,
      name: "test-quiz"
      description: "test-description",
      ...
    }

    404 
    {
      "error": "Quiz not found"
    }
