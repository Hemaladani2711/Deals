package com.example.webservices;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Hemal on 12/28/2015.
 */
public class WebReceiveAds {

    public static String URL="http://10.0.0.114/dealswebservice/WebReceiveAds.php";
    ArrayList<NameValuePair> listofdetail=new ArrayList<NameValuePair>(4);
    String userid1;String userzip1,usercountry1;String dateupdated1;
    public void sendata(int userid,String userzip, String usercountry,long dateupdated)
    {
        userid1=Integer.toString(userid);
        userzip1=userzip;
        usercountry1=usercountry;
        dateupdated1=Long.toString(dateupdated);
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


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }



}
