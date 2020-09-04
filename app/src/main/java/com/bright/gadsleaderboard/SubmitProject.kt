package com.bright.gadsleaderboard

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.bright.gadsleaderboard.dialog.ConfirmDialog
import com.bright.gadsleaderboard.dialog.ErrorDialog
import com.bright.gadsleaderboard.dialog.SuccessDialog
import com.bright.gadsleaderboard.retrofit.ApiUrls
import com.bright.gadsleaderboard.retrofit.ServiceBuilder
import kotlinx.android.synthetic.main.activity_submit_project.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SubmitProject : AppCompatActivity() {

    private val tag = "SUBMIT"
    private val baseUrl = "https://docs.google.com/forms/d/e/"
    private val retrofit = ServiceBuilder(baseUrl).buildService(ApiUrls::class.java)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submit_project)

        setSupportActionBar(toolbarSecondary as Toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = ""

        buttonSubmit.setOnClickListener {
            val firstName = editTextFirstName.text.toString().trim()
            val lastName = editTextLastName.text.toString().trim()
            val email = editTextEmailAddress.text.toString().trim()
            val github = editTextGithubLink.text.toString().trim()

            if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || github.isEmpty()) {
                Toast.makeText(this, "Provide all fields and proceed", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            submitProject(firstName, lastName, email, github)
        }
    }

    private fun submitProject(firstName: String, lastName: String, email: String, link: String) {
        val custom = ConfirmDialog(object : BaseInterface {
            override fun onDone() {
                retrofit.submitProject(email, firstName, lastName, link).enqueue(handleCallBack)
            }
        })
        custom.show(supportFragmentManager, tag)
    }

    //MARK: handle that callback
    private var handleCallBack = object : Callback<Void> {
        override fun onResponse(call: Call<Void>, response: Response<Void>) {
            Log.e("SUCCESS", response.body().toString())
            SuccessDialog().show(supportFragmentManager, tag)
        }

        override fun onFailure(call: Call<Void>, t: Throwable) {
            Log.e("ERROR", t.toString())
            ErrorDialog().show(supportFragmentManager, tag)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}