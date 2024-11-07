package fr.diginamic.ob;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Pays")
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
     * Getter
     *
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Setter
     *
     * @param id id
     */
    public void setId(Integer id) {
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
        sb.append("nom='").append(nom).append('\'');
        sb.append(", url='").append(url).append('\'');
        sb.append(", lieux=").append(lieux);
        sb.append(", films=").append(films);
        sb.append('}');
        return sb.toString();
    }
}