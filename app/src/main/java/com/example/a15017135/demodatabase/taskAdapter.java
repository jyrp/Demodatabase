package com.example.a15017135.demodatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class taskAdapter extends ArrayAdapter {
    private ArrayList<task> Task;
    private Context context;
    private TextView tvID;
    private  TextView tvDesc;
    private TextView tvDate;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.row, parent, false);


        tvID = (TextView)rowView.findViewById(R.id.tvID);
        tvDesc = (TextView)rowView.findViewById(R.id.tvDesc);
        tvDate = (TextView)rowView.findViewById(R.id.tvDate);

        task currentTask = Task.get(position);

        tvID.setText(currentTask.getId());
        tvDesc.setText(currentTask.getDescription());
        tvDate.setText(currentTask.getDate());
        return rowView;
    }
    public taskAdapter(Context context, int resource, ArrayList<task> objects){
        super(context, resource, objects);

        Task = objects;
        this.context = context;
    }
}
