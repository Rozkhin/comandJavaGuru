package com.javaguru.shoppinglist;

import com.sun.org.apache.xerces.internal.impl.RevalidationHandler;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class ShoppingListApplication {

    private static void printProduct(Product p) {
        System.out.println(p.getId()+" | "
                +p.getName()+" | "
                +p.getPrice()+" | "
                +p.getType().toString()+" | "
                +p.getDiscount()+" | "
                +p.getActualPrice()+" | "
                +p.getDescription());
    }

    public static void main(String[] args) {
        Map<Long, Product> productRepository = new HashMap<>();
        Long productIdSequence = 1L;
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
                        do {
                            System.out.println("Enter product name: ");
                            name = scanner.nextLine();
                            validation=NewValidator.ValidateName(name);
                            //System.out.println(validation);
                        }while (!validation);


                            System.out.println("Enter product price: ");
                            price = new BigDecimal(scanner.nextLine());

                        do {
                            System.out.println("Enter product discount: ");
                            discount=new BigDecimal(scanner.nextLine());
                            validation=NewValidator.ValidateDiscount(discount);
                        }while (!validation);

                            System.out.println("Enter product category: ");
                        for (ProductTypes pt: ProductTypes.values()) {
                            System.out.println(pt.ordinal()+". "+pt.toString());
                        }
                        userInput = Integer.valueOf(scanner.nextLine());
                        ProductTypes one = ProductTypes.getProductById(userInput);

                        System.out.println("Enter product description (Optional): ");
                        description=scanner.nextLine();

                        Product product = new Product();
                        product.setName(name);
                        product.setPrice(price);
                        product.setDiscount(discount);
                        product.setId(productIdSequence);
                        product.setType(one);
                        product.setDescription(description);
                        productRepository.put(productIdSequence, product);
                        productIdSequence++;
                        System.out.println("Result: " + product.getId());
                        break;
                    case 2:
                        System.out.println("Enter product id: ");
                        currProductId = Long.valueOf(scanner.nextLine());
                        if (productRepository.containsKey(currProductId)) {
                            currProduct = productRepository.get(currProductId);
                            printProduct(currProduct);
                        } else
                            System.out.println("Coldn't find product with id = "+currProductId.toString());
                        break;
                    case 3:
                        System.out.println("Enter product id: ");
                        currProductId = Long.valueOf(scanner.nextLine());
                        if (productRepository.containsKey(currProductId)) {
                            currProduct = productRepository.get(currProductId);
                            System.out.println("Current product description: ");
                            System.out.println(currProduct.getDescription());
                            System.out.println("Enter new product description: ");
                            currProduct.setDescription(scanner.nextLine());
                        } else
                            System.out.println("Coldn't find product with id = "+currProductId.toString());
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
}
