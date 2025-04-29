package view;

import services.RequisitorDeDados;

public class Menu {

    private final RequisitorDeDados requisitor;
    private final String URI;

    public Menu() {
        requisitor = new RequisitorDeDados();
        String apiKey = "68c087cfbe26d5a736cbc97f";//TODO Tirar daqui por razão de segurança
        URI = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/";
    }

    public void exibirMenu(){
        while(true){
            String tempUri = "";

            try {
                tempUri = URI + requisitor.seletorDeMoedaDeOrigem();
                System.out.println(tempUri);
            }catch (Exception e){
                System.out.println(e.getMessage());
                break;
            }

            System.out.println("####################");

            try {
                tempUri += requisitor.seletorDeMoedaFinal();
                System.out.println(tempUri);
            }catch (Exception e){
                System.out.println(e.getMessage());
                break;
            }

            System.out.println("#####################");
        }

        System.out.println("Acabou");
    }
}
