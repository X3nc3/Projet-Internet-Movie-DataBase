package ob;

import jakarta.persistence.*;

@Entity
@Table(name = "LIEU")
public class Lieu {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ville")
    private String ville;

    // Constructeurs


    public Lieu(Long id, String ville) {
        this.id = id;
        this.ville = ville;
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
     * @return ville
     */
    public String getVille() {
        return ville;
    }

    /**
     * Setter
     *
     * @param ville ville
     */
    public void setVille(String ville) {
        this.ville = ville;
    }

    public Lieu() {

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

    // toString (optional, for debugging)
    @Override
    public String toString() {
        return "Lieu{" +
                "id=" + id +
                ", ville='" + ville + '\'' +
                '}';
    }
}
