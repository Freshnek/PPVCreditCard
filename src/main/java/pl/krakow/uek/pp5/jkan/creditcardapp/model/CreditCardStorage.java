package pl.krakow.uek.pp5.jkan.creditcardapp.model;

import java.util.Arrays;
import java.util.Map;

interface CreditCardStorage {
    void add(CreditCard card);

    CreditCard load(String creditCardNumber);
}
