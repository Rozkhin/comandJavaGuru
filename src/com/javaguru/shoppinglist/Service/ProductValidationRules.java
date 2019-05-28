package com.javaguru.shoppinglist.Service;

import com.javaguru.shoppinglist.Database.product.Product;

class ProductValidationRules {
    class ProductNameValidationRule implements ProductValidationRule{


        @Override
        public void validate(Product product) throws ProductValidationException {
            checkNotNull(product);
            if(product.getName()==null) throw new ProductValidationException("Task name must not null");
        }
        class ProductDiscountValidationRule implements ProductValidationRule{
            @Override
            public void validate(Product product) throws ProductValidationException {
                if(product.getDiscount().compareTo())
            }
        }
    }
}
