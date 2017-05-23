package Database;
import User.*;
/**
 * Partially implemented backend
 */
import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.*;

public class Database {
    //placeholder for connection string
    static private MongoClient mongoClient = null;

    public static MongoCollection connect(String DBName, String CollectionName){
        MongoDatabase db = mongoClient.getDatabase(DBName);
        MongoCollection collection = db.getCollection(CollectionName);
        return collection;
    }

    public static void addStudent(Student Student){
        MongoCollection collection = Database.connect("recroot","user");
        BasicDBObject document = new BasicDBObject();
        document.put("name", Student.Name);
        document.put("ssn", Student.SSN);
        document.put("username", Student.Username);
        document.put("password", Student.Password);
        document.put("email", Student.Email);
        document.put("gpa",Student.GPA);
        document.put("usertype", "Student");
        document.put("createdDate", new Date());
        collection.insertOne(document);
    }

    public static void addAdvisor(Adviser Adviser){
        MongoCollection collection = Database.connect("recroot","user");
        BasicDBObject document = new BasicDBObject();
        document.put("name", Adviser.Name);
        document.put("ssn", Adviser.SSN);
        document.put("username", Adviser.Username);
        document.put("password", Adviser.Password);
        document.put("email", Adviser.Email);
        document.put("department", Adviser.Department);
        document.put("usertype", "Adviser");
        document.put("createdDate", new Date());
        collection.insertOne(document);
    }

    public static Boolean checkUser(String Username){
        //search database, determine if user exist
        return false;
    }

}
