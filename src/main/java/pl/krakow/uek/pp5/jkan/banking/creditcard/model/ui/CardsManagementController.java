package pl.krakow.uek.pp5.jkan.banking.creditcard.model.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.krakow.uek.pp5.jkan.banking.creditcard.model.CreditCardFacade;
import pl.krakow.uek.pp5.jkan.banking.creditcard.model.WithdrawCommand;
import pl.krakow.uek.pp5.jkan.banking.creditcard.model.dto.CreditCardDetailsDto;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CardsManagementController {
    private CreditCardFacade creditCardFacade;
    @Autowired
    public CardsManagementController(CreditCardFacade creditCardFacade) {
        this.creditCardFacade = creditCardFacade;
    }
    @RequestMapping("/fake-cards")
    public List<CreditCardDetailsDto> fakeCardBalances() {
        return Arrays.asList(
                new CreditCardDetailsDto("1234", BigDecimal.valueOf(2000)),
                new CreditCardDetailsDto("1134", BigDecimal.valueOf(3000)),
                new CreditCardDetailsDto("1224", BigDecimal.valueOf(4000))
        );
    }
    public List<CreditCardDetailsDto> cardBalances() {
        return creditCardFacade.allCardsReport();
    }
    @PostMapping("cards/withdraw")
    public void withdraw(@RequestBody WithdrawCommand withdrawCommand) {
        creditCardFacade.handle(withdrawCommand);
    }
//    @EventListener(ApplicationStartedEvent.class)
//    public void createSomeCards() {
//        String cardId = creditCardFacade.registerClient(BigDecimal.valueOf(2000));
//    }
}
