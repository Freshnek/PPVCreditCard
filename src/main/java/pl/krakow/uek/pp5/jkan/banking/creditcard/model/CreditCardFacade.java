package pl.krakow.uek.pp5.jkan.banking.creditcard.model;

import pl.krakow.uek.pp5.jkan.banking.creditcard.model.dto.CreditCardDetailsDto;

import java.util.List;
import java.util.stream.Collectors;

public class CreditCardFacade {

    private final InMemoryCCStorage storage;
    private String client;

    CreditCardFacade(InMemoryCCStorage ccStorage) {
        this.storage = ccStorage;
    }

    public void handle(WithdrawCommand withdrawCommand) {
        CreditCard loaded = storage.load(withdrawCommand.getCreditCardNumber());
        loaded.withdraw(withdrawCommand.getWithdrawValue());
        storage.add(loaded);
    }
//    public List<CreditCardDetailsDto> raport() {
//        return storage.all().stream()
//                .map(card -> CreditCardDetailsDto.of(card.getCardNumber, card.balance))
//                .collect(Collectors.toList());
//    }

    public List<CreditCardDetailsDto> allCardsReport() {
        return storage.loadAll().values().stream()
                .map(CreditCard::details)
                .collect(Collectors.toList());
    }
}
