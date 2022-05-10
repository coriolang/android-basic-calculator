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

        var firstOperand = 0.0
        var secondOperand = 0.0
        var operation = Operation.NONE

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

            if (editText.text.toString() == "-") {
                editText.text.append('0')
            }

            editText.text.append('.')
        }

        findViewById<Button>(R.id.clearButton).setOnClickListener {
            editText.text.clear()
            editText.text.append('0')
        }

        findViewById<Button>(R.id.addButton).setOnClickListener {
            firstOperand = editText.text.toString().toDouble()
            operation = Operation.ADD

            editText.text.clear()
            editText.text.append('0')
        }

        findViewById<Button>(R.id.subtractButton).setOnClickListener {
            if (editText.text.toString() == "0") {
                editText.text.clear()
                editText.text.append('-')

                return@setOnClickListener
            }

            firstOperand = editText.text.toString().toDouble()
            operation = Operation.SUBTRACT

            editText.text.clear()
            editText.text.append('0')
        }

        findViewById<Button>(R.id.multiplyButton).setOnClickListener {
            firstOperand = editText.text.toString().toDouble()
            operation = Operation.MULTIPLY

            editText.text.clear()
            editText.text.append('0')
        }

        findViewById<Button>(R.id.divideButton).setOnClickListener {
            firstOperand = editText.text.toString().toDouble()
            operation = Operation.DIVIDE

            editText.text.clear()
            editText.text.append('0')
        }

        findViewById<Button>(R.id.equalButton).setOnClickListener {
            secondOperand = editText.text.toString().toDouble()

            val result = when (operation) {
                Operation.ADD -> firstOperand + secondOperand
                Operation.SUBTRACT -> firstOperand - secondOperand
                Operation.MULTIPLY -> firstOperand * secondOperand
                Operation.DIVIDE -> firstOperand / secondOperand
                Operation.NONE -> return@setOnClickListener
            }

            operation = Operation.NONE

            editText.text.clear()
            editText.text.append(result.toString())
        }
    }

    private fun appendNumber(symbol: Char, editText: EditText) {
        if (editText.text.toString() == "0") {
            editText.text.clear()
        }

        if (editText.text.toString() == "-0") {
            editText.text.clear()
            editText.text.append("-")
        }

        editText.text.append(symbol)
    }
}