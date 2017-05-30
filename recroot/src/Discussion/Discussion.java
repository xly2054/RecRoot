package Discussion;

import java.util.ArrayList;

/**
 * Discussion represents topic folder/wrapper for concentrated threads
 */
public class Discussion {

    public String Topic;
    public ArrayList<Threads> threads = new ArrayList<Threads>();

    public Discussion(String Topic){
        this.Topic = Topic;
    }

    public void addThread(String Subject, String Poster, String Body, String Time){
        Threads t = new Threads(Subject,Poster,Body,Time);
        threads.add(t);
    }

    public Threads getThread(String Subject){
        for (Threads t : threads){
            if (t.Subject.equals(Subject)){
                return t;
            }
        }
        return null;
    }

    public void removeThread(String Subject){
        for (Threads t : threads){
            if (t.Subject.equals(Subject)){
                threads.remove(getThread(Subject));
            }
        }
    }

    public void replyThread(String Subject, String Poster, String Body, String Time) throws CloneNotSupportedException{
        Threads t = getThread(Subject);
        Threads rt = (Threads) t.clone();
        rt.addComments(Poster,Body,Time);
        this.threads.remove(t);
        this.threads.add(rt);
    }
}