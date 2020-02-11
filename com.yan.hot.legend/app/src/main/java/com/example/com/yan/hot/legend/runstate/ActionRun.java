package com.example.com.yan.hot.legend.runstate;

import com.example.com.yan.hot.legend.devote.DevoteManager;
import com.zsctc.remote.touch.bytes.ClickTool;
import com.zsctc.remote.touch.bytes.TimeUtil;

import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;

/**
 * Created by on 2018/10/13.
 */
public class ActionRun {

    private static List<ClickTool.ClientType> noRun = new ArrayList<>();

    static {
        noRun.add(ClickTool.ClientType.客娱);
        noRun.add(ClickTool.ClientType.乐趣双开);
        noRun.add(ClickTool.ClientType.乐趣网页双开);
        noRun.add(ClickTool.ClientType.乐趣qq浏览器);
    }
    //不跑简单模式
    private static List<ClickTool.ClientType> noRunForSimple = new ArrayList<>();

    static {
        noRunForSimple.add(ClickTool.ClientType.牛刀);
        noRunForSimple.add(ClickTool.ClientType.客娱);
        noRunForSimple.add(ClickTool.ClientType.牛刀网页);
        noRunForSimple.add(ClickTool.ClientType.核弹头网页);

        noRunForSimple.add(ClickTool.ClientType.热血单机);

        noRunForSimple.add(ClickTool.ClientType.核弹头);
        noRunForSimple.add(ClickTool.ClientType.牛刀猎豹);

        noRunForSimple.add(ClickTool.ClientType.热血单机双开);
        noRunForSimple.add(ClickTool.ClientType.牛刀qq浏览器);

        noRunForSimple.add(ClickTool.ClientType.核弹头双开);
        noRunForSimple.add(ClickTool.ClientType.牛刀浏览器360);

        noRunForSimple.add(ClickTool.ClientType.牛刀网页双开);
    }


    private List<ActionState> actionStates = new ArrayList<>();
    private ModeType modeType = ModeType.TASK;
    private boolean auto = true;
    private boolean autoCheckPoint = true;
    //重新执行失败的任务的次数
    private int repeatTask = 0;


    public ActionRun() {
    }

    public ActionRun(ModeType modeType) {
        ClickTool.ClientType[] clientTypes = ClickTool.ClientType.values();
        this.modeType = modeType;

        switch (modeType){
            case SIMPLE:
                long second = TimeUtil.getRemainInDay();
                int time = (int) (second/60/6) - 2;
                boolean run;
                int i = 0;
                for (ClickTool.ClientType clientType : clientTypes) {
                    run = !noRunForSimple.contains(clientType) && !DevoteManager.isMax(clientType);
                    if (run){
                        if (i > time){
                            run = false;
                        }
                        i ++;
                    }
                    actionStates.add(new ActionState(clientType, run));
                }
                Timber.e("actionStates:" +actionStates);
                break;
            default:
                for (ClickTool.ClientType clientType : clientTypes) {
                    actionStates.add(new ActionState(clientType, !noRun.contains(clientType) && !DevoteManager.isMax(clientType)));
                }
                break;
        }

    }

    public void setActionStates(ClickTool.ClientType clientType, boolean run) {
        for (ActionState state : actionStates) {
            if (state.getClientType() == null){
                continue;
            }
            if (state.getClientType().equals(clientType)) {
                state.setRun(run);
                return;
            }
        }
        actionStates.add(new ActionState(clientType,run));
    }

    public boolean isRun(ClickTool.ClientType clientType) {
        for (ActionState state : actionStates) {
            if (state.getClientType() == null){
                continue;
            }
            if (state.getClientType().equals(clientType)) {
                return state.isRun();
            }
        }
        return false;
    }

    public List<ActionState> getActionStates() {
        return actionStates;
    }

    public void setModeType(ModeType modeType) {
        this.modeType = modeType;
    }

    public ModeType getModeType() {
        return modeType;
    }

    public boolean isAuto() {
        return auto;
    }

    public void setAuto(boolean auto) {
        this.auto = auto;
    }

    public boolean isAutoCheckPoint() {
        return autoCheckPoint;
    }

    public void setAutoCheckPoint(boolean autoCheckPoint) {
        this.autoCheckPoint = autoCheckPoint;
    }

    public int getRepeatTask() {
        return repeatTask;
    }

    public void setRepeatTask(int repeatTask) {
        this.repeatTask = repeatTask;
    }

    public class ActionState {
        public ActionState() {
        }

        private ClickTool.ClientType clientType;
        private boolean run;

        public ActionState(ClickTool.ClientType clientType, boolean run) {
            this.clientType = clientType;
            this.run = run;
        }

        public ClickTool.ClientType getClientType() {
            return clientType;
        }

        public void setClientType(ClickTool.ClientType clientType) {
            this.clientType = clientType;
        }

        public boolean isRun() {
            return run;
        }

        public void setRun(boolean run) {
            this.run = run;
        }

        @Override
        public String toString() {
            return "ActionState{" +
                    "clientType=" + clientType +
                    ", run=" + run +
                    '}';
        }
    }

    public enum ModeType {
        TASK, DAILY, DAILY_TASK, SIMPLE, NIGHT
    }

    @Override
    public String toString() {
        return "ActionRun{" +
                "actionStates=" + actionStates +
                ", modeType=" + modeType +
                ", auto=" + auto +
                ", autoCheckPoint=" + autoCheckPoint +
                ", repeatTask=" + repeatTask +
                '}';
    }
}
