package phone.nikolas.com.rxjavasamplemvvm.activity.main;

import java.util.List;


/**
 * Created by Pleret on 3/11/2017.
 */

public interface MainView {

    void onSuccessFetchData(List<String> emailData);
    void onErrorFetchData(String error);
}
