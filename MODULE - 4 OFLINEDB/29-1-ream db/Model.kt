package com.example.myapplication

import io.realm.RealmObject

open class Model : RealmObject()
{
        var id=0
        var name: String? = null
        var pass: String? = null

}