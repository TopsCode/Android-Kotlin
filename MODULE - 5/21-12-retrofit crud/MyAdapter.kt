package com.example.retrofitcrud


import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context

import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView

import android.content.Intent

import android.widget.Toast

import android.content.DialogInterface

import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup
import com.example.retrofitcrudex.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MyAdapter(context: Context, dataList: List<Model>) :
    RecyclerView.Adapter<MyAdapter.Myview>() {
    var context: Context
    var dataList: List<Model>
    var api: Apiinterface? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myview
    {
        val view: View = LayoutInflater.from(parent.context).inflate(
            R.layout.design, parent, false)
        return Myview(view)
    }

    override fun onBindViewHolder(holder: Myview, @SuppressLint("RecyclerView") position: Int) {
        holder.t1.setText(dataList[position].name)
        holder.t2.setText(dataList[position].email)

        holder.itemView.setOnClickListener(object : View.OnClickListener
        {
            override fun onClick(v: View) {
                val alert: AlertDialog.Builder = AlertDialog.Builder(v.getContext())
                alert.setTitle("select?")
                alert.setPositiveButton("update",
                    DialogInterface.OnClickListener { dialog, which ->
                        val i = Intent(context, UpdateActivity::class.java)
                        i.putExtra("id", dataList[position].id)
                        i.putExtra("name", dataList[position].name)
                        i.putExtra("email", dataList[position].email)

                        i.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                        v.getContext().startActivity(i)
                    })

                alert.setNegativeButton("Delete",
                    {
                            dialogInterface: DialogInterface, i: Int ->

                        api = ApiClient().getApiClient()!!.create(Apiinterface::class.java)

                        val call: Call<Model?>? = api!!.deletedata(dataList[position].id)

                        call!!.enqueue(object :Callback<Model?>{
                            override fun onResponse(call: Call<Model?>, response: Response<Model?>, )
                            {
                               // Toast.makeText(v.getContext(), "deleted", Toast.LENGTH_SHORT).show()
                                val i = Intent()
                                i.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                                v.getContext().startActivity(Intent(v.getContext(), MainActivity2::class.java))

                            }

                            override fun onFailure(call: Call<Model?>, t: Throwable) {

                            }

                            /* override fun onFailure(call: Call<Model?>, t: Throwable)
                             {
                                 Toast.makeText(v.getContext(), "Error Delete", Toast.LENGTH_SHORT).show()
                             }*/
                        })

                        Toast.makeText(v.getContext(), "deleted", Toast.LENGTH_SHORT).show()
                        val i = Intent()
                        i.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                        v.getContext().startActivity(Intent(v.getContext(), MainActivity2::class.java))

                    })
              /*  alert.setNegativeButton("Delete",
                    DialogInterface.OnClickListener { dialog, which ->
                        api =
                            ApiClient().getApiClient()!!.create<Apiinterface>(Apiinterface::class.java)
                        val call: Call<Model?>? = api!!.deleteNote(dataList[position].id)
                        call!!.enqueue(object : Callback<Model?>{
                            override fun onResponse(call: Call<Model?>?, response: Response<Model?>?) {
                                Toast.makeText(v.getContext(), "deleted", Toast.LENGTH_SHORT).show()
                                val i = Intent()
                                i.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                            }

                            override fun onFailure(call: Call<Model?>?, t: Throwable) {

                                // Toast.makeText(v.getContext(), "Error"+t.getMessage(), Toast.LENGTH_SHORT).show();
                                //Log.d("123456", t.message)
                            }
                        })
                        v.getContext()
                            .startActivity(Intent(v.getContext(), ViewActivity::class.java))
                    })*/
                alert.show()
            }
        })
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class Myview(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var t1: TextView
        var t2: TextView


        init {
            t1 = itemView.findViewById(R.id.t1)
            t2 = itemView.findViewById(R.id.t2)

        }
    }

    init {
        this.context = context
        this.dataList = dataList
    }
}