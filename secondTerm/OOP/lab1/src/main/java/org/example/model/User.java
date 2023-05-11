package org.example.model;

import lombok.Data;

@Data
public class User {
    private String mail;
    private String password;
    private String role;

    public User(String _mail, String _password, String _role){
        this.mail=_mail;
        this.password=_password;
        this.role=_role;
    }

}
