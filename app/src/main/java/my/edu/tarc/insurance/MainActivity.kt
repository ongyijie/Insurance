package my.edu.tarc.insurance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import java.util.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    // Global variable
    private var premium: Int = 0 //lateinit for textView
    private var malePremium: Int = 0
    private var smokerPremium: Int = 0
    private var total: Int = 0

    private lateinit var textViewPremium: TextView
    private lateinit var textViewMalePremium: TextView
    private lateinit var textViewSmokerPremium: TextView
    private lateinit var textViewTotal: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Link UI to program
        val spinnerAge: Spinner = findViewById(R.id.spinnerAge)
        val radioButtonGender: RadioGroup = findViewById(R.id.radioGroupGender)
        val checkBoxSmoker: CheckBox = findViewById(R.id.checkBoxSmoker)

        textViewPremium = findViewById(R.id.textViewPremium)
        textViewMalePremium = findViewById(R.id.textViewMalePremium)
        textViewSmokerPremium = findViewById(R.id.textViewSmokerPremium)
        textViewTotal = findViewById(R.id.textViewTotal)

                // set event listener
        spinnerAge.onItemSelectedListener = this
        radioButtonGender.setOnCheckedChangeListener() { it, _ ->
            val male = it.checkedRadioButtonId // it refers to the current view
            malePremium = if(male == R.id.radioButtonMale) {
                val age = spinnerAge.selectedItemPosition
                when (age) {
                    1 -> 50
                    2 -> 100
                    3 -> 150
                    4, 5 -> 200
                    else -> 0
                }
            } else
                0
            textViewMalePremium.text = malePremium.toString()
        }

        checkBoxSmoker.setOnCheckedChangeListener{ compoundButton, b ->
            if(compoundButton.isChecked) {
                val age = spinnerAge.selectedItemPosition
                smokerPremium = when (age) {
                    1 -> 100
                    2 -> 150
                    3 -> 200
                    4 -> 250
                    5 -> 300
                    else -> 0
                }
            } else {
                smokerPremium = 0
            }
            textViewSmokerPremium.text = smokerPremium.toString()
        }

        val buttonCalculate: Button = findViewById(R.id.buttonCalculate)
            buttonCalculate.setOnClickListener {
                total = premium + malePremium + smokerPremium
                textViewPremium.text = premium.toString()
                textViewMalePremium.text = malePremium.toString()
                textViewSmokerPremium.text = smokerPremium.toString()
                textViewTotal.text = total.toString()
    }

        val buttonReset: Button = findViewById(R.id.buttonReset)
        buttonReset.setOnClickListener {
            spinnerAge.setSelection(0)
            radioButtonGender.clearCheck()
            textViewPremium.text = null
            textViewMalePremium.text = null
            textViewSmokerPremium.text = null
            textViewTotal.text = null
        }
}

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, index: Int, id: Long) {
        //Toast.makeText(this, "Item selected = ${index}", Toast.LENGTH_SHORT).show()
        when(index) {
            0 -> premium = 60
            1 -> premium = 70
            2 -> premium = 80
            3 -> premium = 120
            4,5 -> premium = 150
        }
        textViewPremium.text = premium.toString()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
    }
}