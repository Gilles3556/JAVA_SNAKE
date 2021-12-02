package pndg.code.model;

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
}
