package com.example.firebasecrud

import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.FirebaseDatabase
import com.orhanobut.dialogplus.DialogPlus
import com.orhanobut.dialogplus.ViewHolder

class myadapter(options: FirebaseRecyclerOptions<Model?>) : FirebaseRecyclerAdapter<Model, myadapter.myviewholder>(options)
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myviewholder
    {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.singlerow, parent, false)
        return myviewholder(view)
    }

    override fun onBindViewHolder(holder: myviewholder, position: Int, model: Model)
    {
        holder.name.text = model.name
        holder.pass.text = model.pass
        holder.email.text = model.email

        holder.edit.setOnClickListener()
        {

            val dialogPlus = DialogPlus.newDialog(holder.edit.context)
                .setContentHolder(ViewHolder(R.layout.dialogcontent))
                .setExpanded(true, 1100)
                .create()
            val myview = dialogPlus.holderView
            val name = myview.findViewById<EditText>(R.id.uname)
            val pass = myview.findViewById<EditText>(R.id.ucourse)
            val email = myview.findViewById<EditText>(R.id.uemail)
            val submit = myview.findViewById<Button>(R.id.usubmit)

            name.setText(model.name)
            pass.setText(model.pass)
            email.setText(model.email)
            dialogPlus.show()
            submit.setOnClickListener()
            {
                val map: MutableMap<String, Any> = HashMap()
                map["name"] = name.text.toString()
                map["email"] = email.text.toString()
                map["pass"] = pass.text.toString()
                FirebaseDatabase.getInstance().reference.child("vaishali")
                    .child(getRef(position).key!!).updateChildren(map)
                    .addOnSuccessListener {
                        dialogPlus.dismiss()
                        Toast.makeText(holder.edit.context, "updated", Toast.LENGTH_SHORT).show()
                    }
                    .addOnFailureListener { dialogPlus.dismiss() }
            }


        }
        holder.delete.setOnClickListener()
        {
            val alert = AlertDialog.Builder(holder.delete.context)
            alert.setTitle("DELETE?")
            alert.setPositiveButton("YES") { dialog, which ->
                FirebaseDatabase.getInstance().reference.child("vaishali")
                    .child(getRef(position).key!!).removeValue()
                holder.delete.context.startActivity(
                    Intent(
                        holder.delete.context,
                        MainActivity::class.java
                    ))
            }
                alert.setNegativeButton("NO", { dialogInterface: DialogInterface, i: Int ->

                    dialogInterface.cancel()



                }


                )
            alert.show()
            }


        }



    inner class myviewholder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        var name: TextView
        var pass: TextView
        var email: TextView
        var edit:ImageView
        var delete:ImageView


        init {
            // img=(CircleImageView) itemView.findViewById(R.id.img1);
            name = itemView.findViewById(R.id.nametext)
            pass = itemView.findViewById(R.id.passtext)
            email = itemView.findViewById(R.id.emailtext)
            edit=itemView.findViewById(R.id.editicon)
            delete=itemView.findViewById(R.id.deleteicon)

        }
    }

}