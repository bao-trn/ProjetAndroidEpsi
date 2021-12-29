package fr.epsi.epsig2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class DetailActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        showBtnBack()
        intent.getStringExtra("product_name")?.let { setProductDetailTitle(it) }
        val productDetailDescription = findViewById<TextView>(R.id.product_detail_description)
        productDetailDescription.text = intent.getStringExtra("product_description")

        val productPictureUrl = intent.getStringExtra("product_picture_url")
        val productDetailImage = findViewById<ImageView>(R.id.product_detail_image)
        Picasso.get().load(productPictureUrl).into(productDetailImage)

    }
}