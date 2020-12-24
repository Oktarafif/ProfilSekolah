package id.rafif.profilsekolah.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import id.rafif.profilsekolah.R
import id.rafif.profilsekolah.model.ItemRV
import id.rafif.profilsekolah.recyclerview.GaleriItemListAdapter
import id.rafif.profilsekolah.retrofit.RetrofitService
import kotlinx.android.synthetic.main.fragment_galeri.view.*
import kotlinx.coroutines.launch


class GaleriFragment : Fragment() {

    private lateinit var adapter: GaleriItemListAdapter

    fun onCreate(inflater: LayoutInflater
                          ,container: ViewGroup?,
                          savedInstanceState: Bundle?
    ): View? {
        // inflate view yang akan digunakan, dalam hal ini fragment_galeri
        val view = inflater.inflate(R.layout.fragment_galeri, container, false)
        // buat adapter untuk recyclerview
        adapter = GaleriItemListAdapter()
        // atur recyclerview rv_galeri
        view.rv_galeri.adapter = adapter
        view.rv_galeri.setHasFixedSize(true)
        view.rv_galeri.layoutManager = LinearLayoutManager(view.context)
        // pengaturan recyclerview selesai
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // buat variabel untuk membuat retrofitService
        val retrofitService = RetrofitService.buildService(RetrofitService::class.java)
        // pada fragment kita gunakan viewLifecyclerOwner untuk menjalankan fungsi suspend / asynchronous
        viewLifecycleOwner.lifecycleScope.launch {
            // jalankan fungsi getDataGaleri yang berjalan secara asynchronous / di background
            val request = retrofitService.getDataGaleri()
            if (request.isSuccessful) { // jika request sukses
                val dataGaleri = request.body() as List<ItemRV>
                adapter.addData(dataGaleri)
                adapter.notifyDataSetChanged()
            }
        }
    }
}