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

		//		Action tmp = null;
		//		for (Action action: actions) {
		//			if (action.getName().equals("魔界入侵")){
		//				tmp = action;
		//				break;
		//			}
		//		}
		//		if (tmp != null){
		//			List<Coordinate> coordinates = tmp.getCoordinates();
		//		coordinates.get(7).setTime(coordinates.get(7).getTime() - 2000);
		//		coordinates.get(8).setTime(coordinates.get(7).getTime() - 2000);
		//		coordinates.get(9).setTime(coordinates.get(7).getTime() - 2000);
		//		coordinates.remove(6);
		//		Coordinate coordinate = new Coordinate(559,1431);
		//		coordinate.setTime(coordinates.get(8).getTime() + 1000);
		//		coordinates.add(9,coordinate);

		//			for (int i = 0; i < coordinates.size(); i++) {
		//				Coordinate coordinate = coordinates.get(i);
		//				if (coordinate.getX() == 427 && coordinate.getY() == 1618){
		//					coordinate.setX(216);
		//					coordinate.setY(1589);
		//				}
		//			}
		//			Coordinate coordinate = coordinates.get(7);
		//			for (int i = 1; i <= 2; i++) {
		//				Coordinate coordinateTmp = new Coordinate(coordinate.getX(), coordinate.getY());
		//				coordinateTmp.setTime(coordinate.getTime() + 800*i);
		//				coordinates.add(7+i, coordinateTmp);
		//			}
		//			for (int i = 0; i < coordinates.size(); i++) {
		//				Log.e("test", "tmp: " + coordinates.get(i) + "\n" );
		//			}
		//			Log.e(TAG, "tmp: " + coordinates.subList(10, 58));
		//			coordinates.removeAll(coordinates.subList(10, 58));
		//			Log.e(TAG, "tmp: " +  coordinates);
		//			ActionFile.write(actions);
		//			Log.e("test", "tmp: " + tmp);
		//		}

		//		Action tmp = null;
		//		for (Action action: actions) {
		//			if (action.getName().equals("特戒副本")){
		//				tmp = action;
		//				break;
		//			}
		//		}
		//		if (tmp != null){
		//			List<Coordinate> coordinates = tmp.getCoordinates();
		//
		//			for (int i = 5; i < coordinates.size(); i++) {
		//				Coordinate coordinate = coordinates.get(i);
		//				coordinate.setTime(coordinate.getTime() + (i - 4) * 1000);
		//			}
		//
		//			for (int i = 0; i < coordinates.size(); i++) {
		//				Log.e("test", "tmp: " + coordinates.get(i) + "\n" );
		//			}
		//
		//			ActionFile.write(actions);
		//			Log.e("test", "tmp: " + tmp);
		//		}

		//		Action tmp = null;
		//		for (Action action: actions) {
		//			if (action.getName().equals("怪物攻城")){
		//				tmp = action;
		//				break;
		//			}
		//		}
		//		if (tmp != null){
		//			List<Coordinate> coordinates = tmp.getCoordinates();
		//			coordinates.clear();
		//
		//			int[][] coords = {{1008, 1849}, {1020, 896}, {432, 1606}, {1032, 1841},
		//						{1009, 1863}, {1021, 1843}, {1025, 1852},
		//					{1028, 1826}, {1025, 1842}, {1004, 1847},
		//					{1029, 1833}, {1026, 1827}, {1027, 1833}, {1025, 1819},
		//					{1029, 1803}, {993, 1817}, {1025, 1831},
		//					{1020, 1841}, {574, 1443}, {574, 1443}, {71, 1234},
		//					{736, 1629}, {733, 1264}, {1009, 1261},{1034, 1843}};
		//			long time = 45199529;
		//			for (int i = 0; i < coords.length; i++) {
		//				Coordinate coordinate = new Coordinate(coords[i][0], coords[i][1]);
		//				coordinate.setTime(time + i * 2000);
		//				coordinates.add(coordinate);
		//			}
		//
		//			for (int i = 0; i < coordinates.size(); i++) {
		//				Log.e("test", "tmp: " + coordinates.get(i) + "\n" );
		//			}
		//
		//			ActionFile.write(actions);
		//			Log.e("test", "tmp: " + tmp);
		//		}

//				Action tmp = null;
//				for (Action action : actions) {
//					if (action.getName().equals("怪物攻城")) {
//						tmp = action;
//						break;
//					}
//				}
//				if (tmp != null) {
//					List<Coordinate> coordinates = tmp.getCoordinates();
//					List<Coordinate> delete = new ArrayList<Coordinate>();
//					for (int i = 2; i < coordinates.size(); i++) {
//						delete.add(coordinates.get(i));
//					}
//					coordinates.removeAll(delete);
//
//					long lastTime = coordinates.get(coordinates.size() - 1).getTime();
//					int[][] xys = new int[][]{
//							{432, 1606}, {289,1545}, {289,1545},
//							{289,1545},{289,1545},{289,1545},
//							{289,1545},{289,1545},{289,1545},
//					};
//					List<Coordinate> addCoordinate;
//					for (int i = 0; i < 50; i++) {
//						addCoordinate = new ArrayList<Coordinate>();
//						for (int j = 0; j < xys.length; j++) {
//							Coordinate coordinate = new Coordinate(xys[j][0], xys[j][1]);
//							lastTime += 4000;
//							coordinate.setTime(lastTime);
//							addCoordinate.add(coordinate);
//						}
//						coordinates.addAll(addCoordinate);
//					}
//
//					Coordinate coordinate = new Coordinate(547,1412);
//					lastTime += 4000;
//					coordinate.setTime(lastTime);
//					coordinates.add(coordinate);
//
//					coordinate = new Coordinate(67,1604);
//					lastTime += 4000;
//					coordinate.setTime(lastTime);
//					coordinates.add(coordinate);
//
//					coordinate = new Coordinate(1020, 1841);
//					lastTime += 4000;
//					coordinate.setTime(lastTime);
//					coordinates.add(coordinate);
//
//					for (int i = 0; i < coordinates.size(); i++) {
//						Log.e("test", "tmp: " + coordinates.get(i) + "\n");
//					}
//					ActionFile.write(actions);
//					// 289,1545  1020, y=1841 547,1412 67,1604
//					Log.e("test", "tmp: " + tmp);
//				}

//				Action tmp = null;
//				for (Action action: actions) {
//					if (action.getName().equals("神兵幻境")){
//						tmp = action;
//						break;
//					}
//				}
//				if (tmp != null){
//					List<Coordinate> coordinates = tmp.getCoordinates();
//
//					for (int i = 21; i < coordinates.size(); i++) {
//						coordinates.get(i).setTime(coordinates.get(i).getTime() + 40000);
//					}
//
//					for (int i = 0; i < coordinates.size(); i++) {
//						Log.e("test", "tmp: " + coordinates.get(i) + "\n" );
//					}
//
//					ActionFile.write(actions);
//					Log.e("test", "tmp: " + tmp);
//				}

