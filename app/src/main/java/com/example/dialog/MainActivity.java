package com.example.dialog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.net.MailTo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnCustDial,btnNoti, btnSendMail,btnSendMessege, btnCall;
    EditText phoneNumber, msgTo,msgBody,mailTo,mailBody,mailSubject;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Initialization of the Button
        setContentView(R.layout.activity_main);
        btnCustDial =findViewById(R.id.btnCustDailog);
        btnNoti=findViewById(R.id.btnNotification);
        btnCall= findViewById(R.id.btnCall);
        btnSendMessege= findViewById(R.id.btnSendMsg);
        btnSendMail= findViewById(R.id.btnMail);
        phoneNumber= findViewById(R.id.edtMobile);
        msgBody= findViewById(R.id.edtMsgBody);
        msgTo= findViewById(R.id.edtMsgto);
        mailBody=findViewById(R.id.edtMailBody);
        mailTo=findViewById(R.id.edtMailto);
        mailSubject=findViewById(R.id.edtMailSubject);


        //Open the Dialer
    btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a=phoneNumber.getText().toString();
                Intent iDial= new Intent(Intent.ACTION_DIAL);
                iDial.setData(Uri.parse("tel: +91"+a));
                startActivity(iDial);
            }
        });
    //Open the Messege app
        btnSendMessege.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number=msgTo.getText().toString();
                String body=msgBody.getText().toString();
                Intent iMsg= new Intent(Intent.ACTION_SENDTO);
                iMsg.setData(Uri.parse("smsto:"+Uri.encode("+91"+number)));
                iMsg.putExtra("sms_body",body);
                startActivity(iMsg);
            }
        });
    //Opne the Email App
        btnSendMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email= mailTo.getText().toString();
                String subject=mailSubject.getText().toString();
                String body=mailBody.getText().toString();
                Intent iMail= new Intent(Intent.ACTION_SEND);
                iMail.setType("Message/rfc822");
                iMail.putExtra(Intent.EXTRA_EMAIL,new String[]{email});
                iMail.putExtra(Intent.EXTRA_SUBJECT,subject);
                iMail.putExtra(Intent.EXTRA_TEXT,body);
                startActivity(iMail);


            }
        });




        //Push Notification outside
        NotificationManager nm=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        Notification notification=new Notification.Builder(MainActivity.this)
                .setSmallIcon(R.drawable.cancel_24)
                .setContentText("New Update Detected")
                .setSubText("This is the latest Version of this application")
                .build();
        btnNoti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                nm.notify(1,notification);
            }
        });

// Dialog Box for Successful message order place
        btnCustDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog=new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.cust_dialog);
                dialog.show();


            }
        });




    }


    //Alert Dialog Box on Exit
    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to exit?")
                .setTitle("Exit")
                .setCancelable(false)
                .setIcon(R.drawable.cancel_24)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        MainActivity.this.finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                })
                .setNeutralButton("Toast", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(),"Neutral",Toast.LENGTH_SHORT);

                    }
                });
        AlertDialog alert = builder.create();
        alert.show();

    }

}