package jp.techacademy.kozo.aisatuapp

import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import android.util.Log
import android.view.View
import android.os.Build
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)
    }

    // Click
    override fun onClick(v: View) {
        if (v.id == R.id.button1) {
            val time = showTimePickerDialog()
            val hour = time.first
            val minute = time.second
        }
    }

    // Time Picker
    private fun showTimePickerDialog(): Pair<Int, Int> {
        var h = 0
        var m = 0
        val timePickerDialog = TimePickerDialog(
                this,
                TimePickerDialog.OnTimeSetListener { view, hour, minute ->
                    // show set time
                    Log.d("UI_PARTS", "$hour:$minute")

                    // set greetings
                    if (hour in 2..9) {
                        aisatu.text = "おはよう"
                    } else if (hour in 10..17) {
                        aisatu.text = "こんにちは"
                    } else if (hour in 18..24 || hour in 0..1){
                        aisatu.text = "こんばんは"
                    } else {
                        aisatu.text = "Hello World!"
                    }
                },
                13, 0, true)
        timePickerDialog.show()
        return Pair(h, m)
    }
}