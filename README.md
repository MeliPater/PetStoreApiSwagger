# Petstore server - Home Challenge

The challenge is divided into two tasks, API Test Automation and API Performance Testing, applied to the Swagger Petstore.

## Swagger Petstore information
The sample <a href="https://petstore3.swagger.io">Pet Store server</a> allows managing a pet store with CRUD operations. The service has three main resources shown below.

<details>
<summary>please click here to see...</summary>

```
Swagger Petstore API
│
├── Pet (manages the pet catalog)
│   ├── POST /pet             -> Add a new pet
│   ├── GET /pet/{petId}      -> Obtain a pet by Id
│   ├── PUT /pet              -> Update an existing pet
│   ├── DELETE /pet/{petId}   -> Delete a pet by Id
│   ├── GET /pet/findByStatus -> Obtain a pet by Status
│   └── GET /pet/findByTags   -> Obtain a pet by Tags
│
├── Store (handles orders)
│   ├── POST /store/order             -> Create a new order
│   ├── GET /store/order/{orderId}    -> Obtain order by Id
│   ├── DELETE /store/order/{orderId} -> Delete a order by Id
│   └── GET /store/inventory          -> Obtain pets inventory
│
└── User (manages user accounts)
    ├── POST /user                -> Create a new user
    ├── GET /user/{username}      -> Obtain a user by username
    ├── PUT /user/{username}      -> Update an existing user
    ├── DELETE /user/{username}   -> Delete a user
    ├── POST /user/createWithList -> Create multiple users using a listt
    ├── GET /user/login           -> log in to the system
    └── GET /user/logout          -> log out of the system
```

**To run** the server locally, run this task:

```
mvn package jetty:run
```
</details>

> **To confirm** that the server is up and ready for use, a request to the following URL: http://localhost:8080/api/v3/openapi.json must return a `200 OK` response.

# API Test Automation

### Built with
This project use the following technologies and tools:

- **IDE:** IntelliJ IDEA
- **Design Pattern:** Screenplay
- **Framework:** Serenity BDD
- **Testing Library:** Rest Assured
- **Behavior-Driven Development (BDD):** Cucumber
- **Build Tool:** Gradle 8.5
- **Programming Language:** Java 21
- **Environment:** Local

These resources ensure a structured, scalable, and easy-to-maintain.

