package com.example.webservices;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

public class WebSerForgotPasswordEmail {
	
	
	String UserEmail,strForgotPwEmail;
	int responseForgotPw;
	public static String UrlForgotPwId="http://134.154.17.112/dealswebservice/getForgotPasswordInfo.php";
	ArrayList<NameValuePair>NameValuepair=new ArrayList<NameValuePair>();
	
	public WebSerForgotPasswordEmail(String strForgotPW)
	{
		strForgotPwEmail=strForgotPW;
	}
	
	public int getresponse()
	{
		return responseForgotPw;
	}

	
	
	public void fetchdata()
	{
		try {

		DefaultHttpClient client=new DefaultHttpClient();
		HttpPost post=new HttpPost(UrlForgotPwId);
		NameValuepair.add(new BasicNameValuePair("varForgotEmail",strForgotPwEmail));
		post.setEntity(new UrlEncodedFormEntity(NameValuepair));
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
		
		String result=builder.toString();
			Log.i("Result", "" + result);
			setdata(result);
		//responseForgotPw=Integer.parseInt(result);
						
		is.close();
		
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void setdata(String result)
	{
		try{
		JSONObject jobj=new JSONObject(result);
		responseForgotPw=jobj.getInt("response");


		}
		catch (Exception e) {
			Log.i("Json error",e.getMessage());
		}

	}
	

}
