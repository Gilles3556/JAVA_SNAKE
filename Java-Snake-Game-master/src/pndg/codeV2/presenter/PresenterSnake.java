package pndg.codeV2.presenter;

import pndg.codeV2.ihm.FabriqueIhmSnake;
import pndg.codeV2.ihm.FenetreJeuSnake;
import pndg.codeV2.model.FabriqueObjet;
import pndg.codeV2.model.FacadeJeuSnake;
import pndg.codeV2.model.Localisable;
import pndg.codeV2.model.exceptions.JeuSnakeException;

import java.awt.*;

public class PresenterSnake {
    private FacadeJeuSnake fjs;
    private FenetreJeuSnake fen;

    public PresenterSnake(){
     init();
    }

    public void init(){
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
        fjs.addScoreUnePomme();
        fen.majPomme(fjs.getScorePomme());
    }

    public Localisable[] getLesPommes(){
        return fjs.getLesPommes();
    }
    public String afficherTerrain(){
        return fjs.getTerrain().toString();
    }


    public int calculerCollisionApple(int sx,int sy){
        return fjs.calculerCollisionApple(sx,sy);
    }

    public int getCtrPomme(){
        return fjs.getScorePomme();
    }

    public void gererCollision(int idx){
        fjs.faireGrandirSerpent();
        fjs.effacerPomme(idx);
        fjs.augmenterScore();
    }
}
