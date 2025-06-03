# Jest Snapshot Tests für Mock API

Dieses Projekt enthält Snapshot-Tests für die Mock API, die mit Jest und Supertest implementiert wurden.

## Voraussetzungen

- Node.js (Version 14 oder höher)
- npm (wird mit Node.js installiert)
- Die Spring Boot Mock API muss auf http://localhost:8080 laufen

## Installation

```bash
# Abhängigkeiten installieren
npm install
```

## Ausführung der Tests

```bash
# Tests ausführen
npm test

# Snapshots aktualisieren (falls sich die API-Antworten geändert haben)
npm run test:update
```

## Teststruktur

Die Tests befinden sich im Verzeichnis `src/__tests__/` und testen folgende Endpunkte:

- GET /api/customers/1
- GET /api/orders/1
- GET /api/products/1
- GET /api/categories
- GET /api/statistics

Die Snapshots werden automatisch im Verzeichnis `src/__tests__/__snapshots__/` erstellt.

## Hinweise

- Stellen Sie sicher, dass die Spring Boot App läuft, bevor Sie die Tests ausführen
- Bei Änderungen an der API-Antwort müssen die Snapshots aktualisiert werden
- Das Datum in den Order-Responses wird für konsistente Snapshots normalisiert 