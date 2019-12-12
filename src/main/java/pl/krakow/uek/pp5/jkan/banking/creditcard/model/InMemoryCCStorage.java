package pl.krakow.uek.pp5.jkan.banking.creditcard.model;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

class InMemoryCCStorage implements CreditCardStorage {

    private ConcurrentHashMap<String, CreditCard> cards;

    InMemoryCCStorage() {
        cards = new ConcurrentHashMap<String, CreditCard>();
    }

    public void add(CreditCard card) {
        cards.put(card.cardNumber, card);
    }

    public CreditCard load(String creditCardNumber) {
        return cards.get(creditCardNumber);
    }
    public ConcurrentHashMap<String, CreditCard> loadAll() {
        return cards;
    }
    public List<CreditCard> all() {
        return cards.values().stream().collect(Collectors.toList());
    }
}
