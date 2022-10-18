package academy.prog;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
@Data
public class OnlineUser {
    private static final OnlineUser ONLINE_USER = new OnlineUser();

    private final Map<String, Boolean> onlineList = new HashMap<>();

    private OnlineUser(){

    }
    public static OnlineUser getInstance(){
        return ONLINE_USER;
    }

    @Override
    public String toString(){
        StringBuilder text = new StringBuilder(System.lineSeparator());
        for(String key : onlineList.keySet()){
            if(onlineList.get(key))
                text.append(key).append(" online").append(System.lineSeparator());
        }
        return text.toString();
    }
}
