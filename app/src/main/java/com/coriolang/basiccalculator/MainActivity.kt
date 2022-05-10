package com.coriolang.basiccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText = findViewById<EditText>(R.id.editText)

        findViewById<Button>(R.id.button0).setOnClickListener {
            appendNumber('0', editText)
        }

        findViewById<Button>(R.id.button1).setOnClickListener {
            appendNumber('1', editText)
        }

        findViewById<Button>(R.id.button2).setOnClickListener {
            appendNumber('2', editText)
        }

        findViewById<Button>(R.id.button3).setOnClickListener {
            appendNumber('3', editText)
        }

        findViewById<Button>(R.id.button4).setOnClickListener {
            appendNumber('4', editText)
        }

        findViewById<Button>(R.id.button5).setOnClickListener {
            appendNumber('5', editText)
        }

        findViewById<Button>(R.id.button6).setOnClickListener {
            appendNumber('6', editText)
        }

        findViewById<Button>(R.id.button7).setOnClickListener {
            appendNumber('7', editText)
        }

        findViewById<Button>(R.id.button8).setOnClickListener {
            appendNumber('8', editText)
        }

        findViewById<Button>(R.id.button9).setOnClickListener {
            appendNumber('9', editText)
        }

        findViewById<Button>(R.id.dotButton).setOnClickListener {
            if (editText.text.contains(".")) {
                return@setOnClickListener
            }

            editText.text.append('.')
        }

        findViewById<Button>(R.id.clearButton).setOnClickListener {
            editText.text.clear()
            editText.text.append('0')
        }
    }

    private fun appendNumber(symbol: Char, editText: EditText) {
        if (editText.text.contains("0") && editText.text.length == 1) {
            editText.text.clear()
        }

        editText.text.append(symbol)
    }
}