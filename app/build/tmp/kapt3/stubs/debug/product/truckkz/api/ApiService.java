package product.truckkz.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J+\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ+\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ+\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\b\b\u0001\u0010\u000f\u001a\u00020\u00072\b\b\u0001\u0010\u0010\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J!\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0004H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013J!\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00032\b\b\u0001\u0010\u0016\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017J!\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0004H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013J+\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u001b\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ+\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u001b\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ+\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010 \u001a\u00020!H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\"J=\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010 \u001a\u00020!2\u0010\b\u0001\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\'0&H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010(J!\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u00032\b\b\u0001\u0010+\u001a\u00020!H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010,J=\u0010-\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00032$\b\u0001\u0010.\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040/j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`0H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00101JA\u00102\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u00103\u001a\u00020\u00072\b\b\u0001\u00104\u001a\u00020\u00072\n\b\u0001\u0010+\u001a\u0004\u0018\u00010\'H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00105J+\u00106\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u00107\u001a\u00020\u0004H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00108\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00069"}, d2 = {"Lproduct/truckkz/api/ApiService;", "", "addFavorite", "Lretrofit2/Response;", "", "auth", "idProducts", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteFavorite", "getCategory", "Lproduct/truckkz/models/category/CategoryModels;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCategoryProducts", "Lproduct/truckkz/models/products/index/ProductsModels;", "pageID", "categoryID", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFavorite", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFieldsCategory", "Lproduct/truckkz/models/createProducts/fieldsCategory/FieldsCategoryModels;", "id", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProduct", "getProductInfo", "Lproduct/truckkz/models/products/show/ProductShowModels;", "number", "getUser", "Lproduct/truckkz/models/user/UserModels;", "postNewProductsCreate", "Lproduct/truckkz/models/createProducts/newProducts/NewProductsModels;", "json", "Lcom/google/gson/JsonObject;", "(Ljava/lang/String;Lcom/google/gson/JsonObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "postUserFullRegister", "Lproduct/truckkz/models/full/FullModels;", "images", "", "Lokhttp3/MultipartBody$Part;", "(Ljava/lang/String;Lcom/google/gson/JsonObject;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "postUserRegister", "Lproduct/truckkz/models/nepolnyi/NepolModel;", "body", "(Lcom/google/gson/JsonObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "postUserSignIn", "params", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "(Ljava/util/HashMap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pushImageProducts", "productsID", "imageID", "(Ljava/lang/String;IILokhttp3/MultipartBody$Part;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestSearch", "text", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface ApiService {
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "/api/v1/users/{idUser}")
    public abstract java.lang.Object getUser(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String auth, @retrofit2.http.Path(value = "idUser")
    int number, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<product.truckkz.models.user.UserModels>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "api/products/{idProduct}")
    public abstract java.lang.Object getProductInfo(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String auth, @retrofit2.http.Path(value = "idProduct")
    int number, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<product.truckkz.models.products.show.ProductShowModels>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "api/category")
    public abstract java.lang.Object getCategory(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<product.truckkz.models.category.CategoryModels>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "api/products")
    public abstract java.lang.Object getProduct(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String auth, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<product.truckkz.models.products.index.ProductsModels>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "/products/get/search/{text}")
    public abstract java.lang.Object requestSearch(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String auth, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "text")
    java.lang.String text, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<product.truckkz.models.products.index.ProductsModels>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "/products/get/favorites")
    public abstract java.lang.Object getFavorite(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String auth, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<product.truckkz.models.products.index.ProductsModels>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "/categories/get/fields-by-id/{idCategory}")
    public abstract java.lang.Object getFieldsCategory(@retrofit2.http.Path(value = "idCategory")
    int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<product.truckkz.models.createProducts.fieldsCategory.FieldsCategoryModels>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "api/auth/login")
    @retrofit2.http.FormUrlEncoded()
    public abstract java.lang.Object postUserSignIn(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.FieldMap()
    java.util.HashMap<java.lang.String, java.lang.String> params, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<product.truckkz.models.user.UserModels>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "/products/add-to-favorites/{idProducts}")
    @retrofit2.http.Headers(value = {"Accept: application/json"})
    public abstract java.lang.Object addFavorite(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String auth, @retrofit2.http.Path(value = "idProducts")
    int idProducts, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.lang.String>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.DELETE(value = "/products/delete-from-favorites/{idProducts}")
    @retrofit2.http.Headers(value = {"Accept: application/json"})
    public abstract java.lang.Object deleteFavorite(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String auth, @retrofit2.http.Path(value = "idProducts")
    int idProducts, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.lang.String>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "/products/publish/details")
    @retrofit2.http.Headers(value = {"Accept: application/json"})
    public abstract java.lang.Object postNewProductsCreate(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String auth, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.google.gson.JsonObject json, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<product.truckkz.models.createProducts.newProducts.NewProductsModels>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "/api/auth/sign-up-incomplete")
    @retrofit2.http.Headers(value = {"Accept: application/json"})
    public abstract java.lang.Object postUserRegister(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.google.gson.JsonObject body, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<product.truckkz.models.nepolnyi.NepolModel>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.PUT(value = "/api/v1/users/sign-up-complete")
    @retrofit2.http.Headers(value = {"Accept: application/json"})
    @retrofit2.http.Multipart()
    public abstract java.lang.Object postUserFullRegister(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String auth, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Part(value = "userCompleteRegisterDto")
    com.google.gson.JsonObject json, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Part()
    java.util.List<okhttp3.MultipartBody.Part> images, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<product.truckkz.models.full.FullModels>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "/products/get/main-page-by-category/{idPage}/{idCategory}")
    public abstract java.lang.Object getCategoryProducts(@retrofit2.http.Path(value = "idPage")
    int pageID, @retrofit2.http.Path(value = "idCategory")
    int categoryID, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<product.truckkz.models.products.index.ProductsModels>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "/products/publish/image/{idProducts}/{idImage}")
    @retrofit2.http.Headers(value = {"Accept: application/json"})
    @retrofit2.http.Multipart()
    public abstract java.lang.Object pushImageProducts(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String auth, @retrofit2.http.Path(value = "idProducts")
    int productsID, @retrofit2.http.Path(value = "idImage")
    int imageID, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Part()
    okhttp3.MultipartBody.Part body, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.lang.String>> continuation);
}