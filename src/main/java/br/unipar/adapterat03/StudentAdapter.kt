package com.example.studentlist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import br.unipar.adapterat03.R

class StudentAdapter(private val context: Context, private val students: List<Pair<String, String>>) : BaseAdapter() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun getCount(): Int = students.size

    override fun getItem(position: Int): Any = students[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View = convertView ?: inflater.inflate(R.layout.list_item, parent, false)

        val studentName: TextView = view.findViewById(R.id.textViewStudent)
        val studentArea: TextView = view.findViewById(R.id.textViewArea)

        val (name, area) = students[position]

        studentName.text = name
        studentArea.text = area

        return view
    }
}
