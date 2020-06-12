package david.hosseini.videosearch.di

import dagger.Module
import dagger.Provides
import david.hosseini.videosearch.api.VimeoApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
class ApiModule {

    @Provides
    fun provideOkHttpClient(): OkHttpClient {

        val httpClient = OkHttpClient.Builder()

        httpClient.addInterceptor { chain ->
            val request = chain.request()
                .newBuilder()
                .addHeader("Authorization", "Bearer $TOKEN")
                .build()
            chain.proceed(request)
        }

        return httpClient.build()
    }

    @Provides
    fun provideVimeoApi(httpClient: OkHttpClient): VimeoApi {

        return Retrofit.Builder()
            .client(httpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(VimeoApi::class.java)
    }

}

private const val TOKEN = "342a799b9f3bc943d0e62c636d196cd7"
private const val BASE_URL = "https://api.vimeo.com/"
