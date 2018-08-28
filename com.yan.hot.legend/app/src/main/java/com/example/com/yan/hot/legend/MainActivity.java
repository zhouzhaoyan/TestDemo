package com.example.com.yan.hot.legend;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;

import com.yan.hot.legend.action.Action;
import com.yan.hot.legend.action.ActionFile;
import com.yan.hot.legend.action.ActionTime;
import com.yan.hot.legend.action.Coordinate;
import com.zsctc.remote.touch.bytes.TimeUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class MainActivity extends Activity {

//	private List<Coordinate> eidtCoordinatess;
	private static final String Coordinate_FLAG = "Coordinate_FLAG";
	private List<Action> actions;
	private ListView actionsView;
	public static boolean daily = false;
	public static boolean simple = false;
	public static boolean surplus = false;
	public static boolean isGame1 = true;
    public static boolean isGame2 = true;
    public static boolean isGame3 = true;
    public static boolean isGame4 = true;
    public static boolean isGame5 = true;
    public static boolean isGame6 = true;
	public static boolean isGame7 = true;
	public static boolean isGame8 = true;
	public static boolean isGame9 = true;

	public static void open(Context context, List<Coordinate> coordinatess){
		Intent intent = new Intent(context, MainActivity.class);
		intent.putExtra(Coordinate_FLAG, (Serializable)coordinatess);
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(intent);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		actionsView = (ListView) findViewById(R.id.action_list);
		actions = ActionFile.read();

		ChangeCoordinate.change(actions);

		if (actions == null){
			actions = new ArrayList<Action>();
		}
		ActionAdapter actionAdapter = new ActionAdapter(this, actions);
		actionsView.setAdapter(actionAdapter);

		if (actions == null) {
			actions = new ArrayList<Action>();
		}
		List<Coordinate> eidtCoordinatess = (List<Coordinate>) getIntent().getSerializableExtra(Coordinate_FLAG);
		Log.e("test", "actions:" + actions);
		if (eidtCoordinatess != null){
			showActionDialog(eidtCoordinatess);
		}else{
			AliveService.openAliveService(getApplicationContext());
		}

		Log.e(TAG, "week: " + TimeUtil.dateToWeek(System.currentTimeMillis()));
		Log.e(TAG, "day: " + TimeUtil.getCurrentDay());
		Log.e(TAG, "hour: " + TimeUtil.getCurrentHour());
		Log.e(TAG, "min: " + TimeUtil.getCurrentMin());
	}

	public void onClick(View view){
		switch (view.getId()) {
		case R.id.action_add:
			AliveService.stopService(this);
			Intent intent = new Intent(this, RecordingScriptService.class);
			startService(intent);
			finish();
			break;
		case R.id.action_start:
			daily = ((CheckBox)findViewById(R.id.filter)).isChecked();
			simple = ((CheckBox)findViewById(R.id.simple)).isChecked();
			surplus = ((CheckBox)findViewById(R.id.surplus)).isChecked();

		    isGame1 = ((CheckBox)findViewById(R.id.game1)).isChecked();
			isGame2 = ((CheckBox)findViewById(R.id.game2)).isChecked();
			isGame3 = ((CheckBox)findViewById(R.id.game3)).isChecked();
			isGame4 = ((CheckBox)findViewById(R.id.game4)).isChecked();
			isGame5 = ((CheckBox)findViewById(R.id.game5)).isChecked();
			isGame6 = ((CheckBox)findViewById(R.id.game6)).isChecked();
			isGame7 = ((CheckBox)findViewById(R.id.game7)).isChecked();
			isGame8 = ((CheckBox)findViewById(R.id.game8)).isChecked();
			isGame9 = ((CheckBox)findViewById(R.id.game9)).isChecked();
			Log.e(TAG, "onClick: isGame1:" + isGame1
					+ ",isGame2:" + isGame2
					+ ",isGame3:" + isGame3
					+ ",isGame4:" + isGame4
					+ ",isGame5:" + isGame5
					+ ",isGame6:" + isGame6);

			AliveService.openAliveService(getApplicationContext());
			break;
		case R.id.action_stop:
			AliveService.stopService(getApplicationContext());
			ClickService.stopService(getApplicationContext());
			break;
		default:
			break;
		}

	}

	private void showActionDialog(final List<Coordinate> eidtCoordinatess){
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
