package fr.diginamic.ob;

import jakarta.persistence.*;

@Entity
@Table(name = "ROLES")
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "character_name")
    private String characterName;

    @Column(name = "role")
    private String role;

    @ManyToOne
    @JoinColumn(name = "id_acteur")
    private Acteur acteurId;

    @ManyToOne
    @JoinColumn(name = "id_film")
    private Film filmId;

    public Roles() {
    }

    public Roles(String role, String characterName) {
        this.role = role;
        this.characterName = characterName;
    }

    /**
     * Getter for getcharacterName
     *
     * @return characterName
     */

    public String getCharacterName() {
        return characterName;
    }

    /**
     * Setter for getcharacterName
     *
     * @return characterName
     */

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
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

    /**
     * Getter for getacteur_id
     *
     * @return acteur_id
     */

    public Acteur getActeurId() {
        return acteurId;
    }

    /**
     * Setter for getacteur_id
     *
     * @return acteur_id
     */

    public void setActeurId(Acteur acteurId) {
        this.acteurId = acteurId;
    }

    /**
     * Getter for getfilm_id
     *
     * @return film_id
     */

    public Film getFilm_id() {
        return filmId;
    }

    /**
     * Setter for getfilm_id
     *
     * @return film_id
     */

    public void setFilm_id(Film film_id) {
        this.filmId = film_id;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Roles{");
        sb.append("characterName='").append(characterName).append('\'');
        sb.append(", role='").append(role).append('\'');
        sb.append(", acteur_id=").append(acteurId);
        sb.append(", film_id=").append(filmId);
        sb.append('}');
        return sb.toString();
    }
}