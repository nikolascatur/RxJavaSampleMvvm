package phone.nikolas.com.rxjavasamplemvvm.depen.module;

import com.android.databinding.library.BuildConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import phone.nikolas.com.rxjavasamplemvvm.networking.NetworkService;
import phone.nikolas.com.rxjavasamplemvvm.networking.Service;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Pleret on 3/12/2017.
 */
@Module
public class NetworkModule {

    final String LOGGING_INTERCEPTOR = "loggingInterceptor";
    final String BASE_OKHTTP = "baseOkHttp3";
    final String BASE_RETROFIT = "baseRetrofit";
    final String BASE_NETWORK_SERVICE = "baseNetworkService";

    public NetworkModule(){

    }

    @Provides
    @Singleton
    @SuppressWarnings("unused")
    @Named(LOGGING_INTERCEPTOR)
    public HttpLoggingInterceptor providesLoggingIntercepor(){
        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    @Provides
    @Singleton
    @SuppressWarnings("unused")
    @Named(BASE_OKHTTP)
    public OkHttpClient providesHttpClient3(@Named(LOGGING_INTERCEPTOR) HttpLoggingInterceptor interceptor ){
        int timeout = 3;
        return new okhttp3.OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .readTimeout(timeout, TimeUnit.SECONDS)
                .writeTimeout(timeout,TimeUnit.SECONDS)
                .connectTimeout(timeout,TimeUnit.SECONDS)
                .build();
    }

    @Provides
    @Singleton
    @SuppressWarnings("unused")
    @Named("gson")
    public Gson providesGson(){
        return new GsonBuilder().create();
    }

    @Provides
    @Singleton
    @SuppressWarnings("unused")
    @Named(BASE_RETROFIT)
    public Retrofit providesRetrovit(@Named(BASE_OKHTTP) OkHttpClient httpClient){
        return new Retrofit.Builder()
                .baseUrl("https://private-7cba43-androidrxdemo.apiary-mock.com/")
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    @SuppressWarnings("unused")
    @Named(BASE_NETWORK_SERVICE)
    public NetworkService providesNetorkService(@Named(BASE_RETROFIT) Retrofit retrofit){
        return retrofit.create(NetworkService.class);
    }

    @Provides
    @Singleton
    @SuppressWarnings("unused")
    public Service providesService(@Named(BASE_NETWORK_SERVICE) NetworkService service){
        return new Service(service);
    }

}
