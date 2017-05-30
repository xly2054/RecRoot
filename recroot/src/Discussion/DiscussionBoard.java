package Discussion;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
/**
 * Discussion board is a single instance represents all discussion threads
 */
public final class DiscussionBoard {

    private static volatile DiscussionBoard instance = null;
    public ArrayList<Discussion> DiscussionList = new ArrayList<Discussion>();

    private DiscussionBoard() {}

    public static DiscussionBoard getInstance() {
        if (instance == null) {
            synchronized(DiscussionBoard.class) {
                if (instance == null) {
                    instance = new DiscussionBoard();
                }
            }
        }
        return instance;
    }

    public Discussion getDiscussion(String Topic){
        if(DiscussionList==null){
            return null;
        }
        for (Discussion d:DiscussionList){
            if(d.Topic.equals(Topic)){
                return d;
            }
        }
        return null;
    }


    public Discussion newDiscussion(String Topic) {
        if (getDiscussion(Topic)==null){
            Discussion d = new Discussion(Topic);
            this.DiscussionList.add(d);
            return d;
        }
        System.out.println("Discussion already exist");
        return getDiscussion(Topic);
    }

    public void newThread(String Topic, String Subject, String OrignalPoster,String Body){
        Discussion d = null;
        if(getDiscussion(Topic)!=null) {
            d = getDiscussion(Topic);
        }else{
            d = newDiscussion(Topic);
        }
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        d.addThread(Subject,OrignalPoster,dateFormat.format(date),Body);
        return;
    }

    public void replyThread(String Topic,String Subject,String Poster,String Body){
        Discussion d = getDiscussion(Topic);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        Threads t = d.getThread(Subject);
        t.addComments(Poster,Body,dateFormat.format(date));
    }

    public void listThread(){
        for (Discussion d: DiscussionList){
            System.out.println("Topics on Board: " + d.Topic);
        }
    }
}

