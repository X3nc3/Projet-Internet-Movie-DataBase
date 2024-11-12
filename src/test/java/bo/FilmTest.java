package bo;
import fr.diginamic.bo.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.*;

import java.util.HashSet;
import java.util.Set;

public class FilmTest {

    private Film film;

    @BeforeEach
    public void setUp() {
        // Créer une instance de Film avant chaque test
        film = new Film("Film 1", "http://example.com", "Un film génial", "Français", "2024");
    }

    @Test
    public void testGettersAndSetters() {
        // Test des méthodes getter et setter pour 'nom'
        film.setNom("Film 2");
        assertEquals("Film 2", film.getNom());

        // Test des méthodes getter et setter pour 'url'
        film.setUrl("http://example2.com");
        assertEquals("http://example2.com", film.getUrl());

        // Test des méthodes getter et setter pour 'plot'
        film.setPlot("Un autre film génial");
        assertEquals("Un autre film génial", film.getPlot());

        // Test des méthodes getter et setter pour 'langue'
        film.setLangue("Anglais");
        assertEquals("Anglais", film.getLangue());

        // Test des méthodes getter et setter pour 'anneeSortie'
        film.setAnneeSortie("2025");
        assertEquals("2025", film.getAnneeSortie());
    }

    @Test
    public void testFilmRelationships() {
        // Utilisation de Mockito pour tester les relations ManyToMany et ManyToOne
        Lieu lieu = Mockito.mock(Lieu.class);
        Set<Lieu> lieux = new HashSet<>();
        lieux.add(lieu);

        film.setLieuTournage(lieux);
        assertEquals(1, film.getLieuTournage().size());

        Genre genre = Mockito.mock(Genre.class);
        Set<Genre> genres = new HashSet<>();
        genres.add(genre);

        film.setGenres(genres);
        assertEquals(1, film.getGenres().size());

        Realisateur realisateur = Mockito.mock(Realisateur.class);
        Set<Realisateur> realisateurs = new HashSet<>();
        realisateurs.add(realisateur);

        film.setRealisateurs(realisateurs);
        assertEquals(1, film.getRealisateurs().size());

        Pays pays = Mockito.mock(Pays.class);
        film.setPays(pays);
        assertNotNull(film.getPays());
    }
}
