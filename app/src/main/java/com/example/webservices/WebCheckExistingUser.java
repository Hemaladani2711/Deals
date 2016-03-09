package com.example.webservices;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WebCheckExistingUser {

	public static String urlcheckExistingUser="http://134.154.17.112/dealswebservice/getExistingUserInfo.php";
	ArrayList<NameValuePair>lstUserLoginIdPw=new ArrayList<NameValuePair>();
	//String userId,userName,userMobile,userEmail,userPw,userZip,userCountry,isBusiness,dateCreated;
	//ArrayList<String> lstUserInfo=new ArrayList<String>(9);
	HashMap map;
	int UserId;
	String txtExistingUserId,txtExistingUserPW;

	public WebCheckExistingUser(String txtUserId,String txtUserPw)
	{
		txtExistingUserId=txtUserId;
		txtExistingUserPW=txtUserPw;
	}

	public HashMap returnUserdata()
	{
		return map;
	}

	public void fetchData()
	{

		try {

				DefaultHttpClient client=new DefaultHttpClient();
				HttpPost post=new HttpPost(urlcheckExistingUser);
				lstUserLoginIdPw.add(new BasicNameValuePair("varCheckExistingUserLoginId",txtExistingUserId));
				lstUserLoginIdPw.add(new BasicNameValuePair("varCheckExistingUserPW",txtExistingUserPW));
				post.setEntity(new UrlEncodedFormEntity(lstUserLoginIdPw));
				HttpResponse response=client.execute(post);
				HttpEntity entity=response.getEntity();
				InputStream stream=entity.getContent();
				BufferedReader reader=new BufferedReader(new InputStreamReader(stream));
				String line;
				StringBuilder builder=new StringBuilder();
				while((line=reader.readLine())!=null)
				{
					builder.append(line);
				}
				
				String result=builder.toString();
			Log.i("result", result);

				setdata(result);


				stream.close();
		
			
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			  catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		   } 
			
			catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		   }
	
		
		
		
	}
	
	public void setdata(String result)
	{


		try {

			map=new HashMap();
			JSONObject jsonObj=new JSONObject(result);

				JSONArray array=jsonObj.getJSONArray("userinfo");


				for(int i=0;i<array.length();i++)
				{
				JSONObject obj=array.getJSONObject(i);


				map.put("userId",obj.getInt("userid"));
				map.put("userName",obj.getString("user_name"));
				map.put("userMobile",obj.getString("user_mobile"));
				map.put("userEmail",obj.getString("user_email"));
				map.put("userPw",obj.getString("user_pw"));
				map.put("userZip",obj.getString("user_zip"));
				map.put("userCountry",obj.getString("user_country"));
				map.put("isBusiness",obj.getString("is_business"));
				map.put("dateCreated", obj.getString("date_created"));
				Log.i("UserInfoHashMap",map.toString());
				Log.i("UserCountry",map.get("userCountry").toString());


				// Log.i("userId",""+userId);

			}



		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}

	
	
}
