package com.example.a191

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class floating_screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_floating_scrin)

        val fab = findViewById<FloatingActionButton>(R.id.snakbarchik)
        fab.setOnClickListener{
            Snackbar.make(it,"Не нажимайте на данную кнопку. Я вам ЗАПРЕЩАЮ!", Snackbar.LENGTH_SHORT).show()
        }
    }

}