//				Action tmp = null;
//				for (Action action: actions) {
//					if (action.getName().equals("王者争霸")){
//						tmp = action;
//						break;
//					}
//				}
//				if (tmp != null){
//					List<Coordinate> coordinates = tmp.getCoordinates();
//
//					Coordinate coordinate = coordinates.get(5);
//					coordinate.setX(338);
//					coordinate.setY(1691);
//					for (int i = 0; i < coordinates.size(); i++) {
//						Log.e("test", "tmp: " + coordinates.get(i) + "\n" );
//					}
//					ActionFile.write(actions);
//					Log.e("test", "tmp: " + tmp);
//				}

//						Action tmp = null;
//						for (Action action: actions) {
//							if (action.getName().equals("龙城争霸")){
//								tmp = action;
//								break;
//							}
//						}
//						if (tmp != null){
//							List<Coordinate> coordinates = tmp.getCoordinates();
//
//							long lastTime = coordinates.get(coordinates.size() - 1).getTime();
//							Coordinate coordinate = new Coordinate(546,1500);
//							lastTime += 2000;
//							coordinate.setTime(lastTime);
//							coordinates.add(coordinate);
//
//							coordinate = new Coordinate(1013, 1821);
//							lastTime += 2000;
//							coordinate.setTime(lastTime);
//							coordinates.add(coordinate);
//
//							coordinate = new Coordinate(1013, 1821);
//							lastTime += 2000;
//							coordinate.setTime(lastTime);
//							coordinates.add(coordinate);
//
//							for (int i = coordinates.size() - 20; i < coordinates.size(); i++) {
//								Log.e("test", "tmp: " + coordinates.get(i) + "\n" );
//							}
//							ActionFile.write(actions);
//							Log.e("test", "tmp: " + tmp);
//						}

//								Action tmp = null;
//								for (Action action: actions) {
//									if (action.getName().equals("熔炼")){
//										tmp = action;
//										break;
//									}
//								}
//								if (tmp != null){
//									List<Coordinate> coordinates = tmp.getCoordinates();
//
//									long firstTime = coordinates.get(0).getTime();
//									firstTime += 3000;
//									coordinates.get(1).setTime(firstTime);
//
//									for (int i = 2; i < coordinates.size() - 2; i++) {
//										firstTime += 1000;
//										coordinates.get(i).setTime(firstTime);
//									}
//
//									firstTime += 2000;
//									coordinates.get(coordinates.size() - 2).setTime(firstTime);
//
//									firstTime += 2000;
//									coordinates.get(coordinates.size() - 1).setTime(firstTime);
//
//
//									Coordinate coordinate = new Coordinate(1013, 1821);
//									firstTime += 1000;
//									coordinate.setTime(firstTime);
//									coordinates.add(coordinate);
//
//									coordinate = new Coordinate(1013, 1821);
//									firstTime += 1000;
//									coordinate.setTime(firstTime);
//									coordinates.add(coordinate);
//
//									firstTime = coordinates.get(0).getTime();
//									coordinate = new Coordinate(1013, 1821);
//									firstTime -= 1000;
//									coordinate.setTime(firstTime);
//									coordinates.add(0, coordinate);
//
//									coordinate = new Coordinate(1013, 1821);
//									firstTime -= 1000;
//									coordinate.setTime(firstTime);
//									coordinates.add(0, coordinate);
//
//									for (int i = 0; i < coordinates.size(); i++) {
//										Log.e("test", "tmp: " + coordinates.get(i) + "\n" );
//									}
//									ActionFile.write(actions);
//									Log.e("test", "tmp: " + tmp);
//								}

//		Action tmp = null;
//		for (Action action: actions) {
//			if (action.getName().equals("血战矿洞")){
//				tmp = action;
//				break;
//			}
//		}
//		if (tmp != null){
//			List<Coordinate> coordinates = tmp.getCoordinates();
//
//			coordinates.get(4).setX(576);
//			coordinates.get(4).setY(1681);
//			coordinates.get(5).setX(576);
//			coordinates.get(5).setY(1681);
//			coordinates.get(6).setX(576);
//			coordinates.get(6).setY(1681);
//			for (int i = 0; i < coordinates.size(); i++) {
//				Log.e("test", "tmp: " + coordinates.get(i) + "\n" );
//			}
//
//			ActionFile.write(actions);
//			Log.e("test", "tmp: " + tmp);
//		}

//		Action tmp = null;
//		for (Action action: actions) {
//			if (action.getName().equals("血战比奇")){
//				tmp = action;
//				break;
//			}
//		}
//		if (tmp != null){
//			List<Coordinate> coordinates = tmp.getCoordinates();
//
//			coordinates.get(4).setX(982);
//			coordinates.get(4).setY(1037);
//
//			coordinates.get(5).setX(773);
//			coordinates.get(5).setY(1675);
//
//			coordinates.get(6).setX(773);
//			coordinates.get(6).setY(1675);
//
//			for (int i = 0; i < 50; i++) {
//				Log.e("test2", i + ",tmp: " + coordinates.get(i) + "\n" );
//			}
//			ActionFile.write(actions);
//			Log.e("test", "tmp2: " + tmp);
//		}

//		Action tmp = null;
//		for (Action action: actions) {
//			if (action.getName().equals("守护神剑")){
//				tmp = action;
//				break;
//			}
//		}
//		if (tmp != null){
//			List<Coordinate> coordinates = tmp.getCoordinates();
//
//			for (int i = 7; i < coordinates.size(); i++) {
//				coordinates.get(i).setTime(coordinates.get(i).getTime()+1000);
//			}
//
//			for (int i = 0; i < coordinates.size(); i++) {
//				Log.e("test", "tmp: " + coordinates.get(i) + "\n" );
//			}
//
//			ActionFile.write(actions);
//			Log.e("test", "tmp: " + tmp);
//		}

//		Action tmp = null;
//		for (Action action: actions) {
//			if (action.getName().equals("世界boss")){
//				tmp = action;
//				break;
//			}
//		}
//		if (tmp != null){
//			List<Coordinate> coordinates = tmp.getCoordinates();
//			coordinates.get(2).setX(982);
//			coordinates.get(2).setY(1037);
//
//			coordinates.get(3).setX(773);
//			coordinates.get(3).setY(1675);
//
//			coordinates.get(4).setX(773);
//			coordinates.get(4).setY(1675);
//
//			for (int i = 0; i < coordinates.size(); i++) {
//				Log.e("test", "tmp: " + coordinates.get(i) + "\n" );
//			}
//
//			ActionFile.write(actions);
//			Log.e("test", "tmp: " + tmp);
//		}

