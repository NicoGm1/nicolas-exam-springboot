package fr.nsurget.nicolasexamspringboot.appli_name.json_views;

public class GameJsonView {

    public interface GameEssentialView {}

    public interface GameDetailedView extends GameEssentialView {}

    public interface GameFullView extends GameDetailedView {}

}
