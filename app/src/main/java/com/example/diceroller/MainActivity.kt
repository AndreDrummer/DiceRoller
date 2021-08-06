package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)

        rollButton.setOnClickListener {
            rollDice()
        }

        rollDice()
    }

    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val dice2Roll = dice.roll()
        val diceImage: ImageView = findViewById(R.id.imageView);
        val dice2Image: ImageView = findViewById(R.id.imageView2);

        val drawableResourceDice1 = when(diceRoll) {
            1 -> R.drawable.__dice_1
            2 -> R.drawable.__dice_2
            3 -> R.drawable.__dice_3
            4 -> R.drawable.__dice_4
            5 -> R.drawable.__dice_5
            else -> R.drawable.__dice_6
        }

        val drawableResourceDice2 = when(dice2Roll) {
            1 -> R.drawable.__dice_1
            2 -> R.drawable.__dice_2
            3 -> R.drawable.__dice_3
            4 -> R.drawable.__dice_4
            5 -> R.drawable.__dice_5
            else -> R.drawable.__dice_6
        }

        diceImage.setImageResource(drawableResourceDice1)
        diceImage.contentDescription = diceRoll.toString()

        dice2Image.setImageResource(drawableResourceDice2)
        dice2Image.contentDescription = dice2Roll.toString()
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}