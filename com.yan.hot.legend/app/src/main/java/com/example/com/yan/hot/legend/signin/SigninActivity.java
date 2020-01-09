package com.example.com.yan.hot.legend.signin;

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

public class SigninActivity extends Activity implements View.OnClickListener {
    private RecyclerView list;
    private List<SigninObject> signinObjects = new ArrayList<>();
    private Button devote_save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        initData();
        initView();
    }

    private void initData() {
        signinObjects = SigninManager.getSignin();
    }

    private void initView() {
        list = (RecyclerView) findViewById(R.id.list);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(new SigninAdapter(signinObjects));
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
                        updateTime(signinObjects);
                        SigninFile.write(signinObjects);
                        emitter.onNext(true);
                        emitter.onComplete();
                    }
                }).subscribeOn(Schedulers.single()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        Toast.makeText(SigninActivity.this, "成功", Toast.LENGTH_LONG).show();
                    }
                });
                break;
        }
    }

    private void updateTime(List<SigninObject> signinObjectsNew){
        List<SigninObject> oldDevoteObject = SigninFile.read();
        if (oldDevoteObject == null || oldDevoteObject.isEmpty()){
            oldDevoteObject = SigninManager.getDefault();
        }
        for (SigninObject oldObj: oldDevoteObject) {
            for (SigninObject newObj: signinObjectsNew) {
                if (oldObj.getClientType() == newObj.getClientType()){
                    if (oldObj.getIndex() != newObj.getIndex()){
                        SigninManager.updateTime(newObj);
                    }
                    break;
                }
            }
        }
    }
}
