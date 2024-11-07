package fr.diginamic.ob;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Roles {

    @Column(name = "characterName")
    private String characterName;

    @Column(name = "role")
    private String role;

    @OneToOne(mappedBy = "roles", cascade = CascadeType.PERSIST)
    private Acteur acteur_id;

    @OneToOne(mappedBy = "roles", cascade = CascadeType.PERSIST)
    private Film film_id;
}