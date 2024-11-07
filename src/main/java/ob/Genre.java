package ob;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Genre")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;

    @ManyToMany()
    @JoinTable(name = "film_genre",
            joinColumns = @JoinColumn(name = "id_genre"),
            inverseJoinColumns = @JoinColumn(name = "id_film"))
    private Set<Film> films = new HashSet<>();

    // Constructor without arguments
    public Genre() {}

    /**
     * @return the id
     */
    public Long getId() {
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
    public void setId(Long id) {
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
