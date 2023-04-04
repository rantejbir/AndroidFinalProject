package com.cst2335.androidfinalproject;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface ListDao {
    @Insert
    public void insertEntry(ListEntry m);
    @Query("Select * from ListEntry")
    public List<ListEntry> getAllEntries();

    @Delete
    public void DeleteEntries(ListEntry m);
}