//		Action tmp = null;
//		for (Action action: actions) {
//			if (action.getName().equals("经验副本")){
//				tmp = action;
//				break;
//			}
//		}
//		if (tmp != null){
//			List<Coordinate> coordinates = tmp.getCoordinates();
//
//			coordinates.get(10).setY(1011);
//
//			for (int i = 0; i < coordinates.size(); i++) {
//				Log.e("test", "tmp: " + coordinates.get(i) + "\n" );
//			}
//			ActionFile.write(actions);
//			Log.e("test", "tmp: " + tmp);
//		}

//		Action tmp = null;
//		for (Action action: actions) {
//			if (action.getName().equals("圣魔龙战将")){
//				tmp = action;
//				break;
//			}
//		}
//		if (tmp != null){
//
//			Action action = new Action();
//			action.setActionTime(tmp.getActionTime());
//			action.setName("圣魔龙战将");
//
//			List<Coordinate> coordinates = new ArrayList<Coordinate>(tmp.getCoordinates());
//			Coordinate coordinate = coordinates.get(4);
//			coordinate.setX(547);
//			coordinate.setY(1346);
//
//			List<Coordinate> delete = new ArrayList<Coordinate>();
//			for (int i = 5; i < coordinates.size(); i++) {
//				delete.add(coordinates.get(i));
//			}
//			coordinates.removeAll(delete);
//
//			long lastTime = coordinates.get(4).getTime();
//			for (int i = 0; i < 145; i++) {
//				lastTime += 2000;
//				coordinate = new Coordinate(281,1570);
//				coordinate.setTime(lastTime);
//				coordinates.add(coordinate);
//
//				for (int j = 0; j < 1; j++) {
//					lastTime += 5000;
//					coordinate = new Coordinate(1018, 1826);
//					coordinate.setTime(lastTime);
//					coordinates.add(coordinate);
//				}
//			}
//
//			action.setCoordinates(coordinates);
//			for (int i = 0; i < coordinates.size(); i++) {
//				Log.e("test", "tmp: " + coordinates.get(i) + "\n" );
//			}
//
//			actions.add(action);
//			ActionFile.write(actions);
//			Log.e("test", "tmp: " + tmp);
//		}

//		Action tmp = null;
//		for (Action action: actions) {
//			if (action.getName().equals("跨服boss-苍月岛")){
//				tmp = action;
//				break;
//			}
//		}
//		if (tmp != null){
//			List<Coordinate> coordinates = new ArrayList<Coordinate>();
//			for (Coordinate coordinate: tmp.getCoordinates()) {
//				Coordinate coordinate1 = new Coordinate();
//				coordinate1.setTime(coordinate.getTime());
//				coordinate1.setX(coordinate.getX());
//				coordinate1.setY(coordinate.getY());
//				coordinates.add(coordinate1);
//			}
//
//            coordinates.get(5).setX(912);
//            coordinates.get(5).setY(1081);
//			coordinates.get(6).setX(516);
//			coordinates.get(6).setY(823);
//			for (int i = 0; i < 50; i++) {
//				Log.e("test", "tmp: " + coordinates.get(i) + "\n" );
//			}
//
//			tmp.setCoordinates(coordinates);
//			ActionFile.write(actions);
//			Log.e("test", "tmp: " + tmp);
//		}

//				Action tmp = null;
//				for (Action action: actions) {
//					if (action.getName().equals("自动关卡")){
//						tmp = action;
//						break;
//					}
//				}
//				if (tmp != null){
//					List<Coordinate> coordinates = tmp.getCoordinates();
//					long lastTime = coordinates.get(coordinates.size() - 1).getTime();
//					coordinates.get(coordinates.size() - 1).setTime(lastTime + 29000);
//
//					for (int i = 0; i < coordinates.size(); i++) {
//						Log.e("test", "tmp: " + coordinates.get(i) + "\n" );
//					}
//
//					ActionFile.write(actions);
//					Log.e("test", "tmp: " + tmp);
//				}

//		Action tmp = null;
//		for (Action action: actions) {
//			if (action.getName().equals("秘境boss")){
//				tmp = action;
//				break;
//			}
//		}
//		if (tmp != null){
//			List<Coordinate> coordinates = tmp.getCoordinates();
//			ActionTime actionTime = tmp.getActionTime();
//
//			Action action = new Action();
//			action.setActionTime(actionTime);
//			action.setName("秘境boss2");
//            action.setCoordinates(new ArrayList<Coordinate>(coordinates));
//            actions.add(action);
//
//			ActionFile.write(actions);
//			Log.e("test", "tmp: " + tmp);
//		}

//		Action tmp = null;
//		for (Action action: actions) {
//			if (action.getName().equals("蛮荒之地")){
//				tmp = action;
//				break;
//			}
//		}
//		if (tmp != null){
//			List<Coordinate> coordinates = tmp.getCoordinates();
//
//			coordinates.get(0).setX(1014);
//			coordinates.get(0).setY(1845);
//
//			long firstTime = coordinates.get(0).getTime();
//			Coordinate coordinate = new Coordinate(1014, 1845);
//			coordinate.setTime(firstTime-1000);
//			coordinates.add(0, coordinate);
//
//			for (int i = coordinates.size() - 2; i < coordinates.size(); i++) {
//				coordinates.get(i).setTime(coordinates.get(i).getTime() + 120000);
//			}
//
//			for (int i = 0; i < coordinates.size(); i++) {
//				Log.e("test", "tmp: " + coordinates.get(i) + "\n" );
//			}
//
//			ActionFile.write(actions);
//			Log.e("test", "tmp: " + tmp);
//		}

//		Action tmp = null;
//		for (Action action: actions) {
//			if (action.getName().equals("竞技")){
//				tmp = action;
//				break;
//			}
//		}
//		if (tmp != null){
//			List<Coordinate> coordinates = tmp.getCoordinates();
//
//			coordinates.get(coordinates.size() - 1).setX(1019);
//			coordinates.get(coordinates.size() - 1).setY(1844);
//			long lastTime = coordinates.get(coordinates.size() - 1).getTime();
//			lastTime += 1000;
//			coordinates.get(coordinates.size() - 1).setTime(lastTime);
//
//			Coordinate coordinate = new Coordinate(1019, 1844);
//			lastTime += 1500;
//			coordinate.setTime(lastTime);
//			coordinates.add(coordinate);
//
//			for (int i = 0; i < coordinates.size(); i++) {
//				Log.e("test", "tmp: " + coordinates.get(i) + "\n" );
//			}
//			ActionFile.write(actions);
//			Log.e("test", "tmp: " + tmp);
//		}

