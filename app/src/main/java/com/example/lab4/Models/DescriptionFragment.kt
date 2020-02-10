package com.example.lab4.Models


import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.lab4.R
import kotlinx.android.synthetic.main.fragment_description.*

class DescriptionFragment : Fragment(), View.OnClickListener {

    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_description, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.comment_button).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.comment_button -> {
                if(!TextUtils.isEmpty(comment_input.text.toString())){
                    val bundle = bundleOf("comentario" to comment_input.text.toString())
                    navController!!.navigate(
                        R.id.action_descriptionFragment_to_commentFragment,
                        bundle
                    )
                }
                else{
                    Toast.makeText(activity, "Ingrese un comentario", Toast.LENGTH_SHORT).show()
                }

            }
        }
    }

}
