package me.prouge.template.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity(name="USER")
@Getter
@Setter
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
      @ManyToOne
      @OneToMany
      private List<Participant> participantList = new ArrayList<>();
     */

    private String email;

    private String password;

    public UserEntity(final String email, final String pwd) {
        this.email = email;
        this.password = pwd;
    }

    public UserEntity() {
    }

}
