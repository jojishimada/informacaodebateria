package com.example.informacaodebateria

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var txtBatteryState: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtBatteryState = findViewById(R.id.txtBatteryStatus)
        registerReceiver(this.mBatteryInfoReceiver, IntentFilter(Intent.ACTION_BATTERY_CHANGED))
    }

    private val mBatteryInfoReceiver: BroadcastReceiver= object : BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            //val level = intent.getIntArrayExtra(BatteryManager.EXTRA_LEVEL,defaultValue=1)

            val level = intent!!.getIntExtra(BatteryManager.EXTRA_TEMPERATURE, 0)
            //val scale = intent!!.getIntExtra(BatteryManager.EXTRA_SCALE, 0)

            val batteryPct = level/10

            txtBatteryState!!.text = "Battery Status: $batteryPct ºC"


        }
    }
}