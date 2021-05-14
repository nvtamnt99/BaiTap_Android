package com.example.a18065341_huynhanhtien_room_custom_listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PlaceApdater extends BaseAdapter {

    private Context context;
    private List<Place> places;
    private int layout;
    private OnClickCustom onDeleteClick;
    private OnClickCustom onUpdateClick;

    public PlaceApdater(Context context, List<Place> places, int layout, OnClickCustom onDeleteClick, OnClickCustom onUpdateClick ) {
        this.context = context;
        this.places = places;
        this.layout = layout;
        this.onDeleteClick = onDeleteClick;
        this.onUpdateClick = onUpdateClick;
    }

    @Override
    public int getCount() {
        return places.size();
    }

    @Override
    public Object getItem(int position) {
        return places.get(position);
    }

    @Override
    public long getItemId(int position) {
        return places.get(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        view = LayoutInflater.from(this.context).inflate(this.layout, parent, false);

        TextView tvSTT = view.findViewById(R.id.tvSTT);
        TextView tvName = view.findViewById(R.id.tvName);
        ImageView ivRemove = view.findViewById(R.id.ivRemove);
        ImageView ivEdit = view.findViewById(R.id.ivEdit);

        int id = places.get(position).getId();


        tvSTT.setText(id+ ". ");
        tvName.setText(places.get(position).getName());
        ivRemove.setOnClickListener(v -> {

             this.onDeleteClick.onClick(id );
        });

        ivEdit.setOnClickListener(v -> {
            this.onUpdateClick.onClick(id );
        });




        return view;
    }

}

