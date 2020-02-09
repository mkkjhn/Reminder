package com.example.reminder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var fabOpened = false
        fab.setOnClickListener {
            val intent = Intent(applicationContext, TimeActivity::class.java)

            if (!fabOpened){
                fabOpened = true
                fab_map.animate().translationY(-resources.getDimension(R.dimen.standard_66))
                fab_time.animate().translationY(-resources.getDimension(R.dimen.standard_116))
            }
            else {
                fabOpened = false
                fab.fab_map.animate().translationY(0f)
                fab.fab_time.animate().translationY(0f)
            }

            startActivity(intent)
        }

        fab_time.setOnClickListener {
            val intent = Intent(applicationContext, TimeActivity::class.java)
            startActivity(intent)
        }

        fab_map.setOnClickListener {
            val intent = Intent(applicationContext, MapActivity::class.java)
            startActivity(intent)
        }

        val data = arrayOf("Oulu", "Helsinki", "Tampere")

        val reminderAdapter = ReminderAdapter(applicationContext, data)

        list.adapter = reminderAdapter
    }

}
