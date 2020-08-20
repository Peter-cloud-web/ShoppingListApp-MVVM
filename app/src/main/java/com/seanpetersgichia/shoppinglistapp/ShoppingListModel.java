package com.seanpetersgichia.shoppinglistapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "shoppinglist_table")
public class ShoppingListModel {

    @PrimaryKey
    public int id;

    public String groceryName;

    public int groceryQuantity;

}
