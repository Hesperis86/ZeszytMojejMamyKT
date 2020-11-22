package com.example.zeszytmojejmamykt.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.zeszytmojejmamykt.R
import com.example.zeszytmojejmamykt.db.Recipe
import kotlinx.android.synthetic.main.recipe_layout.view.*

class RecipesAdapter(private val recipes: List<Recipe>) : RecyclerView.Adapter<RecipesAdapter.RecipeViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        return RecipeViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recipe_layout, parent, false)
        )
    }

    override fun getItemCount() = recipes.size


    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.view.text_view_name.text = recipes[position].title
        holder.view.text_view_portions.text = recipes[position].portions.toString() //int
        holder.view.text_view_ingredients.text = recipes[position].ingredients
        holder.view.text_view_preparationInstructions.text = recipes[position].prepInstructions
    }

    class RecipeViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}
