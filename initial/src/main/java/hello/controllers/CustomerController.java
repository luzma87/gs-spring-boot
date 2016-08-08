package hello.controllers;

import hello.exceptions.CustomException;
import hello.models.Customer;
import hello.models.ResponseSuccess;
import hello.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository repository;

    @Autowired
    private HttpServletResponse response;

    @RequestMapping(value = "/customer/create", method = POST)
//    public ResponseSuccess create(@RequestParam(value = "name", defaultValue = "Pepe") String name,
//                                  @RequestParam(value = "lastName", defaultValue = "Perez") String lastName)
//            throws CustomException {
    public ResponseSuccess create(@RequestBody Customer customer)
            throws CustomException {
        // http://ryanjbaxter.com/2014/12/17/building-rest-apis-with-spring-boot/  <--
        // https://spring.io/guides/gs/accessing-data-jpa/   <--
        // https://spring.io/guides
        // https://spring.io/guides/gs/spring-boot/#initial
        // https://spring.io/guides/gs/accessing-data-rest/
        // http://docs.spring.io/spring-data/data-commons/docs/1.6.1.RELEASE/reference/html/repositories.html
        // http://spring.io/guides/tutorials/bookmarks/
        // http://stackoverflow.com/questions/3686808/spring-3-requestmapping-get-path-value
        // http://stackoverflow.com/questions/32201441/how-do-i-retrieve-query-string-parameter-in-spring-boot
        // http://atmarkplant.com/spring-boot-request-parameters/
        
        System.out.println("trying to create customer: " + customer.getFirstName() + " " + customer.getLastName());
        if (customer.getFirstName().equalsIgnoreCase("juan")) {
            System.out.println("\tcannot create " + customer.getFirstName() + " " + customer.getLastName());
            throw new CustomException(response, "Error creating customer");
        }
        System.out.println("\tcan create " + customer.getFirstName() + " " + customer.getLastName());
        repository.save(customer);
        response.setStatus(HttpServletResponse.SC_CREATED);
        return new ResponseSuccess("Customer created");
    }

}
