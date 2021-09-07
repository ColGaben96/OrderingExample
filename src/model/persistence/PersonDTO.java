package model.persistence;

import java.io.Serial;
import java.io.Serializable;
import java.util.Comparator;

public class PersonDTO implements Serializable, Comparator<PersonDTO> {

    @Serial
    private static final long serialVersionUID = 1L;

    private int id;
    private String names;
    private String lastname;
    private String email;

    public PersonDTO(int id, String names, String lastname, String email) {
        this.id = id;
        this.names = names;
        this.lastname = lastname;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getNames() {
        return names;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public int compare(PersonDTO o1, PersonDTO o2) {
        return o1.getLastname().compareTo(o2.getLastname());
    }
}
