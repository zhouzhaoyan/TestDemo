package com.example.com.yan.hot.legend.runstate;

import com.zsctc.remote.touch.bytes.ClickTool;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by on 2018/10/13.
 */
public class ActionRun {

    private static List<ClickTool.ClientType> noRun = new ArrayList<>();

    static {
        noRun.add(ClickTool.ClientType.游戏07073);
        noRun.add(ClickTool.ClientType.热血单机h5双开);
    }


    @Override
    public String toString() {
        return "ActionRun{" +
                "actionStates=" + actionStates +
                ", modeType=" + modeType +
                '}';
    }

    private List<ActionState> actionStates = new ArrayList<>();
    private ModeType modeType = ModeType.TASK;

    public ActionRun() {
    }

    public ActionRun(ModeType modeType) {
        ClickTool.ClientType[] clientTypes = ClickTool.ClientType.values();


        for (ClickTool.ClientType clientType : clientTypes) {
            actionStates.add(new ActionState(clientType, noRun.contains(clientType) ? false : true));
        }
    }

    public void setActionStates(ClickTool.ClientType clientType, boolean run) {
        for (ActionState state : actionStates) {
            if (state.getClientType().equals(clientType)) {
                state.setRun(run);
                break;
            }
        }
    }

    public boolean isRun(ClickTool.ClientType clientType) {
        for (ActionState state : actionStates) {
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
}
