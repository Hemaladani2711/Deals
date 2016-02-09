package com.example.webservices;

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

public class WebSerForgotPasswordEmail {
	
	
	String UserEmail,UrlForgotPwId,strForgotPw;
	int responseForgotPw;
	
	ArrayList<NameValuePair>NameValuepair=new ArrayList<NameValuePair>();
	
	public WebSerForgotPasswordEmail(String strForgotPW)
	{
		strForgotPw=strForgotPW;
	}
	
	public int getresponse()
	{
		return responseForgotPw;
	}
	public void seturl()
	{
		UrlForgotPwId="";
		
		
		/*
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * */
					
	}
	
	
	
	public void fetchdata()
	{
		try {
		seturl();
		DefaultHttpClient client=new DefaultHttpClient();
		HttpPost post=new HttpPost(UrlForgotPwId);
		NameValuepair.add(new BasicNameValuePair("varForgotEmail",strForgotPw));
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
		responseForgotPw=Integer.parseInt(result);
						
		is.close();
		
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
