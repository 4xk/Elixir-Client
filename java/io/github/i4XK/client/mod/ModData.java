package io.github.i4XK.client.mod;

public class ModData {
    public String name;
    public Category category;
    public int bind;
    public ModData(String name, Category category, int bind){
        this.name = name;
        this.category = category;
        this.bind = bind;
    }
    public enum Category{
        Combat,Movement,Render,Miscellaneous

    }
}

