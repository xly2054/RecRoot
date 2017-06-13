package Database.dao;

import User.Student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * User data access object
 */
public class UserDAO {
    private Connection c;
    public UserDAO(Connection c) throws IOException{
        if(c == null) throw new IOException("null connection");
        this.c = c;
    }

    //get all
    public List<Student> getStudents() throws SQLException {
        Statement st = c.createStatement();
        List<Student> stus = new ArrayList<>();
        try(ResultSet rs = st.executeQuery("SELECT * FROM USERS WHERE TYPE='student'")){
            while(rs.next()){
                double gpa = rs.getDouble("GPA");
                String name = rs.getString("NAME");
                String username = rs.getString("USERNAME");
                String email = rs.getString("EMAIL");
                String ssn = rs.getString("SSN");
                String password = rs.getString("PASSWORD");
                Student s = new Student(name,ssn,username,password,email,gpa);
                stus.add(s);
            }
        }
        st.close();
        return stus;
    }

    //get one
    public Student getStudent(String Name) throws SQLException {
        Statement st = c.createStatement();
        Student s = null;
        try(ResultSet rs = st.executeQuery("SELECT * FROM USERS WHERE NAME='" +Name + "'")){
            while(rs.next()){
                double gpa = rs.getDouble("GPA");
                String name = rs.getString("NAME");
                String username = rs.getString("USERNAME");
                String email = rs.getString("EMAIL");
                String ssn = rs.getString("SSN");
                String password = rs.getString("PASSWORD");
                s = new Student(name,ssn,username,password,email,gpa);
            }
        }
        st.close();
        return s;
    }
}
