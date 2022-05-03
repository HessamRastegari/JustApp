package hessam.rastegari.justapp.di;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import hessam.rastegari.justapp.network.RetroInterfaceServices;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {

   String baseUrl="https://api.github.com/search/"; //repositories?q=newyork


   @Singleton
   @Provides
   public RetroInterfaceServices getRetroInterfaceServices(Retrofit retrofit) {

      return retrofit.create(RetroInterfaceServices.class);

   }

   @Singleton
   @Provides
   public Retrofit getRetroInstance(){
      return new Retrofit.Builder()
              .baseUrl(baseUrl)
              .addConverterFactory(GsonConverterFactory.create())
              .build();
   }
}
