import com.fasterxml.jackson.databind.ObjectMapper;
import models.Rates;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientGetExample {
    public static void main(String[] args) {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://api.coingecko.com/api/v3/exchange_rates"))
                .GET()
                .build();

        try{
            var response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            ObjectMapper mapper = new ObjectMapper();

            Rates rates = mapper.readValue(json, Rates.class);

            System.out.println(rates.toString());
            System.out.println("Done!");

        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
