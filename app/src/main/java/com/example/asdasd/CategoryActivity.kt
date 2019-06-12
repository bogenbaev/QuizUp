package com.example.asdasd

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_category.*
import kotlinx.android.synthetic.main.activity_main.*

class CategoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        var otvet1 = ArrayList<Button>()
        otvet1.add(button5)
        otvet1.add(button4)
        otvet1.add(button3)
        otvet1.add(button2)
        resText.text = "Your result is: " + res
        checkerAnswer(otvet1)
        var count: Int = 0;
        button.setOnClickListener() {
            if (lockedGreen || lockedRed) {
                count++
                if (count == 1) {
                    button2.setBackgroundColor(Color.GRAY)
                    button3.setBackgroundColor(Color.GRAY)
                    button4.setBackgroundColor(Color.GRAY)
                    button5.setBackgroundColor(Color.GRAY)
                    textView.text = "Who was founded Kazakh Khanate"
                    button2.text = "Margellan Khan"
                    button3.text = "Nugman Khan"
                    button4.text = "Erkebulan"
                    button5.text = "Darkhan Bey"
                    checkerAnswer(otvet1)
                }
                if (count % 4 == 2) {
                    button2.setBackgroundColor(Color.GRAY)
                    button3.setBackgroundColor(Color.GRAY)
                    button4.setBackgroundColor(Color.GRAY)
                    button5.setBackgroundColor(Color.GRAY)
                    textView.text = "When was Kazakh Khanate founded?"
                    button2.text = "1541"
                    button3.text = "1465"
                    button4.text = "1121"
                    button5.text = "1343"
                    checkerAnswer(otvet1)
                }
                if (count % 4 == 3) {
                    button2.setBackgroundColor(Color.GRAY)
                    button3.setBackgroundColor(Color.GRAY)
                    button4.setBackgroundColor(Color.GRAY)
                    button5.setBackgroundColor(Color.GRAY)
                    textView.text = "How long revolution of Kenesary was extended?"
                    button2.text = "9"
                    button3.text = "8"
                    button4.text = "12"
                    button5.text = "10"
                    checkerAnswer(otvet1)
                }
                if (count % 4 == 0) {
                    var intent = Intent(this, ResultActivity::class.java)
                    startActivity(intent)
                }
            }
            else {
                Toast.makeText(this, "Tandashish oynamai", Toast.LENGTH_LONG).show()
            }
        }
    }
    public var lockedGreen: Boolean = false
    public var lockedRed:Boolean = false
    public var res: Int = 0
    fun checkerAnswer (buttons : ArrayList<Button>) {
        var cnt: Int = 0
        buttons.forEach { it1 ->
            it1.setOnClickListener() {
                cnt++
                if (cnt == 1) {
                    if (it1.text == "1905" || it1.text == "1465" || it1.text == "10" || it1.text == "Nugman Khan") {
                        it1.setBackgroundColor(Color.GREEN)
                        res++
                        resText.text = "Your result is: " + res.toString() + "/4"
                        lockedGreen = true
                    } else {
                        it1.setBackgroundColor(Color.RED)
                        lockedRed = true
                    }
                } else {
                    Toast.makeText(this, "Your already have choiced", Toast.LENGTH_LONG).show()
                    return@setOnClickListener
                }
            }
        }
    }
}
