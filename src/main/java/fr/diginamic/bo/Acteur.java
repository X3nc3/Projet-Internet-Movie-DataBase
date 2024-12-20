package fr.diginamic.bo;

import jakarta.persistence.*;

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
    private String dateNaissance;

    @Column(name = "taille")
    private double taille;

    @ManyToOne
    @JoinColumn(name = "lieu_id")
    private Lieu lieuNaissance;

    @OneToMany(mappedBy = "acteur", cascade = CascadeType.PERSIST)
    private Set<CastingPrincipale> castingPrincipaleFilms;

    @OneToMany(mappedBy = "acteur", cascade = CascadeType.PERSIST)
    private Set<Roles> roles;


    {
        roles = new HashSet<>();
    }

    public Acteur() {
    }

    public Acteur(String identite, String url, String dateNaissance, double taille) {
        this.identite = identite;
        this.url = url;
        this.dateNaissance = dateNaissance;
        this.taille = taille;
    }

    public Acteur(String id) {
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
     * Getter for getdateNaissance
     *
     * @return dateNaissance
     */

    public String getDateNaissance() {
        return dateNaissance;
    }

    /**
     * Setter for getdateNaissance
     *
     * @return dateNaissance
     */

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    /**
     * Getter for gettaille
     *
     * @return taille
     */

    public double getTaille() {
        return taille;
    }

    /**
     * Setter for gettaille
     *
     * @return taille
     */

    public void setTaille(double taille) {
        this.taille = taille;
    }

    /**
     * Getter for getlieuNaissance
     *
     * @return lieuNaissance
     */

    public Lieu getLieuNaissance() {
        return lieuNaissance;
    }

    /**
     * Setter for getlieuNaissance
     *
     * @return lieuNaissance
     */

    public void setLieuNaissance(Lieu lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    /**
     * Getter for getcastingPrincipaleFilms
     *
     * @return castingPrincipaleFilms
     */

    public Set<CastingPrincipale> getCastingPrincipaleFilms() {
        return castingPrincipaleFilms;
    }

    /**
     * Setter for getcastingPrincipaleFilms
     *
     * @return castingPrincipaleFilms
     */

    public void setCastingPrincipaleFilms(Set<CastingPrincipale> castingPrincipaleFilms) {
        this.castingPrincipaleFilms = castingPrincipaleFilms;
    }

    /**
     * Getter for getfilmsCasting
     *
     * @return filmsCasting
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
        sb.append("taille=").append(taille);
        sb.append(", dateNaissance=").append(dateNaissance);
        sb.append(", url='").append(url).append('\'');
        sb.append(", identite='").append(identite).append('\'');
        sb.append(", id='").append(id).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
