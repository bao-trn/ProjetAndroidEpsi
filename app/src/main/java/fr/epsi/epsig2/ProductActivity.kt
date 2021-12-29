package fr.epsi.epsig2

import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class ProductActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        showBtnBack()
        intent.getStringExtra("title")?.let { setHeaderTitle(it) }

        val products = arrayListOf<Product>()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewProducts)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val productAdapter = ProductAdapter(products)
        recyclerView.adapter = productAdapter

        val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()
        val mRequestURL = intent.getStringExtra("products_url").toString()
        val request = Request.Builder()
            .url(mRequestURL)
            .get()
            .cacheControl(CacheControl.FORCE_NETWORK)
            .build()
        okHttpClient.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call, response: Response) {
                val data = response.body()?.string()
                if(data !=null){
                    val jsOb= JSONObject(data)
                    val jsArray =jsOb.getJSONArray("items")
                    for(i in 0 until jsArray.length()){
                        val jsProducts = jsArray.getJSONObject(i)
                        val name =jsProducts.optString("name","")
                        val description =jsProducts.optString("description","")
                        val picture_url =jsProducts.optString("picture_url","")
                        val product = Product(name=name,description=description, picture_url=picture_url)
                        products.add(product)
                        Log.d("Product",product.name)
                    }
                    runOnUiThread(Runnable {
                        productAdapter.notifyDataSetChanged()
                    })

                    Log.d("WS",data)
                    Log.d("Products","${products.size}")
                }
            }
        })

    }
}