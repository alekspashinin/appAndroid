package com.faircorp

import android.os.Bundle
import android.widget.TextView
import com.faircorp.model.WindowService


const val WINDOW_NAME_PARAM = "com.faircorp.windowname.attribute"



class WindowActivity : BasicActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_window)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val id = intent.getLongExtra(WINDOW_NAME_PARAM, 0)
        val window = WindowService.findById(id)

        if (window != null) {
            findViewById<TextView>(R.id.txt_window_name).text = window.name
            findViewById<TextView>(R.id.txt_room_name).text = window.room.name
            findViewById<TextView>(R.id.txt_window_current_temperature).text = window.room.currentTemperature?.toString()
            findViewById<TextView>(R.id.txt_window_target_temperature).text = window.room.targetTemperature?.toString()
            findViewById<TextView>(R.id.txt_window_status).text = window.status.toString()
        }
        else {
            System.out.println("NULL")
        }
    }
}


//class WindowActivity: AppCompatActivity(), OnWindowSelectedListener {
//
//    val windowService = WindowService() // (1)
//
//    val listener: OnWindowSelectedListener = TODO()
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        val id = intent.getLongExtra(WINDOW_NAME_PARAM, 0)
//        val window = windowService.findById(id)
//
//        if (window != null) {
//            findViewById<TextView>(R.id.txt_window_name).text = window.name
//            findViewById<TextView>(R.id.txt_room_name).text = window.room.name
//            findViewById<TextView>(R.id.txt_window_target_temperature).text =
//                window.room.currentTemperature?.toString()
//            findViewById<TextView>(R.id.txt_window_target_temperature).text =
//                window.room.targetTemperature?.toString()
//            findViewById<TextView>(R.id.txt_window_status).text = window.status.toString()
//            super.onCreate(savedInstanceState)
//            setContentView(R.layout.activity_window)
//
//            val recyclerView = findViewById<RecyclerView>(R.id.list_windows) // (2)
//            val adapter = WindowAdapter(listener) // (3)
//
//            recyclerView.layoutManager = LinearLayoutManager(this)
//            recyclerView.addItemDecoration(
//                DividerItemDecoration(
//                    this,
//                    DividerItemDecoration.VERTICAL
//                )
//            )
//            recyclerView.setHasFixedSize(true)
//            recyclerView.adapter = adapter
//
//            adapter.update(windowService.findAll()) // (4)
//        }
//
//        fun onWindowSelected(id: Long) {
//            val intent = Intent(this, WindowActivity::class.java).putExtra(WINDOW_NAME_PARAM, id)
//            startActivity(intent)
//        }
//    }
//
//    override fun onWindowSelected(id: Long) {
//        TODO("Not yet implemented")
//    }
//}