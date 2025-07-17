# Java Backend Technical Test
## Description of the service
This service is responsible to control user and their addresses.

## Technologies
- Java 21
- Spring boot
- Docker

## Getting Started
This project is build with Gradle and has support for Docker builds.

The project contains an example file `.env.example` of all environment variables prepared for local development.

```shell
cp .env.example .env
```

### Development requirements
- JVM 21

### Run project locally
To start service with database in docker run:
```shell
docker-compose --env-file .env -f ./Dockerfiles/docker-compose.yml up -d
```

### Running the tests
To start all tests and quality verifications run `./gradlew check`.
Unit/Integration tests can be started separately with `./gradlew test`.

