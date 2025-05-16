package convirtiendo;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class conversor {

    private final String API_KEY = "a021b65fe2eafa24f40f9796";
    private final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public float convertir(String monedaOrigen,String monedaDestino, float cantidad) throws IOException, InterruptedException {
        String url = BASE_URL + API_KEY + "/latest/" + monedaOrigen;
        float tasa = 0;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        JsonObject json = gson.fromJson(response.body(), JsonObject.class);

        JsonObject conversionRates = json.getAsJsonObject("conversion_rates");

        if (!conversionRates.has(monedaDestino)) {
            throw new IllegalArgumentException("Moneda no soportada.");
        }

        tasa = conversionRates.get(monedaDestino).getAsFloat();
        return (float) cantidad*tasa;
    }
}
