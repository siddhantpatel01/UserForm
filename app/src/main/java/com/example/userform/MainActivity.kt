package com.example.userform

import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.userform.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener, RadioGroup.OnCheckedChangeListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.Submit.setOnClickListener(this)
        binding.radioButton.setOnCheckedChangeListener(this)

    }

    override fun onClick(view: View?) {
        when(view?.id){

            R.id.Submit ->{
                val Firstname = binding.UserFirstName.text.toString()
                val Lastname = binding.UserLastName.text.toString()
                val Phone1= binding.Phone1.text.toString()
                val phone2 = binding.Phone2.text.toString()
                val mail = binding.email.text.toString()

                binding.output.text=" Name :- $Firstname  $Lastname \n Phone NO :- $Phone1 \n Alternate Phone No :- $phone2 \n Email :- $mail "




            }
        }
    }

    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {

        when(group?.checkedRadioButtonId){
            R.id.male ->{
                val rbMale = findViewById<RadioButton>(checkedId)
                var gender = rbMale.text.toString()
//                binding.output.text = "Gender is :- ${rbMale.text.toString()}"
//                Toast.makeText(this, rbMale.text.toString(), Toast.LENGTH_SHORT).show()

            }
            R.id.Female ->{
                val rbFemale = findViewById<RadioButton>(checkedId)
                binding.output.text = "Gender is :- ${rbFemale.text.toString()}"
                Toast.makeText(this, rbFemale.text.toString(), Toast.LENGTH_SHORT).show()

            }
            R.id.TransGender ->{
                val rbTransgender = findViewById<RadioButton>(checkedId)
                binding.output.text = "Gender is :- ${rbTransgender.text.toString()}"
                Toast.makeText(this, rbTransgender.text.toString(), Toast.LENGTH_SHORT).show()
            }

        }
    }


}
