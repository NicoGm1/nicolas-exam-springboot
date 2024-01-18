package fr.nsurget.nicolasexamspringboot.Citydex.json_views;

public class DepartmentJsonView {

    public interface DepartmentEssentialView {
    }

    public interface DepartmentDetailedView extends DepartmentEssentialView {
    }

    public interface DepartmentFullView extends DepartmentDetailedView,
            CityJsonView.CityEssentialView,
            RegionJsonView.RegionEssentialView {
    }

}