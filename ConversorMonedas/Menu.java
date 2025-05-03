package org.ConversorMonedas;

import java.util.Scanner;

public class Menu {
    public static void mostrarMenu() {
        System.out.println("""
        ***********************************************
        Sea bienvenido/a al Conversor de Moneda =]
        1) Dólar => Peso argentino
        2) Peso argentino => Dólar
        3) Dólar => Real brasileño
        4) Real brasileño => Dólar
        5) Dólar => Peso colombiano
        6) Peso colombiano => Dólar
        7) Salir
        Elija una opción válida:
        ***********************************************
        """);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();  // Limpia el buffer para evitar errores con nextDouble()

            ExchangeRateResponse rates = ExchangeRateResponse.fromJson(ApiClient.getExchangeRates("USD"));

            if (opcion >= 1 && opcion <= 6) {
                System.out.print("Ingrese el monto a convertir: ");
                double monto = scanner.nextDouble();
                scanner.nextLine();  // Limpia el buffer después de ingresar el número

                switch (opcion) {
                    case 1:
                        System.out.println("Resultado: " + Conversor.convertir("ARS", monto, rates) + " Pesos Argentinos");
                        break;
                    case 2:
                        System.out.println("Resultado: " + (monto / rates.getConversionRates().get("ARS")) + " Dólares");
                        break;
                    case 3:
                        System.out.println("Resultado: " + Conversor.convertir("BRL", monto, rates) + " Reales Brasileños");
                        break;
                    case 4:
                        System.out.println("Resultado: " + (monto / rates.getConversionRates().get("BRL")) + " Dólares");
                        break;
                    case 5:
                        System.out.println("Resultado: " + Conversor.convertir("COP", monto, rates) + " Pesos Colombianos");
                        break;
                    case 6:
                        System.out.println("Resultado: " + (monto / rates.getConversionRates().get("COP")) + " Dólares");
                        break;
                }
            } else if (opcion == 7) {
                System.out.println("Saliendo del conversor...");
            } else {
                System.out.println("Opción inválida, por favor ingrese un número del 1 al 7.");
            }
        } while (opcion != 7);

        scanner.close();
    }
}

