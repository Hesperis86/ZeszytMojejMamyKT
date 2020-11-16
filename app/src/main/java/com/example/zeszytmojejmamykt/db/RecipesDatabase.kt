package com.example.zeszytmojejmamykt.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Recipe::class, Ingredients::class],
    version = 1
)
abstract class RecipesDatabase : RoomDatabase() {

    abstract fun getRecipeDao(): RecipeDao

    abstract fun getIngredientsDao(): IngredientsDao

    companion object {
        @Volatile private var instance : RecipesDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance?: synchronized(LOCK) {
            instance?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            RecipesDatabase::class.java,
            "recipesdatabase"
        ).build()
    }
}