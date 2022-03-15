Spring Boot API

A simple Spring Boot REST API.

To run, ensure you have Java installed, clone this repo and run:

`./mvnw spring-boot:run`

Then:

`open http://localhost:8080/message`

Routes:

GET ALL: `localhost:8080/message`

GET BY ID: `localhost:8080/message/:id`

POST: `localhost:8080/message` with JSON body `{ "content": "your message here" }`

PUT: `localhost:8080/message/:id` with JSON body `{ "content": "your updated content here" }`

DELETE: `localhost:8080/message/:id`