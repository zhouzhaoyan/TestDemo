package com.example.com.yan.hot.legend.devote;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.com.yan.hot.legend.R;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import static com.example.com.yan.hot.legend.devote.DevoteManager.getDefault;

public class DevoteActivity extends Activity implements View.OnClickListener {

    private RecyclerView list;
    private List<DevoteObject> devoteObjects = new ArrayList<>();
    private Button devote_save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_devote);
        initData();
        initView();
    }

    private void initData() {
        devoteObjects = DevoteFile.read();
        if (devoteObjects == null){
            devoteObjects = getDefault();
        }
    }

    private void initView() {
        list = (RecyclerView) findViewById(R.id.list);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(new DevoteAdapter(devoteObjects));
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
                        DevoteFile.write(devoteObjects);
                        emitter.onNext(true);
                        emitter.onComplete();
                    }
                }).subscribeOn(Schedulers.single()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        Toast.makeText(DevoteActivity.this,"成功",Toast.LENGTH_LONG).show();
                        finish();
                    }
                });
                break;
        }
    }
}