//		Action tmp = null;
//		for (Action action: actions) {
//			if (action.getName().equals("秘境boss2")){
//				tmp = action;
//				break;
//			}
//		}
//		if (tmp != null){
//			List<Coordinate> coordinates = tmp.getCoordinates();
//
//			for (int i = 0; i < coordinates.size(); i++) {
//				Log.e("test", "tmp: " + coordinates.get(i) + "\n" );
//			}
//			ActionFile.write(actions);
//			Log.e("test", "tmp: " + tmp);
//		}

//		Action tmp = null;
//		for (Action action: actions) {
//			if (action.getName().equals("自动关卡")){
//				tmp = action;
//				break;
//			}
//		}
//		if (tmp != null){
//
//			Action action = new Action();
//			action.setName("自动关卡2");
//			action.setCoordinates(tmp.getCoordinates());
//			action.setActionTime(tmp.getActionTime());
//
//			actions.add(action);
//
//			ActionFile.write(actions);
//			Log.e("test", "tmp: " + tmp);
//		}

//		Action tmp = null;
//		for (Action action: actions) {
//			if (action.getName().equals("圣魔龙战将2")){
//				tmp = action;
//				break;
//			}
//		}
//		if (tmp != null){
//			List<Coordinate> coordinates = tmp.getCoordinates();
//
//			List<Coordinate> delete = new ArrayList<Coordinate>();
//			for (int i = 4; i < coordinates.size(); i++) {
//				delete.add(coordinates.get(i));
//			}
//			coordinates.removeAll(delete);
//
//			long lastTime = coordinates.get(coordinates.size() - 1).getTime();
//			Coordinate coordinate;
//			for (int i = 0; i < 6*4; i++) {
//				lastTime += 2000;
//				coordinate = new Coordinate(547, 1346);
//				coordinate.setTime(lastTime);
//				coordinates.add(coordinate);
//
//				for (int j = 0; j < 4; j++) {
//					lastTime += 2000;
//					coordinate = new Coordinate(281,1570);
//					coordinate.setTime(lastTime);
//					coordinates.add(coordinate);
//				}
//
//			}
//
//			for (int j = 0; j < 6*15; j++) {
//				lastTime += 10000;
//				coordinate = new Coordinate(281,1570);
//				coordinate.setTime(lastTime);
//				coordinates.add(coordinate);
//			}
//
//			for (int i = 0; i < coordinates.size(); i++) {
//				Log.e("test", "tmp: " + coordinates.get(i) + "\n" );
//			}
//
//			ActionFile.write(actions);
//			Log.e("test", "tmp: " + tmp);
//		}

//		Action tmp = null;
//		for (Action action: actions) {
//			if (action.getName().equals("秘境boss")){
//				tmp = action;
//				break;
//			}
//		}
//		if (tmp != null){
//			List<Coordinate> coordinates = new ArrayList<Coordinate>();
//			coordinates.add(tmp.getCoordinates().get(0));
//
//			long lastTime = coordinates.get(0).getTime();
//			for (int i = 0; i < 61; i++) {
//				Coordinate coordinate = new Coordinate(1015, 1327);
//				lastTime += 1000;
//				coordinate.setTime(lastTime);
//				coordinates.add(coordinate);
//
//				coordinate = new Coordinate(572, 1658);
//				lastTime += 1000;
//				coordinate.setTime(lastTime);
//				coordinates.add(coordinate);
//
//				coordinate = new Coordinate(572, 1658);
//				lastTime += 1000;
//				coordinate.setTime(lastTime);
//				coordinates.add(coordinate);
//
//				if (i%2 == 0){
//					coordinate = new Coordinate(965, 660);
//				}else{
//					coordinate = new Coordinate(899, 529);
//				}
//				lastTime += 1000;
//				coordinate.setTime(lastTime);
//				coordinates.add(coordinate);
//
//				coordinate = new Coordinate(471, 1543);
//				lastTime += 1000;
//				coordinate.setTime(lastTime);
//				coordinates.add(coordinate);
//
//				coordinate = new Coordinate(734, 1347);
//				lastTime += 1000;
//				coordinate.setTime(lastTime);
//				coordinates.add(coordinate);
//
//				coordinate = new Coordinate(734, 1347);
//				lastTime += 1000;
//				coordinate.setTime(lastTime);
//				coordinates.add(coordinate);
//
//				coordinate = new Coordinate(1010, 1820);
//				lastTime += 1000;
//				coordinate.setTime(lastTime);
//				coordinates.add(coordinate);
//			}
//
//			Coordinate coordinate = new Coordinate(1010, 1820);
//			lastTime += 1000*105;
//			coordinate.setTime(lastTime);
//			coordinates.add(coordinate);
//
//			tmp.setCoordinates(coordinates);
//
//			for (int i = 0; i < coordinates.size(); i++) {
//				Log.e("test", "tmp: " + coordinates.get(i) + "\n" );
//			}
//
//			ActionFile.write(actions);
//			Log.e("test", "tmp: " + tmp);
//		}

//		Action tmp = null;
//		for (Action action: actions) {
//			if (action.getName().equals("秘境boss")){
//				tmp = action;
//				break;
//			}
//		}
//		if (tmp != null){
//
//			Action action = new Action();
//			action.setName("秘境boss2");
//			action.setCoordinates(tmp.getCoordinates());
//			action.setActionTime(tmp.getActionTime());
//
//			actions.add(action);
//
//			ActionFile.write(actions);
//			Log.e("test", "tmp: " + tmp);
//		}

//        Action tmp = null;
//        for (Action action: actions) {
//            if (action.getName().equals("竞技")){
//                tmp = action;
//                break;
//            }
//        }
//        if (tmp != null){
//
//            Action action = new Action();
//            action.setName("竞技2");
//            action.setCoordinates(tmp.getCoordinates());
//            action.setActionTime(tmp.getActionTime());
//
//            actions.add(action);
//
//            ActionFile.write(actions);
//            Log.e("test", "tmp: " + tmp);
//        }

//		Action tmp = null;
//		for (Action action: actions) {
//			if (action.getName().equals("激情泡点")){
//				tmp = action;
//				break;
//			}
//		}
//		if (tmp != null){
//			List<Coordinate> coordinates = tmp.getCoordinates();
//
//			List<Coordinate> delete = new ArrayList<Coordinate>();
//			for (int i = 8; i < 13; i++) {
//				delete.add(coordinates.get(i));
//			}
//			coordinates.removeAll(delete);
//
//            long lastTime = coordinates.get(7).getTime();
//            for (int i = 0; i < 880; i++) {
//                Coordinate coordinate = new Coordinate(150, 334);
//                lastTime += 1000;
//                coordinate.setTime(lastTime);
//                coordinates.add(i+8, coordinate);
//            }
//
//            for (int i = 0; i < coordinates.size(); i++) {
//				Log.e("test", "tmp: " + coordinates.get(i) + "\n" );
//			}
//
//			ActionFile.write(actions);
//			Log.e("test", "tmp: " + tmp);
//		}


