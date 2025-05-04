
import model.MoedaBase;
import services.RequestToApi;
import view.Menu;

public class Main {
    public static void main(String[] args) {

//        Menu menu = new Menu();
//        menu.exibirMenu();
        String uri = "https://v6.exchangerate-api.com/v6/68c087cfbe26d5a736cbc97f/latest/BRL";

        RequestToApi ra = new RequestToApi();
        MoedaBase coin = ra.getMoedaBase(uri);

        System.out.println(coin);
    }
}
