package com.siiberad.todolist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.siiberad.todolist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvHome.text = loadLanguage()[1].name

        binding.rvHome.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = HomeAdapter(loadLanguage())
        }
    }

    private fun loadLanguage() = listOf(
        Language("Java"),
        Language("Kotlin"),
        Language("Python"),
        Language("JavaScript"),
        Language("PHP"),
        Language("CPP"),
    )

}