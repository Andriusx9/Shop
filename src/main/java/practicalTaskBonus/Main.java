package practicalTaskBonus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Product monitor = new Product(210.0, 1, "Monitor LG");
        Product ssdDrive = new Product(45.9, 1, "Samsung SSD 240 GB");
        Product motherboard = new Product(98.2, 1, "Motherboard Asus - G5");
        Product graphicsCard = new Product(325.6, 1, "Graphics Card");
        Product ram = new Product(12.25, 1, "RAM 8 GB 2999 Ghz");

        List<Product> shopProducts = new ArrayList<>();
        shopProducts.add(monitor);
        shopProducts.add(ssdDrive);
        shopProducts.add(motherboard);
        shopProducts.add(graphicsCard);
        shopProducts.add(ram);

        Cart shopCart = new Cart();
        Customer jack = new Customer("Jack", 28, shopCart);

        showMenu(shopProducts, jack, shopCart);

    }

    public static void showShopProducts(List<Product> products) {
        System.out.println("**************");
        System.out.println("Shop Products:");
        System.out.println("***************");
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + ". Name - " + products.get(i).getName() + "; Price - " + products.get(i).getPrice());
        }
        System.out.println("***************************************************");
        System.out.println();
    }

    public static void showCart(Cart cart) {
        System.out.println("**************");
        System.out.println("Your cart");
        System.out.println("Total price: " + CartService.countCartTotalPrice(cart));
        System.out.println("***************");

        for (int i = 0; i < cart.getProducts().size(); i++) {
            System.out.println((i + 1) + ". " + cart.getProducts().get(i).getName() + "; " + cart.getProducts().get(i).getQuantity());
        }
        System.out.println();
    }

    public static void showMenu(List<Product> products, Customer customer, Cart cart) {

        showMenuSelection();

        Scanner scan = new Scanner(System.in);
        int chooseFunction = scan.nextInt();

        while (chooseFunction != 3) {

            showCart(cart);

            switch (chooseFunction) {
                case 1:
                    chooseProductAddToCart(products, customer);
                    break;
                case 2:
                    System.out.println("Which product do you want remove: ");
                    for (int i = 0; i < customer.getCart().getProducts().size(); i++) {
                        System.out.println((i + 1) + ". " + customer.getCart().getProducts().get(i).getName() + "; " + customer.getCart().getProducts().get(i).getQuantity());
                    }

                    System.out.println();
                    chooseFunction = scan.nextInt();

                    CartService.removeProductFromCart(customer.getCart().getProducts().get((chooseFunction - 1)), customer);

                    break;

            }

            showCart(cart);
            showMenuSelection();

            chooseFunction = scan.nextInt();

        }


    }

    private static void showMenuSelection() {
        System.out.println("*********************************");
        System.out.println("Menu. Select a function: ");
        System.out.println("*********************************");
        System.out.println("1. Add product to cart");
        System.out.println("2. Remove product from cart");
        System.out.println("3. EXIT");
        System.out.println("*********************************");
    }

    public static void chooseProductAddToCart(List<Product> products, Customer customer) {

        showShopProducts(products);

        Scanner scan = new Scanner(System.in);

        System.out.println("Select the item number you want to add to cart: ");

        int chosenNumber = scan.nextInt();

        while (chosenNumber <= 0 || chosenNumber >= products.size() + 1) {

            System.out.println("There is no such product with number " + chosenNumber);
            System.out.println("Select the item number you want to add to cart: ");
            chosenNumber = scan.nextInt();

        }

        System.out.println("You choose: " + products.get(chosenNumber - 1).getName() + "; Price - "
                + products.get(chosenNumber - 1).getPrice());
        System.out.println("Choose how much to add to cart?");
        int quantity = scan.nextInt();

        CartService.addProductToCart(new Product(products.get(chosenNumber - 1).getPrice(), quantity, products.get(chosenNumber - 1).getName()), customer);

    }
}
