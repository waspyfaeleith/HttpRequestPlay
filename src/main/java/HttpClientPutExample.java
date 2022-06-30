import com.fasterxml.jackson.databind.ObjectMapper;
import models.Employee;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientPutExample {
    public static void main(String[] args) {
        String putEndpoint = "http://dummy.restapiexample.com/api/v1/update/4710";

        Employee employee = new Employee("Jack Jarvis Esq.", 50000, 82);

        try {

            ObjectMapper mapper = new ObjectMapper();
            String jsonResult = mapper.writeValueAsString(employee);
            System.out.println(jsonResult);

            var request = HttpRequest.newBuilder()
                    .uri(URI.create(putEndpoint))
                    .header("Content-Type", "application/json")
                    .PUT(HttpRequest.BodyPublishers.ofString(jsonResult))
                    .build();

            var client = HttpClient.newHttpClient();

            var response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println(response.statusCode());
            System.out.println(response.body());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
