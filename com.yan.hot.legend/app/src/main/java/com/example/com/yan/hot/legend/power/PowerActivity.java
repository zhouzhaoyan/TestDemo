package com.example.com.yan.hot.legend.power;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.com.yan.hot.legend.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Timer;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import static com.example.com.yan.hot.legend.power.PowerManager.getDefault;

public class PowerActivity extends Activity implements View.OnClickListener {

    private RecyclerView list;
    private List<PowerObject> powerObjects = new ArrayList<>();
    private Button devote_save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_power);
        initData();
        initView();
    }

    private void initData() {
        powerObjects = PowerFile.read();
        List<PowerObject> aDefault = getDefault();
        if (powerObjects == null) {
            powerObjects = aDefault;
        }
        List<PowerObject> add = new ArrayList<>();
        for (PowerObject defaultPowerObject : aDefault){
            if (!powerObjects.contains(defaultPowerObject)){
                add.add(defaultPowerObject);
            }
        }
        powerObjects.addAll(0, add);
    }

    private void initView() {
        list = (RecyclerView) findViewById(R.id.list);
        list.setLayoutManager(new LinearLayoutManager(this));
        List<PowerObject> delete = new ArrayList<>();
        for (PowerObject powerObject: powerObjects) {
            if (powerObject.getAccountName() == null){
                delete.add(powerObject);
            }
        }
        powerObjects.removeAll(delete);
        Log.e("test", "initView: " + powerObjects );
        Collections.sort(powerObjects, new Comparator<PowerObject>() {
            @Override
            public int compare(PowerObject lhs, PowerObject rhs) {
                if (lhs.getValue() - rhs.getValue() != 0){
                    //战力
                    return (lhs.getValue() - rhs.getValue()) == 0 ? 0 : (lhs.getValue() - rhs.getValue()) > 0 ? 1 : -1;
                } else {
                    //更新时间
                    return (lhs.getDate() - rhs.getDate()) == 0 ? 0 : (lhs.getDate() - rhs.getDate()) > 0 ? 1 : -1;
                }
            }
        });
        list.setAdapter(new PowerAdapter(powerObjects));
        devote_save = (Button) findViewById(R.id.devote_save);
        devote_save.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.devote_save:
                getCurrentFocus().clearFocus();
                Observable.create(new ObservableOnSubscribe<Boolean>() {
                    @Override
                    public void subscribe(ObservableEmitter<Boolean> emitter) throws Exception {
                        updateTime(powerObjects);
                        PowerFile.write(powerObjects);
                        emitter.onNext(true);
                        emitter.onComplete();
                    }
                }).subscribeOn(Schedulers.single()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        Toast.makeText(PowerActivity.this, "成功", Toast.LENGTH_LONG).show();
                        finish();
                    }
                });
                break;
        }
    }

    private void updateTime(List<PowerObject> newPowerObjects){
        List<PowerObject> oldPowerObjects = PowerFile.read();
        if (oldPowerObjects == null || oldPowerObjects.isEmpty()){
            oldPowerObjects = PowerManager.getDefault();
        }
        for (PowerObject oldPowerObject: oldPowerObjects) {
            for (PowerObject newPowerObject: newPowerObjects) {
                if (oldPowerObject.getClientType() == newPowerObject.getClientType()){
                    if (oldPowerObject.getValue() != newPowerObject.getValue()
                        || oldPowerObject.getReincarn() != newPowerObject.getReincarn()){
                        PowerManager.updateTime(newPowerObject);
                    }
                    break;
                }
            }
        }
    }
}
