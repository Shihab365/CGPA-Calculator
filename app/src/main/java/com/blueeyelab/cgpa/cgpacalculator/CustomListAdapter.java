package com.blueeyelab.cgpa.cgpacalculator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomListAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Items> items;

    public CustomListAdapter(Context context, ArrayList<Items> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null)
        {
            convertView=LayoutInflater.from(context).inflate(R.layout.output_row,parent,false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Items currentItem = (Items) getItem(position);
        viewHolder.credit_text.setText(currentItem.getCredit());
        viewHolder.gpa_text.setText(currentItem.getGpa());
        viewHolder.total_text.setText(currentItem.getTotal());
        viewHolder.rmk_text.setText(currentItem.getRmk());
        return convertView;
    }
    private class ViewHolder {
        TextView credit_text,gpa_text,total_text,rmk_text;
        public ViewHolder(View view) {
            credit_text=(TextView)view.findViewById(R.id.crt_c_id);
            gpa_text=(TextView)view.findViewById(R.id.gp_c_id);
            total_text=(TextView)view.findViewById(R.id.tl_c_id);
            rmk_text=(TextView)view.findViewById(R.id.rm_c_id);
        }
    }
}
