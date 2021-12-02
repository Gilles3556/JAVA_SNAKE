package pndg.codeV2.model;

import pndg.codeV2.ihm.C;

public class Snake implements Croissant {

    private int dots;

    public int getDots() {
        return dots;
    }

    private void setDots(int dots) {
        this.dots = dots;
    }

    public Snake(){
        setDots(C.DOTS_DFLT);
    }

    @Override
    public void grandir() {
        setDots(this.getDots()+1);
    }
}
