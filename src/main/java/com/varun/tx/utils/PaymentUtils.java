package com.varun.tx.utils;

import com.varun.tx.exception.InsufficentAmountException;

import java.util.HashMap;
import java.util.Map;

public class PaymentUtils {

    private static Map<String,Double> paymentMap = new HashMap<>();

    static {
        paymentMap.put("acc1",12000.0);
        paymentMap.put("acc2",10000.0);
        paymentMap.put("acc3",3345688.0);
        paymentMap.put("acc4",4345688.0);

    }

    public static boolean validCreditLimit(String accNo,Double paidAmount){
        if (paidAmount > paymentMap.get(accNo)) {
            throw new InsufficentAmountException("insufficent amount...!");
        }else {
            return true;
        }

    }
}
