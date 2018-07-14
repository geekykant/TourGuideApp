package com.diyandroid.tourguideapp;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Hotels extends Fragment {

    private ArrayList<ListPlaces> arrayList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout, container, false);
        arrayList = new ArrayList<>();

        final TypedArray images = getResources().obtainTypedArray(R.array.hotels_images);

        //Adds hotels to the arrayList
        for (int i = 0; i < getResources().getStringArray(R.array.hotels_names).length; i++) {
            arrayList.add(new ListPlaces(getResources().getStringArray(R.array.hotels_names)[i],
                    images.getResourceId(i, -1)));
        }
        ListView listView = (ListView) view.findViewById(R.id.listView);

        ListAdapter adapter = new ListAdapter(getContext(), R.layout.list_adapter, arrayList);

        if (getActivity() != null) {
            //sets adapter
            listView.setAdapter(adapter);
        }

        //adds listener for each place details
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                TypedArray desc = getResources().obtainTypedArray(R.array.hotels_description);

                Intent intent = new Intent(getActivity(), ListDetail.class);
                intent.putExtra("TOOLBAR_TITLE", arrayList.get(position).getName());
                intent.putExtra("TAB_DESC_ID", desc.getResourceId(position, -1));
                intent.putExtra("IMAGE", images.getResourceId(position, -1));
                startActivity(intent);
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

}
