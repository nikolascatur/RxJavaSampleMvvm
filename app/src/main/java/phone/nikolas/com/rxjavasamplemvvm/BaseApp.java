package phone.nikolas.com.rxjavasamplemvvm;

import android.app.Application;

import dagger.internal.DaggerCollections;
import phone.nikolas.com.rxjavasamplemvvm.depen.componen.AppComponent;
import phone.nikolas.com.rxjavasamplemvvm.depen.componen.DaggerAppComponent;
import phone.nikolas.com.rxjavasamplemvvm.depen.module.AppModule;
import phone.nikolas.com.rxjavasamplemvvm.depen.module.NetworkModule;

/**
 * Created by Pleret on 3/11/2017.
 */

public class BaseApp extends Application{

    private AppComponent mAppComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        setmAppComponent(DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule())
                .build());
    }

    public AppComponent getmAppComponent() {
        return mAppComponent;
    }

    public void setmAppComponent(AppComponent mAppComponent) {
        this.mAppComponent = mAppComponent;
    }
}
