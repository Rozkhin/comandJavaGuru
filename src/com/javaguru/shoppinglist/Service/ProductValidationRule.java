package com.javaguru.shoppinglist.Service;

import com.javaguru.shoppinglist.Database.product.Product;

public interface ProductValidationRule {

    void validate(Product product) throws ProductValidationException;

    default void checkNotNull(Product product) throws ProductValidationException {
        if(product==null){
            throw new ProductValidationException("Product must be not null");
        }
    }
}
