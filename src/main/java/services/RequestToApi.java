package services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.MoedaBase;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RequestToApi {

    //metodo que faz o request para a api e retorna uma string com o response
    private String requestToApi(String uri){

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .build();

        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            return "Ocorreu um erro relacionado a rede";
        } catch (InterruptedException e) {
            return "Ocorreu um erro relacionado a thread do serviço";
        }

        return response.body();
    }

    //metodo que converte a string response de um request para o formato da moeda
    private MoedaBase ConverteStringParaMoedaBase(String body){
        Gson gson = new GsonBuilder().registerTypeAdapter(MoedaBase.class, new MoedaBaseDeserializer()).create();
        return gson.fromJson(body, MoedaBase.class);
    }

    //metodo que junta os dois
    public MoedaBase getMoedaBase(String uri){
        String body = requestToApi(uri);//TODO Tratar o erro de rede ou o relacionado a thread
        return ConverteStringParaMoedaBase(body);
    }
}
