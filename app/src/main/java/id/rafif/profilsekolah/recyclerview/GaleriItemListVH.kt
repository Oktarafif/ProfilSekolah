package id.rafif.profilsekolah.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.rafif.profilsekolah.model.ItemRV
import kotlinx.android.synthetic.main.galeri_item.view.*

class GaleriItemListVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(item: ItemRV) {
        itemView.run {
            Judul.text = item.titleImg
            Desc.text = item.desc
            Glide.with(this).load(item.urlImg).into(img_view)
        }
    }

}
