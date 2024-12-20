package fr.diginamic.bo;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "REALISATEUR")
public class Realisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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

    public Realisateur(String url, String identite) {
        this.url = url;
        this.identite = identite;
    }

    /**
     * Getter for getid
     *
     * @return id
     */

    public Integer getId() {
        return id;
    }

    /**
     * Setter for getid
     *
     * @return id
     */

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Getter for getidentite
     *
     * @return identite
     */

    public String getIdentite() {
        return identite;
    }

    /**
     * Setter for getidentite
     *
     * @return identite
     */

    public void setIdentite(String identite) {
        this.identite = identite;
    }

    /**
     * Getter for geturl
     *
     * @return url
     */

    public String getUrl() {
        return url;
    }

    /**
     * Setter for geturl
     *
     * @return url
     */

    public void setUrl(String url) {
        this.url = url;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Realisateur that = (Realisateur) o;
        return Objects.equals(identite, that.identite) && Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identite, url);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Realisateur{");
        sb.append("url='").append(url).append('\'');
        sb.append(", identite='").append(identite).append('\'');
        sb.append(", id='").append(id).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
