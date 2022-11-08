package com.example.bitfitpart2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class AddbevDetailActivity : AppCompatActivity() {
    private lateinit var bevNameInput: EditText
    private lateinit var bevVolInput: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_vol_detail)

        // TODO: Find the views for the screen
        bevNameInput= findViewById(R.id.EnterbevName)
        bevVolInput= findViewById(R.id.EnterbevVol)

        findViewById<Button>(R.id.addFoodButtonDetail).setOnClickListener{
            val newFood = ItemEntity(
                bevNameInput.text.toString(),
                bevVolInput.text.toString()
            )

            lifecycleScope.launch(IO) {
                (application as BitFitApplication).db.foodDao().insert(newFood)
            }


            bevNameInput.getText().clear()
            bevVolInput.getText().clear()

        }


    }
}