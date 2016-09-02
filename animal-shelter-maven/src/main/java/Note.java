import java.util.Date;

/**
 * Created by rush on 8/31/16.
 */
public class Note {
    private int id;
    private String text;
    private Date date;

    public Note (){

    }

    public Note (int id, String text, Date date){
        this.id = id;
        this.text = text;
        this.date = date;
    }

    public int getId(){
        return this.id = id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String gettext(){
        return this.text = text;
    }
    public void setText(String text){
        this.text = text;
    }
    public Date getDate(){
        return this.date = date;
    }
    public void setDate(Date date){
        this.date = date;
    }


}
