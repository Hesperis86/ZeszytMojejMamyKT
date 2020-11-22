package com.example.zeszytmojejmamykt.ui

import android.os.AsyncTask
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.zeszytmojejmamykt.R
import com.example.zeszytmojejmamykt.db.Recipe
import com.example.zeszytmojejmamykt.db.RecipesDatabase
import kotlinx.android.synthetic.main.fragment_add_recipe.*
import kotlinx.coroutines.launch

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AddRecipeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddRecipeFragment : BaseFragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_recipe, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        button_save.setOnClickListener { view ->
            val recipeTitle = edit_text_title.text.toString().trim()
            //val portionsNum =Integer.parseInt(edit_text_portions.text.toString().trim()) //number??
            val portionsNum = edit_text_portions.text.toString().trim().toInt() //number??
            val ingredients = edit_text_ingredients.text.toString().trim()
            val preparationInstructions = edit_text_preparationInstructions.text.toString()

            if (recipeTitle.isEmpty()) {
                edit_text_title.error = "Title required!"
                edit_text_title.requestFocus()
                return@setOnClickListener
            }

            //if (portionsNum.isEmpty()) {
            //    edit_text_portions.error = "How many portions?"
            //    edit_text_portions.requestFocus()
            //    return@setOnClickListener
            // }

            if (ingredients.isEmpty()) {
                edit_text_ingredients.error = "Ingredients required!"
                edit_text_ingredients.requestFocus()
                return@setOnClickListener
            }

            if (preparationInstructions.isEmpty()) {
                edit_text_preparationInstructions.error = "What should I do with that?"
                edit_text_preparationInstructions.requestFocus()
                return@setOnClickListener
            }

            launch {
                val recipe = Recipe(recipeTitle, portionsNum, ingredients, preparationInstructions)

                context?.let {
                    RecipesDatabase(it).getRecipeDao().addRecipe(recipe)
                    it.toast("Recipe Saved")

                    val action = AddRecipeFragmentDirections.actionSaveRecipe()
                    Navigation.findNavController(view).navigate(action)
                }
            }



            //saveRecipe(recipe)
        }
    }
    /*
    private fun saveRecipe(recipe: Recipe) {
        class SaveRecipe : AsyncTask<Void, Void, Void>() {
            override fun doInBackground(vararg params: Void?): Void? {
                //RecipesDatabase(requireActivity()).getRecipeDao().addRecipe(recipe)
                RecipesDatabase(activity!!).getRecipeDao().addRecipe(recipe)
                return null
            }

            override fun onPostExecute(result: Void?) {
                super.onPostExecute(result)

                Toast.makeText(activity, "Recipe Saved", Toast.LENGTH_LONG).show()
            }
        }
        SaveRecipe().execute()
    }
    */

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AddRecipeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AddRecipeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}