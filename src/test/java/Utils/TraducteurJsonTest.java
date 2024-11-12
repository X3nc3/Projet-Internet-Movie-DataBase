package Utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.diginamic.Utils.*;
import fr.diginamic.bo.*;
import fr.diginamic.dto.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TraducteurJsonTest {

    private TraducteurJson traducteurJson;
    private ObjectMapper objectMapper;
    private List<Film_dto> filmsTestData;

    @BeforeEach
    void setUp() throws IOException {
        traducteurJson = new TraducteurJson();
        objectMapper = new ObjectMapper();

        // Chargement d'un fichier JSON de test avec des données simplifiées
        File testJsonFile = new File("src/test/resources/test_films.json");
        filmsTestData = objectMapper.readValue(testJsonFile, new TypeReference<List<Film_dto>>() {});
    }

    @Test
    void testTraductionJson_CorrectParsing() {
        assertDoesNotThrow(() -> traducteurJson.TraductionJson(), "L'exécution de TraductionJson a échoué");
    }

    @Test
    void testUniqueCountriesExtracted() throws IOException {
        traducteurJson.TraductionJson();

        // Assurez-vous que chaque pays est unique
        List<Pays> extractedCountries = traducteurJson.getListPaysJson();
        long distinctCount = extractedCountries.stream().map(Pays::getNom).distinct().count();
        assertEquals(extractedCountries.size(), distinctCount, "La liste des pays contient des doublons.");
    }

    @Test
    void testUniqueGenresExtracted() throws IOException {
        traducteurJson.TraductionJson();

        // Vérifie que les genres sont uniques
        List<Genre> extractedGenres = traducteurJson.getListGenreJson();
        long distinctCount = extractedGenres.stream().map(Genre::getNom).distinct().count();
        assertEquals(extractedGenres.size(), distinctCount, "La liste des genres contient des doublons.");
    }

    @Test
    void testLieuxAvecActeurs() throws IOException {
        traducteurJson.TraductionJson();

        // Vérifie si chaque acteur a un lieu de naissance valide
        List<Lieu> lieux = traducteurJson.getListLieuxJson();
        for (Lieu lieu : lieux) {
            assertNotNull(lieu.getVille(), "Le lieu devrait avoir une ville.");
            lieu.getActeurs().forEach(acteur -> {
                assertNotNull(acteur.getLieuNaissance(), "L'acteur devrait avoir un lieu de naissance associé.");
            });
        }
    }

    @Test
    void testRealisteursDistincts() throws IOException {
        traducteurJson.TraductionJson();

        // Vérifie l'unicité des réalisateurs
        List<Realisateur> realisateurs = traducteurJson.getListeRealisteurJson();
        long distinctCount = realisateurs.stream().map(Realisateur::getIdentite).distinct().count();
        assertEquals(realisateurs.size(), distinctCount, "La liste des réalisateurs contient des doublons.");
    }

    @Test
    void testActeursDistincts() throws IOException {
        traducteurJson.TraductionJson();

        // Vérifie l'unicité des acteurs
        List<Acteur> acteurs = traducteurJson.getListeActeurJson();
        long distinctCount = acteurs.stream().map(Acteur::getIdentite).distinct().count();
        assertEquals(acteurs.size(), distinctCount, "La liste des acteurs contient des doublons.");
    }
}
