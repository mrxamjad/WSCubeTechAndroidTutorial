package com.example.dialog.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.dialog.ModelClass.ContactModel;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME ="contacDB";
    public static final int DATABASE_VERSION =1;
    public static final String TABLE_CONTACT ="contacs";
    public static final String KEY_ID ="id";
    public static final String KEY_NAME ="name";
    public static final String KEY_PHONE_NO ="phone_no";
    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //crete table contacts (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT,phone_no TEXT);
        String CREATE_TABLE="CREATE TABLE "+TABLE_CONTACT+" ( "+KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+KEY_NAME+" TEXT, "+KEY_PHONE_NO+" TEXT)";
        db.execSQL(CREATE_TABLE);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        //drop table
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_CONTACT);

    }
    // CREATE TABLE METHODE
    public void addContact(String name,String phone_no){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(KEY_NAME,name);
        cv.put(KEY_PHONE_NO,phone_no);
        db.insert(TABLE_CONTACT,null,cv);
    }

    //SELECT QUERY ___ STORING THE DATE INTO MODEL CLASS


   public ArrayList<ContactModel> fetchContacts(){
        SQLiteDatabase db=getReadableDatabase();
        ArrayList<ContactModel> arrContect= new ArrayList<>();
       Cursor cursor=db.rawQuery("SELECT * FROM "+ TABLE_CONTACT,null);
       while (cursor.moveToNext())
       {
           ContactModel model=new ContactModel();
           model.id=cursor.getInt(0);
           model.name=cursor.getString(1);
           model.number=cursor.getString(2);
           arrContect.add(model);

       }

       return arrContect;
   }

   //UPDATE THE TABLE AS PER THE KEY;

    public void updateContactByNumber( ContactModel contactModel){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues cv=new ContentValues();
        //cv.put(KEY_PHONE_NO,contactModel.number);
        cv.put(KEY_NAME,contactModel.name);//if we need we can update only onle line here we are updating two line of the code
        //db.update(TABLE_CONTACT,cv,KEY_ID+" = "+contactModel.id,null);
        db.update(TABLE_CONTACT,cv,KEY_PHONE_NO+" = "+contactModel.number,null);

    }
    public void updateContactByName( ContactModel contactModel){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(KEY_PHONE_NO,contactModel.number);
        db.update(TABLE_CONTACT,cv,KEY_NAME+" = "+contactModel.name,null);

    }
    //DELETE THE DATA FROM THE DATA
    public  void DeleteContactByName(String name){
        SQLiteDatabase db=getWritableDatabase();
        db.delete(TABLE_CONTACT,KEY_NAME+"=?",new String[]{name} );
    }
    public  void DeleteContactByNumber(String number){
        SQLiteDatabase db=getWritableDatabase();
        db.delete(TABLE_CONTACT,KEY_PHONE_NO+"=?",new String[]{number} );
    }
}
