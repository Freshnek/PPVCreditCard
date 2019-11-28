package pl.krakow.uek.pp5.jkan.creditcardapp.model;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import pl.krakow.uek.pp5.jkan.creditcardapp.model.dto.CreditCardDetailsDto;
import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class CardManagementHTTPTest {
    @Autowired
    TestRestTemplate restTemplate;
    @LocalServerPort
    int port;

    @Test
    public void itAllowAccessCardList() {
        String uri = "/api/fake-cards";
        ResponseEntity re = restTemplate.getForEntity(getUrl(uri), CreditCardDetailsDto[].class);
        assertThat(re.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assert.assertEquals(HttpStatus.OK, re.getStatusCode());
    }
    private String getUrl(String uri) {
        return String.format("http://localhost:%s/%s", port, uri);
    }

}
