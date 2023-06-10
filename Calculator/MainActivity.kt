package com.example.calculator

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.Button_0
import kotlinx.android.synthetic.main.activity_main.Button_1
import kotlinx.android.synthetic.main.activity_main.Button_2
import kotlinx.android.synthetic.main.activity_main.Button_3
import kotlinx.android.synthetic.main.activity_main.Button_4
import kotlinx.android.synthetic.main.activity_main.Button_5
import kotlinx.android.synthetic.main.activity_main.Button_6
import kotlinx.android.synthetic.main.activity_main.Button_7
import kotlinx.android.synthetic.main.activity_main.Button_8
import kotlinx.android.synthetic.main.activity_main.Button_9
import kotlinx.android.synthetic.main.activity_main.Button_addition
import kotlinx.android.synthetic.main.activity_main.Button_division
import kotlinx.android.synthetic.main.activity_main.Button_dot
import kotlinx.android.synthetic.main.activity_main.Button_equal
import kotlinx.android.synthetic.main.activity_main.Button_multiply
import kotlinx.android.synthetic.main.activity_main.Button_subtract
import kotlinx.android.synthetic.main.activity_main.button_bracket_left
import kotlinx.android.synthetic.main.activity_main.button_bracket_right
import kotlinx.android.synthetic.main.activity_main.button_clear
import kotlinx.android.synthetic.main.activity_main.input
import kotlinx.android.synthetic.main.activity_main.output
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button_clear.setOnClickListener {
            input.text = ""
            output.text = ""
        }
        button_bracket_left.setOnClickListener {
            input.text = addToInputText("(")
        }
        button_bracket_right.setOnClickListener {
            input.text = addToInputText(")")
        }
        Button_0.setOnClickListener {
            input.text = addToInputText("0")
        }
        Button_1.setOnClickListener {
            input.text = addToInputText("1")
        }
        Button_2.setOnClickListener {
            input.text = addToInputText("2")
        }
        Button_3.setOnClickListener {
            input.text = addToInputText("3")
        }
        Button_4.setOnClickListener {
            input.text = addToInputText("4")
        }
        Button_5.setOnClickListener {
            input.text = addToInputText("5")
        }
        Button_6.setOnClickListener {
            input.text = addToInputText("6")
        }
        Button_7.setOnClickListener {
            input.text = addToInputText("7")
        }
        Button_8.setOnClickListener {
            input.text = addToInputText("8")
        }
        Button_9.setOnClickListener {
            input.text = addToInputText("9")
        }
        Button_division.setOnClickListener {
            input.text = addToInputText("÷")
        }
        Button_addition.setOnClickListener {
            input.text = addToInputText("+")
        }

        Button_subtract.setOnClickListener {
            input.text = addToInputText("-")
        }
        Button_dot.setOnClickListener {
            input.text = addToInputText(".")
        }
        Button_multiply.setOnClickListener {
            input.text = addToInputText("×")

        }
        Button_equal.setOnClickListener {
            showresult()
        }
    }
    private fun addToInputText(buttonValue: String):String{
        return "${input.text}$buttonValue"
    }
    private fun getInputExp():String{
        var expression=input.text.replace(Regex("÷"),"/")
        expression=expression.replace(Regex("×"),"*")
        return expression
    }
    @SuppressLint("SetTextI18n")
    private fun showresult(){
        try{
            val expression=getInputExp()
            val result= Expression(expression).calculate()
            if(result.isNaN()){
                output.text="Error"
                output.setTextColor(ContextCompat.getColor(this,R.color.red))
            }
            else{
                output.text=DecimalFormat("0.######").format(result).toString()
                output.setTextColor(ContextCompat.getColor(this,R.color.green))
            }
        }catch (e:Exception){
            output.text="Error"
            output.setTextColor(ContextCompat.getColor(this,R.color.red))

        }
    }
}
