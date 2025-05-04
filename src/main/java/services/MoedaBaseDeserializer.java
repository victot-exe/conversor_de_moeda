package services;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import model.MoedaBase;

import java.lang.reflect.Type;
//classe para fazerr a deserialização do obj das moedas
public class MoedaBaseDeserializer implements JsonDeserializer<MoedaBase> {

    @Override
    public MoedaBase deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context){
        JsonObject obj = json.getAsJsonObject();//aqui pegamos a string e a transformamos toda em um objeto json com todos os campoos
        JsonObject conversionRates = obj.getAsJsonObject("conversion_rates");//aqui pegamos apenas o objeto referente as conversion rates para conseguir acessar as moedas

        return new MoedaBase(
                conversionRates.get("USD").getAsDouble(),
                conversionRates.get("EUR").getAsDouble(),
                conversionRates.get("JPY").getAsDouble(),
                conversionRates.get("CNY").getAsDouble(),
                conversionRates.get("GBP").getAsDouble(),
                conversionRates.get("CHF").getAsDouble(),
                conversionRates.get("BRL").getAsDouble()
        );
    }
}
