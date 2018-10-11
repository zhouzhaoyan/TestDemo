package com.example.com.yan.hot.legend;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.yan.hot.legend.action.Action;
import com.yan.hot.legend.action.ActionFile;

import java.util.ArrayList;
import java.util.List;

public class AllActionActivity extends Activity {

    private ListView actionsView;
    private List<Action> actions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_action);

        actionsView = (ListView) findViewById(R.id.action_list);

        actions = ActionFile.read();
        if (actions == null){
            actions = new ArrayList<>();
        }
        ActionAdapter actionAdapter = new ActionAdapter(this, actions);
        actionsView.setAdapter(actionAdapter);
    }
}
