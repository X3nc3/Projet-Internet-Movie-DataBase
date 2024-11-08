package fr.diginamic.ob;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "REALISATEUR")
public class Realisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "identite")
    private String identite;

    @Column(name = "url")
    private String url;

    @ManyToMany(mappedBy = "realisateurs")
    private Set<Film> films;


    {
        films = new HashSet<>();
    }

    public Realisateur() {}

    // Getters and setters

    /**
     * Getter
     *
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * Setter
     *
     * @param id id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter
     *
     * @return identite
     */
    public String getIdentite() {
        return identite;
    }

    /**
     * Setter
     *
     * @param identite identite
     */
    public void setIdentite(String identite) {
        this.identite = identite;
    }

    /**
     * Getter
     *
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Setter
     *
     * @param url url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Getter
     *
     * @return films
     */
    public Set<Film> getFilms() {
        return films;
    }

    /**
     * Setter
     *
     * @param films films
     */
    public void setFilms(Set<Film> films) {
        this.films = films;
    }
}
