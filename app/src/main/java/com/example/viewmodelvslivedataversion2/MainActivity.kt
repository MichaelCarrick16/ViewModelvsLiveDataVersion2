package com.example.viewmodelvslivedataversion2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.startTimer()

        viewModel._second.observe(this, Observer {
            tv_number.text = it.toString()
        })

        viewModel.checkFinish.observe(this, Observer {
            if(it){
                Toast.makeText(this,"Finished",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this,"No Finish",Toast.LENGTH_SHORT).show()
            }
        })

    }
}