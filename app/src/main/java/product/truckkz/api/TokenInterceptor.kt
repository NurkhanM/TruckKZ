package product.truckkz.api

import product.truckkz.UserDate.TOKEN_USER
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException


class TokenInterceptor : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {

        //rewrite the request to add bearer token
        val newRequest: Request = chain.request().newBuilder()
            .header("Authorization", "Bearer $TOKEN_USER")
            .build()
        return chain.proceed(newRequest)
    }
}