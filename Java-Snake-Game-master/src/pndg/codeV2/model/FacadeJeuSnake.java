package pndg.codeV2.model;

import pndg.codeV2.model.exceptions.JeuSnakeException;

public class FacadeJeuSnake {

   private JeuSnake jeu;

    public JeuSnake getJeu() {
        return jeu;
    }

    public FacadeJeuSnake(){
        jeu = FabriqueObjet.creerJeuSnake();
    }

    public void init(){
        jeu.init();
    }
    public void restart(){
        jeu= FabriqueObjet.creerJeuSnake();
        init();
    }
    public int getDots(){
        return jeu.getLeSerpent().getDots();
    }
    public int[] getTerrainTabX(){
        return jeu.getLeTerrain().getX();
    }
    public int[] getTerrainTabY(){
        return jeu.getLeTerrain().getY();
    }


    public void faireGrandirSerpent(){
        jeu.getLeSerpent().grandir();
    }


    public Directions getDirections(){
        return jeu.getDir();
    }

    public void addScoreUnePomme(){
        jeu.addPomme();
    }

    public int getScorePomme(){
        return jeu.getNbPomme();
    }

    public String getTerrain(){
        return jeu.getLeTerrain().toString();
    }

    private boolean etreFinDesPommes(){
        int ctr=0;
        for(int i=0;i<jeu.getLesPommes().length;i++){
            if (jeu.getLesPommes()[i]==null){
                ctr++;
            }
        }
        if(ctr == jeu.getLesPommes().length){
            return true;
        }else{
            return false;
        }
    }
    public Localisable[] getLesPommes(){
        if(etreFinDesPommes()){
            return null;
        }
        return jeu.getLesPommes();

    }

    public int calculerCollisionApple(int sx,int sy){
        return jeu.calculerCollisionApple( sx, sy);
    }
    public void effacerPomme(int idx){
        jeu.effacerPomme(idx);
    }
    public void augmenterScore(){
        jeu.addPomme();
    }
}
