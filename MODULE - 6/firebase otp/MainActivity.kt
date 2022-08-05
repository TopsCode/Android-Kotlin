package com.example.otp
/*keytool -list -v -keystore "%USERPROFILE%\.android\debug.keystore" -alias androiddebugkey -storepass android -keypass android*/

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import android.widget.Toast

import android.text.TextUtils
import com.google.firebase.auth.PhoneAuthProvider
import java.util.concurrent.TimeUnit
import com.google.firebase.auth.PhoneAuthCredential
import android.content.Intent
import android.util.Log

import com.google.firebase.auth.AuthResult

import androidx.annotation.NonNull

import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.FirebaseException


class MainActivity : AppCompatActivity()
{

    // variable for FirebaseAuth class
     lateinit var mAuth: FirebaseAuth

    // variable for our text input
    // field for phone and OTP.
    lateinit var edtPhone: EditText  // variable for our text input

    // field for phone and OTP.
    lateinit var edtOTP: EditText

    // buttons for generating OTP and verifying OTP
    lateinit var verifyOTPBtn: Button  // buttons for generating OTP and verifying OTP
    lateinit var generateOTPBtn: Button

    // string for storing our verification ID
    private var verificationId: String? = null
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAuth = FirebaseAuth.getInstance();

        // initializing variables for button and Edittext.
        edtPhone = findViewById(R.id.idEdtPhoneNumber);
        edtOTP = findViewById(R.id.idEdtOtp);
        verifyOTPBtn = findViewById(R.id.idBtnVerify);
        generateOTPBtn = findViewById(R.id.idBtnGetOtp);


        verifyOTPBtn.setOnClickListener()
        {
            if (TextUtils.isEmpty(edtOTP.getText().toString())) {
                // if the OTP text field is empty display
                // a message to user to enter OTP
                Toast.makeText(this, "Please enter OTP", Toast.LENGTH_SHORT).show();
            }
            else
            {
                // if OTP field is not empty calling
                // method to verify the OTP.
                verifyCode(edtOTP.getText().toString());
            }
        }
        generateOTPBtn.setOnClickListener()
        {
            if (TextUtils.isEmpty(edtPhone.text.toString())) {
                // when mobile number text field is empty
                // displaying a toast message.
                Toast.makeText(this@MainActivity, "Please enter a valid phone number.", Toast.LENGTH_SHORT).show()
            }
            else {
                // if the text field is not empty we are calling our
                // send OTP method for getting OTP from Firebase.
                val phone = edtPhone.text.toString()
                sendVerificationCode(phone)
            }
        }





    }





    private fun verifyCode(code: String)
    {
        val credential = PhoneAuthProvider.getCredential(verificationId!!, code)
        signInWithCredential(credential);
    }

    private val mCallBack: PhoneAuthProvider.OnVerificationStateChangedCallbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks()
    {

            override fun onCodeSent(s: String, forceResendingToken: PhoneAuthProvider.ForceResendingToken)
            {
                super.onCodeSent(s, forceResendingToken)
                verificationId = s
            }
            override fun onVerificationCompleted(phoneAuthCredential: PhoneAuthCredential) {

                val code = phoneAuthCredential.smsCode


                if (code != null) {

                    edtOTP!!.setText(code)

                    verifyCode(code)
                }
            }


            override fun onVerificationFailed(e: FirebaseException)
            {

                Toast.makeText(this@MainActivity, "Error   " + e.message, Toast.LENGTH_LONG).show()
                Log.d("topsdetail", e.message!!)
            }
        }

    private fun signInWithCredential(credential: PhoneAuthCredential)
    {

        mAuth.signInWithCredential(credential)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // if the code is correct and the task is successful
                    // we are sending our user to new activity.
                    val i = Intent(this@MainActivity, HomeActivity::class.java)
                    startActivity(i)
                    finish()
                }
                else {
                    // if the code is not correct then we are
                    // displaying an error message to the user.
                    Toast.makeText(this@MainActivity, "Error", Toast.LENGTH_LONG).show()
                }
            }

    }

    private fun sendVerificationCode(phone: String)
    {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(phone, 60, TimeUnit.SECONDS, this, mCallBack)
    }

}