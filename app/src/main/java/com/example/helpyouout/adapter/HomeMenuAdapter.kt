package com.example.helpyouout.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.helpyouout.R
import com.example.helpyouout.main.BaseActivity
import com.example.helpyouout.main.Fragment.ChatBotFragment
import com.example.helpyouout.main.Fragment.MeditationFragment
import com.example.helpyouout.main.Fragment.MentalHealthListFragment
import com.example.helpyouout.main.Fragment.ScoreCardFragment
import com.example.helpyouout.model.HomeMenuModel

class HomeMenuAdapter(val context: Context, val listOfData: ArrayList<HomeMenuModel>) : RecyclerView.Adapter<HomeMenuAdapter.VH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(LayoutInflater.from(context).inflate(R.layout.home_grid_view, parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val data = listOfData[position];
        holder.title.text = data.name;
        holder.backgroundImg.setImageResource(data.image)

        holder.cardView.setOnClickListener {

            handleClickListener(position)

        }

    }

    inner class VH(itemview: View) : RecyclerView.ViewHolder(itemview) {
        var title = itemview.findViewById<TextView>(R.id.txtTitle)
        var backgroundImg = itemview.findViewById<ImageView>(R.id.backgroundImg)
        var cardView = itemview.findViewById<CardView>(R.id.optionCard)
    }

    override fun getItemCount(): Int {
        return listOfData.size
    }

    fun handleClickListener(index: Int) {
        when (index) {

            0 -> {
                val meditationFragment = MeditationFragment()
                (context as BaseActivity).replaceFragment(meditationFragment)
            }

            1 -> {
                val scoreCardFragment = ScoreCardFragment()
                (context as BaseActivity).replaceFragment(scoreCardFragment)


            }

            2 -> {
                val chatBotFragment = ChatBotFragment();
                (context as BaseActivity).replaceFragment(chatBotFragment)

            }

            3 -> {
                val mentalHealthListFragment = MentalHealthListFragment()
                (context as BaseActivity).replaceFragment(mentalHealthListFragment);

            }


        }

    }

}