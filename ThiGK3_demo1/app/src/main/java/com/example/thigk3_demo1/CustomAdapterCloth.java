package com.example.thigk3_demo1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapterCloth extends RecyclerView.Adapter<CustomAdapterCloth.ViewHolder> {
    ArrayList<Cloth> mCloths;
    private OnclickListener listener;

    public CustomAdapterCloth(ArrayList<Cloth> cloths, OnclickListener listener) {
        this.mCloths = cloths;
        this.listener = listener;// sau khi them vao trong controller thi phai khai bao them o ham Main
    }

    @NonNull
    @Override
    public CustomAdapterCloth.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cloth,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return mCloths.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Cloth mCloth;
        ImageView imgcloth;
        TextView tvName, tvPrice;
        public ViewHolder(@NonNull View itemView) {
            // anh xa
            super(itemView);
            imgcloth = itemView.findViewById(R.id.imgCloth);
            tvName = itemView.findViewById(R.id.tvName);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            // bat su kien item click
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.itemClick(mCloth);
                }
            });
        }
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapterCloth.ViewHolder holder, int position) {
        Cloth cloth = mCloths.get(position);
        holder.mCloth = mCloths.get(position);
        holder.imgcloth.setImageResource(cloth.getImgCloth());
        holder.tvPrice.setText(cloth.getPrice()+"$");
        holder.tvName.setText(cloth.getName());
    }

}
