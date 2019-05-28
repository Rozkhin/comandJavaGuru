package com.javaguru.shoppinglist.GUI;

import com.javaguru.shoppinglist.Database.product.Product;
import com.javaguru.shoppinglist.Database.product.ProductTypes;
import com.javaguru.shoppinglist.Service.ProductService;
import com.javaguru.shoppinglist.Service.ProductValidationService;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;

public class ConsoleI {
    private ProductService productService = new ProductService();

    public void execute(){
        while(true){
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("1. Create product");
                System.out.println("2. Show information about product by id");
                System.out.println("3. Change product description ");
                System.out.println("4. Exit");
                Integer userInput = Integer.valueOf(scanner.nextLine());
                switch (userInput) {
                    case 1:
                        CreateProduct();
                        break;
                    case 2:

                    case 3:
                    case 4:
                        return;
            }
        }catch (Exception e){
                e.printStackTrace();
            System.out.println("Error! Please try again");
            }
        }
    }
    private void CreateProduct(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter product name: ");
        String name = scanner.nextLine();
        System.out.println("Enter product price: ");
        BigDecimal price =  new BigDecimal(scanner.nextLine());
        System.out.println("Enter product discount: ");
        BigDecimal discount = new BigDecimal(scanner.nextLine());
        System.out.println("Enter product category: ");
        for (ProductTypes pt: ProductTypes.values()) {
            System.out.println(pt.ordinal()+". "+pt.toString());
        }
        int userInput = Integer.valueOf(scanner.nextLine());
        ProductTypes Type = ProductTypes.getProductById(userInput);
        System.out.println("Enter product description: ");
        String description = scanner.nextLine();
        Product prd = new Product();
        prd.setName(name);
        prd.setPrice(price);
        prd.setDiscount(discount);
        prd.setType(Type);
        prd.setDescription(description);
        Long id=productService.createProduct(prd);
        if(id==null) System.out.println("Can't create product");

    }
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
