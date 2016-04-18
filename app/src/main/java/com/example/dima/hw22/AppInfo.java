package com.example.dima.hw22;

import android.graphics.drawable.Drawable;

/**
 * Created by fraps on 18.04.2016.
 */
public class AppInfo {
    private String path;
    private String name;
    private Drawable src;

    public String getLabel() {
        return path;
    }

    public void setLabel(String label) {
        this.path = label;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Drawable getIcon() {
        return src;
    }

    public void setIcon(Drawable icon) {
        this.src = icon;
    }
}
