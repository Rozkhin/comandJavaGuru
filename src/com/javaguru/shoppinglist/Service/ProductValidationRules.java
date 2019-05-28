package com.javaguru.shoppinglist.Service;

import com.javaguru.shoppinglist.Database.product.Product;

import java.math.BigDecimal;
import java.math.BigInteger;

import static java.math.BigDecimal.valueOf;

class ProductValidationRules {
    static class ProductNameValidationRule extends com.javaguru.shoppinglist.Service.ProductNameValidationRule implements ProductValidationRule {


        @Override
        public void validate(Product product) throws ProductValidationException {
            checkNotNull(product);
            if (product.getName() == null) throw new ProductValidationException("Task name must not null");
        }

        @Override
        public void checkNotNull(Product product) throws ProductValidationException {

        }

    }

    static class ProductDiscountValidationRule extends com.javaguru.shoppinglist.Service.ProductNameValidationRule implements ProductValidationRule {
        @Override
        public void validate(Product product) throws ProductValidationException {
            BigDecimal maxdisc = valueOf(80);
            if (product.getDiscount().compareTo(maxdisc) >= 0)
                throw new ProductValidationException("Discount cant be more than 80%");

        }

        @Override
        public void checkNotNull(Product product) throws ProductValidationException {

        }
    }
}

