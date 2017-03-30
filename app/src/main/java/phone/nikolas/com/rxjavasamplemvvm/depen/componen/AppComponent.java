package phone.nikolas.com.rxjavasamplemvvm.depen.componen;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;
import phone.nikolas.com.rxjavasamplemvvm.activity.detailnote.DetailNoteActivity;
import phone.nikolas.com.rxjavasamplemvvm.activity.inputaddress.InputAddressActivity;
import phone.nikolas.com.rxjavasamplemvvm.activity.main.MainActivity;
import phone.nikolas.com.rxjavasamplemvvm.activity.note.NoteActivity;
import phone.nikolas.com.rxjavasamplemvvm.depen.module.AppModule;
import phone.nikolas.com.rxjavasamplemvvm.depen.module.DatabaseModule;
import phone.nikolas.com.rxjavasamplemvvm.depen.module.NetworkModule;
import phone.nikolas.com.rxjavasamplemvvm.model.Notes;
import phone.nikolas.com.rxjavasamplemvvm.networking.NetworkService;

/**
 * Created by Pleret on 3/11/2017.
 */

@Singleton
@Component(modules = {AppModule.class, NetworkModule.class, DatabaseModule.class})
public interface AppComponent {
    void inject(MainActivity mainActivity);
    void inject(InputAddressActivity inputAddressActivity);
    void inject(NoteActivity noteActivity);
    void inject(DetailNoteActivity detailNoteActivity);

    Notes getNotes();
}
