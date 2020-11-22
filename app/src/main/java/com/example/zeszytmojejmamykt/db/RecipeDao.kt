package com.example.zeszytmojejmamykt.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface RecipeDao {

    @Insert
    suspend fun addRecipe(recipe: Recipe) //suspend means that the function can be reached only in scope of a coroutine

    @Query("SELECT * from recipes ORDER BY id DESC")
    suspend fun getAllRecipes(): List<Recipe>

    //@Insert
    //fun addMultipleRecipes(vararg recipe: Recipe)
}