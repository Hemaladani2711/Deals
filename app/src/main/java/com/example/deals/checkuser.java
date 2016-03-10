package com.example.deals;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.SQLITEDatabase.DatabaseHandle;
import com.example.webservices.WebCheckExistingUser;

import java.util.HashMap;


public class checkuser extends Activity {


	RadioButton rdoExistingUser,rdoNewUser;
	EditText edtExistingUserId, edtExistingUserPW;
	Button btnForgotPW,btnLogin,btnSubmit;
	WebCheckExistingUser obj;
	String txtExistingUserId,txtExistingUserPW;
	DatabaseHandle sqlitetables;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.checkuserpage);
	    findobjects();
	    setbuttonsstate();
		MediaPlayer mySound = MediaPlayer.create(checkuser.this, R.raw.jingle);
		mySound.start();
	    
	    // TODO Auto-generated method stub
	}
	
	
	public void setbuttonsstate()
	{
	    if(rdoExistingUser.isChecked())
	    {
			edtExistingUserId.setEnabled(true);
			edtExistingUserPW.setEnabled(true);
			btnForgotPW.setEnabled(true);
			btnLogin.setEnabled(true);
			btnSubmit.setEnabled(false);
			rdoNewUser.setChecked(false);

	    }
	    else if(rdoNewUser.isChecked())
	    {
			edtExistingUserId.setEnabled(false);
			edtExistingUserPW.setEnabled(false);
			btnForgotPW.setEnabled(false);
			btnLogin.setEnabled(false);
			btnSubmit.setEnabled(true);
			
			rdoExistingUser.setChecked(false);
	    }
	    
	    rdoExistingUser.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if(buttonView.isChecked())
				{
					edtExistingUserId.setEnabled(true);
					edtExistingUserPW.setEnabled(true);
					btnForgotPW.setEnabled(true);
					btnLogin.setEnabled(true);
					btnSubmit.setEnabled(false);
					rdoNewUser.setChecked(false);
				}
			}
		});
	    
	    btnForgotPW.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
				Intent it=new Intent(checkuser.this,forgotpasswordpage.class);
				startActivity(it);
				
			}
		});
	    
	    rdoNewUser.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if(buttonView.isChecked())
				{
					
					edtExistingUserId.setEnabled(false);
					edtExistingUserPW.setEnabled(false);
					btnForgotPW.setEnabled(false);
					btnLogin.setEnabled(false);
					btnSubmit.setEnabled(true);
					
					rdoExistingUser.setChecked(false);
				}
				
			}
		});
	    
	    btnLogin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			txtExistingUserId=edtExistingUserId.getText().toString();
			txtExistingUserPW=edtExistingUserPW.getText().toString();
			checkexistinguserserver task=new checkexistinguserserver();
				task.execute();
				
				
				
			}
		});
	    
	    btnSubmit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
				Intent it=new Intent(checkuser.this,NewUserDetailPage.class);
				startActivity(it);
				
				
			}
		});
	    
	    
	    
	    
	}

	public class checkexistinguserserver extends AsyncTask<String,Void,Void>
	{

		ProgressDialog pd;
		@Override
		protected Void doInBackground(String... params) {
			obj=new WebCheckExistingUser(txtExistingUserId,txtExistingUserPW);
			obj.fetchData();

			return null;
		}

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pd=new ProgressDialog(checkuser.this);
			pd.setMessage("Checking Credentials");
			pd.show();
		}

		@Override
		protected void onPostExecute(Void aVoid) {
			super.onPostExecute(aVoid);
			pd.cancel();
			HashMap userInfoDetail=new HashMap();
			userInfoDetail=obj.returnUserdata();
			try {

				Log.i("HashMap Empty",userInfoDetail.toString());
			if(userInfoDetail.isEmpty())
			{
				Toast.makeText(getApplicationContext(),"User Id and Password don't match. Try with forgot password, if registered before",Toast.LENGTH_LONG).show();
			}
			else {
				sqlitetables = new DatabaseHandle(getApplicationContext());
				sqlitetables.InsertUserInfo((Integer) userInfoDetail.get("userId"), userInfoDetail.get("userName").toString(), userInfoDetail.get("userMobile").toString(), userInfoDetail.get("userEmail").toString(), userInfoDetail.get("userPw").toString(), userInfoDetail.get("userCountry").toString(), userInfoDetail.get("userZip").toString(), userInfoDetail.get("isBusiness").toString(), Long.parseLong(userInfoDetail.get("dateCreated").toString()));
				Toast.makeText(getApplicationContext(), "UserInserted In DB", Toast.LENGTH_LONG).show();
			}
			}
			catch(Exception e)
			{
				Log.i("Error in Check User",e.getMessage());
			}


		}


	}

	
	public void findobjects()
	{
		
		rdoExistingUser=(RadioButton)findViewById(R.id.rdoExistingUser);
		rdoNewUser=(RadioButton)findViewById(R.id.rdoNewUser);
		edtExistingUserId=(EditText)findViewById(R.id.edtEmailExistingUser);
		edtExistingUserPW=(EditText)findViewById(R.id.edtExistingUserPw);
		btnLogin=(Button)findViewById(R.id.btnExistingUserLogin);
		btnForgotPW=(Button)findViewById(R.id.btnForgotPW);
		btnSubmit=(Button)findViewById(R.id.btnCheckNewUser);
		edtExistingUserId.setEnabled(false);
		edtExistingUserPW.setEnabled(false);
		btnForgotPW.setEnabled(false);
		btnLogin.setEnabled(false);
		btnSubmit.setEnabled(false);
		
	}
	
	

}
// Hello, this is hank again.  Pbbbbbbt!