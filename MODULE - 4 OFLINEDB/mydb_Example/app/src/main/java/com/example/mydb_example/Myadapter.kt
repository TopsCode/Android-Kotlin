package com.example.mydb_example

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton

class Myadapter(var context:Context,var userlist:MutableList<UserModel>):RecyclerView.Adapter<Myadapter.myClass>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myClass {
       var view=LayoutInflater.from(context).inflate(R.layout.row_data,parent,false)
        return myClass(view)
    }
    class myClass(view:View):RecyclerView.ViewHolder(view){
        var userName=view.findViewById<TextView>(R.id.tv_display_username)
        var userEmail=view.findViewById<TextView>(R.id.tv_display_email)
        var userMobile=view.findViewById<TextView>(R.id.tv_display_mobile)

        var btn_edit=view.findViewById<MaterialButton>(R.id.btn_edit)
        var btn_delete=view.findViewById<MaterialButton>(R.id.btn_delete)
    }



    override fun onBindViewHolder(holder: myClass, position: Int) {
        var mydata=userlist[position]
        holder.userEmail.text=mydata.user_email
        holder.userMobile.text=mydata.user_mobile
        holder.userName.text=mydata.userName

        holder.btn_edit.setOnClickListener{
            var d=Dialog(context)
            d.setContentView(R.layout.mydialog)
            d.setCancelable(true)

            var update_username= d.findViewById<EditText>(R.id.ed_username_e)
            var update_mobile=d.findViewById<EditText>(R.id.ed_contact_e)
            var update_password=d.findViewById<EditText>(R.id.ed_password_e)
            var update_email=d.findViewById<EditText>(R.id.ed_email_e)

            var update_btn=d.findViewById<MaterialButton>(R.id.btn_update_e)
            update_email.setText(mydata.user_email)
            update_username.setText(mydata.userName)
            update_mobile.setText(mydata.user_mobile)
            update_password.setText(mydata.user_pass)


            d.show()
            update_btn.setOnClickListener {
                var um=UserModel(mydata.user_id,update_username.text.toString(),update_email.text.toString(),update_password.text.toString(),update_mobile.text.toString())
                DatabaseHelper(context).updateData(um)
                var i =Intent(context,ViewUser::class.java)
                context.startActivity(i)
                d.cancel()

            }


        }
        holder.btn_delete.setOnClickListener{
            var alertDialog= AlertDialog.Builder(context)
                .setTitle("Delete User")
                .setMessage("Are you sure you want to delete")
                .setPositiveButton("Yes",DialogInterface.OnClickListener { dialogInterface, i ->
                    var db = DatabaseHelper(context)
                    var um=UserModel(mydata.user_id,mydata.userName,mydata.user_email,mydata.user_pass,mydata.user_mobile)
                    var id=db.DeleteUserData(um)
                   var i =Intent(context,ViewUser::class.java)
                    context.startActivity(i)
                    dialogInterface.dismiss()

                })
                .setNegativeButton("NO" ,DialogInterface.OnClickListener { dialogInterface, i ->  })
                .show()


        }
    }

    override fun getItemCount(): Int {
       return userlist.size
    }
}