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
     * Getter for getid
     *
     * @return id
     */

    public Integer getId() {
        return id;
    }

    /**
     * Setter for getid
     *
     * @return id
     */

    public void setId(Integer id) {
        this.id = id;
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
     * Getter for getacteurId
     *
     * @return acteurId
     */

    public Acteur getActeurId() {
        return acteurId;
    }

    /**
     * Setter for getacteurId
     *
     * @return acteurId
     */

    public void setActeurId(Acteur acteurId) {
        this.acteurId = acteurId;
    }

    /**
     * Getter for getfilmId
     *
     * @return filmId
     */

    public Film getFilmId() {
        return filmId;
    }

    /**
     * Setter for getfilmId
     *
     * @return filmId
     */

    public void setFilmId(Film filmId) {
        this.filmId = filmId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Roles{");
        sb.append("role='").append(role).append('\'');
        sb.append(", characterName='").append(characterName).append('\'');
        sb.append(", id=").append(id);
        sb.append('}');
        return sb.toString();
    }
}