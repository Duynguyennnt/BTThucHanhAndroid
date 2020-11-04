package com.example.baitaptuan10;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class peopleAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<people> peopleList;

    public peopleAdapter(Context context, int layout, List<people> peopleList) {
        this.context = context;
        this.layout = layout;
        this.peopleList = peopleList;
    }

    @Override
    public int getCount() {
        return peopleList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    private class ViewHolder{
        TextView txtten,txtsdt;
        ImageView imghinh;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null ){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view= inflater.inflate(layout, null);
            // anh xa
            holder = new ViewHolder();
            holder.txtten = (TextView) view.findViewById(R.id.ten);
            holder.txtsdt = (TextView) view.findViewById(R.id.sdt);
            holder.imghinh = (ImageView) view.findViewById(R.id.hinh);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        people people = peopleList.get(i);
        holder.txtten.setText(people.getTen());
        holder.txtsdt.setText(people.getSdt());
        holder.imghinh.setImageResource(people.getHinh());
        return view;
    }
}