//				Action tmp = null;
//				for (Action action: actions) {
//					if (action.getName().equals("圣魔龙战将")){
//						tmp = action;
//						break;
//					}
//				}
//				if (tmp != null){
//					List<Coordinate> coordinates = tmp.getCoordinates();
//
//					List<Coordinate> delete = new ArrayList<Coordinate>();
//					for (int i = 4; i < coordinates.size(); i++) {
//						delete.add(coordinates.get(i));
//					}
//					coordinates.removeAll(delete);
//
//					long lastTime = coordinates.get(coordinates.size() - 1).getTime();
//					Coordinate coordinate;
//					for (int i = 0; i < 6*10; i++) {
//						lastTime += 2000;
//						coordinate = new Coordinate(547, 1346);
//						coordinate.setTime(lastTime);
//						coordinates.add(coordinate);
//
//						for (int j = 0; j < 4; j++) {
//							lastTime += 2000;
//							coordinate = new Coordinate(281,1570);
//							coordinate.setTime(lastTime);
//							coordinates.add(coordinate);
//						}
//
//					}
//
//					for (int j = 0; j < 6*9; j++) {
//						lastTime += 10000;
//						coordinate = new Coordinate(281,1570);
//						coordinate.setTime(lastTime);
//						coordinates.add(coordinate);
//					}
//
//					coordinate = new Coordinate(1010, 1820);
//					lastTime += 1000;
//					coordinate.setTime(lastTime);
//					coordinates.add(coordinate);
//
//					for (int i = 0; i < coordinates.size(); i++) {
//						Log.e("test", "tmp: " + coordinates.get(i) + "\n" );
//					}
//
//					ActionFile.write(actions);
//					Log.e("test", "tmp: " + tmp);
//				}

//		Action tmp = null;
//		for (Action action: actions) {
//			if (action.getName().equals("圣火凤")){
//				tmp = action;
//				break;
//			}
//		}
//		if (tmp != null){
//			List<Coordinate> coordinates = tmp.getCoordinates();
//
//			List<Coordinate> delete = new ArrayList<Coordinate>();
//			for (int i = 4; i < coordinates.size(); i++) {
//				delete.add(coordinates.get(i));
//			}
//			coordinates.removeAll(delete);
//
//			long lastTime = coordinates.get(coordinates.size() - 1).getTime();
//			Coordinate coordinate;
//			for (int i = 0; i < 6*2; i++) {
//				lastTime += 2000;
//				coordinate = new Coordinate(836,1147);
//				coordinate.setTime(lastTime);
//				coordinates.add(coordinate);
//
//				for (int j = 0; j < 4; j++) {
//					lastTime += 2000;
//					coordinate = new Coordinate(399,1569);
//					coordinate.setTime(lastTime);
//					coordinates.add(coordinate);
//				}
//
//			}
//
//			for (int j = 0; j < 30*7; j++) {
//				lastTime += 2000;
//				coordinate = new Coordinate(399,1569);
//				coordinate.setTime(lastTime);
//				coordinates.add(coordinate);
//			}
//
//			Coordinate coordinate = new Coordinate(1010, 1820);
//			long lastTime = coordinates.get(coordinates.size() - 1).getTime() + 1000;
//			coordinate.setTime(lastTime);
//			coordinates.add(coordinate);
//
//			for (int i = 0; i < coordinates.size(); i++) {
//				Log.e("test", "tmp: " + coordinates.get(i) + "\n" );
//			}
//
//
//			ActionFile.write(actions);
//			Log.e("test", "tmp: " + tmp);
//		}

//		Action tmp = null;
//		for (Action action: actions) {
//			if (action.getName().equals("暗之秘境")){
//				tmp = action;
//				break;
//			}
//		}
//		if (tmp != null){
//			List<Coordinate> coordinates = tmp.getCoordinates();
//
//			List<Coordinate> delete = new ArrayList<Coordinate>();
//			for (int i = 1; i < 145; i++) {
//				delete.add(coordinates.get(i));
//			}
//			coordinates.removeAll(delete);
//
//			long lastTime = coordinates.get(0).getTime();
//			for (int i = 0; i < 24; i++) {
//
//				Coordinate coordinate = new Coordinate(1043, 1323);
//				lastTime += 1000;
//				coordinate.setTime(lastTime);
//				coordinates.add(1+i*6, coordinate);
//
//				coordinate = new Coordinate(586, 1666);
//				lastTime += 1000;
//				coordinate.setTime(lastTime);
//				coordinates.add(1+i*6+1, coordinate);
//
//				coordinate = new Coordinate(586, 1666);
//				lastTime += 1000;
//				coordinate.setTime(lastTime);
//				coordinates.add(1+i*6+2, coordinate);
//
//				if (i%2==0){
//					coordinate = new Coordinate(895, 1238);
//				} else{
//					coordinate = new Coordinate(911, 1130);
//				}
//				lastTime += 1000;
//				coordinate.setTime(lastTime);
//				coordinates.add(1+i*6+3, coordinate);
//
//				coordinate = new Coordinate(482, 1558);
//				lastTime += 1000;
//				coordinate.setTime(lastTime);
//				coordinates.add(1+i*6+4, coordinate);
//
//				coordinate = new Coordinate(1010, 1820);
//				lastTime += 1000;
//				coordinate.setTime(lastTime);
//				coordinates.add(1+i*6+5, coordinate);
//			}
//
//			for (int i = 0; i < coordinates.size(); i++) {
//				Log.e("test", "tmp: " + coordinates.get(i) + "\n" );
//			}
//
//			ActionFile.write(actions);
//			Log.e("test", "tmp: " + tmp);
//		}

//		Action tmp = null;
//		for (Action action: actions) {
//			if (action.getName().equals("跨服竞技场")){
//				tmp = action;
//				break;
//			}
//		}
//		if (tmp != null){
//			List<Coordinate> coordinates = tmp.getCoordinates();
//
//			for (int i = 0; i < coordinates.size(); i++) {
//				Log.e("test", "tmp: " + coordinates.get(i) + "\n" );
//			}
//			ActionFile.write(actions);
//			Log.e("test", "tmp: " + tmp);
//		}

//		Action tmp = null;
//		for (Action action: actions) {
//			if (action.getName().equals("跨服boss")){
//				tmp = action;
//				break;
//			}
//		}
//		if (tmp != null){
//			List<Coordinate> coordinates = tmp.getCoordinates();
//			coordinates.get(5).setX(912);
//			coordinates.get(5).setY(1081);
//
//			int addTime = 0;
//			for (int i = 5; i < 9; i++) {
//				addTime += 2000;
//				coordinates.get(i).setTime(coordinates.get(i).getTime() + addTime);
//			}
//
//			for (int i = 9; i < coordinates.size(); i++) {
//				coordinates.get(i).setTime(coordinates.get(i).getTime() + addTime);
//			}
//			for (int i = 0; i < 50; i++) {
//				Log.e("test", "tmp: " + coordinates.get(i) + "\n" );
//			}
//
//			ActionFile.write(actions);
//			Log.e("test", "tmp: " + tmp);
//		}

