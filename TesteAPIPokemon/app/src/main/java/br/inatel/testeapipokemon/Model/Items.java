package br.inatel.testeapipokemon.Model;

/**
 * Created by rodrigo on 09/10/2017.
 */

public class Items {
    //private int numI;
    private String name;
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

   /* public int getNumI() {
        String [] urlDiv = url.split("/");
        return Integer.parseInt(urlDiv[urlDiv.length-1]);
    }

    public void setNumI(int numI) {
        this.numI = numI;
    }*/
}
