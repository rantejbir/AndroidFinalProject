package com.cst2335.androidfinalproject;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * @author Rantejbir Singh
 *
 */
@Entity
public class ListEntry {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    public int id;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "category")
    private String category;
    @ColumnInfo(name = "other")
    private String other;


    public ListEntry(String name, String category, String other) {
        this.name = name;
        this.category = category;
        this.other = other;

    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }



    public ListEntry() {
    }

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id=id;
    }


}