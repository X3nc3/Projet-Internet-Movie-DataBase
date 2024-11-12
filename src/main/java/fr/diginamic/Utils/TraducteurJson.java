package fr.diginamic.Utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.diginamic.bo.*;
import fr.diginamic.dto.*;


import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TraducteurJson {

    public static void TraductionJson() throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        File filmsJsonfile = new File("src/main/resources/films.json");
        List<Film_dto> filmsExtreJson = objectMapper.readValue(filmsJsonfile, new TypeReference<List<Film_dto>>() {
        }); // Récupération des données du json

        List<Pays> ListPaysJson = new ArrayList<>();                        // création d'une liste pour stocker tous les pays renseignée dans le json
        for (Film_dto filmDto : filmsExtreJson) {                           // boucle pour récupérer tous les paysDTO du json
            Pays_dto paysDTOExtreJson = filmDto.pays();                     // création d'un paysDTO temporaire pour stocker l'info
            if (paysDTOExtreJson != null) {                                 // vérification si présence de paysDTO
                Pays paysExtreJson = new Pays();                            // création d'un pays pour ajouter des valeurs
                paysExtreJson.setNom(paysDTOExtreJson.nom());               // insertion de la valeur dans le pays
                paysExtreJson.setUrl(paysDTOExtreJson.url());

                boolean paysExiste = false;                                 // code pour verification si présence dans la liste des pays total
                for (Pays pays : ListPaysJson) {
                    if (pays.getNom() != null && pays.getNom().equals(paysExtreJson.getNom())) {
                        paysExiste = true;
                        break;
                    }
                }

                if (!paysExiste) {                                          // s'il n'existe PAS dans la liste
                    ListPaysJson.add(paysExtreJson);                        // ajout dans la liste total si le pays n'y est pas
                }
            }
        }

        List<Genre> ListGenreJson = new ArrayList<>();                      // creation d'une liste pour stocker tous les genres renseignée dans le json
        for (Film_dto filmDto : filmsExtreJson) {                           // boucle pour récupérer tous genres dans les FilmDTO du json // Obtenir la liste des genres pour chaque film

            String[] genresFilm = filmDto.genres();                         // création d'une liste pour stocker les genres du film sélectionné

            for (String nomGenre : genresFilm) {                            // boucle pour récupérer 1 genre par 1 genre
                Genre genreExtreJson = new Genre(nomGenre);                 // Crée un nouvel objet Genre avec le nom du genre

                boolean genreExiste = false;
                int k = 0;
                while (k < ListGenreJson.size()) {                          // code pour viciation si présence dans la liste des genres total
                    Genre genre = ListGenreJson.get(k);

                    if (genre.getNom() != null && genre.getNom().equals(nomGenre)) {
                        genreExiste = true;
                        break;
                    }
                    k++;
                }

                if (!genreExiste) {
                    ListGenreJson.add(genreExtreJson);
                }
            }
        }





        // ** Extraction des lieux **
        List<Lieu> ListLieuxJson = new ArrayList<>();
        for (Film_dto filmDto : filmsExtreJson) {
            Lieu_dto lieuDto = filmDto.lieuTournage();
            if (lieuDto != null) {
                Lieu lieu = new Lieu();
                lieu.setVille(lieuDto.ville());
                boolean lieuExiste = ListLieuxJson.stream().anyMatch(l -> l.getVille().equals(lieu.getVille()));
                if (!lieuExiste) {
                    ListLieuxJson.add(lieu);
                }
            }
        }


        // ** Extraction des réalisateurs **
        List<Realisateur> ListRealisateursJson = new ArrayList<>();
        for (Film_dto filmDto : filmsExtreJson) {
            Realisateur_dto[] realisateursFilm = filmDto.realisateurs();
            if (realisateursFilm != null) {
                for (Realisateur_dto realisateurDto : realisateursFilm) {
                    Realisateur realisateur = new Realisateur();
                    realisateur.setIdentite(realisateurDto.identite());
                    realisateur.setUrl(realisateurDto.url());

                    boolean realisateurExiste = ListRealisateursJson.stream()
                            .anyMatch(r -> r.getIdentite().equals(realisateur.getIdentite()));
                    if (!realisateurExiste) {
                        ListRealisateursJson.add(realisateur);
                    }
                }
            }
        }


        // ** Extraction des rôles **
        List<Roles> ListRolesJson = new ArrayList<>();
        for (Film_dto filmDto : filmsExtreJson) {
            Role_dto[] rolesFilm = filmDto.roles();
            if (rolesFilm != null) {
                for (Role_dto roleDto : rolesFilm) {
                    Roles role = new Roles();
                    role.setCharacterName(roleDto.characterName());
                    role.setFilmId(new Film(filmDto.id()));
                    role.setActeurId(new Acteur(roleDto.acteur().id()));

                    ListRolesJson.add(role);
                }
            }
        }

// Afficher les résultats pour vérification
        System.out.println("Pays : " + Arrays.toString(ListPaysJson.toArray()));
        System.out.println("Genres : " + Arrays.toString(ListGenreJson.toArray()));
//        System.out.println("Acteurs : " + Arrays.toString(ListActeursJson.toArray()));
        System.out.println("Lieux : " + Arrays.toString(ListLieuxJson.toArray()));
        System.out.println("Réalisateurs : " + Arrays.toString(ListRealisateursJson.toArray()));
        System.out.println("Rôles : " + Arrays.toString(ListRolesJson.toArray()));
//        System.out.println("Films : " + Arrays.toString(ListFilmsJson.toArray()));

//        Film[] ListFilms = null;
//
//        for (int i =0;i < ( films.size() -1); i++){
//            Film filmTemp = new Film();
//            filmTemp.setId(films.get(i).id());
//            filmTemp.set
//        }
    }
}
