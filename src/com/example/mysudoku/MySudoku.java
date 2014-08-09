package com.example.mysudoku;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MySudoku extends Activity implements OnClickListener{

	private static final String TAG = "MySudoku";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		Button continueButton = (Button) findViewById(R.id.continue_button);
		Button newButton = (Button) findViewById(R.id.new_button);
		Button aboutButton = (Button) findViewById(R.id.about_button);
		Button exitButton = (Button) findViewById(R.id.exit_button);
		continueButton.setOnClickListener(this);
		newButton.setOnClickListener(this);
		aboutButton.setOnClickListener(this);
		exitButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.about_button:
			Intent i = new Intent(this, About.class);
			startActivity(i);
			break;
		case R.id.new_button:
			openNewGameDialog();
			 break;
		case R.id.exit_button:
			finish();
			break;
		case R.id.continue_button:
			startGame(Game.DIFFICULTY_CONTINUE);
			break;
		default:
			break;
		}
	}
	
	private void openNewGameDialog(){
		new AlertDialog.Builder(this).setTitle(R.string.new_game_title).setItems(R.array.difficulty, 
				new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						startGame(which);
					}
		}).show();
	}
	
	private void startGame(int i){
		Log.d(TAG, "clicked on " + i);
		Intent intent = new Intent(MySudoku.this, Game.class);
		intent.putExtra(Game.KEY_DIFFICULTY, i);
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.settings:
			startActivity(new Intent(this, Prefs.class));
			break;

		default:
			break;
		}
		return true;
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	//	Music.play(this, R.raw.main);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	//	Music.stop(this);
	}
	
	
}
