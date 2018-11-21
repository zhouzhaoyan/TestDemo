package com.example.com.yan.hot.legend.devote;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.com.yan.hot.legend.R;

import java.util.List;

/**
 * Created by on 2018/9/29.
 */
public class DevoteAdapter extends RecyclerView.Adapter<DevoteAdapter.DevoteVH> {

    private List<DevoteObject> list;


    public DevoteAdapter(List<DevoteObject> list) {
        this.list = list;
    }

    @Override
    public DevoteVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_devote, parent, false);
        return new DevoteVH(v);
    }

    @SuppressLint({"LogNotTimber", "SetTextI18n"})
    @Override
    public void onBindViewHolder(DevoteVH holder, int position) {
        final DevoteObject object = list.get(position);
        Log.e("test", "onBindViewHolder: position:" + position + ",object:" + object);
        holder.name.setText(object.getName() + "(" + object.getAccountName() + ")");
        holder.value.setText(object.getValue() + "");
        holder.value.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    try {
                        int value = Integer.parseInt(((EditText) v).getText().toString());
                        object.setValue(value);
                        DevoteManager.updateTime(object);
                    } catch (Exception e) {
                    }
                }
            }
        });
        holder.offset.setText(object.getOffset() + "");
        holder.offset.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    try {
                        int value = Integer.parseInt(((EditText) v).getText().toString());
                        object.setOffset(value);
                        DevoteManager.updateTime(object);
                    } catch (Exception e) {
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class DevoteVH extends RecyclerView.ViewHolder {
        private final TextView name;
        private final EditText value;
        private final EditText offset;

        public DevoteVH(View v) {
            super(v);
            name = (TextView) v.findViewById(R.id.devote_name);
            value = (EditText) v.findViewById(R.id.devote_value);
            offset = (EditText) v.findViewById(R.id.devote_offset);
        }
    }
}
