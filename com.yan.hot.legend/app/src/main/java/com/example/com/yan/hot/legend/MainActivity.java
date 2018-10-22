package com.example.com.yan.hot.legend;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.com.yan.hot.legend.devote.DevoteActivity;
import com.example.com.yan.hot.legend.devote.DevoteManager;
import com.example.com.yan.hot.legend.plug.PlugQQ;
import com.example.com.yan.hot.legend.runstate.ActionRun;
import com.example.com.yan.hot.legend.runstate.ActionRunFile;
import com.yan.hot.legend.action.Action;
import com.yan.hot.legend.action.ActionFile;
import com.yan.hot.legend.action.ActionTime;
import com.yan.hot.legend.action.Coordinate;
import com.zsctc.remote.touch.bytes.ClickTool;

import java.io.Serializable;
import java.util.List;

import static android.content.ContentValues.TAG;

public class MainActivity extends Activity {

    //	private List<Coordinate> eidtCoordinatess;
    private static final String Coordinate_FLAG = "Coordinate_FLAG";
    private List<Action> actions;

    public static void open(Context context, List<Coordinate> coordinatess) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(Coordinate_FLAG, (Serializable) coordinatess);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actions = ActionFile.read();
        ChangeCoordinate.change(actions);

        List<Coordinate> eidtCoordinatess = (List<Coordinate>) getIntent().getSerializableExtra(Coordinate_FLAG);
        if (eidtCoordinatess != null) {
            showActionDialog(eidtCoordinatess);
        } else {
            //			AliveService.openAliveService(getApplicationContext());
        }

