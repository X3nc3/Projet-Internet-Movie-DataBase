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

    @Column(name = "nom")
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

    public Genre(String nom) {
        this.nom = nom;
    }

    /**
     * Getter for getid
     *
     * @return id
     */

    public String getId() {
        return id;
    }

    /**
     * Setter for getid
     *
     * @return id
     */

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter for getnom
     *
     * @return nom
     */

    public String getNom() {
        return nom;
    }

    /**
     * Setter for getnom
     *
     * @return nom
     */

    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Getter for getfilms
     *
     * @return films
     */

    public Set<Film> getFilms() {
        return films;
    }

    /**
     * Setter for getfilms
     *
     * @return films
     */

    public void setFilms(Set<Film> films) {
        this.films = films;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Genre{");
        sb.append("nom='").append(nom).append('\'');
        sb.append(", id='").append(id).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
