package com.example.webservices;

import android.util.Log;
import android.view.ViewDebug;
import android.widget.SimpleCursorAdapter;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * Created by Hemal on 12/15/2015.
 */
public class WebSendNewUserData {
    public static String URL="http://10.0.0.114/dealswebservice/getUserData.php";

    String strUserName,strUserMobileNo,strUserEmail,strUserPW,strUserZipCode,strCountryName, strIsBusiness,strDateCreated;
    int userId;
    ArrayList<NameValuePair> lstUserInfo = new ArrayList<NameValuePair>(8);
    /*ArrayList<NameValuePair> lstUserMobileNo;
    ArrayList<NameValuePair> lstUserEmail;
    ArrayList<NameValuePair> lstUserPw;
    ArrayList<NameValuePair> lstUserZip;
    ArrayList<NameValuePair> lstCountry;
    ArrayList<NameValuePair> lstIsBusiness;*/


    public int returnUserid()
    {
        return userId;
    }
    public void setdata(String strUserName1,String strUserMobileNo1,String strUserEmail1,String strUserPW1,String strUserZipCode1,String strCountryName1, String strIsBusiness1, long datecreated)
    {
        strUserName=strUserName1;
        strUserMobileNo=strUserMobileNo1;
        strUserEmail=strUserEmail1;
        strUserPW=strUserPW1;
        strUserZipCode=strUserZipCode1;
        strCountryName=strCountryName1;
        strIsBusiness = strIsBusiness1;
        strDateCreated=Long.toString(datecreated);
    }
    public void setdata(String result)
    {
        try {


                JSONObject jsonObj=new JSONObject(result);
                JSONArray array=jsonObj.getJSONArray("userinfo");
                for(int i=0;i<array.length();i++)
                {
                    JSONObject obj=array.getJSONObject(i);
                    userId=obj.getInt("userid");
                   // Log.i("userId",""+userId);
                }



            } catch (JSONException e) {
            // TODO Auto-generated catch block
              e.printStackTrace();
            }

    }
    public void connectandfetchdata()
    {
        try {
            lstUserInfo.add(new BasicNameValuePair("strUserName",strUserName));
            lstUserInfo.add(new BasicNameValuePair("strUserMobileNo",strUserMobileNo));
            lstUserInfo.add(new BasicNameValuePair("strUserEmail",strUserEmail));
            lstUserInfo.add(new BasicNameValuePair("strUserPW",strUserPW));
            lstUserInfo.add(new BasicNameValuePair("strUserZipCode",strUserZipCode));
            lstUserInfo.add(new BasicNameValuePair("strCountryName",strCountryName));
            lstUserInfo.add(new BasicNameValuePair("strIsBusiness",strIsBusiness));
            lstUserInfo.add(new BasicNameValuePair("datecreated", strDateCreated));
           // Log.i("strUserName", strUserName + strUserMobileNo + strUserEmail + strUserPW + strUserZipCode + strCountryName + strIsBusiness + strDateCreated);
            DefaultHttpClient client = new DefaultHttpClient();
            HttpPost post=new HttpPost(URL);
            post.setEntity(new UrlEncodedFormEntity(lstUserInfo));
            HttpResponse response=client.execute(post);
            HttpEntity entity=response.getEntity();
            InputStream is=entity.getContent();
            BufferedReader reader=new BufferedReader(new InputStreamReader(is));
            String line;
            StringBuilder builder=new StringBuilder();
            while((line=reader.readLine())!=null)
            {
                builder.append(line);
            }

            String result = builder.toString();
            //Log.i("result",result);
            setdata(result);
            is.close();

            }
        catch (Exception e) {
            e.printStackTrace();
        }


    }



}
