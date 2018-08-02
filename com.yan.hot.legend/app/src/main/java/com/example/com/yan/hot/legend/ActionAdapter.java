package com.example.com.yan.hot.legend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.yan.hot.legend.action.Action;
import com.yan.hot.legend.action.ActionFile;
import com.yan.hot.legend.action.ActionTime;
import com.yan.hot.legend.action.Coordinate;

import java.util.List;

/**
 * Created by zhouzhaoyan on 2018/3/2.
 */

public class ActionAdapter extends BaseAdapter implements View.OnClickListener {
    private Context context;
    private List<Action> actions;

    public ActionAdapter(Context context, List<Action> actions) {
        this.context = context;
        this.actions = actions;
    }

    @Override
    public int getCount() {
        return actions.size();
    }

    @Override
    public Object getItem(int position) {
        return actions.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Action action = (Action) getItem(position);
        Hold hold;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.dialog_action, null);
            hold = new Hold();
            hold.nameView = (EditText) convertView.findViewById(R.id.action_name);
            hold.hourView = (EditText) convertView.findViewById(R.id.action_hour);
            hold.minView = (EditText) convertView.findViewById(R.id.action_min);
            hold.intervalView = (EditText) convertView.findViewById(R.id.action_interval);
            hold.countView = (EditText) convertView.findViewById(R.id.action_count);
            hold.runTimeView = (TextView) convertView.findViewById(R.id.action_runtime);
            View save = convertView.findViewById(R.id.action_save);
            save.setTag(hold);
            save.setOnClickListener(this);
            View del = convertView.findViewById(R.id.action_delete);
            del.setTag(hold);
            del.setVisibility(View.VISIBLE);
            del.setOnClickListener(this);
            convertView.setTag(hold);
        }else{
            hold = (Hold) convertView.getTag();
        }
        hold.position = position;

        hold.nameView.setText(action.getName());
        hold.hourView.setText(action.getActionTime().getHour() + "");
        hold.minView.setText(action.getActionTime().getMin() + "");
        hold.intervalView.setText(action.getActionTime().getInterval() + "");
        hold.countView.setText(action.getActionTime().getCount() + "");
        List<Coordinate> coordinates = action.getCoordinates();
        long runTime = (coordinates.get(coordinates.size() - 1).getTime()
                - coordinates.get(0).getTime())/1000;
        hold.runTimeView.setText(runTime/60 + ":" + runTime%60 + "");
        return convertView;
    }

    @Override
    public void onClick(View view) {
        Hold hold = (Hold) view.getTag();
        switch (view.getId()) {
            case R.id.action_save:

                Action action = (Action) getItem(hold.position);
                action.setName(hold.nameView.getText().toString());
                ActionTime actionTime = new ActionTime();
                actionTime.setHour(Integer.parseInt(hold.hourView.getText().toString()));
                actionTime.setMin(Integer.parseInt(hold.minView.getText().toString()));
                actionTime.setInterval(Integer.parseInt(hold.intervalView.getText().toString()));
                actionTime.setCount(Integer.parseInt(hold.countView.getText().toString()));
                action.setActionTime(actionTime);
                ActionFile.write(actions);

//                AliveService.openAliveService(context.getApplicationContext());

                Toast.makeText(context, "成功", Toast.LENGTH_LONG).show();
                break;
            case R.id.action_delete:
                actions.remove(hold.position);
                ActionFile.write(actions);

//                AliveService.openAliveService(context.getApplicationContext());

                Toast.makeText(context, "成功", Toast.LENGTH_LONG).show();
                notifyDataSetChanged();
                break;
            default:
                break;
        }
    }

    private class Hold{
        public EditText nameView, hourView, minView, intervalView, countView;
        public TextView runTimeView;
        public int position;
    }


}
