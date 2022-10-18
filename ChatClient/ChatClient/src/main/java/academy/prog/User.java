package academy.prog;

import lombok.Data;

@Data
public class User {
    public static final User USER = new User();
    private String login;
    public User() {
    }
    public static User getInstance(){
        return USER;
    }
}
