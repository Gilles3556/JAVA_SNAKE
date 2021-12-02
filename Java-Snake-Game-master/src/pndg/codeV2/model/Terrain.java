package pndg.codeV2.model;

import pndg.codeV2.ihm.C;

public class Terrain {
    private final int x[] ;
    private final int y[];

    public int[] getX() {
        return x;
    }

    public int[] getY() {
        return y;
    }

    public Terrain(){
        x = new int[C.ALL_DOTS];
        y = new int[C.ALL_DOTS];
    }

    public  String toString(){
        StringBuffer strb = new StringBuffer("Contenu des tableaux\n");
        strb.append("y[]=");
        for(int i=0;i<y.length;i++){
            strb.append(y[i]+" ! ");
        }
        strb.append("\nx[]=");
        for(int j=0;j<x.length;j++){
           strb.append(x[j]+" ! ");
        }
        strb.append("\n");

        return strb.toString();
    }
}
