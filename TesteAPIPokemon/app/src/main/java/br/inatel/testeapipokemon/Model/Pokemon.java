package br.inatel.testeapipokemon.Model;

/**
 * Created by rodrigo on 06/10/2017.
 */

public class Pokemon {
    private String name;
    private String url;
    private int num;

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

    public int getNum() {
        //take til / and then return the pokemon number position
        String [] urlDiv = url.split("/");
        return Integer.parseInt(urlDiv[urlDiv.length-1]);
    }

    public void setNum(int num) {
        this.num = num;
    }
}
