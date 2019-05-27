package com.javaguru.shoppinglist.View;

import com.javaguru.shoppinglist.Database.Product;

public class ProductPrint {
    public static void printProduct(Product p) {
        System.out.println(p.getId()+" | "
                +p.getName()+" | "
                +p.getPrice()+" | "
                +p.getType().toString()+" | "
                +p.getDiscount()+" | "
                +p.getActualPrice()+" | "
                +p.getDescription());
    }
}
