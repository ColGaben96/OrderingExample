package model.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;

public class DBConn {

    private Connection db;
    private Statement st;


    private Statement connect() throws Exception {
        String url = "jdbc:mysql://127.0.0.1:3306/orderdb";
        String user = "testuser";
        String pass = "123456";
        Class.forName("com.mysql.cj.jdbc.Driver");
        db = DriverManager.getConnection(url, user, pass);
        return db.createStatement();
    }

    private void disconnect() throws Exception {
        db.close();
    }

    public ArrayList<Object[]> getAllData() throws Exception {
        st = connect();
        var result = new ArrayList<Object[]>();
        var query = st.executeQuery("SELECT * FROM person");
        while (query.next()) {
            result.add(new Object[] {query.getObject(1), query.getObject(2),
                    query.getObject(3), query.getObject(4)});
        }
        disconnect();
        return result;
    }

    public void insertPerson(int id, String names, String lastname, String email) throws Exception {
        st = connect();
        st.executeUpdate("INSERT INTO person VALUES ("+id+", '"+names+"', '"+lastname+"', '"+email+"')");
        disconnect();
    }

    public void deletePerson(int id) throws Exception {
        st = connect();
        st.executeUpdate("DELETE FROM person WHERE id = "+id);
        disconnect();
    }
}
