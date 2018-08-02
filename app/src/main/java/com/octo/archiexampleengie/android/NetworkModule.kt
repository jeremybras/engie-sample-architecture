package com.octo.archiexampleengie.android

import android.content.Context
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.octo.archiexampleengie.BuildConfig
import com.octo.archiexampleengie.repository.common.api.MoshiLocalDateTimeAdapter
import com.readystatesoftware.chuck.ChuckInterceptor
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import timber.log.Timber
import javax.inject.Singleton

@Module
class NetworkModule {

    companion object {
        const val CONVERTER_MOSHI = "MOSCHI"
        const val CONVERTER_PROTOBUF = "PROTOBUF"
    }

    @Singleton
    @Provides
    fun provideOkhttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
        stethoInterceptor: StethoInterceptor,
        context: Context
    ): OkHttpClient.Builder {
        return OkHttpClient()
            .newBuilder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(stethoInterceptor)
            .addInterceptor(ChuckInterceptor(context))
    }

    @Singleton
    @Provides
    fun provideStethoInterceptor(): StethoInterceptor {
        return StethoInterceptor()
    }

    @Provides
    fun provideRetrofitMoschi(
        moshiConverterFactory: MoshiConverterFactory,
        client: OkHttpClient.Builder
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.API_BASE_URL)
            .client(client.build())
            .addConverterFactory(moshiConverterFactory)
            .build()
    }

    @Provides
    fun provideMoshiConverter(moshi: Moshi): MoshiConverterFactory {
        return MoshiConverterFactory.create(moshi)
    }

    @Provides
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(MoshiLocalDateTimeAdapter())
            .build()
    }

    @Provides
    fun provideLoggingInterceptor(timberTree: Timber.Tree): HttpLoggingInterceptor {
        return HttpLoggingInterceptor(HttpLoggingInterceptor.Logger {
            timberTree.d(it)
        }).setLevel(HttpLoggingInterceptor.Level.HEADERS)
    }
}
