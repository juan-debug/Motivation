package com.example.motivation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.motivation.R
import com.example.motivation.infra.MotivationConstants
import com.example.motivation.infra.SecurityPreferences
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() ,View.OnClickListener {
    private lateinit var mSecurityPreferences: SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

         mSecurityPreferences = SecurityPreferences(this)

        if(supportActionBar != null){
            supportActionBar!!.hide()
    }
  buttonSalvar.setOnClickListener(this)


}

    override fun onClick(view: View) {
        val id = view.id
        if (id == R.id.buttonSalvar){
            handleSave()
        }

    }

    private fun handleSave() {
        val name = editName.text.toString()
        if (name != "") {
            mSecurityPreferences.storeString(MotivationConstants.KEY.PERSON_NAME, name)
            val intent = Intent (this , MainActivity::class.java)
             startActivity(intent)
        }else {
            Toast.makeText(this,"informe seu nome!" ,Toast.LENGTH_SHORT).show()

        }
    }
}