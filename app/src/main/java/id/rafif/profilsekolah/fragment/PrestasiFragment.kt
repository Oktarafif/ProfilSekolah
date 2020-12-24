package id.rafif.profilsekolah.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import id.rafif.profilsekolah.R
import id.rafif.profilsekolah.model.Prestasi
import id.rafif.profilsekolah.recyclerview.PrestasiItemListAdapter
import id.rafif.profilsekolah.retrofit.RetrofitInterface
import id.rafif.profilsekolah.retrofit.RetrofitService
import kotlinx.android.synthetic.main.prestasi_list.view.*
import kotlinx.coroutines.launch


class PrestasiFragment : Fragment() {

    private lateinit var adapterRv: PrestasiItemListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_prestasi, container, false)
        adapterRv = PrestasiItemListAdapter()
        view.rv_nasional.setHasFixedSize(true)
        view.rv_nasional.layoutManager = LinearLayoutManager(view.context)
        view.rv_nasional.adapter = adapterRv
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // buat variabel untuk membuat retrofitService
        val retrofitService = RetrofitService.buildService(RetrofitInterface::class.java)
        // pada fragment kita gunakan viewLifecyclerOwner untuk menjalankan fungsi suspend / asynchronous
        viewLifecycleOwner.lifecycleScope.launch {
            // jalankan fungsi getDataGaleri yang berjalan secara asynchronous / di background
            val request = retrofitService.getDataPrestasi()
            if (request.isSuccessful) { // jika request sukses
                val dataPrestasi = request.body() as List<Prestasi>
                adapterRv.addData(dataPrestasi)
                adapterRv.notifyDataSetChanged()
            }
        }
    }
}