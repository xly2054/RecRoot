package Database;
import User.*;
/**
 * Partially implemented backend
 */
import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import org.bson.Document;

import java.util.*;

public class Database {

    static private MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://xydb:5Eg0tqrvVcbbh8KksteB2gEK4t79BZpUU5tvKNlJdWxVvrceOXjExiYkt1vo57sEyt9RaMlXmRO0wqs8KSyl8A==@xydb.documents.azure.com:10255/?ssl=true&replicaSet=globaldb"));

    public static MongoCollection<Document> connect(String DBName, String CollectionName){
        MongoDatabase db = mongoClient.getDatabase(DBName);
        MongoCollection<Document> collection = db.getCollection(CollectionName);
        return collection;
    }

    public static void addStudent(Student Student){
        MongoCollection<Document> collection = Database.connect("recrootdb","user");
        Document doc = new Document("name", Student.Name)
                .append("ssn", Student.SSN)
                .append("username", Student.Username)
                .append("password", Student.Password)
                .append("email", Student.Email)
                .append("gpa",Student.GPA)
                .append("usertype", "Student");

        collection.insertOne(doc);
    }

    public static void addAdvisor(Adviser Adviser){
        MongoCollection collection = Database.connect("recrootdb","user");
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

    public static Student findStudent(String name){
        MongoCollection collection = Database.connect("recrootdb","user");
        //Document myDoc = collection.find().first();
        //System.out.println(myDoc.toJson());
        return null;
    }

    public static Boolean checkUser(String Username){
        //search database, determine if user exist
        return false;
    }

}
