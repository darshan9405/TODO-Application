package my.learning.core;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class User {
    @Id
    @JsonProperty("userName")
    @Column(name = "userName")
    private String userName;

    @JsonProperty
    @Column(name = "hashedPassword")
    private String hashedPassword;

    User(String username, String pass) {
        this.userName = username;
        this.hashedPassword = pass;
    }

    public String getUserName() {
        return userName;
    }
}
