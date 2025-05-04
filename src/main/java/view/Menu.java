package view;

import exception.EncerramentoException;
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

            String tempUri = "";//Incia a uri temporaria, sendo redefinida a cada loop


            String moedaSelecionada = "";//Seleciona a moeda
            try {
                moedaSelecionada = rd.seletorDeMoeda();
            } catch (EncerramentoException e) {//pega a exception que eu criei
                System.out.println(e.getMessage());
                break; //sai do loop para encerrar
            }

            tempUri = URI + moedaSelecionada;//adiciona o link da api e coloca a moeda selecionada no final
            System.out.println(tempUri);

            System.out.println("####################");

        }

        System.out.println("Acabou");
    }
}
