package com.example.kursach

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_rooms.*

class RoomsActivity : AppCompatActivity(), OnItemClickInterface {
    private val viewModel by viewModels<RoomsViewModel>()
    private val adapter = RoomsAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rooms)
        rooms_recycler.layoutManager = LinearLayoutManager(baseContext)
        rooms_recycler.adapter = this.adapter
        viewModel.roomsList.observe(this, Observer {
            this.adapter.data = it
        })
    }

    override fun OnItemClickListener(room: Room) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("room", room)
        startActivity(intent)
    }
}