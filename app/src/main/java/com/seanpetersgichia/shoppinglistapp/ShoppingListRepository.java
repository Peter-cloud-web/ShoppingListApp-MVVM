package com.seanpetersgichia.shoppinglistapp;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ShoppingListRepository {
    private ShoppingListDAO mShoppingListDAO;
    private LiveData<List<ShoppingListModel>> shoppingListTable;

    ShoppingListRepository(Application application){
        ShoppingListDatabase db = ShoppingListDatabase.getDatabase(application);
        mShoppingListDAO = db.shoppingListDAO();
        shoppingListTable = mShoppingListDAO.getAllItems();
    }

    LiveData<List<ShoppingListModel>> getAllItemsSaved(){
        return  shoppingListTable;
    }

    void insert(final ShoppingListModel...shoppingListModels){
        ShoppingListDatabase.databaseWriteExecutor.execute(() -> {
            mShoppingListDAO.insertItem(shoppingListModels);
        });
    }

}
