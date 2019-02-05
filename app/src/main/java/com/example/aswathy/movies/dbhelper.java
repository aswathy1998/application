package com.example.aswathy.movies;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 1/30/2019.
 */
public class dbhelper extends SQLiteOpenHelper {
    public static final String dbname="Mydb.db";
    public static final String Tablename="movie";
    public static final String col1="id";
    public static final String col2="moviename";
    public static final String col3="movieactor";
    public static final String col4="movieactress";
    public static final String col5="releaseyear";
    public static final String col6="director";
    public static final String col7="producer";
    public static final String col8="cameraman";
    public static final String col9="totalcollection";

    public dbhelper(Context context) {
        super(context,dbname,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query="create table "+Tablename+"("+col1+" integer primary key autoincrement,"+col2+" text,"+col3+" text,"+col4+" text,"+col5+" text,"+col6+" text,"+col7+" text,"+col8+" text,"+col9+" text)";
        sqLiteDatabase.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        String query="drop table if exit"+Tablename;
        sqLiteDatabase.execSQL(query);
        onCreate(sqLiteDatabase);

    }
    public boolean insertdata(String moviename,String movieactor,String movieactress,String releaseyear,String director,String producer,String cameraman,String totalcollection){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(col2,moviename);
        contentValues.put(col3,movieactor);
        contentValues.put(col4,movieactress);
        contentValues.put(col5,releaseyear);
        contentValues.put(col6,director);
        contentValues.put(col7,producer);
        contentValues.put(col8,cameraman);
        contentValues.put(col9,totalcollection);

        long status=sqLiteDatabase.insert(Tablename,null,contentValues);
        if(status==-1){
            return false;
        }
        else{
            return true;
        }
    }
    public Cursor searchdata(String moviename)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cur=sqLiteDatabase.rawQuery("SELECT * FROM "+Tablename+" WHERE "+col2+"='"+moviename+"'",null);
        return cur;

    }
    public boolean updateData( String id,String movieactor,String movieactress,String releaseyear,String director,String producer,String cameraman,String totalcollection) {
       SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
      ContentValues contentValues = new ContentValues();

        contentValues.put(col3, movieactor);
        contentValues.put(col4, movieactress);
        contentValues.put(col5, releaseyear);
        contentValues.put(col6, director);
        contentValues.put(col7, producer);
        contentValues.put(col8, cameraman);
        contentValues.put(col9, totalcollection);
        long status = sqLiteDatabase.update(Tablename,contentValues,col1 +"=" +id,null);
        if (status == -1) {
            return false;
        }
        else{
            return true;
        }
    }
    //delete
    public boolean DeleteData(String id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        long status = db.delete(Tablename,col1 +"=" +id,null);
        if (status == -1) {
            return false;
        }
        else{
            return true;
        }
    }
}
