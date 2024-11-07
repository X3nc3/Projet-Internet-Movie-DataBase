package fr.diginamic.ob;

import jakarta.persistence.*;
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
    @JoinColumn(name = "lieu_tournage_id")
    private Lieu lieuTournage;

    @ManyToMany
    @JoinTable(name = "film_genre",
            joinColumns = @JoinColumn(name = "id_film"),
            inverseJoinColumns = @JoinColumn(name = "id_genre"))
    private Set<Genre> genres;

    @ManyToMany
    @JoinTable(name = "film_realisateur",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "realisateurId"))
    private Set<Realisateur> realisateurs;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pays_id")
    private Pays pays;

    @ManyToMany(mappedBy = "acteurs")
    private Set<Acteur> CastingPrincipales; // liste des acteurs qui on fait le casting pour le film

    @(mappedBy = "acteurs")
    private Set<Roles> Roles; // liste des acteurs qui on était pris pour le film




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
     * @return lieuTournage
     */
    public Lieu getLieuTournage() {
        return lieuTournage;
    }

    /**
     * Setter
     *
     * @param lieuTournage lieuTournage
     */
    public void setLieuTournage(Lieu lieuTournage) {
        this.lieuTournage = lieuTournage;
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
}