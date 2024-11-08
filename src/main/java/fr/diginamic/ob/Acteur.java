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

    @Column(name = "date_naissance")
    private LocalDate dateNaissance;

    @Column(name = "taille")
    private double taille;

    @ManyToOne
    @JoinColumn(name = "lieu_id")
    private Lieu lieuNaissance;

    @ManyToMany
    @JoinTable(
            name = "CASTING",
            joinColumns = { @JoinColumn(name = "id_acteur") },
            inverseJoinColumns = { @JoinColumn(name = "id_film") }
    )
    private Set<Film> filmsCasting;

    @OneToMany(mappedBy = "acteurId", cascade = CascadeType.PERSIST)
    private Set<Roles> roles;


    {
        filmsCasting = new HashSet<>();
        roles = new HashSet<>();
    }

    public Acteur() {
    }

    public Acteur(String identite, String url, LocalDate dateNaissance, double taille) {
        this.identite = identite;
        this.url = url;
        this.dateNaissance = dateNaissance;
        this.taille = taille;
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
    public double getTaille() {
        return taille;
    }

    /**
     * Setter
     *
     * @param taille height
     */
    public void setTaille(double taille) {
        this.taille = taille;
    }

    /**
     * Getter for getgetLieuNaissance
     *
     * @return getLieuNaissance
     */

    public Lieu getLieuNaissance() {
        return lieuNaissance;
    }

    /**
     * Setter for getgetLieuNaissance
     *
     * @return getLieuNaissance
     */

    public void setLieuNaissance(Lieu lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    /**
     * Getter for getfilmsCasting
     *
     * @return filmsCasting
     */

    public Set<Film> getFilmsCasting() {
        return filmsCasting;
    }

    /**
     * Setter for getfilmsCasting
     *
     * @return filmsCasting
     */

    public void setFilmsCasting(Set<Film> filmsCasting) {
        this.filmsCasting = filmsCasting;
    }

    /**
     * Getter for getroles
     *
     * @return roles
     */

    public Set<Roles> getRoles() {
        return roles;
    }

    /**
     * Setter for getroles
     *
     * @return roles
     */

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
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
        final StringBuilder sb = new StringBuilder("Acteur{");
        sb.append("id='").append(id).append('\'');
        sb.append(", identite='").append(identite).append('\'');
        sb.append(", url='").append(url).append('\'');
        sb.append(", dateNaissance=").append(dateNaissance);
        sb.append(", height=").append(taille);
        sb.append(", getLieuNaissance=").append(lieuNaissance);
        sb.append(", filmsCasting=").append(filmsCasting);
        sb.append(", roles=").append(roles);
        sb.append('}');
        return sb.toString();
    }
}
