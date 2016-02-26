package com.atikspart.game;

import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FindTheLargest extends Activity implements View.OnClickListener{

	int max;

	int nos[]=new int[4];
	TextView ques;
	ImageView opt1,opt2,opt3,opt4;
	Random r1=new Random();
	boolean st=false;

	@Override

	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	
		setContentView(R.layout.findthelargest);

		ques=(TextView)findViewById(R.id.tVQues);
	
		opt1=(ImageView)findViewById(R.id.iVOpt1);
		opt2=(ImageView)findViewById(R.id.iVOpt2);
		opt3=(ImageView)findViewById(R.id.iVOpt3);
		opt4=(ImageView)findViewById(R.id.iVOpt4);
		
	
		
		nos[0]=generateRandom();
		changeImage(opt1,nos[0]);
		int temp;
		
		
		do
		{
		temp=generateRandom();
		}while(temp==nos[0]);
		
		changeImage(opt2,temp);
		nos[1]=temp;
		
		do
		{
		temp=generateRandom();
		}while(temp==nos[0]||temp==nos[1]);
		
		changeImage(opt3,temp);
		nos[2]=temp;
		

		do
		{
		temp=generateRandom();
		}while(temp==nos[0]||temp==nos[1]||temp==nos[2]);
		
		changeImage(opt4,temp);
		nos[3]=temp;
		
		max=nos[0];
		if (nos[1]>max)
			max=nos[1];
		if (nos[2]>max)
			max=nos[2];
		if (nos[3]>max)
			max=nos[3];
		 
		opt1.setOnClickListener(this);
		opt2.setOnClickListener(this);		
		opt3.setOnClickListener(this);
		opt4.setOnClickListener(this);
		
		
	
	}//end func protected

	public int generateRandom()
	{
		return (r1.nextInt(7));
		
	}
	
	public void changeImage(ImageView rs,int sp)
	{
		switch (sp)
		{	
		case 0:
		{
			rs.setImageResource(R.drawable.n1);
			break;
		}
		case 1:
		{
			rs.setImageResource(R.drawable.n2);
			break;
		}
		case 2:
		{
			rs.setImageResource(R.drawable.n3);
			break;
		}
		case 3:
		{
			rs.setImageResource(R.drawable.n4);
			break;
		}
		case 4:
		{
			rs.setImageResource(R.drawable.n5);
			break;
		}
		case 5:
		{
			rs.setImageResource(R.drawable.n6);
			break;
		}
		case 6:
		{
			rs.setImageResource(R.drawable.n7);
			break;
		}
		case 7:
		{
			rs.setImageResource(R.drawable.n8);
			break;
		}
	
		}		
	
		
		
		
		
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case (R.id.iVOpt1):
		{
			if(nos[0]==max){
				ques.setText("correct");
				st=true;
			}
			else
				ques.setText("oops");
			break;
		}
		case (R.id.iVOpt2):
		{
			if(nos[1]==max){
				ques.setText("correct");
				st=true;
			}
			else
				ques.setText("oops");
			break;
		}
		case (R.id.iVOpt3):
		{
			if(nos[2]==max){
				ques.setText("correct");
				st=true;
			}
			else
				ques.setText("oops");
			break;
		}
		case (R.id.iVOpt4):
		{
			if(nos[3]==max){
				ques.setText("correct");
				st=true;
			}
			else
				ques.setText("oops");
			break;
		}
		
		}
	}
	
	
}
