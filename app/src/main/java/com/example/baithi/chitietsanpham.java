package com.example.baithi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class chitietsanpham extends AppCompatActivity {
    RadioGroup radioGroup;
    TextView soluongsp;
    TextView idName, idGia, tongtien;
    ImageView idImage;
    int trangthai;
    TextView tv_tongtien;
    String receivedGia;
    Button bt_dathang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitietsp);
        //set dữ liệu cho trang sau click vào 1 item
        idName = findViewById(R.id.idttchinh);
        idGia = (TextView)findViewById(R.id.idgia);
        bt_dathang = (Button)findViewById(R.id.bt_dathang);
        idImage = (ImageView) findViewById(R.id.imageView);
        tongtien = (TextView) findViewById(R.id.tongtien);
        Intent intent = getIntent();
        String receivedName =  intent.getStringExtra("name");
        int receivedImage = intent.getIntExtra("image",0);
         final String receivedGia =  intent.getStringExtra("gia");
        String receivedTongTien =  intent.getStringExtra("gia");

        idName.setText(receivedName);
        idImage.setImageResource(receivedImage);
        idGia.setText(receivedGia);
        tongtien.setText(receivedTongTien);
        ImageView closechitiet = (ImageView) findViewById(R.id.close_chitietsp);
        closechitiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(chitietsanpham.this, order.class);
                startActivity(intent);
            }
        });
        final ImageView yeuthich = (ImageView)findViewById(R.id.yeuthich);
         trangthai = 1;
        yeuthich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(trangthai == 1){
                    yeuthich.setImageResource(R.drawable.heart1);
                    trangthai = 2;
                }
                else{
                    yeuthich.setImageResource(R.drawable.heart);
                    trangthai = 1;
                }
            }
        });

        // add toping
        RadioButton rb_1 = (RadioButton)findViewById(R.id.rd_1);
        RadioButton rb_2 = (RadioButton)findViewById(R.id.rd_2);
        RadioButton rb_3 = (RadioButton)findViewById(R.id.rd_3);
        soluongsp = (TextView)findViewById(R.id.soluonghang);
        tv_tongtien = (TextView) findViewById(R.id.tongtien);


 //        final int tien = Integer.parseInt(String.valueOf(tv_tongtien.getText())) ;
        ImageView im_tru = (ImageView)findViewById(R.id.tru);
        ImageView im_cong = (ImageView)findViewById(R.id.cong);

        //click vao + _
        im_tru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(String.valueOf(soluongsp.getText()))==0){

                }
                else{
                    int soluong =Integer.parseInt(String.valueOf(soluongsp.getText()))-1;
                    soluongsp.setText(String.valueOf(soluong));
                    int soluongcapnhat = Integer.parseInt(String.valueOf(soluongsp.getText()));
                    int detail = soluongcapnhat*Integer.parseInt(receivedGia);
                    tv_tongtien.setText(String.valueOf(detail));
                }
            }
        });
        //thêm số lượng hàng
        im_cong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int soluong =Integer.parseInt(String.valueOf(soluongsp.getText()))+1;
                soluongsp.setText(String.valueOf(soluong));
                int soluongcapnhat = Integer.parseInt(String.valueOf(soluongsp.getText()));
                int detail = soluongcapnhat*Integer.parseInt(receivedGia);
                tv_tongtien.setText(String.valueOf(detail));
            }
        });
        final String name = (String) idName.getText();
        String gia = (String) idGia.getText();
        final String gia1 = gia;
        //event click on bt_dathang
        bt_dathang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(chitietsanpham.this, thanhtoandathang.class);
//                startActivity(intent);

                Intent intent = new Intent(chitietsanpham.this, thanhtoandathang.class);
                //    Intent intent = new Intent(mContext,chitietsanpham.class);
                intent.putExtra("name",name);
             //   intent.putExtra("image",mData.get(position).getPhoto());
                intent.putExtra("gia",gia1);
                startActivity(intent);
            }
        });
        radioGroup = (RadioGroup) findViewById(R.id.rg_radio);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int id) {
                switch (id){
                    case R.id.rd_1:
//                        int detail =Integer.parseInt(String.valueOf(tv_tongtien.getText()))+1;
                        int detail2 =Integer.parseInt(receivedGia)+0;
                        tv_tongtien.setText(String.valueOf(detail2));
                        break;
                    case R.id.rd_2:
                        int detail =Integer.parseInt(receivedGia)+3000;
                        tv_tongtien.setText(String.valueOf(detail));
                        break;
                    case R.id.rd_3:
                        int detail1 =Integer.parseInt(receivedGia)+6000;
                        tv_tongtien.setText(String.valueOf(detail1));
                        break;

                }
            }
        });
    }
}
