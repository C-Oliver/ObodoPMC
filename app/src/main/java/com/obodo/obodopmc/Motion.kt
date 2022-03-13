package com.obodo.obodopmc.pm5usb

import android.annotation.SuppressLint
import android.bluetooth.BluetoothManager
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.obodo.obodopmc.R
import java.util.*

class Motion : AppCompatActivity()
{
    private val mUUID: UUID = UUID.fromString("CE060000-43E5-11E4-916C-0800200C9A66")

    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_motion)

        val i = intent
        val email: String? = i.getStringExtra("emailData") as String?

        val txtViewUsername: TextView = findViewById(R.id.txtUsername) as TextView
        txtViewUsername.text = email.toString()


        val bluetoothManager = getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
        val bluetoothAdapter = bluetoothManager.getAdapter()
        val pairedDevices = bluetoothAdapter.bondedDevices

        val socket = pairedDevices.first().createInsecureRfcommSocketToServiceRecord(mUUID)
        val remoteDevice = socket.remoteDevice

        val service = BluetoothService(handler = Handler())
        val connectedThread = service.ConnectedThread(socket)


        // connectedThread.write(bytes)


    }
}