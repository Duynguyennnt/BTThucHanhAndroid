package com.example.baitaptuan9;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class sinhvienview extends AppCompatActivity {
    ListView lvsinhvien;
    ArrayList<sinhvien> arraySinhVien;
    sinhvienAdapter adapter;
    private int vitri=-1;
    EditText  editTextTen, editTextmsv, editTextlop,  editTextTen1, editTextmsv1, editTextlop1;
    Button btnupdate, btnadd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinhvienview);
        anhXa();
        adapter = new sinhvienAdapter(this,R.layout.rowlistview, arraySinhVien);
        lvsinhvien.setAdapter(adapter);
        registerForContextMenu(lvsinhvien);
        lvsinhvien.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                vitri = i;
                return false;
            }
        });



    }
    public void addlistview(final String ten,final String msv,final String lop){
        arraySinhVien.add(new sinhvien(ten,msv,lop,R.drawable.chandung1));
        adapter.notifyDataSetChanged();
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.contextmenu,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.contextmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.add:
                dialog();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.delete:
                xacnhan(vitri);
                break;
            case  R.id.repair:
                dialogtt();
                break;
            case R.id.add:
                dialog();
                break;
        }
        return super.onContextItemSelected(item);
    }
    private void xacnhan(final int vt){
        AlertDialog.Builder aler = new AlertDialog.Builder(this);
        aler.setTitle("Thông Báo!");
        aler.setMessage("Bạn có chắc chắn xóa?");
        aler.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                arraySinhVien.remove(vt);
                adapter.notifyDataSetChanged();
            }
        });
        aler.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        aler.setIcon(R.mipmap.ic_android);
        aler.show();
    }
    // sửa thông tin
    private void dialogtt(){
        Dialog dialogtt = new Dialog(this);
        dialogtt.setContentView(R.layout.repairlayout);
        //anh xa
        btnupdate = (Button) dialogtt.findViewById(R.id.btncapnhap1);
        editTextTen1 = (EditText) dialogtt.findViewById(R.id.editten1);
        editTextmsv1 = (EditText) dialogtt.findViewById(R.id.editmsv1);
        editTextlop1 = (EditText) dialogtt.findViewById(R.id.editlop1);
        editTextTen1.setText(arraySinhVien.get(vitri).getTen());
        editTextmsv1.setText(arraySinhVien.get(vitri).getMsv());
        editTextlop1.setText(arraySinhVien.get(vitri).getLop());
        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ten1 = editTextTen1.getText().toString();
                String msv1 = editTextmsv1.getText().toString();
                String lop1 = editTextlop1.getText().toString();
                arraySinhVien.get(vitri).setTen(ten1);
                arraySinhVien.get(vitri).setMsv(msv1);
                arraySinhVien.get(vitri).setLop(lop1);
            }
        });
        dialogtt.show();
    }
    // add sv
    private void dialog(){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.diglogcustom);
        //anh xa
        btnadd = (Button) dialog.findViewById(R.id.btnadd);
        editTextTen = (EditText) dialog.findViewById(R.id.editten);
        editTextmsv = (EditText) dialog.findViewById(R.id.editmsv);
        editTextlop = (EditText) dialog.findViewById(R.id.editlop);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ten = editTextTen.getText().toString();
                String msv = editTextmsv.getText().toString();
                String lop = editTextlop.getText().toString();
                addlistview(ten, msv,lop);
            }
        });
        dialog.show();
    }
    // xoa nhieu dong
    AbsListView.MultiChoiceModeListener modeListener = new AbsListView.MultiChoiceModeListener() {
        @Override
        public void onItemCheckedStateChanged(ActionMode actionMode, int i, long l, boolean b) {

        }

        @Override
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode actionMode) {

        }
    };
    private void anhXa(){
        lvsinhvien = (ListView) findViewById(R.id.listviewsv);
        arraySinhVien = new ArrayList<>();
        arraySinhVien.add(new sinhvien("Nguyễn Thanh Duy","1811505310411","18T4",R.drawable.chandung1));
        arraySinhVien.add(new sinhvien("Nguyễn Hoàng Lãnh","1811505310410","18T4",R.drawable.chandung2));
        arraySinhVien.add(new sinhvien("Tôn Nữ Trà Ngư","1811505310421","18T4",R.drawable.chandung3));
        arraySinhVien.add(new sinhvien("Võ Nguyễn Hoàng Minh","1811505310414","18T4",R.drawable.chandung4));
        arraySinhVien.add(new sinhvien("Võ Nữ Oanh","1811505310415","18T4",R.drawable.chandung5));
        arraySinhVien.add(new sinhvien("Cò Thị Bé","1811505310416","18T4",R.drawable.chandung6));
        arraySinhVien.add(new sinhvien("Trương Minh Đạt","1811505310417","18T4",R.drawable.chandung7));
        arraySinhVien.add(new sinhvien("Bùi Công Đức","1811505310418","18T4",R.drawable.chandung8));
        arraySinhVien.add(new sinhvien("Trần Thị Như Ý","1811505310419","18T4",R.drawable.chandung9));
    }
}