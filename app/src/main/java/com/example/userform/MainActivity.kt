package com.example.userform

import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.userform.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener, RadioGroup.OnCheckedChangeListener,
    CompoundButton.OnCheckedChangeListener {
    private lateinit var binding: ActivityMainBinding
    private var txtGender: String? = null
    private var coding :String? = null
    private var readingbooks :String? =null
    private var movies :String?=null
    private var playing :String?=null
    private  var traveling  :String?=null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.Submit.setOnClickListener(this)

        // This peace of code for Radio Group/Radio Button
        binding.radioButton.setOnCheckedChangeListener(this)


        // This peace of code for Check Box
        binding.Coding.setOnCheckedChangeListener(this)
        binding.readingBook.setOnCheckedChangeListener(this)
        binding.movies.setOnCheckedChangeListener(this)
        binding.Playing.setOnCheckedChangeListener(this)
        binding.traveling.setOnCheckedChangeListener(this)


    }

    override fun onClick(view: View?) {
        when(view?.id){

            R.id.Submit ->{

                if(binding.UserFirstName.text.isEmpty() && binding.UserLastName.text.isEmpty() && binding.Phone1.text.isEmpty() && binding.Phone2.text.isEmpty() && binding.email.text.isEmpty()) {
                    binding.UserFirstName.requestFocus()
                    Toast.makeText(this,"fill required information ",Toast.LENGTH_SHORT).show()
                }else if(binding.UserFirstName.text.isEmpty()){
                    binding.UserFirstName.requestFocus()
                    Toast.makeText(this,"Please fill your First name",Toast.LENGTH_SHORT).show()

                }
                else if(binding.UserLastName.text.isEmpty()){
                    binding.UserLastName.requestFocus()
                    Toast.makeText(this,"Please fill your Last name",Toast.LENGTH_SHORT).show()

                }
                else if(binding.Phone1.text.isEmpty()){
                    binding.Phone1.requestFocus()
                    Toast.makeText(this,"Please fill your Phone Number name",Toast.LENGTH_SHORT).show()
                }
                else if(binding.Phone2.text.isEmpty()){
                    binding.Phone2.requestFocus()
                    Toast.makeText(this,"Please fill your Alternate Number name",Toast.LENGTH_SHORT).show()
                }else if(binding.email.text.isEmpty()){
                    binding.email.requestFocus()
                    Toast.makeText(this,"Please fill your Email name",Toast.LENGTH_SHORT).show()

                }
                else if(txtGender==null){
                    binding.radioButton.requestFocus()
                    Toast.makeText(this,"Please Select Your Gender",Toast.LENGTH_SHORT).show()

                }

                else{
                    val Firstname = binding.UserFirstName.text.toString()
                    val Lastname = binding.UserLastName.text.toString()
                    val Phone1 = binding.Phone1.text.toString()
                    val phone2 = binding.Phone2.text.toString()
                    val mail = binding.email.text.toString()

                    binding.output.text =
                        " Name :- $Firstname  $Lastname \n Phone NO :- $Phone1 \n Alternate Phone No :- $phone2 \n Email :- $mail \n Gender - $txtGender \n Hobbies \n $coding \n $readingbooks \n $movies \n $playing \n $traveling"


                }

            }
        }
    }

    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {

        when(group?.checkedRadioButtonId){
            R.id.male ->{
                val rbMale = findViewById<RadioButton>(checkedId)
                txtGender = rbMale.text.toString()
//                binding.output.text = "Gender is :- ${rbMale.text.toString()}"
//                Toast.makeText(this, rbMale.text.toString(), Toast.LENGTH_SHORT).show()

            }
            R.id.Female ->{
                val rbFemale = findViewById<RadioButton>(checkedId)
                txtGender = rbFemale.text.toString()
                Toast.makeText(this, rbFemale.text.toString(), Toast.LENGTH_SHORT).show()

            }
            R.id.TransGender ->{
                val rbTransgender = findViewById<RadioButton>(checkedId)
                txtGender = rbTransgender.text.toString()
                //Toast.makeText(this, rbTransgender.text.toString(), Toast.LENGTH_SHORT).show()
            }

        }
    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        when(buttonView?.id){
            R.id.Coding ->{
                coding=binding.Coding.text.toString()
                Toast.makeText(this,binding.Coding.text.toString(),Toast.LENGTH_SHORT).show()
            }
            R.id.readingBook ->{
                readingbooks=binding.readingBook.text.toString()
                Toast.makeText(this,binding.readingBook.text.toString(),Toast.LENGTH_SHORT).show()
            }
            R.id.movies ->{
                movies = binding.movies.text.toString()
                Toast.makeText(this,binding.movies.text.toString(),Toast.LENGTH_SHORT).show()
            }
            R.id.Playing ->{
                playing = binding.Playing.text.toString()
                Toast.makeText(this,binding.Playing.text.toString(),Toast.LENGTH_SHORT).show()
            }
            R.id.traveling ->{
                traveling = binding.traveling.text.toString()
                Toast.makeText(this,binding.traveling.text.toString(),Toast.LENGTH_SHORT).show()
            }
        }
    }


}
