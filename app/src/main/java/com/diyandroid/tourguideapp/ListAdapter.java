package com.diyandroid.tourguideapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends ArrayAdapter {
    private Context mContext;
    private int mResources;
    private List<ListPlaces> arrayList;

    static class ListHolder{
        ImageView cover;
        TextView name;
    }

    ListAdapter(@NonNull Context context, int resource, @NonNull List list) {
        super(context, resource, list);

        this.mContext = context;
        this.mResources = resource;
        this.arrayList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ListHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(mResources, parent, false);

            viewHolder = new ListHolder();
            viewHolder.cover = (ImageView) convertView.findViewById(R.id.setImage);
            viewHolder.name = (TextView) convertView.findViewById(R.id.setText);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ListHolder) convertView.getTag();
        }

        ListPlaces aa = new ListPlaces(arrayList.get(position).getName(),
                arrayList.get(position).getResourseId());

        //assigns values to viewHolder
        viewHolder.cover.setImageResource(aa.getResourseId());
        viewHolder.name.setText(aa.getName());

        return convertView;
    }
}
