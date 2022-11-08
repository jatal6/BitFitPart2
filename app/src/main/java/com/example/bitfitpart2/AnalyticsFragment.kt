package com.example.bitfitpart2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch



private const val TAG = "AnalyticsFragment"
class AnalyticsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.vol_fragment_analytics, container, false)
        /** Adds new food item to the database */
        lifecycleScope.launch(Dispatchers.IO) {
            var  totalCalories = (activity?.application as BitFitApplication).db.foodDao().totalCalories()
            view.findViewById<TextView?>(R.id.value_total_volume).text = totalCalories

        }


        return view

    }

    companion object {

        fun newInstance(): AnalyticsFragment{
            return AnalyticsFragment()
        }

    }
}