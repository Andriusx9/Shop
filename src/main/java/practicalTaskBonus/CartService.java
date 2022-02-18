package practicalTaskBonus;

import java.util.List;

public class CartService {

    public static void addProductToCart(Product product, Customer customer) {

        for (Product product1 : customer.getCart().getProducts()) {
            if (product1.getName().equalsIgnoreCase(product.getName())) {
                product1.setQuantity(product1.getQuantity() + product.getQuantity());
                return;
            }
        }
        customer.getCart().addProduct(product);
    }

    public static void removeProductFromCart(Product product, Customer customer) {

        String productName = product.getName();

        for (int i = 0; i < customer.getCart().getProducts().size(); i++) {

            int cartQuantity = customer.getCart().getProducts().get(i).getQuantity();

            if (customer.getCart().getProducts().get(i).getName().equalsIgnoreCase(productName)) {

                if (cartQuantity == 1) {
                    customer.getCart().removeProduct(product);
                } else if (cartQuantity > 1) {
                    customer.getCart().getProducts().get(i).changeProductQuantity(product);
                }
            }
        }
    }

    public static double countCartTotalPrice(Cart cart) {

        double totalPrice = 0;

        for (int i = 0; i < cart.getProducts().size(); i++) {
            totalPrice = totalPrice + cart.getProducts().get(i).getPrice() * cart.getProducts().get(i).getQuantity();
        }

        return totalPrice;
    }
}
