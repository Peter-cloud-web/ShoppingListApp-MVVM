package com.seanpetersgichia.shoppinglistapp;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ShoppingListRepository {
    private Context context;


    public ShoppingListRepository(Context context) {
        this.context = context.getApplicationContext();
    }

    public void addNewItem(ShoppingListModel shoppingListModel){
        AsyncTask.execute(() -> ShoppingListDatabase.getDatabase(context).shoppingListDAO().insertItem(shoppingListModel));
    }

    public LiveData<List<ShoppingListModel>> getItems(){
        return ShoppingListDatabase.getDatabase(context).shoppingListDAO().getAllItems();
    }

    public LiveData<Integer> getItemCount(){
        return ShoppingListDatabase.getDatabase(context).shoppingListDAO().countAllItems();
    }

    public void deleteItem(ShoppingListModel shoppingListModel){
        AsyncTask.execute(() -> ShoppingListDatabase.getDatabase(context).shoppingListDAO().deleteItem());
    }
}