        DevoteManager.init();
        PlugQQ.init();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.action_add:
                AliveService.stopService(this);
                Intent intent = new Intent(this, RecordingScriptService.class);
                startService(intent);
                finish();
                break;
            case R.id.action_start:
                start();
                updateUi();
                break;
            case R.id.action_stop:
                stop();
                break;
            case R.id.action_devote:
                startActivity(new Intent(this, DevoteActivity.class));
                break;
            case R.id.action_all:
                startActivity(new Intent(this, AllActionActivity.class));
                break;
            case R.id.action_delete:
                ActionRunFile.delete();
                Toast.makeText(this,"成功",Toast.LENGTH_LONG).show();
                updateUi();
                break;
            default:
                break;
        }

    }

    private void stop() {
        AliveService.stopService(getApplicationContext());
        ClickService.stopService(getApplicationContext());
    }

    private void start() {

        ActionRun actionRun = ActionRunFile.read();
        ActionRun.ModeType modeType = ActionRun.ModeType.TASK;
        for (ActionRun.ModeType type:ActionRun.ModeType.values()){
            if (getCheckBox(type) != null && getCheckBox(type).isChecked()){
                modeType = type;
                break;
            }
        }
        actionRun.setModeType(modeType);

        for (ClickTool.ClientType type : ClickTool.ClientType.values()) {
            actionRun.setActionStates(type,getCheckBox(type).isChecked());
        }
        Log.e(TAG, "start: actionRun:" + actionRun );
        ActionRunFile.write(actionRun);

        AliveService.openAliveService(getApplicationContext());
    }

    public void setClientColor(ClickTool.ClientType clientType, int color) {
        getCheckBox(clientType).setTextColor(color);
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateUi();
    }

    private void updateUi() {
        ActionRun actionRun = ActionRunFile.read();
        Log.e(TAG, "updateUi: actionRun:" + actionRun );
        List<ActionRun.ActionState> actionStates = actionRun.getActionStates();
        for (ActionRun.ActionState state : actionStates) {
            setClientColor(state.getClientType(), state.isRun() ? Color.RED : Color.BLACK);
        }
        switch (actionRun.getModeType()){
            case DAILY:
                ((CheckBox) findViewById(R.id.daily)).setChecked(true);
                ((CheckBox) findViewById(R.id.daily_task)).setChecked(false);
                ((CheckBox) findViewById(R.id.simple)).setChecked(false);
                break;
            case DAILY_TASK:
                ((CheckBox) findViewById(R.id.daily)).setChecked(false);
                ((CheckBox) findViewById(R.id.daily_task)).setChecked(true);
                ((CheckBox) findViewById(R.id.simple)).setChecked(false);
                break;
            case SIMPLE:
                ((CheckBox) findViewById(R.id.daily)).setChecked(false);
                ((CheckBox) findViewById(R.id.daily_task)).setChecked(false);
                ((CheckBox) findViewById(R.id.simple)).setChecked(true);
                break;
        }
        for (ActionRun.ActionState state: actionRun.getActionStates()) {
            setClientCheck(state.getClientType(), state.isRun());
        }
    }

    public void setClientCheck(ClickTool.ClientType clientType, boolean check) {
        getCheckBox(clientType).setChecked(check);
    }

    private CheckBox getCheckBox(ActionRun.ModeType modeType) {
        CheckBox checkBox = null;
        switch (modeType) {
            case DAILY:
                checkBox = ((CheckBox) findViewById(R.id.daily));
                break;
            case DAILY_TASK:
                checkBox = ((CheckBox) findViewById(R.id.daily_task));
                break;
            case SIMPLE:
                checkBox = ((CheckBox) findViewById(R.id.simple));
                break;
            case NIGHT:
                checkBox = ((CheckBox) findViewById(R.id.night));
                break;
        }
        return checkBox;
    }

    private CheckBox getCheckBox(ClickTool.ClientType clientType) {
        CheckBox checkBox = null;
        switch (clientType) {
            case 火树:
                checkBox = ((CheckBox) findViewById(R.id.game1));
                break;
            case 游戏07073网页:
                checkBox = ((CheckBox) findViewById(R.id.game3));
                break;
            case 乐趣网页:
                checkBox = ((CheckBox) findViewById(R.id.game2));
                break;
            case 核弹头网页:
                checkBox = ((CheckBox) findViewById(R.id.game4));
                break;
            case 游戏1758网页:
                checkBox = ((CheckBox) findViewById(R.id.game5));
                break;
            case 牛刀:
                checkBox = ((CheckBox) findViewById(R.id.game6));
                break;
            case 牛刀网页:
                checkBox = ((CheckBox) findViewById(R.id.game7));
                break;
            case 玩蛋:
                checkBox = ((CheckBox) findViewById(R.id.game8));
                break;
            case 客娱:
                checkBox = ((CheckBox) findViewById(R.id.game9));
                break;
            case 热血单机:
                checkBox = ((CheckBox) findViewById(R.id.game10));
                break;
            case 游戏07073:
                checkBox = ((CheckBox) findViewById(R.id.game11));
                break;
            case 游戏1758:
                checkBox = ((CheckBox) findViewById(R.id.game12));
                break;
            case 乐趣:
                checkBox = ((CheckBox) findViewById(R.id.game13));
                break;
            case 核弹头:
                checkBox = ((CheckBox) findViewById(R.id.game14));
                break;
            case 热血单机h5:
                checkBox = ((CheckBox) findViewById(R.id.game15));
                break;
            case 热血单机双开:
                checkBox = ((CheckBox) findViewById(R.id.game16));
                break;
            case 凹凸果:
                checkBox = ((CheckBox) findViewById(R.id.game17));
                break;
            case 乐趣双开:
                checkBox = ((CheckBox) findViewById(R.id.game18));
                break;
            case 乐趣网页双开:
                checkBox = ((CheckBox) findViewById(R.id.game19));
                break;
            case 火树网页双开:
                checkBox = ((CheckBox) findViewById(R.id.game20));
                break;
            case 玩蛋双开:
                checkBox = ((CheckBox) findViewById(R.id.game21));
                break;
            case 牛刀网页双开:
                checkBox = ((CheckBox) findViewById(R.id.game22));
                break;
            case 游戏1758网页双开:
                checkBox = ((CheckBox) findViewById(R.id.game23));
                break;
            case 核弹头双开:
                checkBox = ((CheckBox) findViewById(R.id.game24));
                break;
            case 热血单机h5双开:
                checkBox = ((CheckBox) findViewById(R.id.game25));
                break;
        }
        return checkBox;
    }

    private void showActionDialog(final List<Coordinate> eidtCoordinatess) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_action, null);
        final EditText nameView, hourView, minView, intervalView, countView;
        nameView = (EditText) view.findViewById(R.id.action_name);
        hourView = (EditText) view.findViewById(R.id.action_hour);
        minView = (EditText) view.findViewById(R.id.action_min);
        intervalView = (EditText) view.findViewById(R.id.action_interval);
        countView = (EditText) view.findViewById(R.id.action_count);
        builder.setView(view);
        final Dialog dialog = builder.create();
        dialog.show();
        view.findViewById(R.id.action_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Action action = new Action();
                action.setName(nameView.getText().toString());
                action.setCoordinates(eidtCoordinatess);
                ActionTime actionTime = new ActionTime();
                actionTime.setHour(Integer.parseInt(hourView.getText().toString()));
                actionTime.setMin(Integer.parseInt(minView.getText().toString()));
                actionTime.setInterval(Integer.parseInt(intervalView.getText().toString()));
                actionTime.setCount(Integer.parseInt(countView.getText().toString()));
                action.setActionTime(actionTime);
                actions.add(action);
                ActionFile.write(actions);

                //				AliveService.openAliveService(getApplicationContext());

                dialog.dismiss();

            }
        });
    }
}
