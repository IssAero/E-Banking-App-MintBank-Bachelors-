package com.licentaebank.helpers;

import java.util.Random;

public class GenAccountNumber {

    public static int generateAccountNumber(){
        int accountNumber;
        Random random = new Random();
        int bound = 10000;
        accountNumber = bound * random.nextInt(bound);
        return accountNumber;
    }
    //End Generate Account Number Method.
}
