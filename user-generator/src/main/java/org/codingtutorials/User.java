package org.codingtutorials;

public class User {
    private String name;
    private String email;
    private String password;

    public User(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
