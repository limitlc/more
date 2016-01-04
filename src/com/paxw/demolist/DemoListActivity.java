package com.paxw.demolist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.transform.ErrorListener;
import javax.xml.transform.TransformerException;

import org.apache.http.HttpRequest;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.paxw.demolist.anim.ShuXingDongActivity;
import com.paxw.demolist.banner.BannerActivity;
import com.paxw.demolist.canvas.CanvasActivity;
import com.paxw.demolist.customview.heartview.HeartActivity;
import com.paxw.demolist.noview.fragment.NoViewFragmentActivity;
import com.paxw.demolist.progressbar.ProgressBarPai;
import com.paxw.demolist.slidingmenu.SlidemenuActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class DemoListActivity extends ListActivity {
	private List<String> mData = new ArrayList<String>(Arrays.asList(
			"属性动画","progress","侧滑菜单","canvas","心形","banner","没有界面的Fragment"));
	private ListAdapter mAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, mData);
		getListView().setAdapter(mAdapter);
		DisplayMetrics displayMetrics = this.getApplicationContext().getResources().getDisplayMetrics();
		System.out.println("-density-"+displayMetrics.density+"-densityDpi-"+displayMetrics.densityDpi+"-scaledDensity-"+displayMetrics.scaledDensity);
	}
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		Intent intent = null;
		switch (position) {
		case 0:
			intent = new Intent(this, ShuXingDongActivity.class);
			break;
		case 1:
			intent = new Intent(this, ProgressBarPai.class);
			break;
		case 2:
			intent = new Intent(this, SlidemenuActivity.class);
			break;
		case 3:
			intent = new Intent(this, CanvasActivity.class);
			break;
		case 4:
			intent = new Intent(this, HeartActivity.class);
			break;
		case 5:
			intent = new Intent(this, BannerActivity.class);
			break;
		case 6:
			intent = new Intent(this,NoViewFragmentActivity.class);
			break;
		}
		startActivity(intent);
	}
}
