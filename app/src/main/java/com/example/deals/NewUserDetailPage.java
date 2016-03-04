package com.example.deals;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.SQLITEDatabase.DatabaseHandle;
import com.example.webservices.WebSendNewUserData;

import java.util.Calendar;
import java.util.regex.Pattern;

public class NewUserDetailPage extends Activity {

	WebSendNewUserData WebserviceUser = new WebSendNewUserData();;
	Button btnBack,btnSubmit;
	DatabaseHandle dbObj;
	RadioButton rdoUser,rdoBusiness;
	EditText edtNameUser,edtMobilenoUser,edtEmailUser,edtPasswordUser,edtZipUser;
	AutoCompleteTextView edtCountryUser;
	String strUserName,strUserMobileNo,strUserEmail,strUserPW,strUserZipCode,strCountryName, strIsBusiness,strCountryCode;
	long datecreated;
	int userId;
	getcountry obj;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.newuserdetailpage);
	    findObjects();
		obj=new getcountry();

		ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,obj.getCountrydetail());
		edtCountryUser.setAdapter(adapter);
	    rdoUser.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub

				if (buttonView.isChecked()) {
					rdoBusiness.setEnabled(false);
				}

			}
		});
	    
	    rdoBusiness.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub


				if (buttonView.isChecked()) {
					rdoUser.setEnabled(false);
				}

			}
		});
	    
	    
	    btnSubmit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				strUserMobileNo=strCountryCode=strCountryName=null;

				//strUserEmail=;

				if( edtNameUser.getText().toString().isEmpty()|| edtMobilenoUser.getText().toString().isEmpty()||edtEmailUser.getText().toString().isEmpty()||edtPasswordUser.getText().toString().isEmpty()||edtCountryUser.getText().toString().isEmpty()||edtZipUser.getText().toString().isEmpty())
				{
					Toast.makeText(getApplicationContext(),"All fields are mandatory",Toast.LENGTH_SHORT).show();
				}
				else if(edtMobilenoUser.getText().length()!=10)
				{
					Toast.makeText(getApplicationContext(),"Enter only 10 digits of mobile no",Toast.LENGTH_SHORT).show();
				}
				else if(!Pattern.matches(Patterns.EMAIL_ADDRESS.pattern(),edtEmailUser.getText().toString()))
				{
					Toast.makeText(getApplicationContext(),"Please enter valid email id",Toast.LENGTH_SHORT).show();
				}
				else
				{
					strUserMobileNo=edtMobilenoUser.getText().toString();
					strCountryName=edtCountryUser.getText().toString();
					strCountryCode=obj.getCountryCode(strCountryName);
					strUserMobileNo = strCountryCode+strUserMobileNo;
					//Log.i("MObileno", strUserMobileNo);
					if(!rdoBusiness.isChecked())
					{
						strIsBusiness="No";
					}
					else
					{
						strIsBusiness="Yes";
					}
					strUserEmail=edtEmailUser.getText().toString();
					strUserName=edtNameUser.getText().toString();
					Calendar calendar = Calendar.getInstance();
					datecreated=calendar.getTimeInMillis();
					strUserPW=edtPasswordUser.getText().toString();
					strUserZipCode=edtZipUser.getText().toString();
					

					sendUserdata task=new sendUserdata();
					task.execute();



				}




			}
		});




	    
	    // TODO Auto-generated method stub
	}
	public class sendUserdata extends AsyncTask<String,Void,Void>
	{
		ProgressDialog pd;

		@Override
		protected Void doInBackground(String... params) {

			WebserviceUser.connectandfetchdata();


			return null;
		}

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pd=new ProgressDialog(NewUserDetailPage.this);
			pd.setMessage("Registering and Downloading Deals");
			pd.show();
			WebserviceUser.setdata(strUserName,strUserMobileNo,strUserEmail,strUserPW,strUserZipCode,strCountryName,strIsBusiness,datecreated);
		}

		@Override
		protected void onPostExecute(Void aVoid) {
			super.onPostExecute(aVoid);
			pd.cancel();
			userId=WebserviceUser.returnUserid();
			if(userId==0)
			{
				Toast.makeText(getApplicationContext(),"Emailid Exists. If Forgotted please use forgot password",Toast.LENGTH_LONG).show();
			}
			else
			{
				//Toast.makeText(getApplicationContext(), "" + userId, Toast.LENGTH_LONG).show();
				createnewUser task = new createnewUser();
				task.execute();
			}


		}
	}

	public class createnewUser extends AsyncTask<String,Void, Void>
	{

		ProgressDialog pg;

		@Override
		protected Void doInBackground(String... params) {
			dbObj=new DatabaseHandle(getApplicationContext());
			dbObj.InsertUserInfo(userId,strUserName,strUserMobileNo,strUserEmail,strUserPW,strCountryName,strUserZipCode,strIsBusiness,datecreated);


			return null;

		}

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pg=new ProgressDialog(NewUserDetailPage.this);
			pg.setMessage("Registration Successful. Downloading ads");
			pg.show();
		}

		@Override
		protected void onPostExecute(Void aVoid) {
			super.onPostExecute(aVoid);
			pg.cancel();
			Toast.makeText(getApplicationContext(), "User Successfully created", Toast.LENGTH_LONG).show();

		}

		@Override
		protected void onProgressUpdate(Void... values) {
			super.onProgressUpdate(values);
		}
	}
	public void findObjects()
	{
		btnBack=(Button)findViewById(R.id.btnBackNewUser);
		btnSubmit=(Button)findViewById(R.id.btnUserSubmit);
		edtNameUser=(EditText)findViewById(R.id.edtEnterYourName);
		edtEmailUser=(EditText)findViewById(R.id.edtEmailUser);
		edtMobilenoUser=(EditText)findViewById(R.id.edtEnterYourMobile);
		edtPasswordUser=(EditText)findViewById(R.id.edtPasswordUser);
		edtZipUser=(EditText)findViewById(R.id.edtUserZipcode);
		rdoUser=(RadioButton)findViewById(R.id.rdoUser);
		rdoBusiness=(RadioButton)findViewById(R.id.rdoBusiness);
		edtCountryUser=(AutoCompleteTextView)findViewById(R.id.edtCountryName);

		
		
	}

}
