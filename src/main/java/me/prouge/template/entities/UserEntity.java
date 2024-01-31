package me.prouge.template.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String password;

    public UserEntity(final String email, final String pwd) {
        this.email = email;
        this.password = pwd;
    }

    public UserEntity() {
    }

    private Long getId() {
        return this.id;
    }

    private void setId(Long id) {
        this.id = id;
    }


}
