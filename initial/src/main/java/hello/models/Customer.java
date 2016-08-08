package hello.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
    The Customer class is annotated with @Entity, indicating that it is a JPA entity.
    For lack of a @Table annotation, it is assumed that this entity will be
    mapped to a table named Customer.
 */
@Entity
public class Customer {

    /*
        The Customer’s id property is annotated with @Id so that JPA will recognize it
            as the object’s ID. It is also annotated with @GeneratedValue to indicate
            that the ID should be generated automatically.
        The other two properties, firstName and lastName are left unannotated.
            It is assumed that they’ll be mapped to columns that share the same name
            as the properties themselves.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;

    protected Customer() {
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}