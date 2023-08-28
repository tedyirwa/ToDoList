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
        Language("Java", "Exp : 3 years"),
        Language("Kotlin", "Exp : 2 years"),
        Language("Python", "Exp : 4 years"),
        Language("JavaScript", "Exp : 6 years"),
        Language("PHP", "Exp : 1 years"),
        Language("CPP", "Exp : 8 years"),
    )

}