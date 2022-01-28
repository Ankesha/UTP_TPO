package zad1;


import javax.swing.*;

public class Country {
    private int population;
    private String name;
    private String capital;
    private String path = "data/flags/";
    private ImageIcon flag;

    public Country(String name, String capital, int population, String var) {
        this.name = name;
        this.capital = capital;
        this.population = population;
        path += var + ".png";
        flag = new ImageIcon(path);
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public int getPopulation() {
        return population;
    }

    public ImageIcon getFlag() {
        return flag;
    }

}
