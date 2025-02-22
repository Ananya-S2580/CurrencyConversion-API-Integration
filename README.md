											Currency Converter API (Spring Boot)
										--------------------------------------------

📌 Project Overview
---------------------

This project is a Spring Boot application that integrates with the ExchangeRate-API to provide real-time currency conversion. Users can:

Fetch exchange rates for a given base currency.

Convert an amount from one currency to another.

Handle API failures and invalid currency inputs gracefully.

🛠 Tech Stack
-----------------

Backend: Java, Spring Boot

HTTP Client: RestTemplate

Build Tool: Maven

Testing: JUnit

IDE: Eclipse

API Used: ExchangeRate-API


⚙️ Configuration
--------------------

Set Up ExchangeRate-API Key

Register at ExchangeRate-API.

Replace YOUR_API_KEY in application.properties:
		exchange.rate.api.url=https://v6.exchangerate-api.com/v6/YOUR_API_KEY/latest/
		
