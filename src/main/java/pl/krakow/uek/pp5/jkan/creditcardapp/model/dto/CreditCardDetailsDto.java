package pl.krakow.uek.pp5.jkan.creditcardapp.model.dto;

import java.math.BigDecimal;

public class CreditCardDetailsDto {
    private String cardNumber;
    private BigDecimal saldo;

    public CreditCardDetailsDto(String cardNumber, BigDecimal saldo) {
        this.cardNumber = cardNumber;
        this.saldo = saldo;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
}
