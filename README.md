# Mock API with Jest Snapshot Tests

This project contains a mock API implemented in Java with Spring Boot, as well as Jest snapshot tests for the API endpoints.

## Project Structure

- `src/main/java/com/example/mockapi/` - Java Spring Boot API
- `jest-tests/` - Jest Snapshot Tests

## Installation

1. Make sure Java, Maven, and Node are installed
2. In the root directory, run: `mvn clean install`
3. Install the dependencies for Jest: `cd jest-tests && npm install`

## Start the API

1. In the root directory, run: `mvn spring-boot:run`

## Run JEST Tests

1. In `jest-tests/`, run: `npm test`
