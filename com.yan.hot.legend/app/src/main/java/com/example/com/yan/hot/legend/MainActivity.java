package com.example.com.yan.hot.legend;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.com.yan.hot.legend.devote.DevoteActivity;
import com.example.com.yan.hot.legend.devote.DevoteManager;
import com.example.com.yan.hot.legend.screencap.ScreencapPathUtil;
import com.yan.hot.legend.action.Action;
import com.yan.hot.legend.action.ActionFile;
import com.yan.hot.legend.action.ActionTime;
import com.yan.hot.legend.action.Coordinate;
import com.zsctc.remote.touch.bytes.ClickTool;
import com.zsctc.remote.touch.bytes.LogManager;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

public class MainActivity extends Activity {

//	private List<Coordinate> eidtCoordinatess;
	private static final String Coordinate_FLAG = "Coordinate_FLAG";
	private List<Action> actions;
	public static MainActivity mainActivity;
	private boolean isRestart = false;
	public static boolean daily = false;
	public static boolean dailyTask = false;
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
	public static boolean isGame22= true;
	public static boolean isGame23= true;
	public static boolean isGame24= true;

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
		mainActivity = this;

		actions = ActionFile.read();
		ChangeCoordinate.change(actions);

		List<Coordinate> eidtCoordinatess = (List<Coordinate>) getIntent().getSerializableExtra(Coordinate_FLAG);
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
			isRestart = false;

			start();
			break;
		case R.id.action_stop:
			cancelRestart();
			stop();
			break;
		case R.id.action_devote:
			startActivity(new Intent(this, DevoteActivity.class));
			break;
		case R.id.action_all:
			startActivity(new Intent(this, AllActionActivity.class));
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
		daily = ((CheckBox)findViewById(R.id.daily)).isChecked();
		dailyTask = ((CheckBox)findViewById(R.id.daily_task)).isChecked();
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
		isGame22 = ((CheckBox)findViewById(R.id.game22)).isChecked();
		isGame23 = ((CheckBox)findViewById(R.id.game23)).isChecked();
		isGame24 = ((CheckBox)findViewById(R.id.game24)).isChecked();

		for (ClickTool.ClientType type: ClickTool.ClientType.values()) {
			setClientColor(type, Color.BLACK);
		}

		AliveService.openAliveService(getApplicationContext());
	}

	public void setClientColor(ClickTool.ClientType clientType, int color){
		getCheckBox(clientType).setTextColor(color);
	}

	public void setClientCheck(ClickTool.ClientType clientType, boolean check){
		getCheckBox(clientType).setChecked(check);
	}

	private Disposable restartDisposable;
	@SuppressLint("CheckResult")
	public void restart(){
		LogManager.newInstance().writeMessage("running click error, restart");
		if (!isRestart){
			restartDisposable = Observable.just(1)
					.delay(10,TimeUnit.SECONDS)
					.observeOn(AndroidSchedulers.mainThread())
					.map(new Function<Integer, Integer>() {
						@Override
						public Integer apply(Integer integer) throws Exception {
							LogManager.newInstance().writeMessage("running click error, restart doing");
							stop();
							return 1;
						}
					})
					.delay(10, TimeUnit.SECONDS)
					.subscribe(new Consumer<Integer>() {
						@Override
						public void accept(Integer integer) throws Exception {
							restartDisposable = null;
							start();
						}
					});
		}
	}

	public void cancelRestart(){
		if (restartDisposable != null){
			LogManager.newInstance().writeMessage("running click error, restart cancel");
			if (!restartDisposable.isDisposed()){
				restartDisposable.dispose();
			}
			restartDisposable = null;
		}
	}

	private CheckBox getCheckBox(ClickTool.ClientType clientType){
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
		}
		return checkBox;
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
