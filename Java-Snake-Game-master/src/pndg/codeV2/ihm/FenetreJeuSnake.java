package pndg.codeV2.ihm;


import pndg.codeV2.presenter.PresenterSnake;

import javax.swing.*;

public class FenetreJeuSnake extends JFrame {

    public FenetreJeuSnake( PresenterSnake p) {

        initUI(p);
    }
    
    private void initUI(PresenterSnake pres) {
        add(new BoardSnake(pres));
               
        setResizable(false);
        pack();

        setTitle(C.TITRE_JEU2+" , score: 000");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void majPomme(int ctr){
        String msg =String.format("%03d", ctr);
        this.setTitle(C.TITRE_SCORE+msg);
    }
}
