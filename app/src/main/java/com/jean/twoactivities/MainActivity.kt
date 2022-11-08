package com.jean.twoactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        //Inflate the UI ---ie transforming the XML Layout into Java/Kotlin objects to work with
        setContentView(R.layout.activity_main)

        //Create a reference/object to access the XML element EditText with the id editText_send
        val mMessageEditText : EditText = findViewById(R.id.editText_send)

        val message = intent.getStringExtra("REPLY_KEY_VALUE")
        //Create a reference/object to access the XML element TextView with the id text_message

        var textView: TextView = findViewById(R.id.text_message)
        //extract message typed by user as a string, in a variable called message
        textView.text =message.toString()
        //Create a reference/object to access the XML Button with the id button_send
        var buttonSend : Button = findViewById(R.id.button_send)


        buttonSend.setOnClickListener{
            //an intent object linking this current activity to the second/next one to be opened
            val secondActivityIntent = Intent( this, SecondActivity::class.java )

            var message = mMessageEditText.text.toString().trim()//trim removes extra spaces
            //SEND_KEY_VALUE key will be used in the next activity to retrieve the message
            secondActivityIntent.putExtra("SEND_KEY_VALUE",message)

            //call for the SecondActivity to be started
            startActivity(secondActivityIntent)//starting the secondActivity when button is clicked
            //extract message typed by user as a string, in a variable called message
            //dynamically provide the message retrieved from MainActivity and display it in the TextView
            textView.text=message
            //SEND_KEY_VALUE key will be used in the next activity to retrieve the message

            //call for the SecondActivity to be started
            startActivity(secondActivityIntent)//starting the secondActivity when button is clicked
        }



    }
}