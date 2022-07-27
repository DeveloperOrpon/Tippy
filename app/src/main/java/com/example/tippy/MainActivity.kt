package com.example.tippy

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.SeekBar
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var seeckbarvalue=0;
        var Basevalue=0.0;
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, currentValue: Int, p2: Boolean) {
                seeckbarvalue=currentValue
                seekbarshowId.text=seeckbarvalue.toString()+"%"
                calTips(seeckbarvalue,Basevalue)
                Totalvalue(Basevalue,tipid.text.toString().toDouble())
                checkStatus(seeckbarvalue)

            }
            override fun onStartTrackingTouch(p0: SeekBar?) {

            }
            override fun onStopTrackingTouch(p0: SeekBar?) {

            }
        })
        baseValue.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                Basevalue=s.toString().toDouble()
            }
        })

    }

    private fun checkStatus(seeckbarvalue: Int) {
        if (seeckbarvalue>60){
            statusId.text="Excellent"
            statusId.setTextColor(Color.MAGENTA)
        }
        else if (seeckbarvalue>40){
            statusId.text="Good"
            statusId.setTextColor(Color.GREEN)
        }
        else if (seeckbarvalue>20){
            statusId.text="Well Done"
            statusId.setTextColor(Color.GREEN)
        }
        else{
            statusId.text="Poor"
            statusId.setTextColor(Color.RED)
        }
    }

    private fun calTips(seeckbarvalue: Int, basevalue: Double) {
        var tip : Double=((basevalue*seeckbarvalue)/100).toDouble()
        tipid.text=(Math.round(tip * 100.0) / 100.0).toString()
    }
    private fun Totalvalue(basevalue: Double,tip: Double){
        totalId.text= String.format("%.2f", (basevalue+tip))
    }
}