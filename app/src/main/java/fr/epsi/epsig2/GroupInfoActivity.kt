package fr.epsi.epsig2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class GroupInfoActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group_info)
        setHeaderTitle(getString(R.string.txt_title_infos))
        showBtnBack()

        val buttonStudent1: Button = findViewById(R.id.buttonStudent1)
        val buttonStudent2: Button = findViewById(R.id.buttonStudent2)

        buttonStudent1.setOnClickListener(View.OnClickListener {
            openStudentInfo(1)
        })

        buttonStudent2.setOnClickListener(View.OnClickListener {
            openStudentInfo(2)
        })
    }
}