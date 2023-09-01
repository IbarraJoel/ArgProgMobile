package com.example.appticmascurso

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import android.widget.EditText
import android.util.Log
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.appticmascurso.ui.theme.AppTicmasCursoTheme
import com.example.appticmascurso.R

import com.example.appticmascurso.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    lateinit var t1: EditText
    lateinit var t2: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.comparissonTextModel.observe(this, Observer { currentComparisson ->
            binding.textView2.text = currentComparisson.string
        })


        t1 = findViewById(R.id.editTextText)
        t2 = findViewById(R.id.editTextText2)

        binding.button.setOnClickListener {
            mainViewModel.comparissonTextFun(""+t1.text,""+t2.text)
        }

    }
}
