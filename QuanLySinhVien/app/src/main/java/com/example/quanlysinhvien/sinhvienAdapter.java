package com.example.quanlysinhvien;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class sinhvienAdapter extends ArrayAdapter<sinhvien> {
    ArrayList<sinhvien> arrayList;
    Context context;
    public sinhvienAdapter(@NonNull Context context, int resource) {
        super(context, resource);
        this.context = context;
        this.arrayList = new ArrayList<>(sinhvienlist.getsv().arrayListsv);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view== null){
            LayoutInflater inflater = (LayoutInflater)  context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.listsv,null);

        }
    }
    class viewHoder{
        TextView txtten, txtsdt, txtemail, txtlop;
        ImageView imggt;
         public viewHoder(View view){
             txtten = (TextView) view.findViewById(R.id.txtten);
             txtlop = (TextView) view.findViewById(R.id.txtlop);
             txtemail = (TextView) view.findViewById(R.id.txtemail);
             txtsdt = (TextView) view.findViewById(R.id.txtsdt);
             imggt = (ImageView) view.findViewById(R.id.imggt);
         }

    }

}
