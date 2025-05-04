package view;

import exception.EncerramentoException;
import model.MoedaBase;
import services.RequestToApi;
import services.RequisitorDeDados;

public class Menu {

    private final String URI;

    public Menu() {
        String apiKey = "68c087cfbe26d5a736cbc97f";//TODO Tirar daqui por razão de segurança
        URI = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/";
    }

    public void exibirMenu(){

        RequisitorDeDados rd = new RequisitorDeDados();
        System.out.println("Seja bem vindo!");

        while(true){//laço para repetir até que o usuário cancele

            System.out.println("Escolha sua moeda de origem: ");
            String tempUri = "";//Incia a uri temporaria, sendo redefinida a cada loop
            String moedaDeOrigem = "";//Seleciona a moeda

            //Selecinando a moeda de origem
            try {
                moedaDeOrigem = rd.seletorDeMoeda();
            } catch (EncerramentoException e) {//pega a exception que eu criei
                System.out.println(e.getMessage());
                break; //sai do loop para encerrar
            }

            tempUri = URI + moedaDeOrigem;//adiciona o link da api e coloca a moeda selecionada no final

            //fazendo o requeste e o parse
            RequestToApi request = new RequestToApi();
            MoedaBase moeda = request.getMoedaBase(tempUri);

            //TODO while para poder trocar a moeda e essas coisas

            //requisitando o valor que deseja converter
            double valorOrigem = rd.solicitarValor();

            //Selecionando a moeda de destino
            System.out.println("Escolha sua moeda de destino:");

            String moedaDeDestino = "";
            try {
                moedaDeDestino = rd.seletorDeMoeda();
            } catch (EncerramentoException e) {
                System.out.println(e.getMessage());
                break;
            }
            //calculando o valor após o cambio
            double valorCambiado = valorOrigem * moeda.getConversionRates().get(moedaDeDestino);



            System.out.printf("%s %.2f = %s %.2f \n", moedaDeOrigem, valorOrigem, moedaDeDestino, valorCambiado);

            rd.reset();

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Acabou");
    }
}
