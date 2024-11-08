package fr.diginamic.ob;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "LIEU")
public class Lieu {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ville")
    private String ville;


    @ManyToOne
    @JoinColumn(name = "pays_id")
    private Pays pays;

    @OneToMany(mappedBy = "lieuNaissance", cascade = CascadeType.PERSIST)
    private Set<Acteur> Acteurs;

    @ManyToMany(mappedBy = "lieuTournage")
    private Set<Film> films;


    {
        Acteurs = new HashSet<>();
        films = new HashSet<>();
    }

    // Constructeurs

    public Lieu() {

    }

    public Lieu(String ville) {
        this.ville = ville;
    }

    /**
     * Getter for getid
     *
     * @return id
     */

    public Long getId() {
        return id;
    }

    /**
     * Setter for getid
     *
     * @return id
     */

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter for getville
     *
     * @return ville
     */

    public String getVille() {
        return ville;
    }

    /**
     * Setter for getville
     *
     * @return ville
     */

    public void setVille(String ville) {
        this.ville = ville;
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
     * Getter for getActeurs
     *
     * @return Acteurs
     */

    public Set<Acteur> getActeurs() {
        return Acteurs;
    }

    /**
     * Setter for getActeurs
     *
     * @return Acteurs
     */

    public void setActeurs(Set<Acteur> acteurs) {
        Acteurs = acteurs;
    }

    /**
     * Getter for getfilms
     *
     * @return films
     */

    public Set<Film> getFilms() {
        return films;
    }

    /**
     * Setter for getfilms
     *
     * @return films
     */

    public void setFilms(Set<Film> films) {
        this.films = films;
    }

    // Equals and HashCode (optional, based on your needs)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lieu lieu = (Lieu) o;

        return id != null ? id.equals(lieu.id) : lieu.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Lieu{");
        sb.append("id=").append(id);
        sb.append(", ville='").append(ville).append('\'');
        sb.append(", pays=").append(pays);
        sb.append('}');
        return sb.toString();
    }
}
