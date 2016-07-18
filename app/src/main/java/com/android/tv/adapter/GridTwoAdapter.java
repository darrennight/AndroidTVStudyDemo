package com.android.tv.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.tv.R;

import java.util.ArrayList;

public class GridTwoAdapter extends BaseAdapter {
	private ArrayList<String> mList;
	private Context context;


	public GridTwoAdapter(Context context, ArrayList<String> list) {
		this.mList = list;
		this.context = context;
	}


	@Override
	public int getCount() {
		if (mList == null)
			return 0;
		return mList.size();
	}

	@Override
	public Object getItem(int position) {
		if (mList == null) {
			return null;
		}
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if(convertView==null){
			convertView = LayoutInflater.from(context).inflate(R.layout.item_grid_two,parent,false);
			holder = new ViewHolder();
			holder.mName = ((TextView) convertView.findViewById(R.id.tv_name));

			convertView.setTag(holder);
		}else{
			holder = ((ViewHolder) convertView.getTag());
		}

		holder.mName.setText(String.valueOf(position));
		return convertView;
	}


	class ViewHolder{
		TextView mName;
	}

}
