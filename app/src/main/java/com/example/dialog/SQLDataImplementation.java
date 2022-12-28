package com.example.dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dialog.Database.DBHelper;
import com.example.dialog.ModelClass.ContactModel;

import java.util.ArrayList;

public class SQLDataImplementation extends AppCompatActivity {

    public static  String contact="";
    EditText edtName,edtNumber,edtUpdateNumber,edtDeleteNumber,edtUpdateName,edtDeleteName;
    Button btnInsert,btnFetch,btnUpdateByName,btnUpdateByNumber, btnDeleteByName,btnDeleteByNumber;
    TextView txtFetch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqldata_implementation);

        edtName=findViewById(R.id.edtEnterName);
        edtNumber=findViewById(R.id.edtEnterNumber);
        btnInsert=findViewById(R.id.btnInsert);
        txtFetch=findViewById(R.id.txtFetchData);
        btnFetch=findViewById(R.id.btnFetch);
        edtUpdateNumber=findViewById(R.id.edtEnterNumberUpdate);
        edtDeleteName=findViewById(R.id.edtEnterNameDelete);
        edtUpdateName=findViewById(R.id.edtEnterNameUpdate);
        edtDeleteNumber=findViewById(R.id.edtEnterNumberDelete);
        btnUpdateByName=findViewById(R.id.btnUpdateName);
        btnUpdateByNumber=findViewById(R.id.btnUpdateNumber);
        btnDeleteByName=findViewById(R.id.btnDeleteName);
        btnDeleteByNumber=findViewById(R.id.btnDeleteNumber);









        DBHelper db=new DBHelper(this);

        //Insert on click
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=edtName.getText().toString();
                String number=edtNumber.getText().toString();
                db.addContact(name,number);
                Toast.makeText(getApplicationContext(),"INSERTED SUCCESSFULL",Toast.LENGTH_SHORT).show();

            }
        });

        //Fetch the data from the data base



        btnFetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contact="";
                ArrayList<ContactModel> arrayList=db.fetchContacts();
                for(int i=0; i<arrayList.size();i++){

                    contact=contact+ arrayList.get(i).name +" : "+arrayList.get(i).number+"\n";
                }
                txtFetch.setText(contact);


            }
        });


        //update tha the data
        btnUpdateByName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContactModel contact=new ContactModel();
                contact.name=edtUpdateName.getText().toString();
                contact.number=edtUpdateNumber.getText().toString();
                db.updateContactByName(contact);

            }
        });
        btnUpdateByNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContactModel contact=new ContactModel();
                contact.name=edtUpdateName.getText().toString();
                contact.number=edtUpdateNumber.getText().toString();
                db.updateContactByNumber(contact);

            }
        });




        //DELETE THE CONTACT
        btnDeleteByNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeleteContactByNumber(edtDeleteNumber.getText().toString());

            }
        });
        btnDeleteByName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeleteContactByName(edtDeleteName.getText().toString());

            }
        });



    }
}