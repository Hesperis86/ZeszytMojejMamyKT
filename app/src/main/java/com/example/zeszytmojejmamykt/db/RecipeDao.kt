package com.example.zeszytmojejmamykt.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface RecipeDao {

    @Insert
    fun addRecipe(recipe: Recipe)

    @Query("SELECT * from recipes")
    fun getAllRecipes(): List<Recipe>

    //@Insert
    //fun addMultipleRecipes(vararg recipe: Recipe)
}