//		Action tmp = null;
//		for (Action action: actions) {
//			if (action.getName().equals("神域boss")){
//				tmp = action;
//				break;
//			}
//		}
//		if (tmp != null){
//			List<Coordinate> coordinates = tmp.getCoordinates();
//
//			List<Coordinate> delete = new ArrayList<Coordinate>();
//			for (int i = 1; i < coordinates.size(); i++) {
//				delete.add(coordinates.get(i));
//			}
//			coordinates.removeAll(delete);
//
//			for (int j = 0; j < 5; j++) {
//				long lastTime = coordinates.get(coordinates.size() - 1).getTime();
//				Coordinate coordinate = new Coordinate(1053, 1299);
//				lastTime += 1000;
//				coordinate.setTime(lastTime);
//				coordinates.add(coordinate);
//
//				lastTime = coordinates.get(coordinates.size() - 1).getTime();
//				coordinate = new Coordinate(743, 1671);
//				lastTime += 1000;
//				coordinate.setTime(lastTime);
//				coordinates.add(coordinate);
//
//				lastTime = coordinates.get(coordinates.size() - 1).getTime();
//				coordinate = new Coordinate(743, 1671);
//				lastTime += 1000;
//				coordinate.setTime(lastTime);
//				coordinates.add(coordinate);
//
//				for (int i = 0; i < 15; i++) {
//                    coordinate = new Coordinate(904, 606);
//                    lastTime += 1000;
//                    coordinate.setTime(lastTime);
//                    coordinates.add(coordinate);
//
//                    coordinate = new Coordinate(917,888);
//                    lastTime += 1000;
//                    coordinate.setTime(lastTime);
//                    coordinates.add(coordinate);
//
//                    coordinate = new Coordinate(886,1150);
//                    lastTime += 1000;
//                    coordinate.setTime(lastTime);
//                    coordinates.add(coordinate);
//
//                    coordinate = new Coordinate(836, 1415);
//                    lastTime += 1000;
//                    coordinate.setTime(lastTime);
//                    coordinates.add(coordinate);
//                }
//
//				coordinate = new Coordinate(1029, 1837);
//				lastTime += 1000;
//				coordinate.setTime(lastTime);
//				coordinates.add(coordinate);
//			}
//
//			for (int i = 0; i < coordinates.size(); i++) {
//				Log.e("test", "tmp: " + coordinates.get(i) + "\n" );
//			}
//			ActionFile.write(actions);
//			Log.e("test", "tmp: " + tmp);
//		}

//		Action tmp = null;
//		for (Action action: actions) {
//			if (action.getName().equals("野外boss")){
//				tmp = action;
//				break;
//			}
//		}
//		if (tmp != null){
//			Action action = new Action();
//			action.setName("野外boss-减半");
//			action.setActionTime(tmp.getActionTime());
//			List<Coordinate> tmpCoordinates = tmp.getCoordinates();
//			List<Coordinate> coordinates = new ArrayList<Coordinate>();
//			for (Coordinate tmpCoordinate: tmpCoordinates) {
//				Coordinate coordinate1;
//				if (tmpCoordinate.getX() == 886 && tmpCoordinate.getY() == 1150){
//					coordinate1 = new Coordinate(904, 606);
//				}else if (tmpCoordinate.getX() == 836 && tmpCoordinate.getY() == 1415){
//					coordinate1 = new Coordinate(917,888);
//				}else {
//					coordinate1 = new Coordinate(tmpCoordinate.getX(), tmpCoordinate.getY());
//				}
//				coordinate1.setTime(tmpCoordinate.getTime());
//				coordinates.add(coordinate1);
//			}
//			action.setCoordinates(coordinates);
//			actions.add(action);
//
//			for (int i = 0; i < 30; i++) {
//				Log.e("test", "tmp: " + tmpCoordinates.get(i) + "\n" );
//			}
//			ActionFile.write(actions);
//			Log.e("test", "tmp: " + tmp);
//		}

//		Action tmp = null;
//			for (Action action: actions) {
//				if (action.getName().equals("野外boss")){
//					tmp = action;
//					break;
//				}
//			}
//			if (tmp != null){
//				List<Coordinate> coordinates = tmp.getCoordinates();
//				coordinates.clear();
//				long lastTime = 748085;
//				Coordinate coordinate = new Coordinate(995, 1821);
//				coordinate.setTime(lastTime);
//				coordinates.add(coordinate);
//
//				for (int i = 0; i < 18; i++) {
//
//					coordinate = new Coordinate(1053, 1299);
//					lastTime += 1000;
//					coordinate.setTime(lastTime);
//					coordinates.add(coordinate);
//
//					for (int j = 0; j < 4; j++) {
//						coordinate = new Coordinate(904, 606);
//						lastTime += 1000;
//						coordinate.setTime(lastTime);
//						coordinates.add(coordinate);
//
//						coordinate = new Coordinate(917,888);
//						lastTime += 1000;
//						coordinate.setTime(lastTime);
//						coordinates.add(coordinate);
//
//						coordinate = new Coordinate(886,1150);
//						lastTime += 1000;
//						coordinate.setTime(lastTime);
//						coordinates.add(coordinate);
//
//						coordinate = new Coordinate(836, 1415);
//						lastTime += 1000;
//						coordinate.setTime(lastTime);
//						coordinates.add(coordinate);
//					}
//
//					coordinate = new Coordinate(995, 1821);
//					lastTime += 1000;
//					coordinate.setTime(lastTime);
//					coordinates.add(coordinate);
//				}
//
//				for (int i = 0; i < coordinates.size(); i++) {
//					Log.e("test", "tmp: " + coordinates.get(i) + "\n" );
//				}
//				ActionFile.write(actions);
//				Log.e("test", "tmp: " + tmp);
//		}

//		Action tmp = null;
//		for (Action action: actions) {
//			if (action.getName().equals("激情泡点-2倍")){
//				tmp = action;
//				break;
//			}
//		}
//		if (tmp != null){
//			List<Coordinate> tmpCoordinates = tmp.getCoordinates();
//
//			int j = 0;
//			for (Coordinate coordinate: tmpCoordinates) {
//
//				if (coordinate.getX() == 855 && coordinate.getY() == 936){
//					if (j % 3 == 0){
//						coordinate.setX(641);
//						coordinate.setY(699);
//					} else if (j % 3 == 2){
//						coordinate.setX(930);
//						coordinate.setY(1184);
//					}
//					j++;
//				}
//			}
//			for (int i = 0; i < 30; i++) {
//				Log.e("test", "tmp: " + tmpCoordinates.get(i) + "\n" );
//			}
//			ActionFile.write(actions);
//			Log.e("test", "tmp: " + tmp);
//		}

