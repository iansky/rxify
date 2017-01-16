package com.ragdroid.rxify.codelab;

import com.ragdroid.rxify.codelab.presenter.BaseCLPresenter;
import com.ragdroid.rxify.core.BaseSchedulerProvider;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;

/**
 * Created by garimajain on 15/01/17.
 */

public class ChillPresenter extends BaseCLPresenter<String> implements CodeLabContract.Presenter {

    //Input
    Observable<String> inputValues = Observable.fromIterable(
            Arrays.asList("Color : Red", "Size : M", "Occasion : Casual", "Type : T-Shirt"));

    //TODO Concatenate filters to send to API
    //Print "Color : Red | Size : M | Occasion : Casual | Type : T-Shirt"

    @Inject
    public ChillPresenter(BaseSchedulerProvider provider) {
        super(provider);
    }

    @Override
    protected Disposable getDisposable() {
        return inputValues
                .compose(lazyTransformer)
                .subscribe(next, error, complete);
    }
}
