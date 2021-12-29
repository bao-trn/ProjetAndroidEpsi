package fr.epsi.epsig2

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import androidx.core.content.ContextCompat.startActivity

class ProductAdapter (private val products: ArrayList<Product>): RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    class ViewHolder (view: View) : RecyclerView.ViewHolder(view){
        val contentLayoutProducts: LinearLayout = view.findViewById<LinearLayout>(R.id.contentLayoutProducts)

        val imageViewProducts: ImageView = view.findViewById<ImageView>(R.id.imageViewProducts)
        val textViewProductsNames: TextView = view.findViewById<TextView>(R.id.textViewProductsNames)
        val textViewProductsDescriptions: TextView = view.findViewById<TextView>(R.id.textViewProductsDescriptions)

    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.cell_product, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products.get(position)
        Picasso.get().load(product.picture_url).into(holder.imageViewProducts)
        holder.textViewProductsNames.text=product.name
        holder.textViewProductsDescriptions.text=product.description

        holder.contentLayoutProducts.setOnClickListener(View.OnClickListener {
            val context = holder.contentLayoutProducts.context
            val newIntent = Intent(context, DetailActivity::class.java)
            newIntent.putExtra("product_name",product.name)
            newIntent.putExtra("product_picture_url",product.picture_url)
            newIntent.putExtra("product_description",product.description)
            context.startActivity(newIntent)
        })

    }
    override fun getItemCount(): Int {
        return products.size
    }
}