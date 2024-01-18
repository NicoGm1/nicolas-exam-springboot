package fr.nsurget.nicolasexamspringboot.Citydex.mapping;

import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@FieldDefaults(makeFinal = true)
@Component
@AllArgsConstructor
public class WebUrlRoute {

    public static final String URL_HOME = "/";

    public static final String URL_REGISTER = "/register";

    public static final String URL_LOGIN = "/login";
    public static final String URL_LOGOUT = "/logout";
    public static final String URL_USER = "/user";
    public static final String URL_ADMIN = "/admin";
    public static final String URL_ERROR = "/error";
    public static final String URL_SITEMAP = "/sitmap";
    public static final String URL_SEARCH = "/search";



    public String[] getSiteMapLinks() {
        return new String[]{
                WebUrlRoute.URL_REGISTER,
                WebUrlRoute.URL_LOGIN,
                WebUrlRoute.URL_USER,
                WebUrlRoute.URL_ADMIN,
                WebUrlRoute.URL_SITEMAP
        };
    }
}
