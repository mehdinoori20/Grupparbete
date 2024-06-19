<<<<<<< HEAD
=======
/*
Info om Role, Role fungerar i stort sätt på samma sätt som AppUser skillnaden här är att vi bara har ett attribut name
 */
>>>>>>> 1907d18a1f3fc60904cf67263ea92713a65e451c

package se.mehdi.securewebapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Glöm ej getters and setters

   // public Role() {}

    //public Role(String name) {
      // this.name = name;
    //}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
