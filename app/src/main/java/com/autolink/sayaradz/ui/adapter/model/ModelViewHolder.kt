package com.autolink.sayaradz.ui.adapter.model

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.autolink.sayaradz.R
import com.autolink.sayaradz.ui.adapter.BaseViewHolder
import com.autolink.sayaradz.vo.Model
import com.bumptech.glide.RequestManager


class ModelViewHolder(view: View,
                      glide: RequestManager,
                      val listener:ModelsAdapter.OnModelClickListener): BaseViewHolder<Model>(view,glide) {

    init {
        view.setOnClickListener {
            val brand  = it.tag as Model
            listener.onModelClick(brand)
        }
    }


    companion object {
        fun create(parent: ViewGroup, glide: RequestManager,listener:ModelsAdapter.OnModelClickListener): ModelViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_list_model, parent, false)
            return ModelViewHolder(view, glide,listener = listener)
        }
    }


    val modelImage: ImageView = view.findViewById(R.id.model_image)
    val modelName: TextView = view.findViewById(R.id.model_name)




    override fun bindTo(o: Model) {
        with(o) {
            modelName.text = name
            glide.load(photoURL)
                .into(modelImage)
            view.tag = o
        }
    }
}
