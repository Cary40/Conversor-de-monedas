package org.ConversorMonedas;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

public class ApiClient {
    private static String API_KEY;
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    // Cargar API_KEY de config.properties al iniciar la clase
    static {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("src/main/resources/config.properties"));
            API_KEY = properties.getProperty("API_KEY");

            if (API_KEY == null || API_KEY.isEmpty()) {
                throw new IllegalStateException("API_KEY no encontrada en config.properties");
            }
        } catch (IOException e) {
            System.out.println("Error al cargar API_KEY: " + e.getMessage());
        }
    }

    public static String getExchangeRates(String baseCurrency) {
        try {
            String url = BASE_URL + API_KEY + "/latest/" + baseCurrency;

            // Uso de try-with-resources para evitar problemas de gestión de HttpClient
            try (HttpClient client = HttpClient.newHttpClient()) {
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(url))
                        .GET()
                        .build();

                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                if (response.statusCode() != 200) {
                    throw new IOException("Error en la solicitud: Código " + response.statusCode());
                }

                return response.body();
            }
        } catch (Exception e) {
            System.out.println("Error al conectar con la API: " + e.getMessage());
            return "";
        }
    }

    public static void main(String[] args) {
        System.out.println("Probando conexión con la API...");
        String jsonResponse = getExchangeRates("USD");

        if (jsonResponse.isEmpty()) {
            System.out.println( "No se recibió respuesta válida de la API.");
        } else {
            System.out.println("Respuesta obtenida de la API:");
            System.out.println(jsonResponse);
        }
    }
}
