package com.example.dima.hw22;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fraps on 18.04.2016.
 */
public class Adapter extends BaseAdapter {

    private Context context;
    private ArrayList<AppInfo> appinfo;
    private PackageManager packagemanager;
    /////////////////////////////////////////////////////////
    public Adapter(Context context) {
        this.context = context;
        this.appinfo = new ArrayList<>();
    }

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
        convertView = View.inflate(context, R.layout.item, null);

        holder.src = (ImageView) convertView.findViewById((R.id.app_src));
        holder.label = (TextView) convertView.findViewById(R.id.app_label);
        holder.view = convertView.findViewById(R.id.linlayout);

        convertView.setTag(holder);

        AppInfo appInfo = appinfo.get(position);
        holder.src.setImageDrawable(appInfo.getIcon());
        holder.label.setText(appInfo.getLabel());

        return convertView;
    }

    public void LoadAppInfo () {
        packagemanager = context.getPackageManager();
        AppInfo appsInfo;

        Intent intent = new Intent(Intent.ACTION_MAIN, null);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);

        List<ResolveInfo> InstalledApp = packagemanager.queryIntentActivities(intent, 0);
        for(ResolveInfo resolveInfo: InstalledApp){
            appsInfo = new AppInfo();
            String label = resolveInfo.loadLabel(packagemanager).toString();
            Drawable src = resolveInfo.loadIcon(packagemanager);
            String name = resolveInfo.activityInfo.packageName;

            appsInfo.setLabel(label);
            appsInfo.setName(name);
            appsInfo.setIcon(src);

            appinfo.add(appsInfo);
        }
    }

    private class Holder{
        ImageView src;
        TextView label;
        View view;
    }

}
