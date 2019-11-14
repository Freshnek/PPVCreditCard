package pl.krakow.uek.pira.ppv.creditcatd.model;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class CreditCardApiTest {
    public static final BigDecimal WITHDRAW_VALUE = BigDecimal.valueOf(500);
    public static final String CREDIT_CARD_NUMBER = "1234-5678";
    public static final int INITIAL_LIMIT = 1000;
    private InMemoryCCStorage inCCStorage;
    private CreditCardFacade api;

    @Test
    public void withdrawFromCard() {
        thereIsCCStorage();
        thereIsCreditCard();
        thereIsCCApi();

        api.withdrawFromCard(CREDIT_CARD_NUMBER, WITHDRAW_VALUE);

        currentBalanceForCCEquals(CREDIT_CARD_NUMBER, BigDecimal.valueOf(500));

    }
    private void currentBalanceForCCEquals(String creditCardNumber, BigDecimal expectedBalance) {
        CreditCard loaded = inCCStorage.load(creditCardNumber);

        Assert.assertEquals(expectedBalance, loaded.getCurrentBalance());
    }
    private void thereIsCCApi() {
        api = new CreditCardFacade();
    }

    private void thereIsCreditCard() {
        CreditCard card = new CreditCard(CREDIT_CARD_NUMBER);
        card.assignLimit(BigDecimal.valueOf(INITIAL_LIMIT));
        inCCStorage.add(card);
    }

    private void thereIsCCStorage() {
        inCCStorage = new InMemoryCCStorage();
    }

}