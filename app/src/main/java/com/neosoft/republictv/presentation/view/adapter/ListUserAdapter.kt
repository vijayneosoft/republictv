package com.neosoft.republictv.presentation.view.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.neosoft.republictv.R
import com.neosoft.republictv.domain.entity.ResultEntity
import com.neosoft.republictv.presentation.utils.load

/**
 * Created by Vijay on 30/8/19.
 */

class ListUserAdapter(
    private var mContext: Context,
    private var mListUserData: List<ResultEntity>
) : RecyclerView.Adapter<ListUserAdapter.ListUserViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListUserViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.adapter_list_users, parent, false)
        return ListUserViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mListUserData.size
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onBindViewHolder(holder: ListUserViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class ListUserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var imgUsers: ImageView
        var txtName: TextView
        var txtEmail: TextView

        init {
            imgUsers = itemView.findViewById<ImageView>(R.id.img_user)
            txtName = itemView.findViewById<TextView>(R.id.txt_name)
            txtEmail = itemView.findViewById<TextView>(R.id.txt_email)
        }

        @SuppressLint("SetTextI18n")
        @RequiresApi(Build.VERSION_CODES.M)
        fun bind(position: Int) {

            val userData = mListUserData.get(position)
            Glide.with(mContext).load(userData.picture?.large)
                .into(imgUsers)

            txtEmail.setText(userData.email)
            txtName.setText(userData.name?.first + " " + userData.name?.last)


        }
    }

}