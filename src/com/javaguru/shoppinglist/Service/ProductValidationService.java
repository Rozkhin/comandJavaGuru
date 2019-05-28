package com.javaguru.shoppinglist.Service;

import com.javaguru.shoppinglist.Database.product.Collection;
import com.javaguru.shoppinglist.Database.product.Product;

import java.util.HashSet;
import java.util.Set;

public class ProductValidationService {
    private Set<ProductNameValidationRule> validationRules = new HashSet<>();

    public ProductValidationService(Collection repository){
        validationRules.add(new ProductNameValidationRule(repository));
        validationRules.add(new ProductDiscountValidationRule());
    }

    public Boolean validate(Product product){
        Boolean result = true;
        for (ProductNameValidationRule s : validationRules) {
            try {
                s.validate(product);
            } catch (ProductValidationException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
                result = false;
            }
        }
        return result;
    }
}



