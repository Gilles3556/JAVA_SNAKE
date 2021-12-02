package pndg.code.ihm;


import pndg.code.model.FabriqueObjet;
import pndg.code.model.FacadeJeuSnake;
import pndg.code.model.JeuSnake;
import pndg.code.presenter.PresenterSnake;

import javax.swing.*;
import java.awt.*;

public class FenetreJeuSnake extends JFrame {

    public FenetreJeuSnake( PresenterSnake p) {

        initUI(p);
    }
    
    private void initUI(PresenterSnake pres) {


        add(new BoardSnake(pres));
               
        setResizable(false);
        pack();
        
        //setTitle(C.TITRE_JEU);
        setTitle("SNAKE: , score: 000");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void majPomme(int ctr){
        String msg =String.format("%03d", ctr);
        this.setTitle(C.TITRE_SCORE+msg);
    }
}
