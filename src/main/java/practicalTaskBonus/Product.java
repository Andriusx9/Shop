package practicalTaskBonus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Product {
    private double price;
    private int quantity;
    private String name;

    public void changeProductQuantity(Product product) {
        // this.quantity = this.quantity - 1;
        product.quantity = this.getQuantity() - 1;
    }

}
