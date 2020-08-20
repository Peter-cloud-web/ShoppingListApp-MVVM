package com.seanpetersgichia.shoppinglistapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ShoppingListDAO {
    @Insert
    void insertItem(ShoppingListModel... shoppingModels);

    @Query("DELETE FROM shoppinglist_table")
    void deleteItem(ShoppingListModel... shoppingModel);

    @Query("SELECT * from shoppinglist_table")
    LiveData<List<ShoppingListModel>> getAllItems();

    @Query("SELECT COUNT(*) from shoppinglist_table")
    LiveData<List<ShoppingListModel>> countAllItems();

    @Query("SELECT groceryTotalPrice FROM shoppinglist_table")
    void getTotalPrice();
}
