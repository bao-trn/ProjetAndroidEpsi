package fr.epsi.epsig2

import android.content.Intent
import android.media.Image
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {


    fun showBtnBack(){
        val imageViewBack=findViewById<ImageView>(R.id.imageViewBack)
        imageViewBack.visibility=View.VISIBLE
        imageViewBack.setOnClickListener(View.OnClickListener {
            finish()
        })
    }

    fun setHeaderTitle(txt : String){
        val textViewTitle = findViewById<TextView>(R.id.textViewTitle)
        textViewTitle.text = txt
    }

    fun openGroupInfo(){
        val newIntent= Intent(application,GroupInfoActivity::class.java)
        newIntent.putExtra("title",getString(R.string.txt_zone_1))
        startActivity(newIntent)
    }

    fun openStudentInfo(id : Int){
        val newIntent= Intent(application,StudentInfoActivity::class.java)
        newIntent.putExtra("studentId", id)
        startActivity(newIntent)
    }

}