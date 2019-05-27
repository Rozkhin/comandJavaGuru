package com.javaguru.shoppinglist.Service;

import com.javaguru.shoppinglist.Database.Collection;
import com.javaguru.shoppinglist.Database.Product;
import com.javaguru.shoppinglist.Database.ProductTypes;
import com.javaguru.shoppinglist.View.ProductPrint;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class ShoppingListApplication {

    Map<Long, Product> productRepository = new HashMap<>();

    public static void main(String[] args) {


        while (true) {

            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("1. Create product");
                System.out.println("2. Show information about product by id");
                System.out.println("3. Change product description ");
                System.out.println("4. Exit");
                Integer userInput = Integer.valueOf(scanner.nextLine());
                Boolean validation = null;
                String name;
                BigDecimal price;
                BigDecimal discount;
                String description;
                Long currProductId;
                Product currProduct;
                Validator NewValidator = new Validator();
                switch (userInput) {
                    case 1:
                        createProduct();
                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:
                        return;
                }
            } catch (Exception e) {
                System.out.println("Error! Please try again.");
                e.printStackTrace();
            }
        }
    }

    private static void createProduct(Map<Long,Product> productRepository){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter product name: ");
        String name = scanner.nextLine();
        System.out.println("Enter product price: ");
        BigDecimal price = scanner.nextBigDecimal();
        System.out.


    }
}
