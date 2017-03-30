package phone.nikolas.com.rxjavasamplemvvm.activity.main;

import android.view.View;

import java.util.List;

import phone.nikolas.com.rxjavasamplemvvm.base.BasePresenter;
import phone.nikolas.com.rxjavasamplemvvm.networking.Service;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Pleret on 3/11/2017.
 */

public class MainPresenter extends BasePresenter<MainView,MainViewModel> {

    private Service service;
    private CompositeSubscription subscriptions;
    public MainPresenter(Service service){
        this.service = service;
        subscriptions = new CompositeSubscription();
    }

    public void setText(){
        viewModel.setEmailText("nikolas test ");

    }

    public void showInputAddress(){
        view.moveToInputAddress();
    }

    public void setVisible(){
        viewModel.setVisibilityEmail(View.GONE);
    }


    public void getEmailList(){
        final Subscription subscription = service.getEmails(new Service.GetEmailsCallback() {
            @Override
            public void onSuccess(List<String> emailData) {
                view.onSuccessFetchData(emailData);
            }

            @Override
            public void onError(String error) {
                view.onErrorFetchData(error);
            }
        });
        subscriptions.add(subscription);
    }

    public void onStop(){
        if(!subscriptions.isUnsubscribed()){
            subscriptions.clear();
        }

    }

    public void showAddNote(){
        view.showInputNote();
    }

}
