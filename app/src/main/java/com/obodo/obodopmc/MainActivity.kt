package com.obodo.obodopmc.pm5usb

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.obodo.obodopmc.R

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnConnect = findViewById<Button>(R.id.btnConnect)
        btnConnect.setOnClickListener{
            val intent = Intent(this, Motion::class.java)
            // Switch Views
            startActivity(intent)
        }


        val btnStart = findViewById<Button>(R.id.btnStart)
        btnStart.setOnClickListener{

            // Get Email Address
            val txtEmail = findViewById<EditText>(R.id.txtEmail)
            val email = txtEmail.text.toString()

            if (email.isNotEmpty())
            {// make sure we have something in the txt box

                // On Click we switch to the second view...
                val intent = Intent(this, Motion::class.java)

                // send over the email address
                intent.putExtra("emailData", email)

                // Switch Views
                startActivity(intent)
            }
        }
    }
}