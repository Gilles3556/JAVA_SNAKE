package pndg.codeV2.model;

import pndg.codeV2.ihm.C;

public final class FabriqueObjet {

    private FabriqueObjet() {
    }

    public final static Localisable creerApple(){
        return new Apple();
    }

    public final static Croissant creerSnake(){
        return new Snake();
    }

    public final static JeuSnake creerJeuSnake(){
        return new JeuSnake();
    }

    public final static Terrain creerTerrain(){return  new Terrain();}

    public final static Directions creerDirections(){ return new Directions();}

    public final static FacadeJeuSnake creerFacadeJeu(){return new FacadeJeuSnake();}

    /**
     * Méthode chargée de créer le tableau des pommes à cueillir.
     * @return Localisable[]
     */
    public static Localisable[] creerTableauPommes() {
        int nb=(int)(Math.random()* C.MAX_POMME-1)+1;
        Localisable[] tabloPommes = new Localisable[nb];
        for(int i=0;i<nb;i++){
            tabloPommes[i]=FabriqueObjet.creerApple();
            //todo: contrôler qu'il n'y pas deux pommes au même emplacment
        }
        return tabloPommes;
    }
}
