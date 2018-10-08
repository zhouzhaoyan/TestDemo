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
import android.widget.ListView;

import com.example.com.yan.hot.legend.devote.DevoteActivity;
import com.example.com.yan.hot.legend.devote.DevoteManager;
import com.example.com.yan.hot.legend.screencap.ScreencapPathUtil;
import com.yan.hot.legend.action.Action;
import com.yan.hot.legend.action.ActionFile;
import com.yan.hot.legend.action.ActionTime;
import com.yan.hot.legend.action.Coordinate;
import com.zsctc.remote.touch.bytes.ClickTool;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class MainActivity extends Activity {

//	private List<Coordinate> eidtCoordinatess;
	private static final String Coordinate_FLAG = "Coordinate_FLAG";
	private List<Action> actions;
	private ListView actionsView;
	public static MainActivity mainActivity;
	public static boolean daily = false;
	public static boolean simple = false;
	public static boolean surplus = false;
	public static boolean night = false;
	public static boolean isGame1 = true;
    public static boolean isGame2 = true;
    public static boolean isGame3 = true;
    public static boolean isGame4 = true;
    public static boolean isGame5 = true;
    public static boolean isGame6 = true;
	public static boolean isGame7 = true;
	public static boolean isGame8 = true;
	public static boolean isGame9 = true;
	public static boolean isGame10 = true;
	public static boolean isGame11 = true;
	public static boolean isGame12 = true;
	public static boolean isGame13 = true;
	public static boolean isGame14 = true;
	public static boolean isGame15 = true;
	public static boolean isGame16= true;
	public static boolean isGame17= true;
	public static boolean isGame18= true;
	public static boolean isGame19= true;
	public static boolean isGame20= true;
	public static boolean isGame21= true;

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
		mainActivity = this;

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
//			AliveService.openAliveService(getApplicationContext());
		}

		DevoteManager.init();

		ScreencapPathUtil.getPath("test");
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
			night = ((CheckBox)findViewById(R.id.night)).isChecked();

		    isGame1 = ((CheckBox)findViewById(R.id.game1)).isChecked();
			isGame2 = ((CheckBox)findViewById(R.id.game2)).isChecked();
			isGame3 = ((CheckBox)findViewById(R.id.game3)).isChecked();
			isGame4 = ((CheckBox)findViewById(R.id.game4)).isChecked();
			isGame5 = ((CheckBox)findViewById(R.id.game5)).isChecked();
			isGame6 = ((CheckBox)findViewById(R.id.game6)).isChecked();
			isGame7 = ((CheckBox)findViewById(R.id.game7)).isChecked();
			isGame8 = ((CheckBox)findViewById(R.id.game8)).isChecked();
			isGame9 = ((CheckBox)findViewById(R.id.game9)).isChecked();
			isGame10 = ((CheckBox)findViewById(R.id.game10)).isChecked();
			isGame11 = ((CheckBox)findViewById(R.id.game11)).isChecked();
			isGame12 = ((CheckBox)findViewById(R.id.game12)).isChecked();
			isGame13 = ((CheckBox)findViewById(R.id.game13)).isChecked();
			isGame14 = ((CheckBox)findViewById(R.id.game14)).isChecked();
			isGame15 = ((CheckBox)findViewById(R.id.game15)).isChecked();
			isGame16 = ((CheckBox)findViewById(R.id.game16)).isChecked();
			isGame17 = ((CheckBox)findViewById(R.id.game17)).isChecked();
			isGame18 = ((CheckBox)findViewById(R.id.game18)).isChecked();
			isGame19 = ((CheckBox)findViewById(R.id.game19)).isChecked();
			isGame20 = ((CheckBox)findViewById(R.id.game20)).isChecked();
			isGame21 = ((CheckBox)findViewById(R.id.game21)).isChecked();
			Log.e(TAG, "onClick: isGame1:" + isGame1
					+ ",isGame2:" + isGame2
					+ ",isGame3:" + isGame3
					+ ",isGame4:" + isGame4
					+ ",isGame5:" + isGame5
					+ ",isGame6:" + isGame6);

			for (ClickTool.ClientType type: ClickTool.ClientType.values()) {
				setClientColor(type, Color.BLACK);
			}

			AliveService.openAliveService(getApplicationContext());
			break;
		case R.id.action_stop:
			AliveService.stopService(getApplicationContext());
			ClickService.stopService(getApplicationContext());
			break;
		case R.id.action_devote:
			startActivity(new Intent(this, DevoteActivity.class));
			break;
		default:
			break;
		}

	}

	public void setClientColor(ClickTool.ClientType clientType, int color){
		switch (clientType) {
			case 火树:
				((CheckBox) findViewById(R.id.game1)).setTextColor(color);
				break;
			case 游戏07073网页:
				((CheckBox) findViewById(R.id.game3)).setTextColor(color);
				break;
			case 乐趣网页:
				((CheckBox) findViewById(R.id.game2)).setTextColor(color);
				break;
			case 核弹头网页:
				((CheckBox) findViewById(R.id.game4)).setTextColor(color);
				break;
			case 游戏1758网页:
				((CheckBox) findViewById(R.id.game5)).setTextColor(color);
				break;
			case 牛刀:
				((CheckBox) findViewById(R.id.game6)).setTextColor(color);
				break;
			case 牛刀网页:
				((CheckBox) findViewById(R.id.game7)).setTextColor(color);
				break;
			case 玩蛋:
				((CheckBox) findViewById(R.id.game8)).setTextColor(color);
				break;
			case 客娱:
				((CheckBox) findViewById(R.id.game9)).setTextColor(color);
				break;
			case 热血单机:
				((CheckBox) findViewById(R.id.game10)).setTextColor(color);
				break;
			case 游戏07073:
				((CheckBox) findViewById(R.id.game11)).setTextColor(color);
				break;
			case 游戏1758:
				((CheckBox) findViewById(R.id.game12)).setTextColor(color);
				break;
			case 乐趣:
				((CheckBox) findViewById(R.id.game13)).setTextColor(color);
				break;
			case 核弹头:
				((CheckBox) findViewById(R.id.game14)).setTextColor(color);
				break;
			case 热血单机h5:
				((CheckBox) findViewById(R.id.game15)).setTextColor(color);
				break;
			case 热血单机双开:
				((CheckBox) findViewById(R.id.game16)).setTextColor(color);
				break;
			case 凹凸果:
				((CheckBox) findViewById(R.id.game17)).setTextColor(color);
				break;
			case 乐趣双开:
				((CheckBox) findViewById(R.id.game18)).setTextColor(color);
				break;
			case 乐趣网页双开:
				((CheckBox) findViewById(R.id.game19)).setTextColor(color);
				break;
			case 火树网页双开:
				((CheckBox) findViewById(R.id.game20)).setTextColor(color);
				break;
			case 玩蛋双开:
				((CheckBox) findViewById(R.id.game21)).setTextColor(color);
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
