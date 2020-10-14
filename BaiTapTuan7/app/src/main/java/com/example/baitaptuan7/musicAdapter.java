package com.example.baitaptuan7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class musicAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<music> musicList;

    public musicAdapter(Context context, int layout, List<music> musicList) {
        this.context = context;
        this.layout = layout;
        this.musicList = musicList;
    }

    @Override
    public int getCount() {
        return musicList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout,null);
        TextView txtten = (TextView) view.findViewById(R.id.tennhac);
        TextView txtcasi = (TextView) view.findViewById(R.id.casi);
        ImageView imganh =  (ImageView) view.findViewById(R.id.anh);
        music ms = musicList.get(i);
        txtten.setText(ms.getTen());
        txtcasi.setText(ms.getCasi());
        imganh.setImageResource(ms.getAnh());
        return view;
    }
}
