package fr.diginamic.bo;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PAYS")
public class Pays {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "url")
    private String url;

    @Column(name = "lieu")
    @OneToMany(mappedBy = "pays", cascade = CascadeType.PERSIST)
    private Set<Lieu> lieux;

    @OneToMany(mappedBy = "pays", cascade = CascadeType.PERSIST)
    private Set<Film> films;

    {
        lieux = new HashSet<>();
        films = new HashSet<>();
    }

    // Constructeur sans arguments
    public Pays() {}

    public Pays(String nom, String url) {
        this.nom = nom;
        this.url = url;
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
     * Getter for getlieux
     *
     * @return lieux
     */

    public Set<Lieu> getLieux() {
        return lieux;
    }

    /**
     * Setter for getlieux
     *
     * @return lieux
     */

    public void setLieux(Set<Lieu> lieux) {
        this.lieux = lieux;
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

    /** Permet d'ajouter un lieu à un pays
     *
     * @param lieu
     */
    public void ajouterLieu(Lieu lieu){
        if(lieu != null){
            this.getLieux().add(lieu);
            lieu.setPays(this);
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Pays{");
        sb.append("id=").append(id);
        sb.append(", nom='").append(nom).append('\'');
        sb.append(", url='").append(url).append('\'');
        sb.append('}');
        return sb.toString();
    }
}