package com.mtg.speedtest.speedcheck.internet.hikermanager;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends ArrayAdapter<CommonsModel> {

    private final int resourceLayout;
    private final Context mContext;
    private List<CommonsModel> commonsModelList;
    private OnClickListener onClickListener;

    public ListAdapter(Context context, int resource, List<CommonsModel> items) {
        super(context, resource, items);
        this.resourceLayout = resource;
        this.mContext = context;
        this.commonsModelList = items;
    }


    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(mContext);
            v = vi.inflate(resourceLayout, null);
        }

        TextView tvItemName = v.findViewById(R.id.tvItemName);
        TextView tvItemMore = v.findViewById(R.id.tvItemMore);
        TextView tvItemDelete = v.findViewById(R.id.tvItemDelete);
        CommonsModel commonsModel = commonsModelList.get(position);
        tvItemName.setText(commonsModel.name);


        tvItemMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, EditHikeAct.class);
                intent.putExtra("data", commonsModel);
                mContext.startActivity(intent);
            }
        });

        tvItemDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickListener.onDeleteItem(commonsModel);
            }
        });

        return v;
    }

}
