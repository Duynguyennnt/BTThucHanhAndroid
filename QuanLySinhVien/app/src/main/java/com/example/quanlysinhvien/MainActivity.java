package com.example.quanlysinhvien;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    ListView listViewsv;
    sinhvienAdapter sinhvienAdapter;
    sinhviencontroller sinhviencontroller;
    Dialog dialog;
    viewDialog viewDialog;
    Boolean them = true, sua= false, xoa = false;
    sinhvien sv;
    int j;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listViewsv = (ListView) findViewById(R.id.lvsv);
        sinhviencontroller = new sinhviencontroller(this);
        getDataSv();
        sinhvienAdapter = new sinhvienAdapter(this,0, sinhvienlist.getsv().arrayListsv);
        listViewsv.setAdapter(sinhvienAdapter);
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.acivitysv);
        viewDialog = new viewDialog(dialog);
    }
    public void getDataSv(){
        sinhviencontroller.open();
        sinhvienlist.getsv().arrayListsv = new ArrayList<>(sinhviencontroller.getsv());
        sinhviencontroller.close();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menucontext,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.tc:
                break;
            case R.id.dkm:
                them= true;
                sua = false;
                xoa = false;
                viewDialog.setbtn();
                listViewsv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    }
                });
                dialog.show();
                break;
            case R.id.dkl:
                them= false;
                sua = true;
                xoa = true;
                viewDialog.setbtn();
                Toast.makeText(MainActivity.this,"Chọn Sinh Viên Cần Sửa",Toast.LENGTH_SHORT).show();
                listViewsv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        sv = sinhvienAdapter.getItem(i);
                        j=i;
                        viewDialog.settt(sv);
                        dialog.show();
                    }
                });
                break;
            case R.id.ttsv:

                break;
        }
        return super.onOptionsItemSelected(item);
    }

    class viewDialog{
        EditText editten, editsdt, editemail;
        Button btnngaysinh, btnthem, btnsua, btnxoa;
        Spinner splop;
        String lop, gt= "Nu";
//        int ngay,thang,nam;
//        String n;
        RadioGroup gtg;


        public viewDialog(Dialog dl){
            editten = (EditText) dl.findViewById(R.id.editten);
            editsdt = (EditText) dl.findViewById(R.id.editsdt);
            editemail = (EditText) dl.findViewById(R.id.editmail);

            btnngaysinh = (Button) dl.findViewById(R.id.btnngaysinh);
            btnthem = (Button) dl.findViewById(R.id.btnthem);
            btnsua = (Button) dl.findViewById(R.id.btnsua);
            btnxoa = (Button) dl.findViewById(R.id.btnxoa);

            splop = (Spinner) dl.findViewById(R.id.spinnerlp);
//            Calendar cl= Calendar.getInstance();
//            ngay = cl.get(Calendar.DATE);
//            thang = 1 + cl.get(Calendar.MONTH);
//            nam = cl.get(Calendar.YEAR);
            gtg = (RadioGroup) dl.findViewById(R.id.radiogroup);
            setRS();
            setbtnadd();
        }
        public void setbtn(){
            btnthem.setEnabled(them);
            btnxoa.setEnabled(xoa);
            btnsua.setEnabled(sua);
        }
        public void settt(sinhvien sv){
            editten.setText(sv.getTen());
            editemail.setText(sv.getEmail());
            editsdt.setText(sv.getSodt());
            if (sv.getGioitinh().equals("Nu")){
                gtg.check(R.id.rbnu);
            }else {
                gtg.check(R.id.rbnam);
            }
            int content = 0;
            for (int i=0; i<getResources().getStringArray(R.array.lop).length;i++){
                if (sv.getLophoc().equals(getResources().getStringArray(R.array.lop)[i])){
                    content = i;
                    break;
                }
            }
            splop.setSelection(content);
        }
        private void setbtnadd(){
            btnthem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (gtg.getCheckedRadioButtonId()== R.id.rbnam){
                        gt = "Nam";
                    }else {
                        gt = "Nu";
                    }
                    sinhvienlist.getsv().arrayListsv.add(getsv());
                    sinhviencontroller.open();
                    sinhviencontroller.addsv(getsv());
                    sinhviencontroller.close();
                    sinhvienAdapter.notifyDataSetChanged();
                    dialog.dismiss();

                }
            });
            btnsua.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (gtg.getCheckedRadioButtonId()== R.id.rbnam){
                        gt = "Nam";
                    }else {
                        gt = "Nu";
                    }
                    sinhvien s = getsv();
                    s.setId(sv.getId());
                    sinhvienlist.getsv().arrayListsv.set(j,s);
                    sinhviencontroller.open();
                    sinhviencontroller.updatesv(s);
                    sinhviencontroller.close();
                    sinhvienAdapter.notifyDataSetChanged();
                    dialog.dismiss();
                }
            });
             btnxoa.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     sinhvienlist.getsv().arrayListsv.remove(j);
                     sinhviencontroller.open();
                     sinhviencontroller.deletesv(sinhvienlist.getsv().arrayListsv.get(j).getId());
                     sinhviencontroller.close();
                     sinhvienAdapter.notifyDataSetChanged();
                     dialog.dismiss();
                 }
             });

        }
        private void setRS(){
            splop.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    lop = getResources().getStringArray(R.array.lop)[i];
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                    lop = getResources().getStringArray(R.array.lop)[0];
                }
            });

        }
        private sinhvien getsv(){
            sinhvien sv = new sinhvien();
            sv.setTen(editten.getText().toString());
            sv.setSodt(editsdt.getText().toString());
            sv.setEmail(editemail.getText().toString());
            sv.setLophoc(lop);
            sv.setGioitinh(gt);
            return sv;
        }
    }
}