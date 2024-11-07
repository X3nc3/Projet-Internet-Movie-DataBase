package ob;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "ACTEUR")
public class Acteur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "identite")
    private String identite;

    @Column(name = "url")
    private String url;

    @Column(name = "dateNaissance")
    private LocalDate dateNaissance;

    @Column(name = "taille")
    private double height;

    @OneToMany(mappedBy = "acteur")
    private Set<Role> roles = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "CASTING",
            joinColumns = { @JoinColumn(name = "id_acteur") },
            inverseJoinColumns = { @JoinColumn(name = "id_film") }
    )
    private Set<Film> films = new HashSet<>();

    public Acteur() {
    }

    /**
     * Getter
     *
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter
     *
     * @param id id
     */
    public void setId(Long id) {
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
     * @return dateNaissance
     */
    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    /**
     * Setter
     *
     * @param dateNaissance dateNaissance
     */
    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    /**
     * Getter
     *
     * @return height
     */
    public double getHeight() {
        return height;
    }

    /**
     * Setter
     *
     * @param height height
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Getter
     *
     * @return roles
     */
    public Set<Role> getRoles() {
        return roles;
    }

    /**
     * Setter
     *
     * @param roles roles
     */
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Acteur acteur = (Acteur) o;
        return Objects.equals(id, acteur.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Acteur{" +
                "id=" + id +
                ", identite='" + identite + '\'' +
                ", url='" + url + '\'' +
                ", dateNaissance=" + dateNaissance +
                ", height=" + height +
                ", roles=" + roles +
                ", films=" + films +
                '}';
    }
}
