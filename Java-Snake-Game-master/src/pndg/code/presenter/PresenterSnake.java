package pndg.code.presenter;

import pndg.code.ihm.FabriqueIhmSnake;
import pndg.code.ihm.FenetreJeuSnake;
import pndg.code.model.FabriqueObjet;
import pndg.code.model.FacadeJeuSnake;

import java.awt.*;

public class PresenterSnake {
    private FacadeJeuSnake fjs;
    private FenetreJeuSnake fen;

    public PresenterSnake(){
     init();
    }

    private void init(){
        fjs = FabriqueObjet.creerFacadeJeu();
        fen = FabriqueIhmSnake.creerFenetre(this);
    }
    public void restart(){
        fjs.restart();
    }
    public FacadeJeuSnake getFjs() {
        return fjs;
    }

    public FenetreJeuSnake getFen() {
        return fen;
    }

    public void executer(){
        EventQueue.invokeLater(() -> {
            fen.setVisible(true);
        });
    }

    public int getDots(){
        return fjs.getDots();
    }
    public int[] getTerrainTabX(){
        return fjs.getTerrainTabX();
    }
    public int[] getTerrainTabY(){
        return fjs.getTerrainTabY();
    }
    public int getAppleX() {
        return fjs.getAppleX();
    }
    public int getAppleY() {
        return fjs.getAppleY();
    }

    public boolean isRightDirection() {
        return fjs.getDirections().isRightDirection();
    }
    public boolean isLeftDirection() {
        return fjs.getDirections().isLeftDirection();
    }
    public boolean isDownDirection(){
        return fjs.getDirections().isDownDirection();
    }
    public boolean isUpDirection(){
        return fjs.getDirections().isUpDirection();
    }

    public void setLeftDirection(boolean b){
        fjs.getDirections().setLeftDirection(b);
    }
    public void setRightDirection(boolean b){
        fjs.getDirections().setRightDirection(b);
    }
    public void setUpDirection(boolean b){
        fjs.getDirections().setUpDirection(b);
    }
    public void setDownDirection(boolean b){
        fjs.getDirections().setDownDirection(b);
    }

    public void addPomme(){
        fjs.addPomme();
        fen.majPomme(fjs.getPomme());
    }

    public String afficherTerrain(){
        return fjs.getTerrain().toString();
    }
}
