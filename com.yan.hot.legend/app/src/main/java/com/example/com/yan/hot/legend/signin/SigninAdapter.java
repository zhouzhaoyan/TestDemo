package com.example.com.yan.hot.legend.signin;

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

public class SigninAdapter extends RecyclerView.Adapter<SigninAdapter.SigninVH> {
    private List<SigninObject> list;

    public SigninAdapter(List<SigninObject> list) {
        this.list = list;
    }

    @Override
    public SigninAdapter.SigninVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_signin, parent, false);
        return new SigninAdapter.SigninVH(v);
    }

    @SuppressLint({"LogNotTimber", "SetTextI18n"})
    @Override
    public void onBindViewHolder(SigninAdapter.SigninVH holder, int position) {
        final SigninObject object = list.get(position);
        Log.e("test", "onBindViewHolder: position:" + position + ",object:" + object);
        holder.name.setText(object.getName() + "(" + object.getAccountName() + ")");
        holder.index.setText(object.getIndex() + "");
        holder.index.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    try {
                        int value = Integer.parseInt(((EditText) v).getText().toString());
                        object.setIndex(value);
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

    public static class SigninVH extends RecyclerView.ViewHolder {
        private final TextView name;
        private final EditText index;

        public SigninVH(View v) {
            super(v);
            name = (TextView) v.findViewById(R.id.signin_name);
            index = (EditText) v.findViewById(R.id.signin_index);
        }
    }
}
