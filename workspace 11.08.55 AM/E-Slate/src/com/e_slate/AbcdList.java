package com.e_slate;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class AbcdList extends ListActivity {

	String alphabetActivity[]={"Listening","SwitcherActivity","SvExample","Drawing","Draw","addition_show","Ra"};
	 	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,alphabetActivity));
	
	}
	 	protected void onListItemClick(ListView lv,View v,int position,long id)
	 	{
	 		super.onListItemClick(lv, v, position, id);
	 		String choice=alphabetActivity[position];
	 		try
	 		{
	 			Class selected=Class.forName("com.e_slate."+choice);
	 			Intent selectedIntent=new Intent(this,selected);
	 			startActivity(selectedIntent);
	 		}
	 		catch(ClassNotFoundException e){e.printStackTrace();}
	 	}

}
