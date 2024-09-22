package com.mojavecorp.firstappfortest

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity



class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
// подключаем первую страницу
        val listView = findViewById<ListView>(R.id.listView) // чтобы найти нужный объект вводим R.id.object_name
        val userData: EditText = findViewById(R.id.user_data) // в Котлин прописывают название, где каждое второе слово начинается с верхнего регистра
        val button: Button = findViewById(R.id.button)
        //создаем массив для listView
        val todos: MutableList<String> = mutableListOf()
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, todos)
        listView.adapter = adapter

        //Добавляем обработчик на каждый элемент из списка
        listView.setOnItemClickListener { adapterView, view, i, l ->
            val text = listView.getItemAtPosition(i).toString()
            adapter.remove(text)

            Toast.makeText(this, "Вы выполнили: $text", Toast.LENGTH_LONG).show()
        }
        //Добавляем функционал к объектам
        button.setOnClickListener {
            val text = userData.text.toString().trim()  //trim() - для того, чтобы обрезать не нужные пробелы.
                                                        // Text - переменная для получения информации от пользователя
            if(text != "")
                adapter.insert(text, 0)
        }
    }
}
