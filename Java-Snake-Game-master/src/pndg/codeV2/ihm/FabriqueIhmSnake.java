package pndg.codeV2.ihm;

import pndg.codeV2.presenter.PresenterSnake;

import javax.swing.*;
import java.awt.*;

import static pndg.codeV2.ihm.TypeObjet.*;

public final class FabriqueIhmSnake {
    private FabriqueIhmSnake(){
    }

    public final static FenetreJeuSnake creerFenetre( PresenterSnake pres){
        return new FenetreJeuSnake(pres);
    }

    public final static BoardSnake creerBoard( PresenterSnake pres){
        return new BoardSnake(pres);
    }
    public final static Image creerObjet(TypeObjet leType){
        if (leType == TypeObjet.APPLE){
            ImageIcon iia = new ImageIcon("src/resources/apple.png");
            return iia.getImage();
        }else{
            if(leType == BALL){
                ImageIcon iid = new ImageIcon("src/resources/dot.png");
                return iid.getImage();
             }else{
                    ImageIcon iih = new ImageIcon("src/resources/head.png");
                    return iih.getImage();
             }
        }

    }
}