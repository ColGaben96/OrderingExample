package model;

import model.utils.DBConn;

public class Binnacle {
    private PersonDAO person = new PersonDAO();
    private DBConn db = new DBConn();

    public Binnacle() {
        try {
            restore();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void restore() throws Exception {
        var data = db.getAllData();
        for (Object[] objs : data) {
            person.create(Integer.parseInt(String.valueOf(objs[0])), String.valueOf(objs[1]), String.valueOf(objs[2]), String.valueOf(objs[3]));
        }
    }

    public void create(int id, String names, String lastname, String email) throws Exception {
        person.create(id, names, lastname, email);
        db.insertPerson(id, names, lastname, email);
    }

    public void delete(int id) throws Exception {
        person.delete(person.findbyID(id));
        db.deletePerson(id);
    }

    public PersonDAO getPerson() {
        return person;
    }
}
