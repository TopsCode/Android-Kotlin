package com.example.imageupload

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.graphics.Bitmap
import android.net.Uri
import android.provider.MediaStore
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import net.gotev.uploadservice.MultipartUploadRequest
import java.lang.Exception


class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var editText: EditText
    lateinit var button: Button
    lateinit var imageView: ImageView
    lateinit var button2: Button
    lateinit var filepath: Uri
    lateinit var  bitmap: Bitmap

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText=findViewById(R.id.edtdata)
        button=findViewById(R.id.btnchoose)
        button2=findViewById(R.id.btnupload)
        imageView=findViewById(R.id.img)

        requestpermission();

        button.setOnClickListener(this)
        button2.setOnClickListener(this)



    }

    private fun requestpermission()
    {
        if (ContextCompat.checkSelfPermission(this@MainActivity, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)
            return
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE))
        {

        }
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), 200)


    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray)
    {
        if (requestCode == 200)
        {
            if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //Displaying a toast
                Toast.makeText(this, "Permission granted now you can read the storage", Toast.LENGTH_LONG).show()
            }
            else
            {
                //Displaying another toast if permission is not granted
                Toast.makeText(this, "Oops you just denied the permission", Toast.LENGTH_LONG).show()
            }
        }
        else
        {
            Toast.makeText(this, "you are not eligible", Toast.LENGTH_SHORT).show()
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
    @SuppressLint("Range")
    fun getPath(uri: Uri?): String
    {
        var cursor = contentResolver.query(uri!!, null, null, null, null)
        cursor!!.moveToFirst()
        var document_id = cursor.getString(0)
        document_id = document_id.substring(document_id.lastIndexOf(":") + 1)
        cursor.close()
        cursor = contentResolver.query(
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
            null, MediaStore.Images.Media._ID + " = ? ", arrayOf(document_id), null)
        cursor!!.moveToFirst()
        val path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA))
        cursor.close()
        return path
    }

    override fun onClick(p0: View?)
    {
        if(p0==button)
        {
            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), 1)
        }
        if(p0==button2)
        {
            val name = editText.getText().toString().trim { it <= ' ' }
            val path = getPath(filepath)
            try
            {
                MultipartUploadRequest(this@MainActivity, Api.url)
                    .addFileToUpload(path, "url")
                    .addParameter("name", name)
                    .setMaxRetries(2)
                    .startUpload()
                Toast.makeText(this@MainActivity, "success", Toast.LENGTH_SHORT).show()
            }
            catch (e:Exception)
            {

            }

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
    {

        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            filepath = data.data!!
            try {
                bitmap = MediaStore.Images.Media.getBitmap(contentResolver, filepath)
                imageView!!.setImageBitmap(bitmap)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }



        super.onActivityResult(requestCode, resultCode, data)
    }
}