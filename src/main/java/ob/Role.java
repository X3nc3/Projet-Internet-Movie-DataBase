package ob;

import jakarta.persistence.*;

@Entity
@Table(name = "ROLE")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_acteur")
    private Acteur acteur;

    @ManyToOne
    @JoinColumn(name = "id_film") // Assurez-vous que le nom de la colonne est correct
    private Film film;

    @Column(name = "personnage") // Définir le nom de la colonne pour le personnage
    private String personnage;

    public Role() {
    }

    public Role(Acteur acteur, Film film, String personnage) {
        this.acteur = acteur;
        this.film = film;
        this.personnage = personnage;
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
     * @return acteur
     */
    public Acteur getActeur() {
        return acteur;
    }

    /**
     * Setter
     *
     * @param acteur acteur
     */
    public void setActeur(Acteur acteur) {
        this.acteur = acteur;
    }

    /**
     * Getter
     *
     * @return film
     */
    public Film getFilm() {
        return film;
    }

    /**
     * Setter
     *
     * @param film film
     */
    public void setFilm(Film film) {
        this.film = film;
    }

    /**
     * Getter
     *
     * @return personnage
     */
    public String getPersonnage() {
        return personnage;
    }

    /**
     * Setter
     *
     * @param personnage personnage
     */
    public void setPersonnage(String personnage) {
        this.personnage = personnage;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", acteur=" + acteur +
                ", film=" + film +
                ", personnage='" + personnage + '\'' +
                '}';
    }
}