package com.example.zeszytmojejmamykt.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipes")
data class Recipe (
   // @PrimaryKey(autoGenerate = true)
   // val id: Int,
    val title: String,
    val portions: Int,
    val ingredients: String,
    val prepInstructions: String
)
{
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0
}