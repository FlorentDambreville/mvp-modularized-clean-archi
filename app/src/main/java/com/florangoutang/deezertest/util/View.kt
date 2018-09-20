package com.florangoutang.deezertest.util

import android.support.annotation.DrawableRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.squareup.picasso.Picasso

fun ViewGroup.inflateFromParent(layoutId : Int, attachToRoot : Boolean = false) : View {
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
}

fun ImageView.loadUrl(url: String, @DrawableRes placeholder: Int) {
    if(url.isEmpty()){
        setImageResource(placeholder)
        return
    } else {
        Picasso.with(this.context)
                .load(url)
                .placeholder(placeholder)
                .into(this)
    }
}