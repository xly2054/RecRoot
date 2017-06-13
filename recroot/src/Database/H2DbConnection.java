package Database;

import User.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * SQL backend using JDBC framework
 */
public class H2DbConnection {
    public static List<Student> StudentList =  new ArrayList<>();
    public static Connection dbConnection = null;
    static{
        try {
            Class.forName("org.h2.Driver");
            //keep connection open always for the purpose of this test program
            dbConnection = DriverManager.getConnection("jdbc:h2:mem:users","test","");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Student> addStudents(Student S){
        StudentList.add(S);
        return StudentList;
    }

    public static List<Student> getStudentList() {
        return StudentList;
    }

    private static String getInsertStatement(Student s){
        if(s != null){
            return "INSERT INTO USERS VALUES ('" + s.getName() + "','" + s.getSSN() + "','" + s.Username + "','" + s.Password
                    + "','" + s.getEmail() + "'," + s.getGPA() + "," + "'student')";
        }
        return null;
    }

    public static void populate() throws Exception {
        if(dbConnection != null){
            //create db
            String createDB = "CREATE TABLE USERS " +
                    "(name VARCHAR(255), " +
                    " ssn VARCHAR(255), " +
                    " username VARCHAR(255), " +
                    " password VARCHAR(255), " +
                    " email VARCHAR(255), " +
                    " gpa FLOAT, " +
                    " type VARCHAR(255), " +
                    " PRIMARY KEY ( ssn ))";
            Statement t = dbConnection.createStatement();
            t.executeUpdate(createDB);
            t.close();
            Statement t1 = dbConnection.createStatement();
            getStudentList().stream()
                    .map(H2DbConnection::getInsertStatement)
                    .filter(Objects::nonNull)
                    .forEach(sql->{
                        try {
                            t1.executeUpdate(sql);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    });
            t1.close();
        }else{
            throw new Exception("populate: dbconnection is null!");
        }
    }
}
