package fr.epsi.epsig2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class CreateActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)
        showBtnBack()
        setHeaderTitle("Create")
    }
}