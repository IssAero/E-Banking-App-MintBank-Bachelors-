package com.licentaebank.helpers;

import java.util.Random;

public class GenAccountNumber {

    public static int generateAccountNumber(){
        int accountNumber;
        Random random = new Random();
        int bound = 1;
        accountNumber = bound * random.nextInt(1000,9999);
        return accountNumber;
    }
    //End Generate Account Number Method.
}
