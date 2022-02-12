package com.zybooks.pizzaparty


import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.ceil

const val SLICES_PER_PIZZA = 8

/**
 * MainActivity class contains the Kotlin code that interacts with the UI.
 * MainActivity inherits the AppCompatActivity class which is the superclass for all activities and provides the
 latest Android functionality
 */
class MainActivity : AppCompatActivity() {

    private lateinit var numAttendEditText: EditText
    private lateinit var numPizzasTextView: TextView
    private lateinit var howHungryRadioGroup: RadioGroup
    /**
     * The Activity method onCreate() is the first method called when the activity starts, it loads the activity's XML
     layout and performs other initialization logic
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        numAttendEditText = findViewById(R.id.num_attend_edit_text)
        numPizzasTextView = findViewById(R.id.num_pizzas_text_view)
        howHungryRadioGroup = findViewById(R.id.hungry_radio_group)
    }
    /**
     *  Function to calculate no. of pizza and take necessary inputs.
     */
    fun calculateClick(view: View) {
        /**
         *  Get the text that was typed into the EditText.
         */

        val numAttendStr = numAttendEditText.text.toString()
        /**
         *  It will convert the text into an integer.
         */
        val numAttend = numAttendStr.toInt()
        /**
         *  It will determine how many slices on average each person will eat
         */
        val slicesPerPerson = when (howHungryRadioGroup.checkedRadioButtonId) {
            R.id.light_radio_button -> 2
            R.id.medium_radio_button -> 3
            else -> 4
        }
        /**
         *  It will calculate and show the number of pizzas needed.
         */
        val totalPizzas = ceil(numAttend * slicesPerPerson / SLICES_PER_PIZZA.toDouble()).toInt()
        numPizzasTextView.text = "Total pizzas: $totalPizzas"
    }
}