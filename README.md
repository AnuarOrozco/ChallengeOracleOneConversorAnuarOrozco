# Currency Converter 💱

## Project Overview

This project is a **currency converter** built using **Java Swing** for the graphical user interface (GUI). It allows users to input an amount and convert it between various currencies, such as **MXN (Mexican Peso)**, **USD (US Dollar)**, **EUR (Euro)**, **GBP (British Pound)**, **JPY (Japanese Yen)**, and **KRW (South Korean Won)**.

## Features

- **User-friendly interface**: Simple GUI to input the amount, select the source and target currencies, and display the converted result.
- **Multiple currency support**: Convert between MXN, USD, EUR, GBP, JPY, and KRW.
- **Real-time conversion**: Instantly calculates the converted amount upon clicking the "Convert" button.
- **Customizable exchange rates**: Exchange rates are predefined but can be easily modified in the source code.

## How It Works

The converter uses hardcoded exchange rates stored in a `HashMap` to perform the conversion between different currencies. Users enter an amount, select the source currency (e.g., MXN), and the target currency (e.g., USD), and the converter returns the converted amount.

### Example

Convert **100 MXN to USD** with an exchange rate of 1 MXN = 0.059 USD:
- Input: 100 MXN
- Output: 5.90 USD

### Technologies Used

- **Java**: Programming language used to build the application.
- **Swing**: Java library for building graphical user interfaces.
- **HashMap**: Used to store the exchange rates.

## File Structure

- `Main.java`: The entry point of the application. It initializes the main window.
- `Ventana.java`: Contains the graphical user interface and the logic for converting currencies.

## Code Example

Here’s the main method that starts the application:

```java
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override   
            public void run() {
                Ventana ventana = new Ventana();
                ventana.setVisible(true);
            }
        });
    }
}
