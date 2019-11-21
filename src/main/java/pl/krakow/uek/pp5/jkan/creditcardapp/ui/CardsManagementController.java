package pl.krakow.uek.pp5.jkan.creditcardapp.ui;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.krakow.uek.pp5.jkan.creditcardapp.model.dto.CreditCardDetailsDto;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CardsManagementController {
    @RequestMapping("/cards")
    public List<CreditCardDetailsDto> cardBalances() {
        return Arrays.asList(
                new CreditCardDetailsDto("1234", BigDecimal.valueOf(2000)),
                new CreditCardDetailsDto("1134", BigDecimal.valueOf(3000)),
                new CreditCardDetailsDto("1224", BigDecimal.valueOf(4000))
        );
    }
}
