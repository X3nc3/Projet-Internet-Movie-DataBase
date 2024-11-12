package bo;

import fr.diginamic.bo.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Vérifie les fonctionnalités de la class
 */
class FilmTest {

    private Film film;
    private Lieu lieu;
    private Genre genre;
    private Realisateur realisateur;
    private CastingPrincipale castingPrincipale;
    private Roles role;
    private Pays pays;

    @BeforeEach //Initialise les données de test avant chaque méthode de test.
    void initisaliser() {
        film = new Film("Test Film", "http://film.com/film", "A test plot", "Français", "2024");
        lieu = new Lieu();
        genre = new Genre();
        realisateur = new Realisateur();
        castingPrincipale = new CastingPrincipale();
        role = new Roles();
        pays = new Pays();


        film.setLieuTournage(lieu); //Le Lieu (lieu) est associé au film via setLieuTournage(lieu).
        film.setPays(pays); //Le Pays (pays) est associé au film via setPays(pays).


        /**
         * List de type Set<Genre> est créée pour contenir les genres associés au film.
         */
        Set<Genre> genres = new HashSet<>();
        genres.add(genre);
        film.setGenres(genres);

        /**
         * List de type Set<Realisateur> est créée pour contenir les réalisateurs associés au film.
         */
        Set<Realisateur> realisateurs = new HashSet<>();
        realisateurs.add(realisateur);
        film.setRealisateurs(realisateurs);

        /**
         * List de type Set<CastingPrincipale> est créée pour les acteurs ayant passé le casting principal.
         */
        Set<CastingPrincipale> castingPrincipals = new HashSet<>();
        castingPrincipals.add(castingPrincipale);
        film.setCastingPrincipal(castingPrincipals);

        /**
         * Liste de  type Set<Roles> est créée pour représenter les rôles finalement assignés dans le film
          */
        Set<Roles> roles = new HashSet<>();
        roles.add(role);
        film.setRoles(roles);
    }

    /** Teste les getters et setters de la classe Film.
     * Vérifie que les valeurs des attributs sont correctement définies et récupérées.
     */
    @Test
    void testGettersAndSetters() {
        assertEquals("Test Film", film.getNom());
        assertEquals("http://Film.com", film.getUrl());
        assertEquals("A test plot", film.getPlot());
        assertEquals("Français", film.getLangue());
        assertEquals("2022", film.getAnneeSortie());
        assertEquals(lieu, film.getLieuTournage());
        assertEquals(pays, film.getPays());
        assertTrue(film.getGenres().contains(genre));
        assertTrue(film.getRealisateurs().contains(realisateur));
        assertTrue(film.getCastingPrincipal().contains(castingPrincipale));
        assertTrue(film.getRoles().contains(role));
    }

    /**
     * Teste l'ajout d'un nouveau genre à la liste des genres du film.
     * Vérifie que le genre est correctement ajouté à l'ensemble des genres du film.
     */
    @Test
    void testAddGenres() {
        Genre newGenre = new Genre();
        film.getGenres().add(newGenre);
        assertTrue(film.getGenres().contains(newGenre));
    }

    /**
     * Teste l'ajout d'un nouveau réalisateur à la liste des réalisateurs du film.
     * Vérifie que le réalisateur est correctement ajouté à l'ensemble des réalisateurs du film.
     */
    @Test
    void testAddRealisateurs() {
        Realisateur newRealisateur = new Realisateur();
        film.getRealisateurs().add(newRealisateur);
        assertTrue(film.getRealisateurs().contains(newRealisateur));
    }

    /**
     * Teste l'ajout d'un nouveau casting principal au film.
     * Vérifie que le casting est correctement ajouté à l'ensemble des castings principaux du film.
     */
    @Test
    void testAddCastingPrincipale() {
        CastingPrincipale newCasting = new CastingPrincipale();
        film.getCastingPrincipal().add(newCasting);
        assertTrue(film.getCastingPrincipal().contains(newCasting));
    }

    /**
     * Teste l'ajout d'un nouveau rôle à la liste des rôles du film.
     * Vérifie que le rôle est correctement ajouté à l'ensemble des rôles du film.
     */
    @Test
    void testAddRoles() {
        Roles newRole = new Roles();
        film.getRoles().add(newRole);
        assertTrue(film.getRoles().contains(newRole));
    }

}