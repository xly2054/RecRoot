package webinar;
import java.util.ArrayList;
/**
 * webinarPage is an orchestration object keeps tracking all on-going webinar
 * Singleton is also used here since only one instance shall be allowed
 */
public class WebinarPage {

    private static volatile WebinarPage instance = null;
    public static ArrayList<Webinar> WebinarList = new ArrayList<Webinar>();

    private WebinarPage() {}

    public static WebinarPage getInstance() {
        if (instance == null) {
            synchronized(WebinarPage.class) {
                if (instance == null) {
                    instance = new WebinarPage();
                }
            }
        }
        return instance;
    }

    public Webinar hostWebinar(String host){
        Webinar w = new Webinar(host);
        WebinarList.add(w);
        return w;
    }

    public Webinar joinWebinar(String host){
        if(getWebinar(host)!=null){
            return getWebinar(host);
        }
        return new Webinar();
    }

    public static boolean isHostJoined(String host){
        WebinarPage w = getInstance();
        if(w.getWebinar(host)!=null){
            return true;
        }
        return false;
    }

    public static Webinar getWebinar(String host){
        if(WebinarList==null){
            return null;
        }
        for (Webinar w:WebinarList){
            if(w.host.equals(host)){
                return w;
            }
        }
        return null;
    }

}
