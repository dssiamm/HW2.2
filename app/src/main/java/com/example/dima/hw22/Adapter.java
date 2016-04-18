package com.example.dima.hw22;

import android.content.Context;
import android.content.pm.PackageManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by fraps on 18.04.2016.
 */
public class Adapter extends BaseAdapter {

    private Context context;
    private ArrayList<AppInfo> appinfo;
    private PackageManager packagemanager;
    /////////////////////////////////////////////////////////
    @Override
    public int getCount() {
        return appinfo.size();
    }

    @Override
    public Object getItem(int position) {
        return appinfo.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Holder holder;

        holder = new Holder();
        convertView = View.inflate(context, R.layout.content_main, null);
        ImageView imgview = new ImageView(context);
        TextView txtview = new TextView(context);

        holder.src = imgview;
        holder.name = txtview;

        convertView.setTag(holder);

        AppInfo appInfo = appinfo.get(position);
        holder.src.setImageDrawable(appInfo.getIcon());
        holder.name.setText(appInfo.getName()); /////////////////////


        return convertView;
    }

    private class Holder{
        ImageView src;
        TextView name;
    }

}
