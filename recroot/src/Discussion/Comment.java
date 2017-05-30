package Discussion;

/**
 * Comment is a data object for discussion threads
 */
public class Comment {
    String Poster;
    String Body;
    String Time;

    public Comment(String Poster, String Body, String Time){
        this.Poster = Poster;
        this.Body = Body;
        this.Time = Time;
    }
}
