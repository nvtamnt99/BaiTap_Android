package com.example.lab7_roomdbbasic_18048941_lenhathuy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class CustomAdapter extends BaseAdapter {
    List<User> list;
    Context context;
    int layout;

    public CustomAdapter(List<User> list, Context context, int layout) {
        this.list = list;
        this.context = context;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view  = LayoutInflater.from(context).inflate(layout,parent, false);

        TextView tvName = view.findViewById(R.id.txtName);
        tvName.setText(list.get(position).getName());
        return view;
    }
    public void changeList(List<User> lp){
        list = lp;
        notifyDataSetChanged();
    }
}