//		Action tmp = null;
//		for (Action action: actions) {
//			if (action.getName().equals("暗之秘境-机械")){
//				tmp = action;
//				break;
//			}
//		}
//		if (tmp != null){
//			List<Coordinate> coordinates = tmp.getCoordinates();
//
//			List<Coordinate> delete = new ArrayList<Coordinate>();
//			for (int i = 1; i < coordinates.size(); i++) {
//				delete.add(coordinates.get(i));
//			}
//			coordinates.removeAll(delete);
//
//			Coordinate coordinate;
//			long lastTime = coordinates.get(coordinates.size()-1).getTime();
//			for (int i = 0; i < 30*60/7+1; i++) {
//				coordinate = new Coordinate(1020, 1273);
//				lastTime += 1000;
//				coordinate.setTime(lastTime);
//				coordinates.add( coordinate);
//
//				coordinate = new Coordinate(1020, 1273);
//				lastTime += 1000;
//				coordinate.setTime(lastTime);
//				coordinates.add( coordinate);
//
//				coordinate = new Coordinate(586, 1666);
//				lastTime += 1000;
//				coordinate.setTime(lastTime);
//				coordinates.add(coordinate);
//
//				coordinate = new Coordinate(586, 1666);
//				lastTime += 1000;
//				coordinate.setTime(lastTime);
//				coordinates.add(coordinate);
//
//				coordinate = new Coordinate(911, 1130);
//				lastTime += 1000;
//				coordinate.setTime(lastTime);
//				coordinates.add(coordinate);
//
//				coordinate = new Coordinate(482, 1558);
//				lastTime += 1000;
//				coordinate.setTime(lastTime);
//				coordinates.add(coordinate);
//
//				coordinate = new Coordinate(1010, 1820);
//				lastTime += 1000;
//				coordinate.setTime(lastTime);
//				coordinates.add(coordinate);
//			}
//
//			coordinate = new Coordinate(1010, 1831);
//			lastTime += 60000*5;
//			coordinate.setTime(lastTime);
//			coordinates.add(coordinate);
//
//			coordinate = new Coordinate(1010, 1831);
//			lastTime += 1000;
//			coordinate.setTime(lastTime);
//			coordinates.add(coordinate);
//
//			coordinate = new Coordinate(548, 1320);
//			lastTime += 1000;
//			coordinate.setTime(lastTime);
//			coordinates.add(coordinate);
//
//			coordinate = new Coordinate(548, 1519);
//			lastTime += 1000;
//			coordinate.setTime(lastTime);
//			coordinates.add(coordinate);
//
//			coordinate = new Coordinate(1010, 1831);
//			lastTime += 90000;
//			coordinate.setTime(lastTime);
//			coordinates.add(coordinate);
//
//			coordinate = new Coordinate(1010, 1831);
//			lastTime += 1000;
//			coordinate.setTime(lastTime);
//			coordinates.add(coordinate);
//
//			for (int i = 0; i < coordinates.size(); i++) {
//				Log.e("test", "tmp: " + coordinates.get(i) + "\n" );
//			}
//
//			ActionFile.write(actions);
//			Log.e("test", "tmp: " + tmp);
//		}

//		Action tmp = null;
//		for (Action action: actions) {
//			if (action.getName().equals("魔界入侵")){
//				tmp = action;
//				break;
//			}
//		}
//		if (tmp != null){
//			Action actionCopy = copy(tmp, "魔界入侵-鬼眼");
//			List<Coordinate> coordinates = actionCopy.getCoordinates();
//			for (Coordinate coordinate: coordinates) {
//				if (coordinate.getX() == 216 && coordinate.getY() ==1589 ){
//					coordinate.setX(424);
//					coordinate.setY(1587);
//				}
//			}
//			for (int i = 0; i < coordinates.size(); i++) {
//				Log.e("test", "tmp: " + coordinates.get(i) + "\n" );
//			}
//
//			actions.add(actionCopy);
//			ActionFile.write(actions);
//			Log.e("test", "tmp: " + actionCopy);
//		}

//		Action tmp = null;
//		for (Action action: actions) {
//			if (action.getName().equals("暗之秘境-机械")){
//				tmp = action;
//				break;
//			}
//		}
//		if (tmp != null){
//			Action action = copy(tmp, "暗之秘境-紫龙");
//			List<Coordinate> coordinates = action.getCoordinates();
//			for (Coordinate coordinate: coordinates) {
//				if (coordinate.getX() == 909 && coordinate.getY() == 1018){
//					coordinate.setX(916);
//					coordinate.setY(1226);
//				}
//			}
//
//			for (int i = 0; i < 50; i++) {
//				Log.e("test", "tmp: " + coordinates.get(i) + "\n" );
//			}
//
//			actions.add(action);
//			ActionFile.write(actions);
//			Log.e("test", "tmp: " + action);
//		}

//		Action tmp = null;
//		for (Action action: actions) {
//			if (action.getName().equals("暗之秘境-机械")){
//				tmp = action;
//				break;
//			}
//		}
//		if (tmp != null){
//			Action action = copy(tmp, "暗之秘境-修罗");
//			List<Coordinate> coordinates = action.getCoordinates();
//			for (Coordinate coordinate: coordinates) {
//				if (coordinate.getX() == 909 && coordinate.getY() == 1018){
//					coordinate.setX(941);
//					coordinate.setY(1351);
//				}
//			}
//
//			for (int i = 0; i < 50; i++) {
//				Log.e("test", "tmp: " + coordinates.get(i) + "\n" );
//			}
//
//			actions.add(action);
//			ActionFile.write(actions);
//			Log.e("test", "tmp: " + action);
//		}

