/*
Info om AppUser @Entity annoteringen säger till oss att detta är en "entity" i en databas @Id specificerar att primary key:en är id och @GeneratedValue gör så att
databasen genererar värdet åt oss. Username, firstname etc är olika fält i vårat table som har getters och setters för modifiering. alla attribut är privata då vi inte vill
att vem som helst ska ha tillgång till dessa värden.
 */

package se.mehdi.securewebapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String firstname;
    private String lastname;
    private String age;
    private String password;
    private String email;


    // getters and setters

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void updateUser(AppUser updatedUser) {
        this.firstname = updatedUser.getFirstname();
        this.lastname = updatedUser.getLastname();
        this.email = updatedUser.getEmail();
    }
}
