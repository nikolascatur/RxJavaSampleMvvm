package phone.nikolas.com.rxjavasamplemvvm.networking;

import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Pleret on 3/12/2017.
 */

public class Service {

    private final NetworkService networkService;

    public Service(NetworkService networkService) {
        this.networkService = networkService;
    }

    public Subscription getEmails(final GetEmailsCallback callback) {
        return networkService.getEmails()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends List<String>>>() {
                    @Override
                    public Observable<? extends List<String>> call(Throwable throwable) {
                        return Observable.error(throwable);
                    }
                })
                .subscribe(new Subscriber<List<String>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(e.getMessage());
                    }

                    @Override
                    public void onNext(List<String> emailData) {
                        callback.onSuccess(emailData);
                    }
                });

    }

    public interface GetEmailsCallback {
        void onSuccess(List<String> emailData);

        void onError(String error);
    }

}
