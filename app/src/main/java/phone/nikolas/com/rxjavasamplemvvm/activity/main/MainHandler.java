package phone.nikolas.com.rxjavasamplemvvm.activity.main;

import android.content.Intent;
import android.databinding.Bindable;

/**
 * Created by Pleret on 3/11/2017.
 */

public class MainHandler {
    private MainPresenter presenter;

    public MainPresenter getPresenter() {
        return presenter;
    }

    public void setPresenter(MainPresenter presenter) {
        this.presenter = presenter;
    }

    public void clickButtonRegistration(){
        presenter.setText();
    }

    public void clickButtonVisible(){
//        presenter.setVisible();
        presenter.showInputAddress();

    }

    public void clickFetchEmail(){
        presenter.getEmailList();
    }


}
