package com.curso.android.app.proyectoargentinaprograma

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.activity.viewModels
import com.curso.android.app.proyectoargentinaprograma.databinding.ActivityMainBinding
import com.curso.android.app.proyectoargentinaprograma.viewmodel.CompareViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private val compareViewModel: CompareViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        compareViewModel.compareData.observe(this){
            binding.textResult.text = it.result
        }
        binding.compareButton.setOnClickListener {
            // Hide keyboard
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(binding.root.windowToken, 0)

            // Get editText values
            val text1: String = binding.editText1.text.toString()
            val text2: String = binding.editText2.text.toString()

            compareViewModel.compareTexts(text1, text2)

            // Clear editText inputs
            binding.editText1.text.clear()
            binding.editText2.text.clear()
        }
    }
}