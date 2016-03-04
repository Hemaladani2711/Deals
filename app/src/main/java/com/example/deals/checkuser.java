package com.example.deals;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.RadioButton;


public class checkuser extends Activity {


	RadioButton rdoExistingUser,rdoNewUser;
	EditText edtExistingUserId, edtExistingUserPW;
	Button btnForgotPW,btnLogin,btnSubmit;
	
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.checkuserpage);
	    findobjects();
	    setbuttonsstate();
	    
	    
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
			String txtExistingUserId=edtExistingUserId.getText().toString();
			String txtExistingUserPW=edtExistingUserPW.getText().toString();

				
				
				
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
