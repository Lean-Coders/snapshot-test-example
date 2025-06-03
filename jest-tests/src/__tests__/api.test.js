const request = require('supertest');

const API_URL = 'http://localhost:8080';

describe('Mock API Snapshot Tests', () => {
  beforeAll(() => {
    // Stelle sicher, dass die Spring Boot App läuft
    console.log('Stelle sicher, dass die Spring Boot App auf http://localhost:8080 läuft');
  });

  describe('Customer Endpoints', () => {
    it('GET /api/customers/1 sollte mit Snapshot übereinstimmen', async () => {
      const response = await request(API_URL)
        .get('/api/customers/1')
        .expect('Content-Type', /json/)
        .expect(200);

      expect(response.body).toMatchSnapshot();
    });
  });

  describe('Order Endpoints', () => {
    it('GET /api/orders/1 sollte mit Snapshot übereinstimmen', async () => {
      const response = await request(API_URL)
        .get('/api/orders/1')
        .expect('Content-Type', /json/)
        .expect(200);

      // ------------------------------------------------------------------------------------------------
      // Bei Orders ist das orderDate nicht konsistent, da es immer das aktuelle Datum ist
      // Es gibt folgende Möglichkeiten, um das Datum zu normalisieren:
      
      // Möglichkeit 1:  Normalisiere das Datum für konsistente Snapshots
      const normalizedResponse = {
        ...response.body,
        orderDate: '2023-01-01T12:00:00'
      };

      expect(normalizedResponse).toMatchSnapshot();
      // ------------------------------------------------------------------------------------------------

      // Möglichkeit 2:  Setze ein Wildcard für das Datum
      expect(response.body).toMatchSnapshot({
        orderDate: expect.any(String)
      });
     
      // ------------------------------------------------------------------------------------------------

    });
  });
    
  describe('Product Endpoints', () => {
    it('GET /api/products/1 sollte mit Snapshot übereinstimmen', async () => {
      const response = await request(API_URL)
        .get('/api/products/1')
        .expect('Content-Type', /json/)
        .expect(200);

      expect(response.body).toMatchSnapshot();
    });
  });

  describe('Category Endpoints', () => {
    it('GET /api/categories sollte mit Snapshot übereinstimmen', async () => {
      const response = await request(API_URL)
        .get('/api/categories')
        .expect('Content-Type', /json/)
        .expect(200);

      expect(response.body).toMatchSnapshot();
    });
  });

  describe('Statistics Endpoints', () => {
    it('GET /api/statistics sollte mit Snapshot übereinstimmen', async () => {
      const response = await request(API_URL)
        .get('/api/statistics')
        .expect('Content-Type', /json/)
        .expect(200);

      expect(response.body).toMatchSnapshot();
    });
  });

  describe('Customer Orders Endpoints', () => {
    it('GET /api/customers/1/orders sollte mit Snapshot übereinstimmen', async () => {
      const response = await request(API_URL)
        .get('/api/customers/1/orders')
        .expect('Content-Type', /json/)
        .expect(200);

      // ------------------------------------------------------------------------------------------------
      // Wir erhalten hier eine Liste von Orders.
      // Wollen wir auch prüfen, ob mindestens 2 Elemente vorhanden sind.
      // Wir wollen testen, ob die Struktur für alle Elemente passt. 
      // ------------------------------------------------------------------------------------------------
      const orders = response.body;
      
      // Teste, ob mindestens 2 Elemente vorhanden sind
      expect(orders.length).toBeGreaterThan(2);
      
      // Teste, ob die Struktur für alle Elemente passt, dabei orderDate ignorieren
      for (const order of orders) {
        expect(Object.keys(order)).toMatchSnapshot();
      }
      // ------------------------------------------------------------------------------------------------
    });
  });
}); 