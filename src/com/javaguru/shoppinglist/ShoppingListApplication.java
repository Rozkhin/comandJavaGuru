package com.javaguru.shoppinglist;

import com.sun.org.apache.xerces.internal.impl.RevalidationHandler;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class ShoppingListApplication {

    public static void main(String[] args) {
        Map<Long, Product> productRepository = new HashMap<>();
        Long productIdSequence = 0L;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("1. Create product");
                System.out.println("2. Find product by id");
                System.out.println("3. Exit");
                Integer userInput = Integer.valueOf(scanner.nextLine());
                Boolean validation = null;
                String name;
                BigDecimal price;
                BigDecimal discount;
                Validator NewValidator = new Validator();
                switch (userInput) {
                    case 1:
                        do {
                            System.out.println("Enter product name: ");
                            name = scanner.nextLine();
                            validation=NewValidator.ValidateName(name);
                            //System.out.println(validation);
                        }while (validation==false);


                            System.out.println("Enter product price: ");
                            price = new BigDecimal(scanner.nextLine());

                        do {
                            System.out.println("Enter product discount: ");
                            discount=scanner.nextBigDecimal();
                            validation=NewValidator.ValidateDiscount(discount);
                        }while (validation==false);

                        Product product = new Product();
                        product.setName(name);
                        product.setPrice(price);
                        product.setId(productIdSequence);
                        productRepository.put(productIdSequence, product);
                        productIdSequence++;
                        System.out.println("Result: " + product.getId());
                        break;
                    case 2:
                        System.out.println("Enter product id: ");
                        long id = scanner.nextLong();
                        Product findProductResult = productRepository.get(id);
                        System.out.println(findProductResult);
                        break;
                    case 3:
                        return;
                }
            } catch (Exception e) {
                System.out.println("Error! Please try again.");
                e.printStackTrace();
            }
        }
    }
}
