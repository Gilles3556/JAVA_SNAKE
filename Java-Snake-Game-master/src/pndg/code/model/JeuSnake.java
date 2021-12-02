package pndg.code.model;

public class JeuSnake {

    private Localisable laPomme;
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

    public void setLeTerrain(Terrain leTerrain) {
        this.leTerrain = leTerrain;
    }

    public Localisable getLaPomme() {
        return laPomme;
    }

    public void setLaPomme(Localisable laPomme) {
        this.laPomme = laPomme;
    }

    public Croissant getLeSerpent() {
        return leSerpent;
    }

    public void setLeSerpent(Croissant leSerpent) {
        this.leSerpent = leSerpent;
    }

    public JeuSnake() {
        init();
    }

    public void init(){
        nbPomme=0;
        leSerpent = FabriqueObjet.creerSnake();
        laPomme = FabriqueObjet.creerApple();
        leTerrain = FabriqueObjet.creerTerrain();
        dir = FabriqueObjet.creerDirections();
    }

    /* ---------------------------------------------- */
}
