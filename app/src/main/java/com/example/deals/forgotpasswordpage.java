package com.example.deals;

import com.example.webservices.WebSerForgotPasswordEmail;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class forgotpasswordpage extends Activity {

	/** Called when the activity is first created. */
	
	Button btnBackforgotPage,btnSubmit;
	EditText edtEmailforgotPW;
	public String txtForgotEmail;
	int response;
	
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.forgotpassword);
	    findobjects();
	    btnBackforgotPage.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent it = new Intent(forgotpasswordpage.this, checkuser.class);
				startActivity(it);

			}
		});
		btnBackforgotPage.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent it = new Intent(forgotpasswordpage.this,checkuser.class);
				startActivity(it);

			}
		});
	    
	    btnSubmit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				txtForgotEmail=edtEmailforgotPW.getText().toString();
				fetchForgotPWInfo task=new fetchForgotPWInfo();
				task.execute();

				
				
			}
		});
	    
	    
	    

	}
	
	public class fetchForgotPWInfo extends AsyncTask<String, Void, Void>
	{
		
		ProgressDialog pd;
		WebSerForgotPasswordEmail obj;
		@Override
		protected Void doInBackground(String... params) {
			// TODO Auto-generated method stub
			obj=new WebSerForgotPasswordEmail(txtForgotEmail);
			obj.fetchdata();
			
			
			
			return null;
		}

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			
			pd=new ProgressDialog(forgotpasswordpage.this);
			pd.setMessage("Checking Id");
			pd.show();
			
		}

		@Override
		protected void onPostExecute(Void result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			pd.dismiss();
			response=obj.getresponse();
			if(response==1) {
				Toast.makeText(getApplication(),"Password sent",Toast.LENGTH_LONG).show();
			}
			else if(response==3)
			{
				Toast.makeText(getApplication(),"ZipDeals doesn't recognize provided email",Toast.LENGTH_LONG).show();
			}
			else if(response==2)
			{
				Toast.makeText(getApplication(),"Server error",Toast.LENGTH_LONG).show();
			}
		}
		
		
		
	}

	public void findobjects()
	{
		btnBackforgotPage=(Button)findViewById(R.id.btnBackForgotPage);
		btnSubmit=(Button)findViewById(R.id.btnSubmitForgotPW);
		edtEmailforgotPW=(EditText)findViewById(R.id.edtEmailForgotPW);
		
		
	}
	
}
