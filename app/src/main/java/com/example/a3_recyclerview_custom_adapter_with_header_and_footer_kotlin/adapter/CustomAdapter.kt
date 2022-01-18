package com.example.a3_recyclerview_custom_adapter_with_header_and_footer_kotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a3_recyclerview_custom_adapter_with_header_and_footer_kotlin.R
import com.example.a3_recyclerview_custom_adapter_with_header_and_footer_kotlin.model.Member

class CustomAdapter(val members: List<Member>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_ITEM_HEADER = 0
    private val TYPE_ITEM_YES = 1
    private val TYPE_ITEM_NO = 2
    private val TYPE_ITEM_FOOTER = 3


    override fun getItemViewType(position: Int): Int {
        if(isHeader(position)) return TYPE_ITEM_HEADER
        if(isFooter(position)) return TYPE_ITEM_FOOTER

        val member = members[position]
        return if(member.available) TYPE_ITEM_YES else TYPE_ITEM_NO
    }

        fun isHeader(position: Int):Boolean{
            return position == 0
        }

        fun isFooter(position: Int):Boolean{
            return position == members.size-1
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType == TYPE_ITEM_HEADER){
            val view: View =  LayoutInflater.from(parent.context).inflate(R.layout.item_custom_view_header,parent,false)
            return CustomViewHeaderHolder(view)
        }else if(viewType == TYPE_ITEM_YES){
            val view: View =  LayoutInflater.from(parent.context).inflate(R.layout.item_custom_view_yes,parent,false)
            return CustomViewYesHolder(view)
        }else if(viewType == TYPE_ITEM_NO){
            val view: View =  LayoutInflater.from(parent.context).inflate(R.layout.item_custom_view_no,parent,false)
            return CustomViewNoHolder(view)
        }else{
            val view: View =  LayoutInflater.from(parent.context).inflate(R.layout.item_custom_view_footer,parent,false)
            return CustomViewFooterHolder(view)
        }


    }

 

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            val member = members.get(position)

        if(holder is CustomViewYesHolder){
            holder.first_name.text = member.firstName
            holder.last_name.text = member.lastName
        }
        if(holder is CustomViewNoHolder){
            holder.first_name.text = "There is no firstName in this view"
            holder.last_name.text = "There is no lastName in this view"
        }
    }

    override fun getItemCount(): Int {
       return members.size
    }


}

class CustomViewFooterHolder(view: View) : RecyclerView.ViewHolder(view) {

}

class CustomViewNoHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val first_name = itemView.findViewById<TextView>(R.id.firstName)
        val last_name = itemView.findViewById<TextView>(R.id.lastName)

}

class CustomViewYesHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val first_name = itemView.findViewById<TextView>(R.id.firstName)
    val last_name = itemView.findViewById<TextView>(R.id.lastName)
}

class CustomViewHeaderHolder(view: View) : RecyclerView.ViewHolder(view) {

}
