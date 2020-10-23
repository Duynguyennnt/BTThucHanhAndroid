package com.example.baitaptuan9;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class sinhvienAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<sinhvien> sinhVienList;

    public sinhvienAdapter(Context context, int layout, List<sinhvien> sinhVienList) {
        this.context = context;
        this.layout = layout;
        this.sinhVienList = sinhVienList;
    }

    @Override
    public int getCount() {
        return sinhVienList.size();
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
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout,null);
        TextView txtten = (TextView) view.findViewById(R.id.ten);
        TextView txtmsv = (TextView) view.findViewById(R.id.msv);
        TextView txtlop = (TextView) view.findViewById(R.id.lop);
        ImageView imghinh = (ImageView) view.findViewById(R.id.chandung);
        sinhvien sv = sinhVienList.get(i);
        txtten.setText(sv.getTen());
        txtmsv.setText(sv.getMsv());
        txtlop.setText(sv.getLop());
        imghinh.setImageResource(sv.getChandung());
        return view;
    }
}
