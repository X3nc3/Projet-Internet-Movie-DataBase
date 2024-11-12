package fr.diginamic.bo;

import jakarta.persistence.*;

@Entity
@Table(name = "CASTING")
public class CastingPrincipale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "acteur_id")
    private Acteur acteur;

    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;

    @Column(name = "role")
    private String role;


    public CastingPrincipale() {
    }

    public CastingPrincipale(Acteur acteur, Film film, String role) {
        this.acteur = acteur;
        this.film = film;
        this.role = role;
    }

    /**
     * Getter for getacteur
     *
     * @return acteur
     */

    public Acteur getActeur() {
        return acteur;
    }

    /**
     * Setter for getacteur
     *
     * @return acteur
     */

    public void setActeur(Acteur acteur) {
        this.acteur = acteur;
    }

    /**
     * Getter for getfilm
     *
     * @return film
     */

    public Film getFilm() {
        return film;
    }

    /**
     * Setter for getfilm
     *
     * @return film
     */

    public void setFilm(Film film) {
        this.film = film;
    }

    /**
     * Getter for getrole
     *
     * @return role
     */

    public String getRole() {
        return role;
    }

    /**
     * Setter for getrole
     *
     * @return role
     */

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CastingPrincipale{");
        sb.append("id=").append(id);
        sb.append(", acteur=").append(acteur);
        sb.append(", film=").append(film);
        sb.append(", role='").append(role).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
