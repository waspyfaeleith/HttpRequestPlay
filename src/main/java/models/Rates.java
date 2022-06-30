package models;
import java.util.HashMap;

public class Rates {
    private HashMap<String, Currency> rates;

    public Rates() {
    }

    public Rates(HashMap<String, Currency> rates) {
        this.rates = rates;
    }

    public HashMap<String, Currency> getRates() {
        return rates;
    }

    public void setRates(HashMap<String, Currency> rates) {
        this.rates = rates;
    }

    public String toString() {
        String ratesString = "";

        for (var key : this.rates.keySet()) {
            ratesString += String.format("%s :\n", key.toUpperCase());
            ratesString += this.rates.get(key).toString();
        }

        return ratesString;
    }
}
