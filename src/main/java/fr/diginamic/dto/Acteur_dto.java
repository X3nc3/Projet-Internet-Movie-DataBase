    package fr.diginamic.dto;

    public record Acteur_dto(
          String id,
          String identite,
          Naissance_dto naissance,
          String url,
          String height,
          Role_dto[] roles
    ){}
