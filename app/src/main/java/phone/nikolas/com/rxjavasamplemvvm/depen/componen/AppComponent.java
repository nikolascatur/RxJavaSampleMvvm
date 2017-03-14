package phone.nikolas.com.rxjavasamplemvvm.depen.componen;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;
import phone.nikolas.com.rxjavasamplemvvm.activity.main.MainActivity;
import phone.nikolas.com.rxjavasamplemvvm.depen.module.AppModule;
import phone.nikolas.com.rxjavasamplemvvm.depen.module.NetworkModule;
import phone.nikolas.com.rxjavasamplemvvm.networking.NetworkService;

/**
 * Created by Pleret on 3/11/2017.
 */

@Singleton
@Component(modules = {AppModule.class, NetworkModule.class})
public interface AppComponent {
    void inject(MainActivity mainActivity);
}
