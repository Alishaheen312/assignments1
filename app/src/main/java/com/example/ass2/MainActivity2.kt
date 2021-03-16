package com.example.ass2

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val progressDialog = ProgressDialog(this@MainActivity2)
        progressDialog.setTitle("Uploading")
        progressDialog.setMessage("Data is uploading, please wait")
        progressDialog.show()

        val floating_action_button = findViewById<FloatingActionButton>(R.id.floating_action_button)
        floating_action_button.setOnClickListener {
            this.finish()
            startActivity(Intent(this,MainActivity::class.java))
        }



        val arrayList=ArrayList<model>()
        val db=FirebaseFirestore.getInstance()
        var recyclerView:RecyclerView=findViewById(R.id.recyclerView)

        recyclerView.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        db.collection("Users").get()
            .addOnSuccessListener {
            arrayList.addAll(it.toObjects(model::class.java))
                val adapter=adapter(this,arrayList)
                recyclerView.adapter=adapter
                if(progressDialog.isShowing)
                    progressDialog.dismiss()
        }.addOnFailureListener{
            Log.e("get",it.message.toString())
            }




    }

}