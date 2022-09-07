package ru.job4j.pojo;

public class ShopDrop {

    public static Product[] delete(Product[] products, int index) {
        Product[] product = new Product[products.length];
        for (int i = 0; i < products.length; i++) {
            if (i != index) {
                int newProducts = i < index ? i : i - 1;
                product[newProducts] = products[i];
            }
        }
        return product;
    }
}
