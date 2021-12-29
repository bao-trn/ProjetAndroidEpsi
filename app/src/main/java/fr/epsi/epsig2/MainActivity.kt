package fr.epsi.epsig2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonZone1:Button = findViewById(R.id.buttonZone1)
        val buttonZone2:Button = findViewById(R.id.buttonZone2)
        val buttonLogin:Button = findViewById(R.id.buttonLogin)
        val buttonCreate:Button = findViewById(R.id.buttonCreate)
        val buttonStudents:Button = findViewById(R.id.buttonStudents)

        (application as AppEpsi).showToast("Hello Epsi")

        buttonZone1.setOnClickListener(View.OnClickListener {
            openGroupInfo();
        })

        buttonZone2.setOnClickListener(View.OnClickListener {
            val newIntent= Intent(application,DetailActivity::class.java)
            newIntent.putExtra("title",getString(R.string.txt_zone_2))
            startActivity(newIntent)
        })

        buttonLogin.setOnClickListener(View.OnClickListener {
            val newIntent= Intent(application,LoginActivity::class.java)
            startActivity(newIntent)
        })

        buttonCreate.setOnClickListener(View.OnClickListener {
            val newIntent= Intent(application,CreateActivity::class.java)
            startActivity(newIntent)
        })

        buttonStudents.setOnClickListener(View.OnClickListener {
            val newIntent= Intent(application,StudentsActivity::class.java)
            startActivity(newIntent)
        })
    }


}