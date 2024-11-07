package fr.diginamic.ob;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "ACTEUR")
public class Acteur {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "identite")
    private String identite;

    @Column(name = "url")
    private String url;

    @Column(name = "dateNaissance")
    private LocalDate dateNaissance;

    @Column(name = "height")
    private double height;

//    @OneToMany(mappedBy = "acteur")
//    private Set<Roles> roles = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "Lieu_id")
    private Lieu getLieuNaissance;

    @ManyToMany
    @JoinTable(
            name = "CASTING",
            joinColumns = { @JoinColumn(name = "id_acteur") },
            inverseJoinColumns = { @JoinColumn(name = "id_film") }
    )
    private Set<Film> filmsCasting;

//    @ManyToMany
//    @JoinTable(
//            name = "ROLES",
//            joinColumns = { @JoinColumn(name = "id_acteur") },
//            inverseJoinColumns = { @JoinColumn(name = "id_film") }
//    )
//    private Set<Film> filmsRoles;

    @OneToOne
    @JoinColumn(name = "id_roles")
    private Roles roles;

    {
        filmsCasting = new HashSet<>();
//        filmsRoles = new HashSet<>();
    }

    public Acteur() {
    }

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
    public Set<Roles> getRoles() {
        return roles;
    }

    /**
     * Setter
     *
     * @param roles roles
     */
    public void setRoles(Set<Roles> roles) {
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
