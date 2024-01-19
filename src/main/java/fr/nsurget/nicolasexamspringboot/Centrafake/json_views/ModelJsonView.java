package fr.nsurget.nicolasexamspringboot.Centrafake.json_views;

public class ModelJsonView {

    public interface ModelEssentialView extends BrandJsonView.BrandEssentialView {
    }

    public interface ModelDetailedView extends ModelEssentialView, BrandJsonView.BrandEssentialView, ListingJsonView.ListingEssentialView {
    }


}