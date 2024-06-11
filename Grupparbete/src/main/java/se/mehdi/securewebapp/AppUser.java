package se.mehdi.securewebapp;

public class AppUser {

    private String username;
    private String passnord;

    private int id;

    private String firstname;
    private String lastname;
    private int age;

    private String role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassnord() {
        return passnord;
    }

    public void setPassnord(String passnord) {
        this.passnord = passnord;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    @Override
    public String toString() {
        return "AppUser{" +
                "username='" + username + '\'' +
                ", passnord='" + passnord + '\'' +
                ", id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", role='" + role + '\'' +
                '}';
    }
}
