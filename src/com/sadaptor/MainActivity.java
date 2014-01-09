package com.sadaptor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleAdapter.ViewBinder;

public class MainActivity extends Activity {

	private String currentRootPath = null;
	private ListView listView = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		SimpleAdapter adapter = new SimpleAdapter(this,getData(),R.layout.activity_main,
				new String[]{"title","info","img"},
				new int[]{R.id.title,R.id.info,R.id.img});
		//setListAdapter(adapter);
		
		adapter.setViewBinder(new ViewBinder(){  
			  
	        @Override  
	        public boolean setViewValue(View view, Object data,  
	                String textRepresentation) {  
	            if( (view instanceof ImageView) & (data instanceof Bitmap) ) {  
	                ImageView iv = (ImageView) view;  
	                Bitmap bm = (Bitmap) data;  
	                iv.setImageBitmap(bm);  
	                return true;  
	                }  
	                return false;  
	  
	        }  
	             
	       });  
		
		listView = new ListView(this);
		listView.setAdapter(adapter);
		setContentView(listView);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private List<Map<String, Object>> getData() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("title", "G1");
		map.put("info", "google 1");
		map.put("img", R.drawable.communication);
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("title", "G2");
		map.put("info", "google 2");
		map.put("img", R.drawable.education);
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("title", "G3");
		map.put("info", "google 3");
		map.put("img", R.drawable.game);
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("title", "G3");
		map.put("info", "google 3");
		currentRootPath = Environment.getExternalStorageDirectory().toString();
		currentRootPath=currentRootPath+"/thumbnail/1.jpg";
		Log.d("Sadaptor","currentRootPath ="+currentRootPath);
		Bitmap bp = BitmapFactory.decodeFile(currentRootPath);
		//Bitmap bitmap = ;
		map.put("img" , bp);
		
		//map.put("img", R.drawable.game);
		list.add(map);
		
		return list;
	}
}
