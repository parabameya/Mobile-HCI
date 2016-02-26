package com.atikspart.game;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class GameList extends ListActivity {

	String gmList[]={"AlphabetGames","NumberGames"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(GameList.this, android.R.layout.simple_list_item_1, gmList));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String local=gmList[position];
		try{
			Class ourClass=Class.forName("com.atikspart.game."+local);
			Intent ourIntent=new Intent(GameList.this,ourClass);
			startActivity(ourIntent);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
	}

	

}
