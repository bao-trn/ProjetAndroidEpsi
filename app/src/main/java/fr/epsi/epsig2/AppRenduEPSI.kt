package fr.epsi.epsig2

import android.app.Application
import android.widget.Toast

class AppRenduEPSI : Application(){

    fun showToast(txt : String){
        Toast.makeText(this,txt,Toast.LENGTH_SHORT).show()
    }

}