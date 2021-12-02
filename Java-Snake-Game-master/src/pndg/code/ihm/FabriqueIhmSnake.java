package pndg.code.ihm;

import pndg.code.model.FacadeJeuSnake;
import pndg.code.model.JeuSnake;
import pndg.code.presenter.PresenterSnake;

public final class FabriqueIhmSnake {
    private FabriqueIhmSnake(){
    }

    public final static FenetreJeuSnake creerFenetre( PresenterSnake pres){
        return new FenetreJeuSnake(pres);
    }

    public final static BoardSnake creerBoard(PresenterSnake pres){
        return new BoardSnake(pres);
    }
}