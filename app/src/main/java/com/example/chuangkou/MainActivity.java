package com.example.chuangkou;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    final int NOTIFYID = 0x123;
    Button btn_toast,btn_1,btn_2,btn_3,btn_4,btn_5,btn_6,btn_7,btn_8;
    EditText et_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_toast = findViewById(R.id.btn_toast);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
        btn_7 = findViewById(R.id.btn_7);
        btn_8 = findViewById(R.id.btn_8);
        et_1 = findViewById(R.id.et_1);


        btn_toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"123",Toast.LENGTH_SHORT).show();
            }
        });

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                alertDialog.setIcon(R.drawable.erweima);
                alertDialog.setTitle("芜湖？");
                alertDialog.setMessage("起飞否？");
                alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "我起飞啦！", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"飞",Toast.LENGTH_SHORT).show();
                    }
                });
                alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "不起飞啦！", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"落",Toast.LENGTH_SHORT).show();
                    }
                });
                alertDialog.show();
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] item=new String[]{"这波啊","这波是","肉蛋","葱鸡"};
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setIcon(R.drawable.erweima);
                builder.setTitle("请选择");
                builder.setItems(item, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,item[which],Toast.LENGTH_SHORT).show();
                    }
                });

                builder.create().show();
            }
        });

        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] item=new String[]{"这波啊","这波是","肉蛋","葱鸡"};
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setIcon(R.drawable.erweima);
                builder.setTitle("请选择");
                builder.setSingleChoiceItems(item, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,item[which],Toast.LENGTH_SHORT).show();
                    }
                });
               builder.setPositiveButton("确定", null);
               builder.create().show();
            }
        });

        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] item=new String[]{"这波啊","这波是","肉蛋","葱鸡"};
                final boolean[] checkeditem = new boolean[]{false, false, true, false};
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setIcon(R.drawable.erweima);
                builder.setTitle("请选择");
                builder.setMultiChoiceItems(item, checkeditem, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        checkeditem[which] = isChecked;
                    }
                });
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String result = "";
                        for(int i=0; i<checkeditem.length; i++){
                            if(checkeditem[i]){
                                result += item[i] + "?";
                            }
                        }
                        if (result != null)
                            Toast.makeText(MainActivity.this,result,Toast.LENGTH_SHORT).show();
                    }
                });
                builder.create().show();
            }
        });

        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"点击了",Toast.LENGTH_SHORT).show();
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                Notification.Builder not = new Notification.Builder(MainActivity.this);
                not.setAutoCancel(true);
                not.setSmallIcon(R.drawable.erweima);
                not.setContentTitle("扫码啊");
                not.setContentText("点击查看详情");
                not.setWhen(System.currentTimeMillis());
                not.setDefaults(Notification.DEFAULT_SOUND|Notification.DEFAULT_VIBRATE);
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                PendingIntent pi = PendingIntent.getActivity(MainActivity.this,0,intent,0);
                not.setContentIntent(pi);
                notificationManager.notify(NOTIFYID,not.build());
            }
        });

        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("zuckerberg");
                sendBroadcast(intent);
            }
        });

        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });

        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Runnable myWorker = new Runnable() {
                    @Override
                    public void run() {
                        int s = Integer.parseInt(et_1.getText().toString());
                        boolean pd = true;
                        if(s >= 2){
                            for (int i=2; i<s; i++){
                                if(s % i == 0){
                                    pd = false;
                                    break;
                                }
                            }
                        }
                        if(pd)
                            et_1.setText("是素数");
                        else
                            et_1.setText("不是素数");
                    }
                };
                Thread workThread = new Thread(null, myWorker, "workThread");
                workThread.start();

            }
        });

    }
}