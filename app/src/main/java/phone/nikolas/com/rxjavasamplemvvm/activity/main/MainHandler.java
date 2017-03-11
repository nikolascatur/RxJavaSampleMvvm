package phone.nikolas.com.rxjavasamplemvvm.activity.main;

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
}
