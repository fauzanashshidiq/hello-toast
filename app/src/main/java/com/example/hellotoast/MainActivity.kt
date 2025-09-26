package com.example.hellotoast

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private var mCount = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val mShowCount = findViewById<TextView>(R.id.show_count)
        val buttonCountUp = findViewById<Button>(R.id.button_count)
        val buttonToast = findViewById<Button>(R.id.button_toast)
        val buttonSwitchPage = findViewById<Button>(R.id.button_switchpage)
        val buttonBrowser = findViewById<Button>(R.id.button_browser)
        val buttonContact = findViewById<Button>(R.id.button_contact)
        val buttonLocation = findViewById<Button>(R.id.button_location)

        buttonCountUp.setOnClickListener(View.OnClickListener{
            mCount++
            if (mShowCount != null)
                mShowCount.text = mCount.toString()
        })
        buttonToast.setOnClickListener(View.OnClickListener{
            val tulisan: String = mShowCount?.text.toString()
            val toast: Toast = Toast.makeText(this, "Angka yang dimunculkan: " + tulisan, Toast.LENGTH_LONG)
            toast.show()
        })
        buttonSwitchPage.setOnClickListener(View.OnClickListener{
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        })
        buttonBrowser.setOnClickListener({
            val intentbrowse = Intent(Intent.ACTION_VIEW)
            intentbrowse.setData(Uri.parse("https://www.google.com"))
            startActivity(intentbrowse)
        })
        buttonContact.setOnClickListener (View.OnClickListener{
            val intentcontact = Intent(Intent.ACTION_VIEW)
            intentcontact.data = ContactsContract.Contacts.CONTENT_URI
            startActivity(intentcontact)
        })
        buttonLocation.setOnClickListener (View.OnClickListener{
            val intentlocation = Intent(Intent.ACTION_VIEW)
            intentlocation.setData(Uri.parse("geo:-6.930439419113542,107.71790564049459?q=-6.930439419113542,107.71790564049459(UIN+Sunan+Gunung+Djati+Bandung)\n"))
            intent.setPackage("com.google.android.maps")
            startActivity(intentlocation)
        })
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

}