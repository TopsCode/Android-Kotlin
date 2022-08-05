package com.example.bottombar

import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewplaystore.Models


class ProfileFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view:View=inflater.inflate(R.layout.fragment_profile, container, false)
        var exit= view.findViewById<Button>(R.id.exit);
        exit?.setOnClickListener {

            var builder= AlertDialog.Builder(view.context).setTitle("Alert").setMessage("Are you sure u want to exit")
                .setPositiveButton("Yes", DialogInterface.OnClickListener{
                        dialogInterface,i->
                    System.exit(0)

                })
                .setNegativeButton("NO", DialogInterface.OnClickListener{
                        dialogInterface,i->
                    Toast.makeText(context, "App will not be closed", Toast.LENGTH_SHORT).show()
                    dialogInterface.dismiss()
                })
                .setNeutralButton("cancel", DialogInterface.OnClickListener{ dialogInterface, i->
                    Toast.makeText(context, "Process terminated", Toast.LENGTH_SHORT).show()
                    dialogInterface.cancel()
                })
                .setCancelable(false)
            builder.show()
        }

        var rev=view.findViewById<RecyclerView>(R.id.rev);
        rev?.layoutManager= LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)

        var al=ArrayList<Models>()

        al.add(Models("Pubg:BatteleGround",R.mipmap.pubg,R.mipmap.pubg_main,"4.4","864MB","Action","Shooter"))
        al.add(Models("Pubg:BatteleGround",R.mipmap.pubg,R.mipmap.pubg_main,"4.4","864MB","Action","Shooter"))
        al.add(Models("Pubg:BatteleGround",R.mipmap.pubg,R.mipmap.pubg_main,"4.4","864MB","Action","Shooter"))

        var adapter=Myadapter(al)
        rev.adapter=adapter

        return view;
    }

}