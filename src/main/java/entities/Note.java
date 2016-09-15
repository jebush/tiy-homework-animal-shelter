package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;


public class Note {
    private int id;
    private String text;
    private LocalDate date;


    public Note (){

    }

    public Note (String text){
        this.text = text;
        this.date = LocalDate.now();
    }

    public Note (int id, String text, String date){
        this.id = id;
        this.text = text;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.date = LocalDate.parse(date, formatter);

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

    public LocalDate getDate(){
        return this.date = date;
    }

    public void setDate(LocalDate date){
        this.date = date;
    }

    public String getDateAsString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        return this.date.format(formatter);
    }



}