//		Action tmp = null;
//		for (Action action: actions) {
//			if (action.getName().equals("轮回")){
//				tmp = action;
//				break;
//			}
//		}
//		if (tmp != null){
//			List<Coordinate> coordinates = tmp.getCoordinates();
//			coordinates.clear();
//
//			long lastTime = 748085;
//			Coordinate coordinate;
//			for (int i = 0; i < 4; i++) {
//				coordinate = new Coordinate(1005, 1826);
//				lastTime += 1000;
//				coordinate.setTime(lastTime);
//				coordinates.add(coordinate);
//			}
//
//			coordinate = new Coordinate(298, 1809);
//			lastTime += 4000;
//			coordinate.setTime(lastTime);
//			coordinates.add(coordinate);
//
//			for (int i = 0; i < 2; i++) {
//				coordinate = new Coordinate(941, 1674);
//				lastTime += 4000;
//				coordinate.setTime(lastTime);
//				coordinates.add(coordinate);
//			}
//
//			coordinate = new Coordinate(846,1528);
//			lastTime += 2000;
//			coordinate.setTime(lastTime);
//			coordinates.add(coordinate);
//
//			for (int i = 0; i < 5; i++) {
//				coordinate = new Coordinate(818, 860);
//				lastTime += 2000;
//				coordinate.setTime(lastTime);
//				coordinates.add(coordinate);
//			}
//
//			for (int i = 0; i < 6; i++) {
//				coordinate = new Coordinate(1005, 1826);
//				lastTime += 1000;
//				coordinate.setTime(lastTime);
//				coordinates.add(coordinate);
//			}
//
//			for (int i = 0; i < coordinates.size(); i++) {
//				Log.e("test", "tmp: " + coordinates.get(i) + "\n" );
//			}
//
//			ActionFile.write(actions);
//			Log.e("test", "tmp: " + tmp);
//		}

//		Action tmp = null;
//		for (Action action: actions) {
//			if (action.getName().equals("暗殿boss")){
//				tmp = action;
//				break;
//			}
//		}
//		if (tmp != null){
//			List<Coordinate> coordinates = tmp.getCoordinates();
//
//			delete(coordinates, 1);
//
//			long lastTime = coordinates.get(coordinates.size() - 1).getTime();
//			Coordinate coordinate;
//			for (int i = 0; i < 1; i++) {
//				coordinate = new Coordinate(1013, 1829);
//				lastTime += 1000;
//				coordinate.setTime(lastTime);
//				coordinates.add(coordinate);
//			}
//
//            for (int i = 0; i < 56; i++) {
//
//				if (i % 7 == 0){
//					coordinate = new Coordinate(1013, 1829);
//					lastTime += 1000;
//					coordinate.setTime(lastTime);
//					coordinates.add(coordinate);
//
//					coordinate = new Coordinate(555,576);
//					lastTime += 1000;
//					coordinate.setTime(lastTime);
//					coordinates.add(coordinate);
//
//					coordinate = new Coordinate(351,1326);
//					lastTime += 2000;
//					coordinate.setTime(lastTime);
//					coordinates.add(coordinate);
//				}
//
//			    coordinate = new Coordinate(554,1664);
//                lastTime += 1000;
//                coordinate.setTime(lastTime);
//                coordinates.add(coordinate);
//
//				coordinate = new Coordinate(1053, 1299);
//				lastTime += 1000;
//				coordinate.setTime(lastTime);
//				coordinates.add(coordinate);
//
//                coordinate = new Coordinate(365, 1549);
//                lastTime += 1000;
//                coordinate.setTime(lastTime);
//                coordinates.add(coordinate);
//				lastTime += 5000;
//            }
//
////            for (int i = 0; i < 120; i++) {
////            	coordinate = new Coordinate(365, 1549);
////                lastTime += 3000;
////                coordinate.setTime(lastTime);
////                coordinates.add(coordinate);
////            }
//
//            for (int i = 0; i < 2; i++) {
//            	coordinate = new Coordinate(1013, 1829);
//                lastTime += 1000;
//                coordinate.setTime(lastTime);
//                coordinates.add(coordinate);
//            }
//
//			for (int i = 0; i < coordinates.size(); i++) {
//				Log.e("test", "tmp: " + coordinates.get(i) + "\n" );
//			}
//
//			ActionFile.write(actions);
//			Log.e("test", "tmp: " + tmp);
//		}

//		Action tmp = null;
//		for (Action action: actions) {
//			if (action.getName().equals("魔界入侵")){
//				tmp = action;
//				break;
//			}
//		}
//		if (tmp != null){
//			Action actionCopy = copy(tmp, "魔界入侵-吸血");
//			List<Coordinate> coordinates = actionCopy.getCoordinates();
//			for (Coordinate coordinate: coordinates) {
//				if (coordinate.getX() == 216 && coordinate.getY() ==1589 ){
//					coordinate.setX(852);
//					coordinate.setY(1599);
//				}
//			}
//			for (int i = 0; i < coordinates.size(); i++) {
//				Log.e("test", "tmp: " + coordinates.get(i) + "\n" );
//			}
//
//			actions.add(actionCopy);
//			ActionFile.write(actions);
//			Log.e("test", "tmp: " + actionCopy);
//		}

//		Action tmp = null;
//		for (Action action: actions) {
//			if (action.getName().equals("魔界入侵")){
//				tmp = action;
//				break;
//			}
//		}
//		if (tmp != null){
//			Action actionCopy = copy(tmp, "魔界入侵-烛龙");
//			List<Coordinate> coordinates = actionCopy.getCoordinates();
//			for (Coordinate coordinate: coordinates) {
//				if (coordinate.getX() == 216 && coordinate.getY() ==1589 ){
//					coordinate.setX(653);
//					coordinate.setY(1593);
//				}
//			}
//			for (int i = 0; i < coordinates.size(); i++) {
//				Log.e("test", "tmp: " + coordinates.get(i) + "\n" );
//			}
//
//			actions.add(actionCopy);
//			ActionFile.write(actions);
//			Log.e("test", "tmp: " + actionCopy);
//		}

//	Action tmp = null;
//	for (Action action: actions) {
//		if (action.getName().equals("暗殿boss")){
//			tmp = action;
//			break;
//		}
//	}
//	if (tmp != null){
//		List<Coordinate> coordinates = tmp.getCoordinates();
//		Action actionCopy = copy(tmp, "暗殿boss-自定义");
//			for (int i = 0; i < coordinates.size(); i++) {
//				Log.e("test", "tmp: " + coordinates.get(i) + "\n" );
//			}
//
//			actions.add(actionCopy);
//			ActionFile.write(actions);
//			Log.e("test", "tmp: " + actionCopy);
//		}


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
	}

	private void delete(List<Coordinate> coordinates, int startIndex) {
		List<Coordinate> delete = new ArrayList<Coordinate>();
		for (int i = startIndex; i < coordinates.size(); i++) {
            delete.add(coordinates.get(i));
        }
		coordinates.removeAll(delete);
	}

	private Action copy(Action source, String name){
			List<Coordinate> coordinates = new ArrayList<Coordinate>();
			for (Coordinate coordinate: source.getCoordinates()) {
				Coordinate coordinate1;
				if (coordinate.getX() == 911 && coordinate.getY() == 1130){
					coordinate1 = new Coordinate(909, 1018);
				}else{
					coordinate1 = new Coordinate(coordinate.getX(), coordinate.getY());
				}
				coordinate1.setTime(coordinate.getTime());
				coordinates.add(coordinate1);
			}
			Action action = new Action();
			action.setName(name);
			action.setCoordinates(coordinates);
			action.setActionTime(source.getActionTime());
			return action;
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
