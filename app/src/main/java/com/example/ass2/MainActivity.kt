package com.example.ass2

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity(){
    var Name: EditText? = null
    var Phone: EditText? = null
    var Address: EditText? = null
    var btn: Button? = null

    var db: FirebaseFirestore = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)





        Name = findViewById<EditText>(R.id.ed_Name)
        Phone = findViewById<EditText>(R.id.ed_Phone)
        Address = findViewById<EditText>(R.id.ed_Address)

        btn = findViewById<Button>(R.id.btn_)
        btn!!.setOnClickListener { saveToFirebase() }



    }

    fun saveToFirebase() {


        val progressDialog = ProgressDialog(this@MainActivity)
        progressDialog.setTitle("Uploading")
        progressDialog.setMessage("Data is uploading, please wait")
        progressDialog.show()

        val Name = Name!!.text.toString()
        val Phone = Phone!!.text.toString()
        val Address = Address!!.text.toString()

        // Create a new user with a first and last name
        val user: MutableMap<String, Any> = HashMap()
        user["name"] = Name
        user["phone"] = Phone
        user["address"] = Address

// Add a new document with a generated ID
        db.collection("Users")
            .add(user)
            .addOnSuccessListener { documentReference ->
                Log.d("TAG", "DocumentSnapshot added with ID: " + documentReference.id)

                this.finish()
                startActivity(Intent(this,MainActivity2::class.java))
            }
            .addOnFailureListener { e -> Log.w("TAG", "Error adding document", e) }

     //  if(progressDialog.isShowing)
       //    progressDialog.dismiss()

   }

//    override fun onClick(v: View?) {
//      saveToFirebase()
//    }
}