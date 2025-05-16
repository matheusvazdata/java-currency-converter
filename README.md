# Currency Converter API

![License](https://img.shields.io/badge/license-MIT-blue.svg) ![Java](https://img.shields.io/badge/Java-14%2B-orange) ![Build](https://img.shields.io/badge/build-Maven-brightgreen)

## 📖 About

Currency Converter API is a Java console application that enables users to convert amounts from USD to multiple currencies using real-time exchange rates fetched from the Exchange Rate API.

This project was developed as part of the **ONE - Oracle Next Education challenge**, showcasing skills in API consumption, JSON parsing with Gson, modular Java programming, and user interaction through a menu-driven interface.

## 🚀 Features

✅ Real-time currency conversion from USD to selected currencies <br>
✅ Interactive menu-driven interface in the terminal <br>
✅ Conversion history with timestamps <br>
✅ Robust input validation and error handling <br>
✅ Clean and modular code architecture (API, Service, Model, Logger) <br>
✅ Extensible for supporting more currencies or new features <br>
✅ Graceful HTTP connection handling

## 💱 Supported Currencies

| Code | Currency Name          |
| ---- | ---------------------- |
| ARS  | Argentine Peso         |
| BOB  | Bolivian Boliviano     |
| BRL  | Brazilian Real         |
| CLP  | Chilean Peso           |
| COP  | Colombian Peso         |
| USD  | United States Dollar   |
| EUR  | Euro                   |
| JPY  | Japanese Yen           |
| GBP  | British Pound Sterling |

## 🔧 Technologies Used

* Java 14+
* Maven
* OkHttp (HTTP Client)
* Gson (JSON Parsing)
* Java Time API (Logging & History)

## 📥 Installation & Usage

### Requirements

* Java 14 or higher
* Maven installed & configured

### Clone the repository

```bash
git clone https://github.com/matheusvazdata/java-currency-converter.git
cd java-currency-converter
```

### Compile the project

```bash
mvn clean install
```

### Run the application

```bash
mvn exec:java -Dexec.mainClass="br.com.matheusvazdata.App"
```

## 💡 Example Usage

```
=== Currency Converter ===
1 - ARS
2 - BOB
3 - BRL
4 - CLP
5 - COP
6 - USD
7 - EUR
8 - JPY
9 - GBP
H - View Conversion History
0 - Exit
Option: 3
Enter the amount in USD: 150
150.00 USD = 841.59 BRL
```

## 📂 Project Structure

```
src/
└── main/
    └── java/
        └── br/
            └── com/
                └── matheusvazdata/
                    ├── App.java
                    ├── api/
                    │   └── ApiClient.java
                    ├── model/
                    │   └── ExchangeRates.java
                    ├── service/
                    │   └── CurrencyConverter.java
                    └── util/
                        └── Logger.java
```

## 📜 License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## 🌐 API Reference

* [Exchange Rate API](https://www.exchangerate-api.com/)

## 👨‍💻 Author

- Matheus Vaz
- [GitHub Profile](https://github.com/matheusvazdata)
- [LinkedIn](https://www.linkedin.com/in/matheusvazdata/)
- [DataCamp Portfolio](https://www.datacamp.com/portfolio/matheusvazdata)
