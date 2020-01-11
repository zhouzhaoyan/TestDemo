package com.example.com.yan.hot.legend.plug;

import android.util.Log;

import com.example.com.yan.hot.legend.ClickService;
import com.example.com.yan.hot.legend.signin.SigninFile;
import com.example.com.yan.hot.legend.signin.SigninManager;
import com.example.com.yan.hot.legend.signin.SigninObject;
import com.yan.hot.legend.action.Coordinate;
import com.zsctc.remote.touch.bytes.ClickTool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.com.yan.hot.legend.signin.SigninManager.getSignin;

/**
 * Created by on 2018/10/26.
 * 签到
 */
public class PlugSignin {
    private Coordinate coordinate = new Coordinate(399, 298);
    private List<List<Coordinate>> siginCoordinates = new ArrayList<>();

    {
        siginCoordinates.add(Arrays.asList(new Coordinate(190, 320)));
        siginCoordinates.add(Arrays.asList(new Coordinate(350, 320), new Coordinate(700, 1300), new Coordinate(1000, 1500)));
        siginCoordinates.add(Arrays.asList(new Coordinate(550, 320)));
        siginCoordinates.add(Arrays.asList(new Coordinate(750, 320)));
        siginCoordinates.add(Arrays.asList(new Coordinate(900, 320)));

        siginCoordinates.add(Arrays.asList(new Coordinate(190, 520)));
        siginCoordinates.add(Arrays.asList(new Coordinate(350, 520), new Coordinate(700, 1300), new Coordinate(1000, 1500)));
        siginCoordinates.add(Arrays.asList(new Coordinate(550, 520)));
        siginCoordinates.add(Arrays.asList(new Coordinate(750, 520)));
        siginCoordinates.add(Arrays.asList(new Coordinate(900, 520)));

        siginCoordinates.add(Arrays.asList(new Coordinate(190, 720)));
        siginCoordinates.add(Arrays.asList(new Coordinate(350, 720), new Coordinate(700, 1300), new Coordinate(1000, 1500)));
        siginCoordinates.add(Arrays.asList(new Coordinate(550, 720)));
        siginCoordinates.add(Arrays.asList(new Coordinate(750, 720)));
        siginCoordinates.add(Arrays.asList(new Coordinate(900, 720)));

        siginCoordinates.add(Arrays.asList(new Coordinate(190, 920)));
        siginCoordinates.add(Arrays.asList(new Coordinate(350, 920), new Coordinate(700, 1300)));
        siginCoordinates.add(Arrays.asList(new Coordinate(550, 920)));
        siginCoordinates.add(Arrays.asList(new Coordinate(750, 920)));
        siginCoordinates.add(Arrays.asList(new Coordinate(900, 920)));

        siginCoordinates.add(Arrays.asList(new Coordinate(190, 1120)));
        siginCoordinates.add(Arrays.asList(new Coordinate(350, 1120), new Coordinate(700, 1300)));
        siginCoordinates.add(Arrays.asList(new Coordinate(550, 1120)));
        siginCoordinates.add(Arrays.asList(new Coordinate(750, 1120)));
        siginCoordinates.add(Arrays.asList(new Coordinate(900, 1120)));

        siginCoordinates.add(Arrays.asList(new Coordinate(190, 1320)));
        siginCoordinates.add(Arrays.asList(new Coordinate(350, 1320), new Coordinate(700, 1300)));
        siginCoordinates.add(Arrays.asList(new Coordinate(550, 1320)));
        siginCoordinates.add(Arrays.asList(new Coordinate(750, 1320)));
        siginCoordinates.add(Arrays.asList(new Coordinate(900, 1320), new Coordinate(700, 1300)));

    }

    public void runClick(ClickService clickService, ClickTool.ClientType clientType, Coordinate newCoordinate) {

        if (newCoordinate.getX() != coordinate.getX() || newCoordinate.getY() != coordinate.getY()) {
            return;
        }

        Log.e("test", "runClick: PlugSigin");

        List<SigninObject> signinObjects = getSignin();
        SigninObject signinObject = null;
        for (SigninObject signinObjectTmp: signinObjects) {
            if (signinObjectTmp.getClientType() == clientType){
                signinObject = signinObjectTmp;
                break;
            }
        }

        if (signinObject == null || signinObject.getIndex() <= 0 || signinObject.getDate() == SigninManager.getCurrentTime()) {
            return;
        }

        signinObject.setIndex(signinObject.getIndex() + 1);
        signinObject.setDate(SigninManager.getCurrentTime());
        if (signinObject.getIndex() > siginCoordinates.size()){
            signinObject.setIndex(1);
        }

        if (clickService != null){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            switch (clientType){
                case 火树遨游:
                case 趣头条遨游:
                case 玩蛋遨游:
                    break;
                default:
                    clickService.clickTool.swipe(600, 300, 600, 1600);
                    break;
            }

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            List<Coordinate> coordinates = siginCoordinates.get(signinObject.getIndex() - 1);
            for (Coordinate coordinate : coordinates) {
                clickService.runClick(1000, coordinate);
            }
        }

        SigninFile.write(signinObjects);
    }
}
