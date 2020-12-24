package id.rafif.profilsekolah.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.rafif.profilsekolah.R


class Founderragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater
                              ,container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_founder, container, false)
        return view
    }
}