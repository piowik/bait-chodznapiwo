package bait.chodznapiwo.model;

/**
 * Created by artur on 25.11.2017.
 */

public class User {
    private String name;
    private String email;
    private String login;
    private int id;
    private String token;

    public User(int id, String name, String login, String email, String token) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.login = login;
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }


    public String getToken() { return token; }

    public int getId() { return id; }
}
