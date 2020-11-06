package my.edu.tarc.insurance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    // Global variable
    private var premium: Int = 0 //lateinit for textView
    private var malePremium: Int = 0
    private var smokerPremium: Int = 0
    private var total: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Link UI to program
        val spinnerAge: Spinner = findViewById(R.id.spinnerAge)
        val radioButtonMale: RadioButton = findViewById(R.id.radioButtonMale)
        val checkBoxSmoker: CheckBox = findViewById(R.id.checkBoxSmoker)

        // set event listener
        spinnerAge.onItemSelectedListener = this
        radioButtonMale.setOnClickListener {
            val male = it.isSelected // it refers to the current view
            if(male) {
                    //TODO: calculate male premium
                }
        }

        checkBoxSmoker.setOnCheckedChangeListener{ compoundButton, b ->
            if(compoundButton.isChecked) {
                // TODO: calculate smoker premium
            }

        }

    }
    //TODO: calculate total

    //fun calculatePremium(view: View) {
        //val radioGroupGender: RadioGroup = findViewById(R.id.radioGroupGender)
        //val gender = radioGroupGender.checkedRadioButtonId
        //if (gender == R.id.radioButtonMale) {
            //TODO: calculate male premium
        //}
    //}

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, index: Int, id: Long) {
        //Toast.makeText(this, "Item selected = ${index}", Toast.LENGTH_SHORT).show()
        when(index) {
            0 -> premium = 60
            1 -> premium = 70
            2 -> premium = 80
            //TODO: complete the assignment of basic premium
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}