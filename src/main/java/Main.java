import services.RequisitorDeDados;
import view.Menu;

public class Main {
    public static void main(String[] args) {
        RequisitorDeDados rd = new RequisitorDeDados();

        Menu menu = new Menu();
        menu.exibirMenu();
    }
}
