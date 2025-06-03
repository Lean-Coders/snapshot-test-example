# Mock API mit Jest Snapshot Tests

Dieses Projekt enthält eine Mock API, die in Java mit Spring Boot implementiert ist, sowie Jest Snapshot Tests für die API-Endpunkte.

## Projektstruktur

- `src/main/java/com/example/mockapi/` - Java Spring Boot API
- `jest-tests/` - Jest Snapshot Tests

## Installation

1. Stellen Sie sicher, dass Java, Maven und Node installiert sind
2. Führen Sie im Root-Verzeichnis aus: `mvn clean install`
3. Installieren Sie die Abhängigkeiten für Jest: `cd jest-tests && npm install`

## API starten

1. Führen Sie im Root-Verzeichnis aus: `mvn spring-boot:run`

## JEST-Tests starten

1. Führen Sie in `jest-tests/` aus: `npm test`

