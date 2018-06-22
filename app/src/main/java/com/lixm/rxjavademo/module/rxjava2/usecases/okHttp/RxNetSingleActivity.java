package com.lixm.rxjavademo.module.rxjava2.usecases.okHttp;

import com.google.gson.Gson;
import com.lixm.rxjavademo.model.MobileAddress;
import com.lixm.rxjavademo.module.rxjava2.operators.item.RxOperatorBaseActivity;
import com.lixm.rxjavademo.utils.LogUtil;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.ResponseBody;


/**
 * 采用OkHttp3 配合map，doOnNext，线程切换做简单的网络请求
 *
 * 1、通过Observable.create() 方法，调用OkHttp网络请求。
 * 2、通过map操作符，结合Gson，将Response 转换为bean类；
 * 3、通过doOnNext()方法，解析bean中的数据，并进行数据库存储等操作；
 * 4、调度线程，在子线程进行耗时操作任务，在主线程更新UI;
 * 5、通过subscibe(),根据请求成功或者失败来更新UI
 *
 * @author Lixm
 * @date 2018/6/22
 */
public class RxNetSingleActivity extends RxOperatorBaseActivity {

    private static final String TAG="RxNetSingleActivity";

    @Override
    protected String getSubTitle() {
        return "单一的网络请求";
    }

    @Override
    protected void doSomething() {
        Observable.create(new ObservableOnSubscribe<Response>() {
            @Override
            public void subscribe(ObservableEmitter<Response> e) throws Exception {
               Builder builder=new Builder()
                       .url("http://api.avatardata.cn/MobilePlace/LookUp?key=ec47b85086be4dc8b5d941f5abd37a4e&mobileNumber=13021671512")
                       .get();
                Request request=builder.build();
                Call call=new OkHttpClient().newCall(request);
                Response response=call.execute();
                e.onNext(response);
            }
        }).map(new Function<Response, MobileAddress>() {
            @Override
            public MobileAddress apply(Response response) throws Exception {
                LogUtil.i(TAG,"map 线程："+Thread.currentThread().getName()+"\n");
                if (response.isSuccessful()){
                    ResponseBody body=response.body();
                    if (body!=null){
                        LogUtil.w(TAG,"map：转换前："+response.body());
                        return new Gson().fromJson(body.string(),MobileAddress.class);
                    }
                }
                return null;
            }
        }).observeOn(AndroidSchedulers.mainThread())
        .doOnNext(new Consumer<MobileAddress>() {
            @Override
            public void accept(MobileAddress mobileAddress) throws Exception {
                LogUtil.i(TAG,"doOnNext 线程："+Thread.currentThread().getName()+"\n");
                mRxOperatorsText.append("\ndoOnNext 线程："+Thread.currentThread().getName()+"\n");
                LogUtil.w(TAG,"doOnNext:保存成功："+mobileAddress.toString());
                mRxOperatorsText.append("doOnNext：保存成功："+mobileAddress.toString()+"\n");
            }
        }).subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Consumer<MobileAddress>() {
            @Override
            public void accept(MobileAddress mobileAddress) throws Exception {
                LogUtil.w(TAG, "subscribe 线程：" + Thread.currentThread().getName() + "\n");
                mRxOperatorsText.append("\nsubscribe 线程：" + Thread.currentThread().getName() + "\n");
                LogUtil.i(TAG, "成功：" + mobileAddress.toString());
                mRxOperatorsText.append("成功：" + mobileAddress.toString() + "\n");

            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                LogUtil.i(TAG,"subscribe 线程："+Thread.currentThread().getName()+"\n");
                mRxOperatorsText.append("\nsubscribe 线程："+Thread.currentThread().getName()+"\n");

                LogUtil.w(TAG,"失败："+throwable.getMessage()+"\n");
                mRxOperatorsText.append("失败："+throwable.getMessage()+"\n");
            }
        })


        ;

    }
}
