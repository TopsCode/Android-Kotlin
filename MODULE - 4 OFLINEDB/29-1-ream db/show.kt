package com.example.myapplication


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import io.realm.RealmResults
import com.example.myapplication.CustomAdapter
import android.widget.AdapterView.OnItemLongClickListener
import android.widget.AdapterView
import android.content.DialogInterface
import android.view.LayoutInflater
import android.widget.EditText
import android.content.Intent
import android.widget.ListView
import androidx.appcompat.app.AlertDialog
import com.example.myapplication.show
import io.realm.Realm
import java.util.ArrayList

class show : AppCompatActivity() {
    lateinit var listView: ListView
    lateinit var list: MutableList<Model?>
    lateinit var realm: Realm
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)
        listView = findViewById(R.id.list)
        list = ArrayList()
        realm = Realm.getInstance(Realm.getDefaultConfiguration())

        realm!!.beginTransaction()
        val realmResults = realm!!.where(
            Model::class.java).findAll()
        for (i in realmResults.indices) {
            list!!.add(realmResults[i])
        }
        realm!!.commitTransaction()

        val customAdapter = CustomAdapter(this@show, list)
        listView!!.setAdapter(customAdapter)

        listView!!.setOnItemLongClickListener(OnItemLongClickListener { adapterView, view, position, l ->
            val alert = AlertDialog.Builder(this@show)
            alert.setTitle("Select Operations?")
            alert.setPositiveButton("Update") { dialogInterface, i ->
                val `in` = LayoutInflater.from(this@show)
                val view = `in`.inflate(R.layout.edit, null)
                val alert2 = AlertDialog.Builder(this@show)
                alert2.setView(view)
                val edt1 = view.findViewById<EditText>(R.id.edt1)
                val edt2 = view.findViewById<EditText>(R.id.edt2)
                edt1.setText(list.get(position)!!.name)
                edt2.setText(list.get(position)!!.pass)
                alert2.setPositiveButton("Update") { dialogInterface, i ->
                    val realmResults = realm.where(
                        Model::class.java).findAll()
                    realm.beginTransaction()
                    realmResults[position]!!.name = edt1.text.toString()
                    realmResults[position]!!.pass = edt2.text.toString()
                    realm.commitTransaction()
                    startActivity(Intent(this@show, show::class.java))
                }
                alert2.show()
            }
            alert.setNegativeButton("Delete") { dialogInterface, i ->
                realm.beginTransaction()
                val realmResults: RealmResults<Model> = realm.where(Model::class.java).findAll()
                realmResults.deleteFromRealm(position)
                realm.commitTransaction()
                startActivity(Intent(this@show, show::class.java))
            }
            alert.show()
            false
        })
    }

    override fun onBackPressed() {
        finishAffinity()
    }
}