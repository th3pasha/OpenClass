## Project Setup

```sh 
SSH: git@github.com:th3pasha/OpenClass.git
HTTPS: https://github.com/th3pasha/OpenClass.git
cd OpenClass
mvn clean install compile
mvn spring-boot:run
```

## Database Setup

`````yaml
url: ${DATABASE_URL:jdbc:postgresql://localhost:5432/postgres}
username: ${DATABASE_USER:postgres}
password: ${DATABASE_PASSWORD:root}
platform: postgres
`````

## Swagger documentation

```sh
http://localhost:8080/swagger-ui.html
```