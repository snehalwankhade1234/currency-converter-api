# currency-converter-api
A Spring Boot REST API that converts currencies using a free Exchange Rate API and returns the converted value with the exchange rate.
Currency Converter API

A Spring Boot REST API that converts currencies by consuming a free Exchange Rate API (exchangerate.host). Users can provide a source currency, target currency, and amount, and receive the converted value along with the applied exchange rate.

Key Features:

Converts any currency supported by exchangerate.host.

Provides a clean REST endpoint (/currency/convert).

Uses a layered architecture: controller → service → client → model.

Returns detailed conversion info including original amount, converted amount, and exchange rate.

Tech Stack:

Java 17 + Spring Boot

Spring Web & WebFlux (for REST API and WebClient)

Lombok (for DTOs)

Example Request:

POST /currency/convert
{
  "from": "USD",
  "to": "INR",
  "amount": 100
}
Example Response:
{
  "from": "USD",
  "to": "INR",
  "amount": 100.0,
  "convertedAmount": 8350.5,
  "rate": 83.505
}
