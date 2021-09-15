package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.longToast
import org.jetbrains.anko.toast


class MainActivity : AppCompatActivity() ,View.OnClickListener{
    private var firstNum = ""
    private var secondNum = ""
    private var flag = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_c.setOnClickListener(this)
        btn_0.setOnClickListener(this)
        btn_1.setOnClickListener(this)
        btn_2.setOnClickListener(this)
        btn_3.setOnClickListener(this)
        btn_4.setOnClickListener(this)
        btn_5.setOnClickListener(this)
        btn_6.setOnClickListener(this)
        btn_7.setOnClickListener(this)
        btn_8.setOnClickListener(this)
        btn_9.setOnClickListener(this)
        btn_addition.setOnClickListener(this)
        btn_equal.setOnClickListener(this)
        btn_multi.setOnClickListener(this)
        btn_sign.setOnClickListener(this)
        btn_substract.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        doClick(""+(v as Button).text)
    }
    private fun doClick(value:String){
        when(value){
            "+","-","*","÷" -> {
                if(firstNum?.isNotEmpty() && secondNum?.isEmpty()){
                    flag = value
                }else if(firstNum?.isNotEmpty() && secondNum?.isNotEmpty()){
                    flag = value
                    doCount()
                }
            }
            "=" ->{
                if(firstNum?.isNotEmpty() && secondNum?.isNotEmpty()){
                    doCount()
                    flag = ""
                }
            }
            "C"->{
                firstNum = ""
                secondNum = ""
                flag = ""
                num_text.text = ""
            }
            else ->{
                if(flag?.isNotEmpty()){
                    if(secondNum?.isEmpty() && value.equals("0")){
                        longToast("除数不能为0")
                    }else{
                        secondNum += value
                        num_text.text = secondNum
                    }
                }else{
                        firstNum += value
                        num_text.text = firstNum

                }
            }
        }
    }
    //进行运算
    private fun doCount(){
        var result = 0.0
        when(flag){
            "+" -> result = firstNum.toDouble() + secondNum.toDouble()
            "-" -> result = firstNum.toDouble() - secondNum.toDouble()
            "*" -> result = firstNum.toDouble() * secondNum.toDouble()
            "÷" -> result = firstNum.toDouble() / secondNum.toDouble()
        }
        firstNum = result.toString()
        secondNum = ""
        num_text.text = result.toString()

    }
}