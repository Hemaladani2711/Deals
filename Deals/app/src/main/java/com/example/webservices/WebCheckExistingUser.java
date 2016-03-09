package com.example.webservices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class WebCheckExistingUser {
	
	
	ArrayList<NameValuePair>lstUserLoginIdPw=new ArrayList<NameValuePair>();
	String urlcheckExistingUser;
	String txtExistingUserId,txtExistingUserPW;

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
		/*
		 * 
		 * 
		 * get strings code and create SQLITE tables code left
		 * 
		 * 
		 * */
	}

	
	
}
