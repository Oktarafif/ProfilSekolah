package id.rafif.profilsekolah.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import id.rafif.profilsekolah.R
import id.rafif.profilsekolah.model.ItemRV
import id.rafif.profilsekolah.recyclerview.GaleriItemListAdapter
import kotlinx.android.synthetic.main.fragment_eskul.view.*


class EskulFragment : Fragment() {

    private lateinit var adapterRV: GaleriItemListAdapter

    override fun onCreateView(inflater: LayoutInflater
                              ,container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_eskul, container, false)
        // modifikasi bagian RV yg ada di xml
        view.rv_eskul.run{
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(view.context)
            adapter = adapterRV
        }
        return view
    }
}