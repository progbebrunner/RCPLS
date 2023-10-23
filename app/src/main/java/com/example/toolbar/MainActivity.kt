package com.example.toolbar

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Parcel
import android.os.Parcelable
import android.view.MenuItem
import android.widget.TextView
import com.example.toolbar.databinding.ActivityMainBinding

class MainActivity() : AppCompatActivity(), Parcelable {
    lateinit var binding: ActivityMainBinding
    constructor(parcel: Parcel) : this() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MainActivity> {
        override fun createFromParcel(parcel: Parcel): MainActivity {
            return MainActivity(parcel)
        }

        override fun newArray(size: Int): Array<MainActivity?> {
            return arrayOfNulls(size)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
        /*if (item.itemId == android.R.id.home) {
            val txtHelloWorld = findViewById<TextView>(binding.textView1)
            txtHelloWorld.setBackgroundColor(Color.argb(255, 240, 120, 128))

            Handler(Looper.getMainLooper()).postDelayed({
                finish()
            }, 3000)
        }*/
    }

}

fun gameRPSLS (binding: ActivityMainBinding){
    val Pchoise = (1..5).random()
    var Uchoise = 0
    when (binding.root.id.toString()){
        "RockButton" -> Uchoise = 1
        "PaperButton" -> Uchoise = 2
        "ScissorsButton" -> Uchoise = 3
        "LizardButton" -> Uchoise = 4
        "SpockButton" -> Uchoise = 5
    }
    when(Uchoise){
        1 -> when(Pchoise){
            4, 3 -> binding.textAnswer.text = "Победа!"
            1, 5 -> binding.textAnswer.text = "Поражение"
        }
        2 -> when(Pchoise){
            1, 5 -> binding.textAnswer.text = "Победа!"
            3, 4 -> binding.textAnswer.text = "Поражение"
        }
        3 -> when(Pchoise){
            2, 4 -> binding.textAnswer.text = "Победа!"
            1, 5 -> binding.textAnswer.text = "Поражение"
        }
        4 -> when(Pchoise){
            2, 5 -> binding.textAnswer.text = "Победа!"
            1, 3 -> binding.textAnswer.text = "Поражение"
        }
        5 -> when(Pchoise){
            1, 3 -> binding.textAnswer.text = "Победа!"
            2, 4 -> binding.textAnswer.text = "Поражение"
        }
    }
}
