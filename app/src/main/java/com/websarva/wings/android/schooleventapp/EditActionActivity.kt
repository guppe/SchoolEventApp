package com.websarva.wings.android.schooleventapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class EditActionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_action)
        setTitle("EditAction")

        val btEdit: Button = findViewById(R.id.btEdit)

        btEdit.setOnClickListener{
            var intent = Intent(this@EditActionActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }
}