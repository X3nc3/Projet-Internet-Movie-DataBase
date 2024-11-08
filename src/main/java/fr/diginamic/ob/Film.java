package fr.diginamic.ob;

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

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "film_tournage",
            joinColumns = @JoinColumn(name = "lieu_tournage_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "film_id", referencedColumnName = "id")
    )
    private Set<Lieu> lieuTournage;

    @ManyToMany
    @JoinTable(name = "film_genre",
            joinColumns = @JoinColumn(name = "id_film"),
            inverseJoinColumns = @JoinColumn(name = "id_genre"))
    private Set<Genre> genres;

    @ManyToMany
    @JoinTable(name = "film_realisateur",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "realisateur_id"))
    private Set<Realisateur> realisateurs;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pays_id")
    private Pays pays;

    @ManyToMany(mappedBy = "filmsCasting")
    private Set<Acteur> CastingPrincipales; // liste des acteurs qui on fait le casting pour le film


    @OneToMany(mappedBy = "filmId", cascade = CascadeType.PERSIST)
    private Set<Roles> Roles; // liste des acteurs qui on était pris pour le film

    {
        lieuTournage = new HashSet<>();
        realisateurs = new HashSet<>();
        genres = new HashSet<>();
        CastingPrincipales = new HashSet<>();
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
     * @return nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Setter
     *
     * @param nom nom
     */
    public void setNom(String nom) {
        this.nom = nom;
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
     * @return plot
     */
    public String getPlot() {
        return plot;
    }

    /**
     * Setter
     *
     * @param plot plot
     */
    public void setPlot(String plot) {
        this.plot = plot;
    }

    /**
     * Getter
     *
     * @return langue
     */
    public String getLangue() {
        return langue;
    }

    /**
     * Setter
     *
     * @param langue langue
     */
    public void setLangue(String langue) {
        this.langue = langue;
    }

    /**
     * Getter
     *
     * @return anneeSortie
     */
    public String getAnneeSortie() {
        return anneeSortie;
    }

    /**
     * Setter
     *
     * @param anneeSortie anneeSortie
     */
    public void setAnneeSortie(String anneeSortie) {
        this.anneeSortie = anneeSortie;
    }

    /**
     * Getter
     *
     * @return genres
     */
    public Set<Genre> getGenres() {
        return genres;
    }

    /**
     * Setter
     *
     * @param genres genres
     */
    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    /**
     * Getter
     *
     * @return realisateurs
     */
    public Set<Realisateur> getRealisateurs() {
        return realisateurs;
    }

    /**
     * Setter
     *
     * @param realisateurs realisateurs
     */
    public void setRealisateurs(Set<Realisateur> realisateurs) {
        this.realisateurs = realisateurs;
    }

    /**
     * Getter
     *
     * @return pays
     */
    public Pays getPays() {
        return pays;
    }

    /**
     * Setter
     *
     * @param pays pays
     */
    public void setPays(Pays pays) {
        this.pays = pays;
    }

    /**
     * Getter for getCastingPrincipales
     *
     * @return CastingPrincipales
     */

    public Set<Acteur> getCastingPrincipales() {
        return CastingPrincipales;
    }

    /**
     * Setter for getCastingPrincipales
     *
     * @return CastingPrincipales
     */

    public void setCastingPrincipales(Set<Acteur> castingPrincipales) {
        CastingPrincipales = castingPrincipales;
    }

    /**
     * Getter for getRoles
     *
     * @return Roles
     */

    public Set<fr.diginamic.ob.Roles> getRoles() {
        return Roles;
    }

    /**
     * Setter for getRoles
     *
     * @return Roles
     */

    public void setRoles(Set<fr.diginamic.ob.Roles> roles) {
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
        sb.append(", genres=").append(genres);
        sb.append(", realisateurs=").append(realisateurs);
        sb.append(", pays=").append(pays);
        sb.append(", CastingPrincipales=").append(CastingPrincipales);
        sb.append(", Roles=").append(Roles);
        sb.append('}');
        return sb.toString();
    }
}