package com.websarva.wings.android.schooleventapp

import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.RectF
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.constraintlayout.utils.widget.ImageFilterButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import android.graphics.Bitmap as Bitmap1

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTitle("Action")


        val data = mutableListOf(
            ListItem(1, "10:30", "受付完了", "23号館1階受付"),
            ListItem(2, "10:45", "ボードゲーム広場", "5.03"),
            ListItem(3, "12:30", "焼きそば美味しい", "野外模擬店④"),
            ListItem(4, "13:10", "パフェです", "屋内模擬店②"),
            ListItem(5, "14:00", "野外ライブ２", "野外ステージ")
        )

        val btPlaceEdit: FloatingActionButton = findViewById(R.id.btPlaceEdit)
        btPlaceEdit.setOnClickListener{
            var intent = Intent(this@MainActivity, EditActionActivity::class.java)
            startActivity(intent)
        }

        val rvAction = findViewById<RecyclerView>(R.id.rvAction)
        rvAction.setHasFixedSize(true)
        rvAction.layoutManager = LinearLayoutManager(this).apply {
            orientation = LinearLayoutManager.VERTICAL
        }

        rvAction.adapter = ActionsAdapter(data)

        val imageButton: ImageFilterButton = findViewById(R.id.imageButton)

        imageButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
                addCategory(Intent.CATEGORY_OPENABLE)
                type = "image/*"
            }
            startActivityForResult(intent, READ_REQUEST_CODE)
        }
    }

    companion object {
        private const val READ_REQUEST_CODE: Int = 42
    }

    //写真が選択された後の動き
    override fun onActivityResult(requestCode: Int, resultCode: Int, resultData: Intent?) {
        super.onActivityResult(requestCode, resultCode, resultData)
        if (resultCode != RESULT_OK) {
            return
        }
        when (requestCode) {
            READ_REQUEST_CODE -> {
                try {
                    resultData?.data?.also { uri ->
                        val inputStream = contentResolver?.openInputStream(uri)
                        val image = BitmapFactory.decodeStream(inputStream)
                        val imageButton = findViewById<ImageFilterButton>(R.id.imageButton)
                        imageButton.setImageBitmap(image)
                    }
                } catch (e: Exception) {
                    Toast.makeText(this, "エラーが発生しました", Toast.LENGTH_LONG).show()
                }

            }
        }
    }

}