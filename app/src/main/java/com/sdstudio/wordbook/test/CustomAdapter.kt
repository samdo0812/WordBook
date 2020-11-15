package com.sdstudio.wordbook.test

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.sdstudio.wordbook.R
import kotlinx.android.synthetic.main.test_fragment_item.view.*

class CustomAdapter : BaseAdapter{

    var nameList = ArrayList<Item>()
    var context: Context? = null

    constructor(nameList: ArrayList<Item>, context: Context?) : super() {
        this.nameList = nameList
        this.context = context
    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val nameGridList = this.nameList[position]
        var inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        var nameView = inflater.inflate(R.layout.test_fragment_item, null)
        nameView.image.setImageResource(nameGridList.image!!)
        nameView.textView.text = nameGridList.name
        return nameView
    }

    override fun getItem(position: Int): Any {
        return nameList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return nameList.size
    }
}