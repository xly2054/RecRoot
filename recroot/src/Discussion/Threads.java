package Discussion;

import java.util.ArrayList;

/**
 * Thread is a discussion thread
 */
public class Threads implements Cloneable {
    public String Subject;
    public String Poster;
    public String Date;
    public String Body;
    public ArrayList<Comment> comments = new ArrayList<Comment>();

    public Threads(String Subject, String Poster, String Date, String Body){
        this.Subject = Subject;
        this.Poster = Poster;
        this.Date = Date;
        this.Body = Body;
    }

    public Threads(String Subject, String Poster, String Date, String Body,ArrayList<Comment> comments){
        this.Subject = Subject;
        this.Poster = Poster;
        this.Date = Date;
        this.Body = Body;
        this.comments = comments;
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        ArrayList<Comment> temp = new ArrayList<Comment>();
        for(Comment c : this.comments){
            temp.add(c);
        }
        return new Threads(Subject,Poster,Date,Body,temp);
    }

    public void addComments(String Poster,String Body, String Time){
        Comment c = new Comment(Poster,Body,Time);
        this.comments.add(c);
    }

    public void printThread(){
        System.out.println("Thread Subject: " + this.Subject);
        System.out.println("Thread Body: " + this.Body);
        for (Comment c:comments){
            System.out.print("Comment from " + c.Poster);
            System.out.println(": " + c.Body);
        }
    }
}
