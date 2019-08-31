package com.neosoft.republictv.presentation.di.module

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.neosoft.republictv.data.dataRepository.DataRepository
import com.neosoft.republictv.data.mapper.DataMapper
import com.neosoft.republictv.data.net.RestApi
import com.neosoft.republictv.data.net.RestApiImpl
import com.neosoft.republictv.data.net.interfaces.CustomerService
import com.neosoft.republictv.domain.repository.Repository
import com.neosoft.republictv.domain.usecases.ListOfUsersUC
import com.neosoft.republictv.presentation.utils.Constants
import com.neosoft.republictv.presentation.viewModelFactory.ViewModelFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by Vijay on 30/8/19.
 */

@Module
class DataModule {


    @Provides
    @Singleton
    fun provideGson(): Gson {
        val builder = GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        return builder.setLenient().create()
    }

    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit {

        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }


    @Provides
    @Singleton
    fun getRequestHeader(): OkHttpClient {

        val httpClient = OkHttpClient.Builder()

        httpClient.addInterceptor { chain ->
            val original = chain.request()
            val request = original.newBuilder()
                .build()
            chain.proceed(request)
        }
            .addNetworkInterceptor(StethoInterceptor())
            .connectTimeout(100, TimeUnit.SECONDS)
            .writeTimeout(100, TimeUnit.SECONDS)
            .readTimeout(300, TimeUnit.SECONDS)

        return httpClient.build()
    }

    @Provides
    @Singleton
    fun getApiCallInterface(retrofit: Retrofit): CustomerService {
        return retrofit.create(CustomerService::class.java)
    }

    @Singleton
    @Provides
    fun provideRestImpl(customerService: CustomerService, context: Context): RestApi {
        return RestApiImpl(customerService, context)
    }

    @Singleton
    @Provides
    fun provideDataRespository(dataRepository: DataRepository): Repository {
        return dataRepository
    }


    @Provides
    @Singleton
    fun provideViewModelFactory(mListOfUsersUC: ListOfUsersUC): ViewModelProvider.Factory {
        return ViewModelFactory(mListOfUsersUC)
    }

    @Provides
    @Singleton
    fun provideDataMapper(
        rest: RestApi,
        mapper: DataMapper
    ): DataRepository {
        return DataRepository(rest,mapper)
    }


}