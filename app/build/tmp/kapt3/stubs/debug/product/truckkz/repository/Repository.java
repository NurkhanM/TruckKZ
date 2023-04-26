package product.truckkz.repository;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u001f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\u0006\u0010\t\u001a\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\'\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u00122\u0006\u0010\t\u001a\u00020\nJ6\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u00122\"\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0017j\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u0018JI\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00042\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u001c2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010#J6\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00040\u00122\"\u0010%\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0017j\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u0018\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006&"}, d2 = {"Lproduct/truckkz/repository/Repository;", "", "()V", "getCategoryRepository", "Lretrofit2/Response;", "Lproduct/truckkz/models/category/CategoryModels;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProduct2Repository", "Lproduct/truckkz/models/products/index/ProductsModels;", "auth", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProductInfoRepository", "Lproduct/truckkz/models/products/show/ProductShowModels;", "number", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProductRepository", "Landroidx/lifecycle/LiveData;", "Landroidx/paging/PagingData;", "Lproduct/truckkz/models/products/index/Data;", "getSortRepository", "allPro", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "pushRegistPost", "Lproduct/truckkz/models/register/RegisterModels;", "name", "Lokhttp3/RequestBody;", "email", "password", "password_confirmation", "phone", "img", "Lokhttp3/MultipartBody$Part;", "(Lokhttp3/RequestBody;Lokhttp3/RequestBody;Lokhttp3/RequestBody;Lokhttp3/RequestBody;Lokhttp3/RequestBody;Lokhttp3/MultipartBody$Part;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendLoginRepository", "params", "app_debug"})
public final class Repository {
    
    public Repository() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getProductInfoRepository(@org.jetbrains.annotations.NotNull
    java.lang.String auth, int number, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<product.truckkz.models.products.show.ProductShowModels>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object pushRegistPost(@org.jetbrains.annotations.NotNull
    okhttp3.RequestBody name, @org.jetbrains.annotations.NotNull
    okhttp3.RequestBody email, @org.jetbrains.annotations.NotNull
    okhttp3.RequestBody password, @org.jetbrains.annotations.NotNull
    okhttp3.RequestBody password_confirmation, @org.jetbrains.annotations.NotNull
    okhttp3.RequestBody phone, @org.jetbrains.annotations.Nullable
    okhttp3.MultipartBody.Part img, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<product.truckkz.models.register.RegisterModels>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<retrofit2.Response<product.truckkz.models.register.RegisterModels>> sendLoginRepository(@org.jetbrains.annotations.NotNull
    java.util.HashMap<java.lang.String, java.lang.String> params) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getProduct2Repository(@org.jetbrains.annotations.NotNull
    java.lang.String auth, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<product.truckkz.models.products.index.ProductsModels>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getCategoryRepository(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<product.truckkz.models.category.CategoryModels>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<androidx.paging.PagingData<product.truckkz.models.products.index.Data>> getSortRepository(@org.jetbrains.annotations.NotNull
    java.util.HashMap<java.lang.String, java.lang.String> allPro) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<androidx.paging.PagingData<product.truckkz.models.products.index.Data>> getProductRepository(@org.jetbrains.annotations.NotNull
    java.lang.String auth) {
        return null;
    }
}