package com.example.webservices;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Hemal on 12/28/2015.
 */
public class WebReceiveAds {

    public static String URL="http://134.154.17.112/dealswebservice/WebReceiveAds.php";
    ArrayList<NameValuePair> listofdetail=new ArrayList<NameValuePair>(4);
    String userid1;String userzip1,usercountry1;String dateupdated1;
    HashMap mapBusinessInfo,mapReceivedAdDetails;
    public void senddata(int userid,String userzip, String usercountry,long dateupdated)
    {
        userid1=Integer.toString(userid);
        userzip1=userzip;
        usercountry1=usercountry;
        dateupdated1=Long.toString(dateupdated);
    }
    public void setdata(String result)
    {
        int receive_ad_id,ad_business_id,ad_user_id,business_id,business_user_id;
        String receive_ad_title,receive_ad_detail,ad_business_zip,ad_business_country,ad_date_created,business_name,business_office_no,business_complex,business_landmark,business_city,business_state,business_country,business_zip,business_phone,business_website,business_datecreated;
        //Log.i("Json",result);
        try {
            JSONObject jobj = new JSONObject(result);
            JSONArray adsarray=jobj.getJSONArray("receivedaddetails");
           // Log.i("JSON",adsarray.toString());

          for(int i=0;i<adsarray.length();i++)
            {
                JSONObject obj=adsarray.getJSONObject(i);
                //mapBusinessInfo.put
                receive_ad_id=obj.getInt("received_ad_id");
                ad_business_id=obj.getInt("business_id");
                ad_user_id=obj.getInt("user_id");
                receive_ad_title=obj.getString("received_ad_title");
                receive_ad_detail=obj.getString("received_ad_detail");
                ad_business_zip=obj.getString("business_zip");
                ad_business_country=obj.getString("business_country");
                //ad_date_created=obj.getString("date_created");
                Log.i("Add info",receive_ad_id+" "+ad_business_id+" "+ad_user_id+" "+receive_ad_title+" "+receive_ad_detail+" "+ad_business_zip+" "+ad_business_country+" ");


            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
    public void fetchads()
    {
        try {


        listofdetail.add(new BasicNameValuePair("struserid",userid1));
        listofdetail.add(new BasicNameValuePair("struserzip",userzip1));
        listofdetail.add(new BasicNameValuePair("strusercountry",usercountry1));
        listofdetail.add(new BasicNameValuePair("strdateupdated", dateupdated1));
            DefaultHttpClient client = new DefaultHttpClient();
            HttpPost post = new HttpPost(URL);
            post.setEntity(new UrlEncodedFormEntity(listofdetail));
            HttpResponse response=client.execute(post);
            HttpEntity entity=response.getEntity();
            InputStream is=entity.getContent();
            BufferedReader reader=new BufferedReader(new InputStreamReader(is));
            StringBuilder builder=new StringBuilder();
            String line;
            while((line=reader.readLine())!=null)
            {
                builder.append(line);
            }
            String result=builder.toString();
            Log.i("result",""+result);
            setdata(result);



        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }



}
