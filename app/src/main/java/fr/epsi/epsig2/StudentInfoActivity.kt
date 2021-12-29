package fr.epsi.epsig2


import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView


class StudentInfoActivity : BaseActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val myIntent = intent
        setContentView(R.layout.activity_student_info)
        setHeaderTitle(getString(R.string.txt_title_name))
        showBtnBack()
        if(myIntent.getIntExtra("studentId",1) == 2){
            val studentAvatar = findViewById<ImageView>(R.id.studentAvatar)
            val studentName = findViewById<TextView>(R.id.studentName)
            val studentMail = findViewById<TextView>(R.id.studentMail)
            val studentDesc = findViewById<TextView>(R.id.studentDescription)
            studentAvatar.setImageResource(R.drawable.xin)
            studentDesc.text = "Xin Tao n'est pas une bière"
            studentName.text = "TAO Xin"
            studentMail.text = "xin.tao@epsi.fr"
        }
    }
}


