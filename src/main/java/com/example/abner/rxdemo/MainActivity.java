package com.example.abner.rxdemo;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.orhanobut.logger.Logger;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    String TAG = "abnerLog";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        CompositeDisposable c;

//        Observable observable = Observable.just(4,5,6,7,8);
//        observable.subscribe(observer);
//        Integer [] integers = {1,2,3,5};
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        Observable.fromArray(integers)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<Integer>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//                Log.d(TAG, "subscribe");
//            }
//
//            @Override
//            public void onNext(Integer value) {
//                Logger.d("" + value);
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Log.d(TAG, "error");
//            }
//
//            @Override
//            public void onComplete() {
//                Log.d(TAG, "complete");
//            }
//        });

        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    Observer<Integer> observer = new Observer<Integer>() {
        @Override
        public void onSubscribe(Disposable d) {
            Log.d(TAG, "subscribe");
        }

        @Override
        public void onNext(Integer value) {

            Logger.e("" + value);
        }

        @Override
        public void onError(Throwable e) {
            Log.d(TAG, "error");
        }

        @Override
        public void onComplete() {
            Log.d(TAG, "complete");
        }
    };
    Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
        @Override
        public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
            emitter.onNext(1);
            emitter.onNext(2);
            emitter.onNext(3);
            Logger.e("observable");
//            emitter.onComplete();
        }
    });
}
