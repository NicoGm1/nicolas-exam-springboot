package fr.nsurget.nicolasexamspringboot.Citydex.mapping;

import fr.nsurget.nicolasexamspringboot.Citydex.entity.City;

public interface ApiUrlRoute {
    String URL_API = "/api";
    String URL_API_USER = URL_API + "/user";
    String URL_API_REGION = URL_API + "/region";
    String URL_API_DEPARTMENT = URL_API_REGION + "/department";

    String URL_API_CITY = URL_API_DEPARTMENT + "/City";
}
