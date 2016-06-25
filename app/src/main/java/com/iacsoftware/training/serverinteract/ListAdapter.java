package com.iacsoftware.training.serverinteract;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Maahi bhat on 16-11-2015.
 */

public class ListAdapter extends  ArrayAdapter<String> {


    private final Activity context;
    private final ArrayList<String> list1;
    private final ArrayList<String> list2;
    private final ArrayList<String> list3;

    public ListAdapter(Activity context, ArrayList<String> list1, ArrayList<String> list2,ArrayList<String> list3) {
        super(context, R.layout.custom_list, list1);
        // TODO Auto-generated constructor stub
        this.context=context;
        this.list1 = list1;
        this.list2 = list2;
        this.list3 = list3;
    }






    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.custom_list, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.list1);
        TextView txtAuthor = (TextView) rowView.findViewById(R.id.list2);
        TextView txtDate = (TextView) rowView.findViewById(R.id.list3);


        txtTitle.setText(list1.get(position));
        txtAuthor.setText(list2.get(position));
        txtDate.setText(list3.get(position));

        return rowView;

    }


}