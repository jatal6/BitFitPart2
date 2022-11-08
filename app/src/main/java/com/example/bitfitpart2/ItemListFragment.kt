package com.example.bitfitpart2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch


/**
 * A simple [Fragment] subclass.
 * Use the [ItemListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */


class ItemListFragment : Fragment() {
    private val food = mutableListOf<ItemEntity>()
    private lateinit var bevRecyclerView: RecyclerView
    private lateinit var itemAdapter: ItemAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.vol_fragment_list, container, false)
        val layoutManager = LinearLayoutManager(context)
        bevRecyclerView = view.findViewById(R.id.bevRecyclerView)
        bevRecyclerView.setHasFixedSize(true)
        //set adapter with a food array
        itemAdapter = ItemAdapter(view.context, food)
        //set recycler view to adapter


        lifecycleScope.launch {
            /**Get food from database, map to food entity list, clear the data base, add all entries to adapter
            update recyclerView**/
            (activity?.application as BitFitApplication).db.foodDao().getAll().collect { databaseList ->
                databaseList.map { entity ->
                    ItemEntity(entity.foodName, entity.foodCalories)
                }.also { mappedList ->
                    food.clear()
                    food.addAll(mappedList)
                    itemAdapter.notifyDataSetChanged()

                }
            }
        }

        bevRecyclerView.adapter = itemAdapter

        layoutManager.also {
            val dividerItemDecoration = DividerItemDecoration(context, it.orientation)
            bevRecyclerView.addItemDecoration(dividerItemDecoration)
        }
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Call the new method within onViewCreated


    }

    companion object {
        fun newInstance(): ItemListFragment{
            return ItemListFragment()
        }
    }
}