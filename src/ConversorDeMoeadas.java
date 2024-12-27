import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorDeMoeadas {
    private String moedaConversao;
    private String moedaAlvo;
    private String valor;
    private String moedaConvertida;

    public void setMoedaConvertida(String moedaConvertida){
        this.moedaConvertida = moedaConvertida;
    }


    public String getMoedaConversao() {
        return moedaConversao;
    }

    public String getMoedaAlvo() {
        return moedaAlvo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor){
        this.valor = valor;
    }



    public void converterMoeda(String moedaConversao, String moedaAlvo) throws IOException, InterruptedException {

        this.moedaConversao = moedaConversao;
        this.moedaAlvo = moedaAlvo;
        this.valor = valor;

        URI url = URI.create("https://v6.exchangerate-api.com/v6/6a8cba9b1a1e78e23bedb867/pair/" + moedaConversao + "/" + moedaAlvo + "/" + getValor());
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)

                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        RetornaResultado resultadoConversao = gson.fromJson(response.body(), RetornaResultado.class);

        System.out.println(this.moedaConvertida + ": " + resultadoConversao);

    }

}
