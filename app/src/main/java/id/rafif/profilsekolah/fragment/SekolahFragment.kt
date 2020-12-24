package id.rafif.profilsekolah.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import id.rafif.profilsekolah.R


class SekolahFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater
    ,container: ViewGroup?,
    savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sekolah, container, false)
        return view

    }

}