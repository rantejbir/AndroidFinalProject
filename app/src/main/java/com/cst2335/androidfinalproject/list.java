package com.cst2335.androidfinalproject;


public class list {

    private String name ;

    private String category;
    private String others ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }
    public list(){

    }
    public list(String name, String category, String others) {
        this.name = name;
        this.category = category;
        this.others = others;
    }
}
