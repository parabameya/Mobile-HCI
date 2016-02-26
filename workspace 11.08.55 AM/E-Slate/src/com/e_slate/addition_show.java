
package com.e_slate;

import android.app.Activity;  
import android.content.Context;  
import android.os.Bundle;  
import android.view.View;  
import android.view.ViewGroup;  
import android.view.animation.AnimationUtils;  
import android.widget.AdapterView;  
import android.widget.AdapterView.OnItemSelectedListener;  
import android.widget.BaseAdapter;  
import android.widget.Gallery;  
import android.widget.ImageSwitcher;  
import android.widget.ImageView;  
import android.widget.ViewSwitcher;  
  
public class addition_show extends Activity implements ViewSwitcher.ViewFactory, OnItemSelectedListener {  
       
     private Gallery gallery;  
     private ImageSwitcher imageSwitcher;  
       
     private ImageAdapter ia;   
  
     @Override  
     public void onCreate(Bundle savedInstanceState) {  
          super.onCreate(savedInstanceState);  
          setContentView(R.layout.addition_show);  
  
          gallery = (Gallery) findViewById(R.id.gallery_add_show);  
          imageSwitcher = (ImageSwitcher) findViewById(R.id.is_add_show);  
            
          imageSwitcher.setFactory(this);  
          imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this,  
                    android.R.anim.fade_in));  
          imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this,  
                    android.R.anim.fade_out));  
            
  
          ia = new ImageAdapter(this);  
          gallery.setAdapter(ia);  
            
          //Event listener
          gallery.setOnItemSelectedListener(this);  
     }  
       
     private class ImageAdapter extends BaseAdapter {  
          private Context context;  
            
          private ImageAdapter(Context context) {  
               this.context = context;  
          }  
            
          private int[] IMAGE_IDS = {  
                 R.drawable.add1,R.drawable.add2,R.drawable.add3
          };  
  
          public int getCount() {  
               return IMAGE_IDS.length;  
          }  
  
          public Object getItem(int position) {  
               return IMAGE_IDS[position];  
          }  
  
          public long getItemId(int position) {  
               return position;  
          }  
  
          public View getView(int position, View convertView, ViewGroup parent) {  
               ImageView iv = new ImageView(context);  
               iv.setImageResource(IMAGE_IDS[position]);  
               iv.setLayoutParams(new Gallery.LayoutParams(150, 100));  
               return iv;  
          }  
     }  
  
     public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {  
          int imageResourceId = (Integer) ia.getItem(position);  
          imageSwitcher.setImageResource(imageResourceId);  
     }  
  
     public void onNothingSelected(AdapterView<?> parent) {  
     }  
  
     public View makeView() {  
          ImageView i = new ImageView(this);  
          i.setScaleType(ImageView.ScaleType.FIT_CENTER);  
          return i;  
     }  
}  