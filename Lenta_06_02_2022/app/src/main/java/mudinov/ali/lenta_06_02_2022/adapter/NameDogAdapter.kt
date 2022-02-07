package mudinov.ali.lenta_06_02_2022.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import mudinov.ali.lenta_06_02_2022.R
import mudinov.ali.lenta_06_02_2022.activities.PageDogActivity
import mudinov.ali.lenta_06_02_2022.databinding.ItemNameDogBinding
import mudinov.ali.lenta_06_02_2022.model.Dogs

class NameDogsAdapter(private val context: Context, var dogsNameList: ArrayList<Dogs>): RecyclerView.Adapter<DogsViewHolder>() {

    var contextN = context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemNameDogBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_name_dog, parent, false)
        return DogsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DogsViewHolder, position: Int) {
        holder.bind(dogsNameList[position], contextN)
    }

    override fun getItemCount(): Int {
        return dogsNameList.size
    }


}

class DogsViewHolder(val binding: ItemNameDogBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(dogs: Dogs, context: Context) {
        binding.idNameDog.text = dogs.name

        binding.idNameDog.setOnClickListener {
            //Toast.makeText(it.context, "Pressed :  ${binding.idNameDog.text}", Toast.LENGTH_SHORT).show()
            val intent = Intent(context, PageDogActivity::class.java).apply {
                putExtra("image", dogs.image?.url)
                putExtra("name", dogs.name)
                putExtra("temperament", dogs.temperament)
                putExtra("height", dogs.height?.metric)
            }
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }
    }
}