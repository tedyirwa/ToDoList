package com.siiberad.todolist

import android.os.Bundle
import android.view.WindowManager
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.siiberad.todolist.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setView()
    }

    private fun setView() {
        binding.tvHome.text = loadLanguage()[1].name

        val homeAdapter = HomeAdapter(loadLanguage())
        binding.rvHome.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = homeAdapter
        }

        binding.fabHome.setOnClickListener {
            showAlertDialog(homeAdapter)
        }
    }

    private fun loadLanguage() = mutableListOf(
        Language("Java"),
        Language("Kotlin"),
        Language("Python"),
        Language("JavaScript"),
        Language("PHP"),
        Language("CPP"),
    )

    fun showAlertDialog(homeAdapter: HomeAdapter) {
        val editText = EditText(this)

        AlertDialog.Builder(this)
            .setView(editText)
            .setTitle("Dialog")
            .setMessage("Enter some text:")
            .setPositiveButton("OK") { dialog, which ->
                // Handle OK button click
                val enteredText = editText.text.toString()
                homeAdapter.insertItem(Language(enteredText))
            }
            .setNegativeButton("Cancel") { dialog, which ->
                dialog.cancel()
                window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
            }.create().show()
    }
}