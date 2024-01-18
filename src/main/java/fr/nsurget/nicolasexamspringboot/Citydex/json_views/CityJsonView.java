package fr.nsurget.nicolasexamspringboot.Citydex.json_views;

public class CityJsonView {

    public interface CityEssentialView {}

    public interface CityDetailedView extends CityEssentialView {}

    public interface CityFullView extends CityDetailedView,
            DepartmentJsonView.DepartmentEssentialView,
            PostalCodeJsonView.PostalCodeEssentialView {}
}
