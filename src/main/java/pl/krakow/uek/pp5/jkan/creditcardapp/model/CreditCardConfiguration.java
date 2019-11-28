package pl.krakow.uek.pp5.jkan.creditcardapp.model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreditCardConfiguration {
    @Bean
    CreditCardFacade create() {
        return new CreditCardFacade(new InMemoryCCStorage());
    }
    @Bean
    InMemoryCCStorage createMemory() {
        return  new InMemoryCCStorage();
    }
}
