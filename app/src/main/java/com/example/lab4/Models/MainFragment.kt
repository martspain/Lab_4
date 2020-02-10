package com.example.lab4.Models


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.lab4.R


class MainFragment : Fragment(), View.OnClickListener{

    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.description_button).setOnClickListener(this)
        view.findViewById<Button>(R.id.about_button).setOnClickListener(this)
        view.findViewById<Button>(R.id.comment_button).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.description_button -> navController!!.navigate(
                R.id.action_mainFragment_to_descriptionFragment
            )
            R.id.about_button -> navController!!.navigate(
                R.id.action_mainFragment_to_aboutFragment
            )
            R.id.comment_button -> navController!!.navigate(
                R.id.action_mainFragment_to_commentFragment
            )
        }
    }

}
