package fr.epsi.epsig2

import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonZone1:Button = findViewById(R.id.buttonZone1)
        val buttonZone2:Button = findViewById(R.id.buttonZone2)

        (application as AppRenduEPSI).showToast("EPSI Rendu Projet")

        buttonZone1.setOnClickListener(View.OnClickListener {
            openGroupInfo();
        })

        buttonZone2.setOnClickListener(View.OnClickListener {
            openRayonInfo()
        })

    }

}