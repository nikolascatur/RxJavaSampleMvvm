package phone.nikolas.com.rxjavasamplemvvm.depen.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.RealmConfiguration;
import phone.nikolas.com.rxjavasamplemvvm.db.RealmConnection;

/**
 * Created by Pleret on 4/5/2017.
 */
@Module
public class DbModule  {

    @Provides
    @Singleton
    @SuppressWarnings("unused")
    public RealmConnection providesRealm(){
        return new RealmConnection();
    }

}
