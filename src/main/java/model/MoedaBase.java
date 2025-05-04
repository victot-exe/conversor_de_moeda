package model;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

public class MoedaBase {

    @SerializedName("conversion_rates")
    private Map<String, Double> conversionRates;

    public MoedaBase(){
        this.conversionRates = new HashMap<>();
    }

    public Map<String, Double> getConversionRates() {
        return conversionRates;
    }

    public void addConversionRate(String moeda, double rate){
        this.conversionRates.put(moeda, rate);
    }

}
