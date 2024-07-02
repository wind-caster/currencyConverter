import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Requester {
    String url;
    String userConvertTo;

    public Requester(String userBaseCurrency, String userConvertTo){
        this.url = "https://v6.exchangerate-api.com/v6/8db055f6cf2c058891975e4a/latest/" + userBaseCurrency;
        this.userConvertTo = userConvertTo;
    }//constructor

    public ConversionRates makeRequest(){
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(this.url))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Gson gson = new Gson();

            return gson.fromJson(response.body(), ConversionRates.class);

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }//makeRequest


}//Requester
