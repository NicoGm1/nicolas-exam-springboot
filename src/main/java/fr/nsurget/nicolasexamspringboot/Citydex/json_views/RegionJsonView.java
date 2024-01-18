package fr.nsurget.nicolasexamspringboot.Citydex.json_views;

public class RegionJsonView {

    public interface RegionEssentialView {
    }

    public interface RegionDetailedView extends RegionEssentialView {
    }

    public interface RegionFullView extends RegionDetailedView,
            DepartmentJsonView.DepartmentEssentialView {
    }

}