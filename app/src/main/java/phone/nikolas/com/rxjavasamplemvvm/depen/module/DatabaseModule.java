package phone.nikolas.com.rxjavasamplemvvm.depen.module;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import phone.nikolas.com.rxjavasamplemvvm.model.Note;
import phone.nikolas.com.rxjavasamplemvvm.model.Notes;

/**
 * Created by Pleret on 3/25/2017.
 */
@Module
public class DatabaseModule {

    public DatabaseModule() {

    }

    @Provides
    @Singleton
    @SuppressWarnings("unused")
    public Notes notesList() {
        Log.d("TAG","new Notessssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss");

        return new Notes();
    }


}
