package phone.nikolas.com.rxjavasamplemvvm.depen.module;

import android.content.Context;

import dagger.Module;

/**
 * Created by Pleret on 3/11/2017.
 */
@Module
public class AppModule {
    private Context context;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
