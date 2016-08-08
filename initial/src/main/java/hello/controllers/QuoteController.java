package hello.controllers;

import hello.models.Quote;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class QuoteController {

    @RequestMapping("/quote")
    public Quote quote() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
    }
}
