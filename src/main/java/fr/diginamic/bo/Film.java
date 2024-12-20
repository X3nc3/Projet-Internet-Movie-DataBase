package fr.diginamic.bo;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "FILM")
public class Film {

    @Id
    private String id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "url")
    private String url;

    @Column(name = "plot")
    private String plot;

    @Column(name = "langue")
    private String langue;

    @Column(name = "annee_sortie")
    private String anneeSortie;

    @ManyToOne(fetch = FetchType.LAZY)
    private Lieu lieuTournage;

    @ManyToMany
    @JoinTable(name = "FILM_GENRE",
            joinColumns = @JoinColumn(name = "id_film"),
            inverseJoinColumns = @JoinColumn(name = "id_genre"))
    private Set<Genre> genres;

    @ManyToMany
    @JoinTable(name = "FILM_REALISATEURS",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "realisateur_id"))
    private Set<Realisateur> realisateurs;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pays_id")
    private Pays pays;

    @OneToMany(mappedBy = "film")
    private Set<CastingPrincipale> castingPrincipal; // liste des acteurs qui on fait le casting pour le film


    @OneToMany(mappedBy = "film", cascade = CascadeType.PERSIST)
    private Set<Roles> Roles; // liste des acteurs qui on était pris pour le film

    {
        realisateurs = new HashSet<>();
        genres = new HashSet<>();
        castingPrincipal = new HashSet<>();
        Roles = new HashSet<>();
    }

    public Film() {
    }

    public Film(String nom, String url, String plot, String langue, String anneeSortie) {
        this.nom = nom;
        this.url = url;
        this.plot = plot;
        this.langue = langue;
        this.anneeSortie = anneeSortie;
    }

    public Film(String id) {
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
     * Getter for getplot
     *
     * @return plot
     */

    public String getPlot() {
        return plot;
    }

    /**
     * Setter for getplot
     *
     * @return plot
     */

    public void setPlot(String plot) {
        this.plot = plot;
    }

    /**
     * Getter for getlangue
     *
     * @return langue
     */

    public String getLangue() {
        return langue;
    }

    /**
     * Setter for getlangue
     *
     * @return langue
     */

    public void setLangue(String langue) {
        this.langue = langue;
    }

    /**
     * Getter for getanneeSortie
     *
     * @return anneeSortie
     */

    public String getAnneeSortie() {
        return anneeSortie;
    }

    /**
     * Setter for getanneeSortie
     *
     * @return anneeSortie
     */

    public void setAnneeSortie(String anneeSortie) {
        this.anneeSortie = anneeSortie;
    }

    /**
     * Getter for getlieuTournage
     *
     * @return lieuTournage
     */

    public Lieu getLieuTournage() {
        return lieuTournage;
    }

    /**
     * Setter for getlieuTournage
     *
     * @return lieuTournage
     */

    public void setLieuTournage(Lieu lieuTournage) {
        this.lieuTournage = lieuTournage;
    }

    /**
     * Getter for getgenres
     *
     * @return genres
     */

    public Set<Genre> getGenres() {
        return genres;
    }

    /**
     * Setter for getgenres
     *
     * @return genres
     */

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    /**
     * Getter for getrealisateurs
     *
     * @return realisateurs
     */

    public Set<Realisateur> getRealisateurs() {
        return realisateurs;
    }

    /**
     * Setter for getrealisateurs
     *
     * @return realisateurs
     */

    public void setRealisateurs(Set<Realisateur> realisateurs) {
        this.realisateurs = realisateurs;
    }

    /**
     * Getter for getpays
     *
     * @return pays
     */

    public Pays getPays() {
        return pays;
    }

    /**
     * Setter for getpays
     *
     * @return pays
     */

    public void setPays(Pays pays) {
        this.pays = pays;
    }

    /**
     * Getter for getcastingPrincipal
     *
     * @return castingPrincipal
     */

    public Set<CastingPrincipale> getCastingPrincipal() {
        return castingPrincipal;
    }

    /**
     * Setter for getcastingPrincipal
     *
     * @return castingPrincipal
     */

    public void setCastingPrincipal(Set<CastingPrincipale> castingPrincipal) {
        this.castingPrincipal = castingPrincipal;
    }

    /**
     * Getter for getCastingPrincipales
     *
     * @return CastingPrincipales
     */

    public Set<Roles> getRoles() {
        return Roles;
    }

    /**
     * Setter for getRoles
     *
     * @return Roles
     */

    public void setRoles(Set<Roles> roles) {
        Roles = roles;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Film{");
        sb.append("id='").append(id).append('\'');
        sb.append(", nom='").append(nom).append('\'');
        sb.append(", url='").append(url).append('\'');
        sb.append(", plot='").append(plot).append('\'');
        sb.append(", langue='").append(langue).append('\'');
        sb.append(", anneeSortie='").append(anneeSortie).append('\'');
        sb.append(", pays=").append(pays);
        sb.append('}');
        return sb.toString();
    }
}