package hello.controllers;


import java.util.concurrent.atomic.AtomicLong;

import hello.models.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    /*
        The example does not specify GET vs. PUT, POST, and so forth, because
        @RequestMapping maps all HTTP operations by default.
        Use @RequestMapping(method=GET) to narrow this mapping.
     */
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
