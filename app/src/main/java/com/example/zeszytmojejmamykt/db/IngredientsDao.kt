package com.example.zeszytmojejmamykt.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface IngredientsDao {

    @Insert
    fun addIngredient(ingredients: Ingredients)

    @Query("SELECT * from ingredients")
    fun getAllIngredients(): List<Ingredients>
}