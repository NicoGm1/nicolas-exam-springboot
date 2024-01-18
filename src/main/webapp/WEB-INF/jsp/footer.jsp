<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="fr.nsurget.nicolasexamspringboot.Citydex.mapping.WebUrlRoute" %>
    </body>
    <div class="top-footer">
    </div>
    <div class="footer">
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-6">
                    <h4 class="mb-3">Informations de contact</h4>
                    <p>Contactez-nous : toto@toto.to</p>
                    <p>Téléphone : +123 456 7890</p>
                    <p>Adresse : 123 Rue des Taux, Totocity </p>
                    <p>28.197697, -177.394533</p>
                </div>
                <div class="col-lg-3 col-md-6">
                    <h4 class="mb-3">Liens utiles</h4>
                    <nav>
                        <a href="${WebUrlRoute.URL_HOME}">Accueil</a>
                        <a href="${WebUrlRoute.URL_SITEMAP}">Sitemap</a>
                        <a href="${WebUrlRoute.URL_LOGIN}">Login</a>
                    </nav>
                    <p><a href="/privacy-policy">Politique de confidentialité</a> | <a href="/terms-of-use">Conditions
                        d'utilisation</a></p>
                </div>
                <div class="col-lg-3 col-md-6">
                    <h4 class="mb-3">Réseaux sociaux</h4>
                    <ul class="list-unstyled">
                        <li><a href="https://fr-fr.facebook.com/HBCOMPETENCES/"><i class="fab fa-facebook-f"></i></a>&thinsp;- <a
                                href="https://fr-fr.facebook.com/HBCOMPETENCES/">Toto</a></li>
                        <li><a href="https://twitter.com"><i class="fa-brands fa-x-twitter"></i></a>&thinsp;- <a
                                href="https://twitter.com">Toto</a></li>

                    </ul>
                </div>
                <div class="col-lg-3 col-md-6">
                    <h4 class="mb-3">Crédits et droits d'auteur</h4>
                    <p>&copy; 2024 Exam POEC 2024. Tous droits réservés.</p>
                    <p>Images par <a class="nav-link" href="https://unsplash.com/">Unsplash</a></p>
                </div>
            </div>
        </div>
        <div class="line-footer">
        </div>
    </div>
</html>