package fr.diginamic.ob;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PAYS")
public class Pays {

    @Id
    private Integer id;

    private String nom;
    private String url;

    // Constructeur sans arguments
    public Pays() {}

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
}