package fr.diginamic.ob;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "GENRE")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String nom;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "film_genre",
            joinColumns = @JoinColumn(name = "id_genre", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name = "id_film", referencedColumnName="id"))
    private Set<Film> films;
    {
        films = new HashSet<>();
    }

    // Constructor without arguments
    public Genre() {}

    /**
     * @return the id
     */
    public String  getId() {
        return id;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @return the films
     */
    public Set<Film> getFilms() {
        return films;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @param films the films to set
     */
    public void setFilms(Set<Film> films) {
        this.films = films;
    }
}
