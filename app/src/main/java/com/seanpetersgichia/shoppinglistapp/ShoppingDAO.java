package com.seanpetersgichia.shoppinglistapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ShoppingDAO {
    @Insert
    void insertItem(ShoppingModel... shoppingModels);

    @Query("DELETE FROM shoppinglist_table")
    void deleteItem(ShoppingModel... shoppingModel);

    @Query("SELECT * from shoppinglist_table")
    LiveData<List<ShoppingModel>> getAllItems();

    @Query("SELECT COUNT(*) FROM shoppinglist_table")
    LiveData<List<ShoppingModel>> countAllItems();
}
