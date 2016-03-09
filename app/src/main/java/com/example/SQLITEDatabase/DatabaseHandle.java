package com.example.SQLITEDatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import java.net.ContentHandler;
import java.util.HashMap;

/**
 * Created by Hemal on 12/12/2015.
 */
public class DatabaseHandle extends SQLiteOpenHelper {
    public static final String TAG="DatabaseHandler.java";
    private static final int DATABASE_VERSION = 1;
    public static final String DatabaseName="dealsdb.db";
    public String TableUserinfoName="userinfo";
    public String TableBusinessInfoName="businessinfo";
    public String TableReceivedAdsName="received_advertisedetails";
    public String TablePostedAdsDetailsName="posted_advertisedetails";

    private SQLiteDatabase db;
    public String Fielduser_id="userid";
    public String FieldRowid="rowid";
    public String Fielduser_name="user_name";
    public String Fielduser_mobile="user_mobile";
    public String Fielduser_email="user_email";
    public String Fielduser_pw="user_pw";
    public String Fielduser_zip="user_zip";
    public String Fielduser_country="user_country";
    public String Fieldis_business="is_business";
    public String Fielddate_created ="date_created";
    public String Fieldbusiness_id="business_id";
    public String Fieldbusiness_name="business_name";
    public String Fieldbusiness_street1="business_street1";
    public String Fieldbusiness_street2="business_street2";
    public String Fieldbusiness_city="business_city";
    public String Fieldbusiness_state="business_state";
    public String Fieldbusiness_country="business_country";
    public String Fieldbusiness_zip="business_zip";
    public String Fieldbusiness_contactno="business_contactno";
    public String Fieldbusiness_website="business_website";
    public String Fieldbusiness_created="business_created";


    public String Fieldreceived_ad_id="received_ad_id";
    public String Fieldreceived_ad_title="received_ad_title";
    public String Fieldreceived_ad_detail="received_ad_detail";
    public String Fieldadreceived_created="adreceived_created";

    public String Fieldposted_ad_id="posted_ad_id";
    public String Fieldposted_ad_title="posted_ad_title";
    public String Fieldposted_ad_detail="posted_ad_detail";
    public String Fieldpost_created="post_created";



    public DatabaseHandle(Context context) {
        super(context, DatabaseName, null, DATABASE_VERSION);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        String createTableUserinfoName="CREATE TABLE "+TableUserinfoName+"("+FieldRowid+" INTEGER PRIMARY KEY AUTOINCREMENT, "+Fielduser_id+" INTEGER, "+Fielduser_name+" TEXT, "+Fielduser_mobile+" TEXT,"+Fielduser_email+" TEXT, "+Fielduser_pw+" TEXT, "+Fielduser_country+" TEXT, "+Fielduser_zip+" TEXT, "+Fieldis_business+" TEXT, "+Fielddate_created+" DATETIME DEFAULT CURRENT_TIMESTAMP)";
        String createTableBusinessInfo="CREATE TABLE "+TableBusinessInfoName+"("+FieldRowid+" INTEGER PRIMARY KEY AUTOINCREMENT, "+Fielduser_id+" INTEGER, "+Fieldbusiness_id+" INTEGER, "+Fieldbusiness_name+" TEXT,"+Fieldbusiness_street1+" TEXT, "+Fieldbusiness_street2+" TEXT, "+Fieldbusiness_city+" TEXT, "+Fieldbusiness_state+" TEXT, "+Fieldbusiness_country+" TEXT, "+Fieldbusiness_zip+" TEXT, "+Fieldbusiness_contactno+ " TEXT, "+Fieldbusiness_website+ " TEXT, "+Fieldbusiness_created+" DATETIME DEFAULT CURRENT_TIMESTAMP)";
        String createTableReceivedAds="CREATE TABLE "+TableReceivedAdsName+"("+FieldRowid+" INTEGER PRIMARY KEY AUTOINCREMENT, "+Fieldreceived_ad_id+" INTEGER, "+Fieldbusiness_id+" INTEGER, "+Fielduser_id+" INTEGER, "+Fieldreceived_ad_title+" TEXT, "+Fieldreceived_ad_detail+" TEXT, "+Fieldbusiness_zip+" TEXT, "+Fieldbusiness_country+" TEXT, "+Fieldadreceived_created+" DATETIME DEFAULT CURRENT_TIMESTAMP)";
        String createTablePostedAds="CREATE TABLE "+TablePostedAdsDetailsName+"("+FieldRowid+" INTEGER PRIMARY KEY AUTOINCREMENT, "+Fieldposted_ad_id+" INTEGER, "+Fieldbusiness_id+" INTEGER, "+Fielduser_id+" INTEGER, "+Fieldposted_ad_title+" TEXT, "+Fieldposted_ad_detail+" TEXT, "+Fieldbusiness_zip+" TEXT, "+Fieldbusiness_country+" TEXT, "+Fieldadreceived_created+" DATETIME DEFAULT CURRENT_TIMESTAMP)";

        db.execSQL(createTableUserinfoName);
        db.execSQL(createTableBusinessInfo);
        db.execSQL(createTablePostedAds);
        db.execSQL(createTableReceivedAds);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void InsertUserInfo(int userid,String username,String usermobile,String useremail,String userpw, String usercountry, String userzip, String userisbusiness, long userdatecreated)
    {
        try {
            db=this.getWritableDatabase();
            Log.i("SQLite Country",usercountry);

            ContentValues cv=new ContentValues();
            //cv.put(FieldRowid,rowId);
            cv.put(Fielduser_id,userid);
            cv.put(Fielduser_name,username);
            cv.put(Fielduser_mobile,usermobile);
            cv.put(Fielduser_email,useremail);
            cv.put(Fielduser_pw,userpw);
            cv.put(Fielduser_country,usercountry);
            cv.put(Fielduser_zip,userzip);
            cv.put(Fieldis_business,userisbusiness);
            cv.put(Fielddate_created,userdatecreated);
            db.insert(TableUserinfoName,null,cv);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        db.close();




    }


    public void InserBusinessInfo(/*int businessid,int userid,String businessname,String businessstreet1,String businessstree2, String businesscity,String businessstate,String businesscountry,String businesszip,String businesscontactno,String businesswebsite,long businesscreated*/HashMap mapBusinessInfo)
    {
        db=this.getWritableDatabase();
        try
        {
            db.beginTransaction();
            String sql="Insert or Replace into "+TableBusinessInfoName+"("+Fieldbusiness_id+","+Fielduser_id+","+Fieldbusiness_name+","+Fieldbusiness_street1+","+Fieldbusiness_street2+","+Fieldbusiness_city+","+Fieldbusiness_state+","+Fieldbusiness_country+","+Fieldbusiness_zip+","+Fieldbusiness_contactno+","+Fieldbusiness_website+","+Fieldbusiness_created+") VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            SQLiteStatement insert = db.compileStatement(sql);
            for(int i=0;i<mapBusinessInfo.size();i++)
            {

                /*insert.bindLong(1,i);
                insert.bindString(2,mapVendorInfo.get(i));
                insert.execute();*/
            }
            db.setTransactionSuccessful();
            Log.i("Transaction", "Successful");
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }

        finally
        {
            db.endTransaction();
        }
        //return null;


    }


}
