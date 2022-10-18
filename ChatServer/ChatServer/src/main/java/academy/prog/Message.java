package academy.prog;

import java.util.Date;
import java.util.Objects;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Data;
@Data
public class Message {
    private Date date = new Date();
    private String from;
    private String to;
    private String text;


    public Message(String from, String text) {
        this.from = from;
        this.text = text;
    }

    public String toJSON() {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        return gson.toJson(this);
    }

    public static Message fromJSON(String s) {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        return gson.fromJson(s, Message.class);
    }

    @Override
    public String toString() {
        return new StringBuilder().append("[").append(date)
                .append(", From: ").append(from).append(", To: ").append(to)
                .append("] ").append(text)
                .toString();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(date, message.date) && Objects.equals(from, message.from) && Objects.equals(to, message.to) && Objects.equals(text, message.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, from, to, text);
    }
}
