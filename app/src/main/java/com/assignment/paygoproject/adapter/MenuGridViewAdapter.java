package com.assignment.paygoproject.adapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.assignment.paygoproject.R;
import com.assignment.paygoproject.object.Data;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MenuGridViewAdapter extends BaseAdapter {
    private ArrayList<Data> dataArrayList;
    private Activity activity;

    public MenuGridViewAdapter(Activity activity,ArrayList<Data> listCountry) {
        super();
        this.dataArrayList = listCountry;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return dataArrayList.size();
    }

    @Override
    public Data getItem(int position) {
        // TODO Auto-generated method stub
        return dataArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    public static class ViewHolder {
        public ImageView Icon;
        public TextView ServiceName;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        ViewHolder view;
        LayoutInflater inflator = activity.getLayoutInflater();

        if(convertView==null) {
            view = new ViewHolder();
            convertView = inflator.inflate(R.layout.menu_grid_items, null);

            view.ServiceName = (TextView) convertView.findViewById(R.id.ServiceName);
            view.Icon = (ImageView) convertView.findViewById(R.id.Icon);

            convertView.setTag(view);
        } else {
            view = (ViewHolder) convertView.getTag();
        }

        view.ServiceName.setText(dataArrayList.get(position).getServiceName());
        Glide.with(activity)
                .load(dataArrayList.get(position).getIconName())
                .into(view.Icon);
        return convertView;
    }

}