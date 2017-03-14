package phone.nikolas.com.rxjavasamplemvvm.networking;

import java.util.List;

import rx.Observable;

import retrofit2.http.GET;

/**
 * Created by Pleret on 3/12/2017.
 */

public interface NetworkService {
    @GET("emails")
    Observable<List<String>> getEmails();
}
