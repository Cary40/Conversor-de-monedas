package org.ConversorMonedas;

import java.util.Map;
import com.google.gson.Gson;

public class ExchangeRateResponse {
    private String base_code;
    private Map<String, Double> conversion_rates;

    public String getBaseCode() {
        return base_code;
    }

    public Map<String, Double> getConversionRates() {
        return conversion_rates;
    }

    public static ExchangeRateResponse fromJson(String json) {
        return new Gson().fromJson(json, ExchangeRateResponse.class);
    }
}

