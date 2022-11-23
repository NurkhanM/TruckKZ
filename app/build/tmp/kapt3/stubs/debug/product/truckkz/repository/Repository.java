package product.truckkz.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\'\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\'\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\'\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00042\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0004H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J\u001f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J\u001f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00042\u0006\u0010\u0017\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018J\'\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00042\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u001f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J\'\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00042\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\'\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00042\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010 \u001a\u00020!H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\"J7\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u00042\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010 \u001a\u00020!2\u000e\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\'0&H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010(J\u001a\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0\u00040*2\u0006\u0010,\u001a\u00020!J6\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u00040*2\"\u0010.\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050/j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`0J9\u00101\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u00102\u001a\u00020\b2\u0006\u00103\u001a\u00020\b2\b\u0010,\u001a\u0004\u0018\u00010\'H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00104J\'\u00105\u001a\b\u0012\u0004\u0012\u00020\f0\u00042\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u0005H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00107\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00068"}, d2 = {"Lproduct/truckkz/repository/Repository;", "", "()V", "addFavoriteRepository", "Lretrofit2/Response;", "", "auth", "idProducts", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteFavoriteRepository", "getCategoryProductsRepository", "Lproduct/truckkz/models/products/index/ProductsModels;", "pageID", "categoryID", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCategoryRepository", "Lproduct/truckkz/models/category/CategoryModels;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFavoriteRepository", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFieldsCategoryRepository", "Lproduct/truckkz/models/createProducts/fieldsCategory/FieldsCategoryModels;", "number", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProductInfoRepository", "Lproduct/truckkz/models/products/show/ProductShowModels;", "getProductRepository", "getUserRepository", "Lproduct/truckkz/models/user/UserModels;", "postNewProductsCreateRepository", "Lproduct/truckkz/models/createProducts/newProducts/NewProductsModels;", "json", "Lcom/google/gson/JsonObject;", "(Ljava/lang/String;Lcom/google/gson/JsonObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "postUserFullRegisterRepository", "Lproduct/truckkz/models/full/FullModels;", "images", "", "Lokhttp3/MultipartBody$Part;", "(Ljava/lang/String;Lcom/google/gson/JsonObject;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "postUserRegisterRepository", "Landroidx/lifecycle/LiveData;", "Lproduct/truckkz/models/nepolnyi/NepolModel;", "body", "postUserSignInRepository", "params", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "pushImageProductsRepository", "productsID", "imageID", "(Ljava/lang/String;IILokhttp3/MultipartBody$Part;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestSearchRepository", "text", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class Repository {
    
    public Repository() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getUserRepository(@org.jetbrains.annotations.NotNull()
    java.lang.String auth, int number, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<product.truckkz.models.user.UserModels>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getProductInfoRepository(@org.jetbrains.annotations.NotNull()
    java.lang.String auth, int number, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<product.truckkz.models.products.show.ProductShowModels>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<retrofit2.Response<product.truckkz.models.user.UserModels>> postUserSignInRepository(@org.jetbrains.annotations.NotNull()
    java.util.HashMap<java.lang.String, java.lang.String> params) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object postNewProductsCreateRepository(@org.jetbrains.annotations.NotNull()
    java.lang.String auth, @org.jetbrains.annotations.NotNull()
    com.google.gson.JsonObject json, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<product.truckkz.models.createProducts.newProducts.NewProductsModels>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<retrofit2.Response<product.truckkz.models.nepolnyi.NepolModel>> postUserRegisterRepository(@org.jetbrains.annotations.NotNull()
    com.google.gson.JsonObject body) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object postUserFullRegisterRepository(@org.jetbrains.annotations.NotNull()
    java.lang.String auth, @org.jetbrains.annotations.NotNull()
    com.google.gson.JsonObject json, @org.jetbrains.annotations.NotNull()
    java.util.List<okhttp3.MultipartBody.Part> images, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<product.truckkz.models.full.FullModels>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object addFavoriteRepository(@org.jetbrains.annotations.NotNull()
    java.lang.String auth, int idProducts, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.lang.String>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteFavoriteRepository(@org.jetbrains.annotations.NotNull()
    java.lang.String auth, int idProducts, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.lang.String>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object pushImageProductsRepository(@org.jetbrains.annotations.NotNull()
    java.lang.String auth, int productsID, int imageID, @org.jetbrains.annotations.Nullable()
    okhttp3.MultipartBody.Part body, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.lang.String>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getProductRepository(@org.jetbrains.annotations.NotNull()
    java.lang.String auth, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<product.truckkz.models.products.index.ProductsModels>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object requestSearchRepository(@org.jetbrains.annotations.NotNull()
    java.lang.String auth, @org.jetbrains.annotations.NotNull()
    java.lang.String text, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<product.truckkz.models.products.index.ProductsModels>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getFavoriteRepository(@org.jetbrains.annotations.NotNull()
    java.lang.String auth, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<product.truckkz.models.products.index.ProductsModels>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getCategoryRepository(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<product.truckkz.models.category.CategoryModels>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getFieldsCategoryRepository(int number, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<product.truckkz.models.createProducts.fieldsCategory.FieldsCategoryModels>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getCategoryProductsRepository(int pageID, int categoryID, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<product.truckkz.models.products.index.ProductsModels>> continuation) {
        return null;
    }
}