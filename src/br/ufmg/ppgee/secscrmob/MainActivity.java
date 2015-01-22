package br.ufmg.ppgee.secscrmob;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import br.ufmg.ppgee.secscrmob.listener.InteractionListener;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);
	if (savedInstanceState == null) {
	    getFragmentManager().beginTransaction()
		    .add(R.id.container, new PlaceholderFragment()).commit();
	}
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

	getMenuInflater().inflate(R.menu.main, menu);
	return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
	int id = item.getItemId();
	if (id == R.id.action_settings) {
	    return true;
	}
	return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

	EditText mUsernamField;
	EditText mPasswordField;
	Button mSubmitLoginButton;

	public PlaceholderFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
	    View rootView = inflater.inflate(R.layout.fragment_main, container,
		    false);
	    mUsernamField = (EditText) rootView
		    .findViewById(R.id.username_field);
	    mPasswordField = (EditText) rootView
		    .findViewById(R.id.password_field);
	    mSubmitLoginButton = (Button) rootView
		    .findViewById(R.id.submit_login_button);
	    mSubmitLoginButton.setOnClickListener(new OnClickListener() {
		@Override
		public void onClick(View v) {
		    
		    Map<String, Object> payload = new HashMap<String, Object>();
		    payload.put("name", "Ricardo");
		    InteractionListener.getProxy().captureUserEvaluation(payload);
		    
		    // LoginAsyncTask loginAsyncTask = new LoginAsyncTask();
		    // String username = mUsernamField.getText().toString();
		    // String password = mPasswordField.getText().toString();
		    // loginAsyncTask.execute(username, password);
		}
	    });

	    return rootView;
	}
    }

}
