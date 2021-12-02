package pndg.codeV2.ihm;

public enum TypeObjet {
    BALL("BALL"),APPLE("APPLE"),HEAD("HEAD");

    private String libelle;
    private  TypeObjet(String lib){
        this.libelle = lib;
    }
    public String getLibelle(){
        return libelle;
    }
}
