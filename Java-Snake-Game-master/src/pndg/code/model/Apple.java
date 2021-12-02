package pndg.code.model;

import pndg.code.ihm.C;

public class Apple implements Localisable{
    private int apple_x;
    private int apple_y;

    public int getApple_x() {
        return apple_x;
    }

    public void setApple_x(int apple_x) {
        this.apple_x = apple_x;
    }

    public int getApple_y() {
        return apple_y;
    }

    public void setApple_y(int apple_y) {
        this.apple_y = apple_y;
    }

    public void locateApple() {

        int x = (int) (Math.random()*(C.RAND_POS)) + 1;
        this.setApple_x(x*C.DOT_SIZE);

        int y = (int) (Math.random()*(C.RAND_POS)) + 1;
        this.setApple_y(y*C.DOT_SIZE);

        //System.out.println("APPLE EN Y="+x+" X="+x);
    }

    public Apple(){
        locateApple();
    }
}
