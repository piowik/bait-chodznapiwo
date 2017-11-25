package bait.chodznapiwo.model;

/**
 * Created by artur on 25.11.2017.
 */

public class User {
    private String name;
    private String email;
    private String login;
    private String tel;
    private int university_id;
    private int field_id;
    private int year_id;

    public User(String name, String email, String login, String tel, int university_id, int field_id, int year_id) {
        this.name = name;
        this.email = email;
        this.login = login;
        this.tel = tel;
        this.university_id = university_id;
        this.field_id = field_id;
        this.year_id = year_id;
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getUniversity_id() {
        return university_id;
    }

    public void setUniversity_id(int university_id) {
        this.university_id = university_id;
    }

    public int getField_id() {
        return field_id;
    }

    public void setField_id(int field_id) {
        this.field_id = field_id;
    }

    public int getYear_id() {
        return year_id;
    }

    public void setYear_id(int year_id) {
        this.year_id = year_id;
    }
}
