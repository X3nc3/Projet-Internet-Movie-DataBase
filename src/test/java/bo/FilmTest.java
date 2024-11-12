package fr.diginamic.bo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class FilmTest {

    private Film film;

    @Mock
    private Lieu lieuTournage;

    @Mock
    private Genre genre;

    @Mock
    private Realisateur realisateur;

    @Mock
    private Pays pays;

    @Mock
    private CastingPrincipale castingPrincipal;

    @BeforeEach
    void setUp() {
        // Initialisation des mocks
        MockitoAnnotations.openMocks(this);

        // Création d'un film pour les tests
        film = new Film("FilmTest", "http://test.url", "Plot du film", "Français", "2024");

        // Initialisation des collections de genres, réalisateurs et casting
        Set<Genre> genres = new HashSet<>();
        genres.add(genre);
        film.setGenres(genres);

        Set<Realisateur> realisateurs = new HashSet<>();
        realisateurs.add(realisateur);
        film.setRealisateurs(realisateurs);

        Set<CastingPrincipale> castingPrincipals = new HashSet<>();
        castingPrincipals.add(castingPrincipal);
        film.setCastingPrincipal(castingPrincipals);

        // Simuler l'attribution d'un lieu de tournage
        film.setLieuTournage(lieuTournage);

        // Simuler l'attribution d'un pays
        film.setPays(pays);
    }

    @Test
    void testFilmCreation() {
        assertNotNull(film);
        assertEquals("FilmTest", film.getNom());
        assertEquals("http://test.url", film.getUrl());
        assertEquals("Plot du film", film.getPlot());
        assertEquals("Français", film.getLangue());
        assertEquals("2024", film.getAnneeSortie());
    }

    @Test
    void testFilmGenres() {
        Set<Genre> genres = film.getGenres();
        assertNotNull(genres);
        assertTrue(genres.contains(genre));
    }

    @Test
    void testFilmRealisateurs() {
        Set<Realisateur> realisateurs = film.getRealisateurs();
        assertNotNull(realisateurs);
        assertTrue(realisateurs.contains(realisateur));
    }

    @Test
    void testFilmCastingPrincipal() {
        Set<CastingPrincipale> castingPrincipales = film.getCastingPrincipal();
        assertNotNull(castingPrincipales);
        assertTrue(castingPrincipales.contains(castingPrincipal));
    }

    @Test
    void testFilmLieuTournage() {
        Lieu lieu = film.getLieuTournage();
        assertNotNull(lieu);
        assertEquals(lieuTournage, lieu);
    }

    @Test
    void testFilmPays() {
        Pays paysFilm = film.getPays();
        assertNotNull(paysFilm);
        assertEquals(pays, paysFilm);
    }

    @Test
    void testToString() {
        String filmToString = film.toString();
        assertTrue(filmToString.contains("Film{id='"));
        assertTrue(filmToString.contains("nom='FilmTest'"));
        assertTrue(filmToString.contains("url='http://test.url'"));
    }
}
