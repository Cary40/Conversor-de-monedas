package org.ConversorMonedas;

public class Conversor {
    public static double convertir(String monedaDestino, double cantidad, ExchangeRateResponse rates) {
        if (!rates.getConversionRates().containsKey(monedaDestino)) {
            System.out.println("Moneda destino no encontrada en la API. Verifique el código ingresado.");
            return -1;  // Valor especial para indicar que la conversión no se pudo realizar
        }
        double tasaDestino = rates.getConversionRates().get(monedaDestino);
        return cantidad * tasaDestino;
    }

    public static void main(String[] args) {
        ExchangeRateResponse rates = ExchangeRateResponse.fromJson(ApiClient.getExchangeRates("USD"));
        double resultado = convertir("XYZ", 10, rates);  // Prueba con una moneda inexistente

        if (resultado != -1) {
            System.out.println("10 USD a XYZ: " + resultado);
        } else {
            System.out.println("No se pudo realizar la conversión.");
        }
    }
}
