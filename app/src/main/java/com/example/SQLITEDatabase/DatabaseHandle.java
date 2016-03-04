package com.example.SQLITEDatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.net.ContentHandler;

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
    public String Fieldbusiness_complex_streetname_society="business_complex_streetname_society";
    public String Fieldbusiness_office_no="business_office_no";
    public String Fieldbusiness_landmark="business_landmark";
    public String Fieldbusiness_Address="business_Address";
    public String Fieldbbusiness_landline="business_landline";
    public String Fieldbusiness_city="business_city";
    public String Fieldbusiness_country="business_country";
    public String Fieldbusiness_zip="business_zip";
    public String Fieldbusiness_website="business_website";
    public String Fieldreceived_ad_id="received_ad_id";
    public String Fieldreceived_ad_title="received_ad_title";
    public String Fieldreceived_ad_detail="received_ad_detail";
    public String Fieldposted_ad_id="posted_ad_id";
    public String Fieldposted_ad_title="posted_ad_title";
    public String Fieldposted_ad_detail="posted_ad_detail";



    public DatabaseHandle(Context context) {
        super(context, DatabaseName, null, DATABASE_VERSION);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        String createTableUserinfoName="CREATE TABLE "+TableUserinfoName+"("+FieldRowid+" INTEGER PRIMARY KEY AUTOINCREMENT, "+Fielduser_id+" INTEGER, "+Fielduser_name+" TEXT, "+Fielduser_mobile+" TEXT,"+Fielduser_email+" TEXT, "+Fielduser_pw+" TEXT, "+Fielduser_country+" TEXT, "+Fielduser_zip+" INTEGER, "+Fieldis_business+" TEXT, "+Fielddate_created+" DATETIME DEFAULT CURRENT_TIMESTAMP)";
        String createTablereceivedads="CREATE TABLE "+TableUserinfoName+"("+FieldRowid+" INTEGER PRIMARY KEY AUTOINCREMENT, "+Fielduser_id+" INTEGER, "+Fielduser_name+" TEXT, "+Fielduser_mobile+" TEXT,"+Fielduser_email+" TEXT, "+Fielduser_pw+" TEXT, "+Fielduser_country+" TEXT, "+Fielduser_zip+" TEXT, "+Fieldis_business+" TEXT, "+Fielddate_created+" DATETIME DEFAULT CURRENT_TIMESTAMP)";
      //  String createTableBusinessInfoName="CREATE TABLE"+TableBusinessInfoName+"("+FieldRowid+" INTEGER PRIMARY KEY AUTOINCREMENT, "+Fieldbusiness_id+" INTEGER, "+Fielduser_id+" INTEGER, "+Fieldbusiness_name+" TEXT, "+Fieldbusiness_office_no+" TEXT, "+Fieldbusiness_complex_streetname_society+" TEXT, "+Fieldbusiness_landmark+" TEXT, "+Fieldbusiness_Address+" TEXT, "+Fieldbusiness_city+" TEXT, "+Fieldbusiness_country+" TEXT, "+Fieldbusiness_zip+" TEXT, "+Fieldbbusiness_landline+" TEXT, "+Fieldbusiness_website+" TEXT, "+Fielddate_created+" TEXT)";
       /* String createTableUserinfoName=
        String createTableUserinfoName=*/
        db.execSQL(createTableUserinfoName);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void InsertUserInfo(int userid,String username,String usermobile,String useremail,String userpw, String usercountry, String userzip, String userisbusiness, long userdatecreated)
    {
        try {
            db=this.getWritableDatabase();

            int user_zip=Integer.parseInt(userzip);
            ContentValues cv=new ContentValues();
            //cv.put(FieldRowid,rowId);
            cv.put(Fielduser_id,userid);
            cv.put(Fielduser_name,username);
            cv.put(Fielduser_mobile,usermobile);
            cv.put(Fielduser_email,useremail);
            cv.put(Fielduser_pw,userpw);
            cv.put(Fielduser_country,usercountry);
            cv.put(Fielduser_zip,user_zip);
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


}
