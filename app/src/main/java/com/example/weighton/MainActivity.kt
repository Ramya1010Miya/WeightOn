package com.example.weighton



import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    val marsGravity = 0.38
    val venusGravity = 0.91
    val jupiterGravity = 2.34

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showWeightButtonId.setOnClickListener {
            // var result = calculateWeight(weight.toString().toDouble())

            //resultTextViewId.text = "You weight " + result.toString() + " on Mars"

        }

        marsCheckbox.setOnClickListener(this) // registering our clicklistener
        venusCheckbox.setOnClickListener(this)
        jupiterCheckbox.setOnClickListener(this)


    }

    override fun onClick(v: View?) {
        v as CheckBox
        var isChecked: Boolean = v.isChecked
        var weight = enterWeightId.text


        when(v.id) {
            R.id.marsCheckbox -> if (isChecked && !TextUtils.isEmpty(enterWeightId.text.toString()))
            {
                calculateWeight(weight.toString().toDouble(), v)
                venusCheckbox.isChecked = false
                jupiterCheckbox.isChecked = false
            }
            R.id.venusCheckbox -> if (isChecked && !TextUtils.isEmpty(enterWeightId.text.toString()))
            {
                calculateWeight(weight.toString().toDouble(), v)
                marsCheckbox.isChecked = false
                jupiterCheckbox.isChecked = false
            }
            R.id.jupiterCheckbox -> if (isChecked && !TextUtils.isEmpty(enterWeightId.text.toString()))
            {
                calculateWeight(weight.toString().toDouble(), v)
                marsCheckbox.isChecked = false
                venusCheckbox.isChecked = false
            }
        }


    }

    fun calculateWeight(userWeight: Double, checkBox: CheckBox) { // 89.78
        var result: Double?
        when(checkBox.id) {

            R.id.marsCheckbox -> {
                result = userWeight * marsGravity
                resultTextViewId.text = "Weight is " + result.format(2) + " On Mars"
            }
            R.id.venusCheckbox -> {
                result = userWeight * venusGravity
                resultTextViewId.text = "Weight is " + result.format(2) + " On Venus"
            }
            R.id.jupiterCheckbox ->  {
                result = userWeight * jupiterGravity
                resultTextViewId.text = "Weight is " + result.format(2) + " On Jupiter"
            }
            else -> result = userWeight * marsGravity

        }



    }

    fun Double.format(digits: Int) = java.lang.String.format("%.${digits}f", this)
}