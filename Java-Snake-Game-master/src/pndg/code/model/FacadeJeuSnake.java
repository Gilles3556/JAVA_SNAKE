package pndg.code.model;

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
        jeu=FabriqueObjet.creerJeuSnake();
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

    public int getAppleX(){
        return jeu.getLaPomme().getApple_x();
    }

    public int getAppleY(){
        return jeu.getLaPomme().getApple_y();
    }
    public void faireGrandirSerpent(){
        jeu.getLeSerpent().grandir();
    }
    public void deplacerPomme(){
        jeu.getLaPomme().locateApple();
    }

    public Directions getDirections(){
        return jeu.getDir();
    }

    public void addPomme(){
        jeu.addPomme();
    }

    public int getPomme(){
        return jeu.getNbPomme();
    }

    public String getTerrain(){
        return jeu.getLeTerrain().toString();
    }
}
