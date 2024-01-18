package fr.nsurget.nicolasexamspringboot.Citydex.json_views;

public class GameJsonView {

    public interface GameEssentialView {}

    public interface GameDetailedView extends GameEssentialView {}

    public interface GameFullView extends GameDetailedView {}

}
