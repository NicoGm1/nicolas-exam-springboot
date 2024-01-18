package fr.nsurget.nicolasexamspringboot.Citydex.json_views;

public class PostalCodeJsonView {

    public interface PostalCodeEssentialView {
    }

    public interface PostalCodeDetailedView extends PostalCodeEssentialView {
    }

    public interface PostalCodeFullView extends PostalCodeDetailedView,CityJsonView.CityEssentialView {
    }

}