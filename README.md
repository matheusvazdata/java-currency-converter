# Currency Converter API

![Build](https://img.shields.io/badge/build-success-brightgreen)
![License](https://img.shields.io/badge/license-MIT-blue)
![Java](https://img.shields.io/badge/java-11+-blue)

## 📖 About

**Currency Converter API** is a Java console application that allows users to convert amounts from USD to multiple currencies using real-time exchange rates fetched from the [Exchange Rate API](https://www.exchangerate-api.com/).

This project was developed as part of the **ONE - Oracle Next Education** challenge, demonstrating API consumption, JSON parsing with Gson, and user interaction through a menu-driven interface.

## 🚀 Features

- ✅ Real-time currency conversion from USD to multiple currencies.
- ✅ Dynamic menu-driven interface in the console.
- ✅ Conversion history with timestamps.
- ✅ Robust error handling for invalid inputs.
- ✅ Graceful shutdown of HTTP connections.
- ✅ Modular and clean code architecture.
- ✅ Extensible for adding more currencies or conversion features.

## 💱 Supported Currencies

| Code  | Currency Name         |
|-------|-----------------------|
| ARS   | Argentine Peso        |
| BOB   | Bolivian Boliviano    |
| BRL   | Brazilian Real        |
| CLP   | Chilean Peso          |
| COP   | Colombian Peso        |
| USD   | United States Dollar  |
| EUR   | Euro                  |
| JPY   | Japanese Yen          |
| GBP   | British Pound Sterling|

## 🔧 Technologies Used

- Java 11+
- Maven
- OkHttp (HTTP client)
- Gson (JSON parsing)
- Java Time (for logging and history)

## 📥 Installation & Usage

### Requirements

- Java 11 or higher
- Maven installed and configured

### Clone the repository

```bash
git clone https://github.com/matheusvazdata/java-currency-converter.git
cd java-currency-converter
````

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
...
H - View Conversion History
0 - Exit
Option: 3
Enter the amount in USD to convert: 150
150.00 USD = 841.59 BRL
```

---

## 📂 Project Structure

```
src/
└── main/
    └── java/
        └── br/
            └── com/
                └── matheusvazdata/
                    └── App.java
```

## 📜 License

This project is licensed under the **MIT License**. See the [LICENSE](LICENSE) file for details.

## 🌐 API Reference

* [Exchange Rate API](https://www.exchangerate-api.com/)

## 👨‍💻 Author

- Matheus Vaz
- [GitHub Profile](https://github.com/matheusvazdata)
