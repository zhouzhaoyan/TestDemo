package com.example.com.yan.hot.legend.power;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.com.yan.hot.legend.R;
import com.example.com.yan.hot.legend.devote.DevoteManager;
import com.example.com.yan.hot.legend.devote.DevoteObject;
import com.zsctc.remote.touch.bytes.TimeUtil;

import java.util.List;

/**
 * Created by on 2018/9/29.
 */
public class PowerAdapter extends RecyclerView.Adapter<PowerAdapter.DevoteVH> {

    private List<PowerObject> list;


    public PowerAdapter(List<PowerObject> list) {
        this.list = list;
    }

    @Override
    public DevoteVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_power, parent, false);
        return new DevoteVH(v);
    }

    @SuppressLint({"LogNotTimber", "SetTextI18n"})
    @Override
    public void onBindViewHolder(DevoteVH holder, int position) {
        final PowerObject object = list.get(position);
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
                    } catch (Exception e) {
                    }
                }
            }
        });
        holder.offset.setText(object.getReincarn() + "");
        holder.offset.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    try {
                        int value = Integer.parseInt(((EditText) v).getText().toString());
                        object.setReincarn(value);
                    } catch (Exception e) {
                    }
                }
            }
        });
        holder.time.setText(TimeUtil.getFormatDay(object.getDate()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class DevoteVH extends RecyclerView.ViewHolder {
        private final TextView name;
        private final EditText value;
        private final EditText offset;
        private final TextView time;

        public DevoteVH(View v) {
            super(v);
            name = (TextView) v.findViewById(R.id.devote_name);
            value = (EditText) v.findViewById(R.id.devote_value);
            offset = (EditText) v.findViewById(R.id.devote_offset);
            time = (TextView) v.findViewById(R.id.power_time);
        }
    }
}
