package com.example.zeszytmojejmamykt.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ingredients")
class Ingredients(val ingredient_name: String) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}