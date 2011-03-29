package com.hiphopjunkie;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class startjunkie extends Activity {
    private Button addButton;

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        setUpViews();
    }

	private void setUpViews() {
		// TODO Auto-generated method stub
		addButton = (Button)findViewById(R.id.add_button);
		
		addButton.setOnClickListener(new View.OnClickListener() {
			
			//@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(startjunkie.this, FirstQuestionActivity.class);
				startActivity(intent);
				
			}
		});
		
	}
    
}