package com.atikspart.game;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class NumberGames extends ListActivity {
	
	String numGmList[]={"Count","FindTheLargest","Findthesmallest"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(NumberGames.this, android.R.layout.simple_list_item_1, numGmList));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String local=numGmList[position];
		try{
			Class ourClass=Class.forName("com.atikspart.game."+local);
			Intent ourIntent=new Intent(NumberGames.this,ourClass);
			startActivity(ourIntent);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
	}

	
}
