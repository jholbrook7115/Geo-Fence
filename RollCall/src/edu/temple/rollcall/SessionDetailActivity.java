package edu.temple.rollcall;

import org.json.JSONException;
import android.graphics.PorterDuff;

import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class SessionDetailActivity extends Activity {

	TextView course_name;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_session_detail);
		getActionBar().setDisplayShowHomeEnabled(false);
				
		course_name = (TextView) findViewById(R.id.session_detail_course_name);

		Intent intent = getIntent();
		JSONObject sessionInfo = null;
		try {
			sessionInfo = new JSONObject(intent.getExtras().getString("sessionInfo"));
			course_name.setText(sessionInfo.getString("course_name"));
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	  public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.menu, menu);
	    
	    return true;
	  } 
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Intent intent;
	    switch (item.getItemId()) {
	    case R.id.action_home:
	        intent = new Intent(SessionDetailActivity.this, MainActivity.class);
	        intent.setAction("refresh");
	        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	        startActivity(intent);
	        break;
	    case R.id.action_logout:
	    	intent = new Intent(SessionDetailActivity.this, MainActivity.class);
	    	intent.setAction("logout");
	    	intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	    	startActivity(intent);
	    	break;
	    case R.id.action_account:
	    	intent = new Intent(SessionDetailActivity.this, AccountDetailActivity.class);
	    	startActivity(intent);
	    	break;
	    }
	    return super.onOptionsItemSelected(item);
	}
}