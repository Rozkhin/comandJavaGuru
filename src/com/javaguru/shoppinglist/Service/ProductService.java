package com.javaguru.shoppinglist.Service;

import com.javaguru.shoppinglist.Database.product.Collection;
import com.javaguru.shoppinglist.Database.product.Product;

public class ProductService {
    private Collection repository = new Collection();
    private ProductValidationService validationService = new ProductValidationService();

    public Long createProduct(Product product){
        boolean result =validationService.validate(product);
        Long id=null;
        if(result) {
            Product createdProduct = repository.insert(product);
            id=createdProduct.getId();
        }
        return id;
    }
}
