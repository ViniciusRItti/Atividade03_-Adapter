package com.example.studentlist

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import br.unipar.adapterat03.R
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private val students = mutableListOf<Pair<String, String>>()
    private lateinit var adapter: StudentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextName: EditText = findViewById(R.id.editTextName)
        val editTextArea: EditText = findViewById(R.id.editTextArea)
        val buttonAdd: Button = findViewById(R.id.buttonAdd)
        val buttonClear: Button = findViewById(R.id.buttonClear)
        val listViewStudents: ListView = findViewById(R.id.listViewStudents)
        val textViewCount: TextView = findViewById(R.id.textViewCount)

        adapter = StudentAdapter(this, students)
        listViewStudents.adapter = adapter

        buttonAdd.setOnClickListener {
            val name = editTextName.text.toString()
            val area = editTextArea.text.toString()

            if (name.isNotBlank() && area.isNotBlank()) {
                students.add(Pair(name, area))
                adapter.notifyDataSetChanged()
                updateCount()
                editTextName.text.clear()
                editTextArea.text.clear()
            }
        }

        buttonClear.setOnClickListener {
            students.clear()
            adapter.notifyDataSetChanged()
            updateCount()
        }

        updateCount()
    }

    private fun updateCount() {
        val count = students.size
        val currentDate = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())
        findViewById<TextView>(R.id.textViewCount).text = "Quantidade de Alunos: $count\nData: $currentDate"
    }
}
