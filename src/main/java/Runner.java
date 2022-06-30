import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

public class Runner {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://api.coingecko.com/api/v3/exchange_rates");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            int status = con.getResponseCode();
            System.out.println(String.format("RESPONSE CODE: %s", status));

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

            System.out.println(String.format("RESPONSE: %s", content));
            con.disconnect();
        }
        catch (Exception ex) {
            System.out.println(String.format("ERROR: %s", ex.getMessage()));
            ex.printStackTrace();
        }

    }
}
