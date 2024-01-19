package fr.nsurget.nicolasexamspringboot.Centrafake.json_views;

public class ListingJsonView {

    public interface ListingEssentialView extends ModelJsonView.ModelEssentialView {
    }

    public interface ListingDetailedView extends ListingEssentialView,UserJsonView.UserEssentialView, ModelJsonView.ModelEssentialView {
    }


}