package id.rafif.profilsekolah.recyclerview

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.rafif.profilsekolah.model.Prestasi
import kotlinx.android.synthetic.main.galeri_item.view.*
import kotlinx.android.synthetic.main.prestasi_list.view.*

class PrestasiItemListVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bindData(data: Prestasi) {
        val adapterRv = GaleriItemListAdapter()
        itemView.run {
            bt_judul.text = data.title
            rv_nasional.setHasFixedSize(true)
            rv_nasional.layoutManager = LinearLayoutManager(itemView.context)
            rv_nasional.adapter = adapterRv
        }
        adapterRv.addData(data.data)
        adapterRv.notifyDataSetChanged()
    }

}
