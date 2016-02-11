package com.example.managementsystem;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomBaseAdapterjavaieeepapers extends BaseAdapter {
	Context con;
	LayoutInflater layoutInflater;
	ArrayList<HashMap<String, String>> listvalue;

	public CustomBaseAdapterjavaieeepapers(
			ViewStudentlistatten viewStudentlist,
			ArrayList<HashMap<String, String>> usersList)

	{
		// TODO Auto-generated constructor stub
		con = viewStudentlist;
		listvalue = usersList;
		layoutInflater = LayoutInflater.from(viewStudentlist);
	}

	public int getCount() {
		// TODO Auto-generated method stub
		return listvalue.size();
	}

	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return listvalue.get(position);
	}

	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder;
		if (convertView == null) {
			convertView = layoutInflater.inflate(
					R.layout.customlistviewjavaieeepapers, null);
			viewHolder = new ViewHolder();
			viewHolder.txtUsername = (TextView) convertView
					.findViewById(R.id.textView_name);
			viewHolder.txtUsername1 = (TextView) convertView
					.findViewById(R.id.textView_name1);
			viewHolder.txtUsername2 = (TextView) convertView
					.findViewById(R.id.TextView01);
			// viewHolder.txtUsername2 = (TextView) convertView
			// .findViewById(R.id.textView_name2);

			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}

		viewHolder.txtUsername.setText(listvalue.get(position).get("name")
				.toString());
		viewHolder.txtUsername1.setText(listvalue.get(position).get("name1")
				.toString());
		viewHolder.txtUsername2.setText(listvalue.get(position).get("name2")
				.toString());
		// viewHolder.txtUsername2.setText(listvalue.get(position).get("name2")
		// .toString());

		return convertView;

	}

	class ViewHolder {
		TextView txtUsername;
		TextView txtUsername1;
		TextView txtUsername2;
		// TextView txtUsername2;

	}

}
