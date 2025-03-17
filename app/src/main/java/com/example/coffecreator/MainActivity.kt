package com.example.coffecreator

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.SeekBar
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val coffeImageViev : ImageView = findViewById(R.id.coffe_imageview)

        val coffeImages = listOf(
            R.drawable.latte,
            R.drawable.espresso,
            R.drawable.capuccino
        )
        coffeImageViev.setImageResource(coffeImages[1])

        val coffeRadioGroup : RadioGroup = findViewById(R.id.coffe_radiogroup)
        var coffe = "Espresso"
        coffeRadioGroup.setOnCheckedChangeListener{_, checkedId ->

            val coffeRadioButton : RadioButton = findViewById(checkedId)
            coffe = "${coffeRadioButton.text}"
            coffeImageViev.setImageResource(when(coffeRadioButton.text){
                "Espresso" -> coffeImages[1]
                "Caffe Latte" -> coffeImages[0]
                "Capuccino" -> coffeImages[2]
                else -> coffeImages[1]
            })

        }

        val coffeNumberSeekBar : SeekBar = findViewById(R.id.ilosckawy_seekbar)
        var coffeNumber : Int = 1
        val coffenumberTextView : TextView = findViewById(R.id.coffe_number_textview)


        coffeNumberSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{

            override fun onProgressChanged(p0: SeekBar?, progress: Int, fromUser: Boolean) {
                coffenumberTextView.text = "Ilość kaw: ${progress}"
                coffeNumber = progress
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                val a =1
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                val b = 1
            }

        })


        val milkCheckBox : CheckBox = findViewById(R.id.mleko_checkbox)
        var milk = "Bez dodatkowego mleka"
        milkCheckBox.setOnCheckedChangeListener { _, isChecked ->

            if(isChecked)
            {
                milk = "Dodatkowe mleko"
            }
            else
            {
                milk = "Bez dodatkowego mleka"
            }

        }

        val sugarCheckBox : CheckBox = findViewById(R.id.cukier_checkbox)
        var sugar = "Bez dodatkowego cukru"
        sugarCheckBox.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked)
            {
                 sugar = "Dodatkowy cukier"
            }
            else
            {
                 sugar = "Bez dodatkowego cukru"
            }
        }

        val orderButton : Button = findViewById(R.id.order_button)

        orderButton.setOnClickListener {
            Toast.makeText(this, "Twoje zamówienie to: ${coffeNumber} $coffe \n $milk \n $sugar", Toast.LENGTH_SHORT).show()

            Log.i("myInfo", "Twoje zamówienie to: ${coffeNumber} $coffe \n $milk \n $sugar")
        }




    }
}