package com.androiddev.bmicalculator

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.androiddev.bmicalculator.databinding.ActivityMainBinding
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnCalculate.setOnClickListener{

            if(binding.etKg.text.toString() == "" || binding.etCm.text.toString() == ""){
                Toast.makeText(this,"Null field", Toast.LENGTH_SHORT).show()
            }else{

                val valueKg = binding.etKg.text.toString()
                val valueKgFloat = valueKg.toFloat()

                val valueCm = binding.etCm.text.toString()
                val valueCmFloat = valueCm.toFloat()/100

                val value = valueKgFloat/(valueCmFloat*valueCmFloat)
                binding.tvValue.text = String.format("%.2f",value)

                var color = 0

                when{
                    value < 18.5 ->{
                        binding.tvResult.text = "Underweight"
                        color = R.color.BMI_Brown
                    }
                    value >= 18.5 && value < 25 ->{
                        binding.tvResult.text = "Normal"
                        color = R.color.BMI_Green
                    }
                    value >= 25 && value < 30 ->{
                        binding.tvResult.text = "Overweight"
                        color = R.color.BMI_Yellow
                    }
                    value >= 30 ->{
                        binding.tvResult.text = "Obese"
                        color = R.color.BMI_Red
                    }
                }

                binding.tvResult.setTextColor(ContextCompat.getColor(this,color))

            }

        }

    }
}