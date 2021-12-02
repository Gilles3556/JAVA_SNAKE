package pndg.codeV2.model;

import pndg.codeV2.model.exceptions.JeuSnakeException;

public class JeuSnake {

    private Localisable[] lesPommes;

    private Croissant leSerpent;
    private Terrain leTerrain;
    private Directions dir;

    private int nbPomme;

    public int getNbPomme() {
        return nbPomme;
    }
    public void addPomme(){
        nbPomme++;
    }

    public Directions getDir() {
        return dir;
    }

    public Terrain getLeTerrain() {
        return leTerrain;
    }

    public void setLeTerrain( Terrain leTerrain) {
        this.leTerrain = leTerrain;
    }

    public Localisable[] getLesPommes() {
        return lesPommes;
    }


    /**
     * Méthode chargée de contrôler qu'il reste des pommes à trouver.
     * @return boolean
     */
    private boolean resterPommes(){
        int nb=0;
        for(int i=0;i<lesPommes.length;i++){
            if( lesPommes[i]!=null){
                nb++;
            }
        }
        return (nb>0);
    }


    public Croissant getLeSerpent() {
        return leSerpent;
    }

    public void setLeSerpent( Croissant leSerpent) {
        this.leSerpent = leSerpent;
    }

    public JeuSnake() {
        init();
    }

    public void init(){
        nbPomme=0;
        leSerpent = FabriqueObjet.creerSnake();

        /* MEP d'un nombre aléatoire de pomme */
        lesPommes = FabriqueObjet.creerTableauPommes();

        leTerrain = FabriqueObjet.creerTerrain();
        dir = FabriqueObjet.creerDirections();
    }

    /*
    public void calculerPommeSuivante() throws JeuSnakeException{


        lesPommes[idxPommeCourante]=null;
        idxPommeCourante++;

        //si  dernière pomme
        if (idxPommeCourante>lesPommes.length){
            throw new JeuSnakeException("fin de la cueillette");
        }
    }

     */

    /**
     * Méthode chargée de retrouver l'indice de la pomme raméssée par la téte du serpent.
     * @param sx: int
     * @param sy: int
     * @return int : renverra -1 si pas trouvé
     */
    public int calculerCollisionApple(int sx,int sy){
        int idx=-1;

        boolean trouve=false;

       int i=0;
       do{
           if (lesPommes[i]!=null) {
               if (sx == lesPommes[i].getApple_x() && sy == lesPommes[i].getApple_y()) {
                   idx = i;
                   trouve = true;
               }
           }
           i++;

       }while(!trouve && i<lesPommes.length);

       return idx;
    }

    public void effacerPomme(int idx){
        lesPommes[idx]=null;
    }
    /* ---------------------------------------------- */
}
