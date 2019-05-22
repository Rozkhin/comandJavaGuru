package com.javaguru.shoppinglist;

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
}