package com.cst2335.androidfinalproject;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

/**
 * @author Rantejbir Singh
 * The given code uses the @Dao annotation to specify that the ListDao interface is a DAO (Data Access Object), which
 * offers an abstraction layer for accessing and manipulating data in a database. The interface specifies a number of
 * methods whose intended behaviour is defined by annotations like @Insert, @Query, and @Delete. The compilation of
 * the necessary code to perform the provided SQL queries against the database is made possible by these annotations,
 * which offer metadata to the compiler and the underlying database system.
 * The rest of the application can stay independent of the specifics of the database by enclosing the data access
 * code in a separate DAO layer and relying on a more straightforward and abstract interface for working with data.
 */
@Dao
public interface ListDao {
    @Insert
    public void insertEntry(ListEntry m);
    @Query("Select * from ListEntry")
    public List<ListEntry> getAllEntries();

    @Query("SELECT * FROM ListEntry WHERE id = :id")
    ListEntry getById(int id);
    @Delete
    public void DeleteEntry(ListEntry m);
}