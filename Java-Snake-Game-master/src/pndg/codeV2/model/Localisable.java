package pndg.codeV2.model;

public interface Localisable {
    /**
     * Méthode chargée de renvoyer la coordonnée X.
     * @return int, si pas intiailisé renverra -1
     */
    public int getApple_x();

    /**
     * Méthode chargée de renvoyer la coordonnée y.
     * @return int, si pas intiailisé renverra -1
     */
    public int getApple_y();

    /**
     * Méthode chargée de renseigner l'attribut x.
     * @param i int
     */
    void setApple_x(int i);

    /**
     * Méthode chargée de rensegner l'attribut y.
     * @param i int
     */
    void setApple_y(int i);

    /**
     * Méthode chargée d'initialiser au hasrd x et y.
     */
    void locateApple();
}
