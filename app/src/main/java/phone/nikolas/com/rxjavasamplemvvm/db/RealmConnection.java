package phone.nikolas.com.rxjavasamplemvvm.db;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import phone.nikolas.com.rxjavasamplemvvm.model.People;

/**
 * Created by Pleret on 4/5/2017.
 */

public class RealmConnection {

    Realm realm;
//    Class<?> classObject;

    public void initRealm(Context context/*,Class<?> classObject*/){
        Realm.init(context);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .schemaVersion(2)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(config);
        realm = Realm.getDefaultInstance();
    }

    public void insert(String nama,String alamat){
        realm.beginTransaction();
        People people = realm.createObject(People.class);
        people.setNama(nama);
        people.setAlamat(alamat);
        realm.commitTransaction();
    }

    public List<People> getAllData(){
        List<People> peoples = new ArrayList<People>();
        RealmQuery<People> query = realm.where(People.class);
        RealmResults<People> results = query.findAll();
        for(People people : results){
            peoples.add(people);
        }
        return peoples;
    }

    public void close(){
        realm.close();
    }

}
