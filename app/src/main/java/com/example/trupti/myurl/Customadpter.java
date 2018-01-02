package com.example.trupti.myurl;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Lenovo on 02-01-2018.
 */
public class Customadpter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Modal>md;

    public Customadpter(MainActivity mainActivity, List<Modal> arraylistdata) {
        this.activity=mainActivity;
        this.md=arraylistdata;
    }

    @Override
    public int getCount() {
        return md.size();
    }

    @Override
    public Object getItem(int postion) {
        return md.get(postion);
    }

    @Override
    public long getItemId(int postion) {
        return postion;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null)
            convertView = inflater.inflate(R.layout.datalist, null);

        TextView t1 = (TextView) convertView.findViewById(R.id.ltitle);
        TextView t2 = (TextView) convertView.findViewById(R.id.ldescrption);
        ImageView iv=(ImageView)convertView.findViewById(R.id.iview);


        Modal m = md.get(position);
        t1.setText(String.valueOf(m.getAtitle()));
        t2.setText(String.valueOf(m.getAdescription()));
       // iv.setImageResource(Integer.valueOf(m.getAimage()));



        return convertView;
    }
}


