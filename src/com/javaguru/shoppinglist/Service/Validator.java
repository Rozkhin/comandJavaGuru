package com.javaguru.shoppinglist.Service;

import com.javaguru.shoppinglist.Database.product.ProductTypes;

import java.math.BigDecimal;

public class Validator {
    String ValidType;
    String UserString;
    Boolean result;

    public String getUserString() {
        return UserString;
    }

    public Boolean ValidateName(String userString) {
        result= userString.length() >= 3 && userString.length() <= 30;
        return result;
    }
    public Boolean ValidateDiscount(BigDecimal userString){
        result= userString.compareTo(BigDecimal.valueOf(80)) < 0;
        return result;
    }

    public String ValidatePT(int userData){
        String resultstring="ok";
        if(userData > ProductTypes.getProductTypesCount()-1){
            System.out.println(ProductTypes.getProductTypesCount()-1);
            resultstring="no such product category";
        }
        return resultstring;
    }
}