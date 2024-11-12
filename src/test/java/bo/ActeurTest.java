package bo;

import fr.diginamic.bo.Acteur;
import fr.diginamic.bo.Film;
import fr.diginamic.bo.Lieu;
import fr.diginamic.bo.Roles;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


public class ActeurTest {

    private Acteur acteur;
    private Lieu lieu;
    private Film film;
    private Roles role;

    @BeforeEach //Initialise les données de test avant chaque méthode de test.
    void initialiser() {
        // Initialisation des objets de test
        acteur = new Acteur("Brad Pitt", "http://bratpitt.com/bratpitt", "1990-1-1", 1.85);
        lieu = new Lieu("Nantes", "Loire Atlantique");
        film = new Film();
        role = new Roles();
    }

    @Nested//Annotation pour organiser les test dans sous catégories
    @DisplayName("Tests des constructeurs")
    class ConstructeurTests {

        /**
         * Test qui vérifie le constructeur par défaut de la classe Acteur.
         * Vérifie que les collections filmsCasting et roles sont correctement initialisées.
         */
        @Test
        @DisplayName("Test du constructeur par défaut sans paramétres")
        void testConstructeurParDefaut() {
            assertNotNull(acteur.getRoles(), "roles doit être initialisé");
            assertTrue(acteur.getRoles().isEmpty(), "roles doit être vide");
        }

        /**Test qui vérifie que le constructeur avec paramètres (Acteur(String, String, String, double))
         * assigne correctement les valeurs à l'acteur, et que les collections sont bien initialisées.
         */

        @Test
        @DisplayName("Test du constructeur avec paramètres")
        void testConstructeurAvecParametres() {

            acteur = new Acteur("Brad Pitt", "http://bratpitt.com/bratpitt", "1990-1-1", 1.85);

            assertEquals("Brad Pitt", acteur.getIdentite());
            assertEquals("http://bratpitt.com/bratpitt", acteur.getUrl());
            assertEquals("1990-1-1", acteur.getDateNaissance());
            assertEquals(1.85, acteur.getTaille(), 0.001);
            assertNotNull(acteur.getRoles());
        }
    }

    @Nested
    @DisplayName("Tests des getters et setters")
    class GetterSetterTests {

        /**
         * Test des getters et setters pour vérifier que les valeurs sont correctement assignées et récupérées.
         */
        @Test
        @DisplayName("Test des getters/setters de base")
        void testGettersSettersBase() {
            String id = "ACT123";
            String identite = "Hassen MALEK";
            String url = "http://hassenmalek.com/hassen";
            String dateNaissance = "1988-7-22";
            double taille = 1.73;

            acteur.setId(id);
            acteur.setIdentite(identite);
            acteur.setUrl(url);
            acteur.setDateNaissance(dateNaissance);
            acteur.setTaille(taille);

            assertEquals(id, acteur.getId());
            assertEquals(identite, acteur.getIdentite());
            assertEquals(url, acteur.getUrl());
            assertEquals(dateNaissance, acteur.getDateNaissance());
            assertEquals(taille, acteur.getTaille());
        }

        /**
         *  Tests des Relations avec d'autres Objets.
         */
        @Test
        @DisplayName("Test de la relation avec Lieu")
        void testRelationLieu() {
            acteur.setLieuNaissance(lieu);
            assertEquals(lieu, acteur.getLieuNaissance());
        }

        /**
         * vérifie la gestion des rôles associés à un acteur.
         * la capacité de l'acteur à stocker et à récupérer correctement les rôles ajoutés
         */
         @Test
        @DisplayName("Test de la gestion des rôles")
        void testGestionRoles() {
            Set<Roles> roles = new HashSet<>();
            roles.add(role);
            acteur.setRoles(roles);

            assertTrue(acteur.getRoles().contains(role));
            assertEquals(1, acteur.getRoles().size());
        }
    }

        /**
         * Vérifie que deux objets Acteur avec le même ID sont considérés comme égaux.
         */
        @Test
        @DisplayName("Test de la méthode equals")
        void testEquals() {
            acteur.setId("ACT123");
            Acteur autreActeur = new Acteur();
            autreActeur.setId("ACT123");

            assertTrue(acteur.equals(acteur));
            assertTrue(acteur.equals(autreActeur));
            assertFalse(acteur.equals(null));
            assertFalse(acteur.equals(new Object()));

            autreActeur.setId("ACT456");
            assertFalse(acteur.equals(autreActeur));
        }

}

