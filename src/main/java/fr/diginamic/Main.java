package fr.diginamic;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.diginamic.bo.Film;
import fr.diginamic.bo.Genre;
import fr.diginamic.bo.Pays;
import fr.diginamic.dto.Film_dto;
import fr.diginamic.dto.Pays_dto;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File filmsJsonfile = new File("src/main/resources/films.json");
        List<Film_dto> filmsExtreJson = objectMapper.readValue(filmsJsonfile, new TypeReference<List<Film_dto>>() {}); // Récupération des données du json

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

                if (!paysExiste) { // s'il n'existe PAS dans la liste
                    ListPaysJson.add(paysExtreJson);                        // ajout dans la liste total si le pays n'y est pas
                }
            }
        }

        List<Genre> ListGenreJson = new ArrayList<>();                      // creation d'une liste pour stocker tous les genre renseignée dans le json
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








//        System.out.println(Arrays.toString(ListPaysJson.toArray()));      // affichage de tous les pays
//        System.out.println(Arrays.toString(ListGenreJson.toArray()));     // affichage de tous les genres


//        Film[] ListFilms = null;
//
//        for (int i =0;i < ( films.size() -1); i++){
//            Film filmTemp = new Film();
//            filmTemp.setId(films.get(i).id());
//            filmTemp.set
//        }
    }
}