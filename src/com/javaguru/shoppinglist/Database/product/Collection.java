package com.javaguru.shoppinglist.Database.product;

import com.javaguru.shoppinglist.Database.product.Product;

import java.util.HashMap;
import java.util.Map;

public  class Collection
{

    Map<Long, Product> productRepository = new HashMap<>();
    private Long productIdSequence = 0L;

    public Product insert(Product product){
        product.setId(productIdSequence);
        productRepository.put(productIdSequence,product);
        productIdSequence++;
        return product;
    }

    public Product findProductById(Long id){
        return productRepository.get(id);
    }
}
