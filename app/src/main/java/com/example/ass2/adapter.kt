package com.example.ass2

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class adapter(var activity: Activity,var array:ArrayList<model>):
    RecyclerView.Adapter<adapter.MyViewHolder>() {
    class MyViewHolder (item:View):RecyclerView.ViewHolder(item){
        val name:TextView=item.findViewById(R.id.name)
        val phone:TextView=item.findViewById(R.id.phone)
        val adderess:TextView=item.findViewById(R.id.address)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(activity).inflate(R.layout.recycler,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
    holder.name.setText(array[position].name)
    holder.phone.setText(array[position].phone)
    holder.adderess.setText(array[position].address)

    }

    override fun getItemCount(): Int {
return array.size   }
}