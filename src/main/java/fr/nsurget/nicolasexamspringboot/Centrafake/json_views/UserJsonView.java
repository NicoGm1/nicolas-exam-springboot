package fr.nsurget.nicolasexamspringboot.Centrafake.json_views;

public class UserJsonView {

    public interface UserEssentialView {
    }

    public interface UserDetailedView extends UserEssentialView {
    }

    public interface UserFullView extends UserDetailedView {
    }

}