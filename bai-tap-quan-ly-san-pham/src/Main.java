import entity.Product;
import handle.ProductHandle;
import view.Menu;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ProductHandle productHandle = new ProductHandle();
        Menu menu = new Menu();
        List<Product> products = new ArrayList<>();
        menu.callMainMenu(productHandle, products);

    }
}
