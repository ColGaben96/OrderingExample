package model;

import model.persistence.PersonDTO;
import model.utils.AlreadyExistsException;
import model.utils.NotFoundException;

import java.util.ArrayList;

public class PersonDAO {

    private ArrayList<PersonDTO> persons = new ArrayList<>();

    public void create(int id, String names, String lastname, String email) throws AlreadyExistsException {
        for (PersonDTO search : persons) {
            if (search.getId() == id) {
                throw new AlreadyExistsException();
            }
        }
        var newPerson = new PersonDTO(id, names, lastname, email);
        persons.add(newPerson);
    }

    public PersonDTO findbyID(int id) throws NotFoundException {
        for (PersonDTO search : persons) {
            if (search.getId() == id) {
                return search;
            }
        }
        throw new NotFoundException();
    }

    public ArrayList<PersonDTO> searchbyLastname(String lastname) {
        var result = new ArrayList<PersonDTO>();
        for (PersonDTO search : persons) {
            if (search.getLastname().contains(lastname)) {
                result.add(search);
                result.sort(search);
            }
        }
        return result;
    }

    public void delete(PersonDTO personDTO) {
        this.persons.remove(personDTO);
    }

    public ArrayList<PersonDTO> getAllData() {
        return persons;
    }
}
