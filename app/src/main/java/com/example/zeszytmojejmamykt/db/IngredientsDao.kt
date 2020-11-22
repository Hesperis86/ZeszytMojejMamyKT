package com.example.zeszytmojejmamykt.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface IngredientsDao {

    @Insert
    suspend fun addIngredient(ingredients: Ingredients)

    @Query("SELECT * from ingredients")
    suspend fun getAllIngredients(): List<Ingredients>
}