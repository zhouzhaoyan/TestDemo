package com.example.com.yan.hot.legend.recognition;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import com.baidu.ocr.sdk.OCR;
import com.baidu.ocr.sdk.OnResultListener;
import com.baidu.ocr.sdk.exception.OCRError;
import com.baidu.ocr.sdk.model.AccessToken;
import com.baidu.ocr.sdk.model.GeneralBasicParams;
import com.baidu.ocr.sdk.model.GeneralResult;
import com.baidu.ocr.sdk.model.WordSimple;
import com.zsctc.remote.touch.bytes.LogManager;

import java.io.File;

/**
 * 文字识别工具
 */
public class CharacterRecognitionManager {
    private boolean hasGotToken = false;
    private Context context;

    private static final CharacterRecognitionManager ourInstance = new CharacterRecognitionManager();

    public static CharacterRecognitionManager getInstance() {
        return ourInstance;
    }

    private CharacterRecognitionManager() {
    }

    public void init(Context context) {
        this.context = context;
        initAccessTokenWithAkSk(context);
    }

    public void getCharacter(String path, ServiceListener serviceListener) {
        if (hasGotToken) {
            recGeneralBasic(context, path, serviceListener);
        } else {
            LogManager.newInstance().writeMessage("service token fail");
            if (serviceListener != null){
                serviceListener.onTokenFail();
            }
            initAccessTokenWithAkSk(context);
        }
    }

    /**
     * 用明文ak，sk初始化
     */
    private void initAccessTokenWithAkSk(final Context context) {
        OCR.getInstance(context).initAccessTokenWithAkSk(new OnResultListener<AccessToken>() {
            @Override
            public void onResult(AccessToken result) {
                String token = result.getAccessToken();
                hasGotToken = true;
                LogManager.newInstance().writeMessage("AK，SK方式获取token成功，" + token);
                showToast("初始化成功");
            }

            @Override
            public void onError(OCRError error) {
                error.printStackTrace();
                LogManager.newInstance().writeMessage("AK，SK方式获取token失败，" + error.getMessage());
                showToast("AK，SK方式获取token失败");
            }
        }, context.getApplicationContext(), "XbwoHfAhT7RUC8DOjq0ZtH5D", "l9mkyFqLp0lHm1Ckpl5BNKmEkQQv7WpS");
    }

    private void showToast(final String message) {
        new Handler(context.getMainLooper()) {
            @Override
            public void handleMessage(Message msg) {
                Toast.makeText(context, message, Toast.LENGTH_LONG).show();
            }
        }.sendEmptyMessage(0);
    }

    /**
     * 自定义license的文件路径和文件名称，以license文件方式初始化
     */
    private void initAccessTokenLicenseFile(Context context) {
        OCR.getInstance(context).initAccessToken(new OnResultListener<AccessToken>() {
            @Override
            public void onResult(AccessToken accessToken) {
                String token = accessToken.getAccessToken();
                hasGotToken = true;
                LogManager.newInstance().writeMessage("AK，SK方式获取token成功，" + token);
            }

            @Override
            public void onError(OCRError error) {
                error.printStackTrace();
                LogManager.newInstance().writeMessage("AK，SK方式获取token失败，" + error.getMessage());
            }
        }, "aip.license", context.getApplicationContext());
    }

    // 调用通用文字识别服务
    private static void recGeneralBasic(Context ctx, String filePath, final ServiceListener listener) {
        GeneralBasicParams param = new GeneralBasicParams();
        param.setDetectDirection(true);
        param.setImageFile(new File(filePath));
        //高精度
        OCR.getInstance(ctx).recognizeAccurateBasic(param, new OnResultListener<GeneralResult>() {
            @Override
            public void onResult(GeneralResult result) {
                StringBuilder sb = new StringBuilder();
                for (WordSimple wordSimple : result.getWordList()) {
                    WordSimple word = wordSimple;
                    sb.append(word.getWords());
                    sb.append("\n");
                }
                LogManager.newInstance().writeMessage("service success，" + result.getJsonRes());

                if (listener != null) {
                    listener.onSuccessResult(result.getJsonRes());
                }
            }

            @Override
            public void onError(OCRError error) {
                LogManager.newInstance().writeMessage("service onError，" + error.getMessage());
                if (listener != null) {
                    listener.onFailResult(error.getMessage());
                }
            }
        });
    }

    public interface ServiceListener {
        void onSuccessResult(String result);

        void onTokenFail();

        void onFailResult(String result);
    }
}
