package com.example.a3_recyclerview_custom_adapter_with_header_and_footer_kotlin

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a3_recyclerview_custom_adapter_with_header_and_footer_kotlin.adapter.CustomAdapter
import com.example.a3_recyclerview_custom_adapter_with_header_and_footer_kotlin.model.Member

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()

        val members = prepareMemberList()
        refreshAdapter(members)
    }
    private fun initViews() {
        val context : Context = this
         recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(context,1)
    }

    private fun refreshAdapter(members: List<Member>) {
        val adapter = CustomAdapter(members)
        recyclerView.adapter = adapter
    }

    private fun prepareMemberList(): List<Member> {
        val members = ArrayList<Member>()
        for(i in  0..29){
            if(i == 0 || i == 5 || i == 14 || i == 21){
                members.add(Member("Sarvarbek"+i,"Khalmatov"+i,false))
            }else{
                members.add(Member("Sarvarbek"+i,"Khalmatov"+i,true))

            }
        }
        return members
    }

}