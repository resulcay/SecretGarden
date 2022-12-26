package com.example.secretgarden

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import kotlinx.coroutines.awaitAll

class MainActivity : AppCompatActivity() {
    private var constList = ArrayList<Flowers>()
    var adapter : FlowersAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        constList.add(Flowers("Rose","Some Description for Rose",R.drawable.rose))
        constList.add(Flowers("Chrysanthemum","Some Description for Chrysanthemum",R.drawable.chrysanthemum))
        constList.add(Flowers("Tulip","Some Description for Tulip",R.drawable.tulip))
        constList.add(Flowers("Violet","Some Description for Violet",R.drawable.violet))
        constList.add(Flowers("Narcissus","Some Description for Narcissus",R.drawable.narcissus))
        constList.add(Flowers("Orchid","Some Description for Orchid",R.drawable.orchid))
        constList.add(Flowers("Hydrangea","Some Description for Hydrangea",R.drawable.hydrangea))
        constList.add(Flowers("Daisy","Some Description for Daisy",R.drawable.daisy))

        adapter = FlowersAdapter(this,constList)
        findViewById<ListView>(R.id.listView).adapter = adapter

    }
    class FlowersAdapter(context: Context, var constList: ArrayList<Flowers>) : BaseAdapter()
    {
        private var context : Context?= context

        override fun getCount(): Int {
            return  constList.size
        }

        override fun getItem(position: Int): Any {
            return constList.get(position)
        }

        override fun getItemId(position: Int): Long {
            return  position.toLong()
        }

        @SuppressLint("ViewHolder", "InflateParams")
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val posFlowers=constList[position]
            val inflater = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val flowerCard = inflater.inflate(R.layout.flower_card,null)
            parent?.findViewById<TextView>(R.id.cardName)?.text = posFlowers.name
            parent?.findViewById<TextView>(R.id.cardDescription)?.text = posFlowers.description
            parent?.findViewById<ImageView>(R.id.cardImage)?.setImageResource(posFlowers.image!!)
            return  flowerCard
        }
    }
}