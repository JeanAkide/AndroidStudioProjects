package com.jean.twoactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        //Inflate the UI --ie transforming the XML Layout into Java/Kotlin objects to work with
        setContentView(R.layout.activity_second)
        //Create a reference object to access the XML element EditText with the id editText_send
        val mMessageEditText: EditText = findViewById(R.id.editText_reply)
        //in a string variable retrieve the data received from the MainActivity
        //..using the specified SEND_KEY_VALUE key
        val message=intent.getStringExtra("SEND_KEY_VALUE")
        //Create a reference/object to access the XML element TextView with the id text_message
        var textView: TextView = findViewById(R.id.text_reply)
        //Create a reference/object to access the XML button with the id button_send
        val buttonReply: Button = findViewById(R.id.button_reply)


        buttonReply.setOnClickListener{
            //an intent object linking this current activity to the main activity to be opened
            val SecondActivityIntent = Intent(this, MainActivity::class.java)
            var reply = mMessageEditText.text.toString().trim()
            //extract message typed by user as a string, in a variable called message
//            var message= mMessageEditText.text.toString().trim() //trim removes extra spaces

            var message = mMessageEditText.text.toString().trim()//trim removes extra spaces
            //SEND_KEY_VALUE key will be used in the next activity to retrieve the message
            SecondActivityIntent.putExtra("REPLY_KEY_VALUE",message)

            //SEND_KEY_VALUE key will be used in the ne?_KEY_VALUE",reply)
            //call for main Activity to be started
            startActivity(SecondActivityIntent)

        }





        //dynamically provide the message retrieved from MainActivity and display it in the TextView
        textView.text=message




    }
}