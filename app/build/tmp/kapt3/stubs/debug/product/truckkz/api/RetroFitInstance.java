package product.truckkz.api;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000e\u001a\u00020\u000f8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u00148FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\b\u001a\u0004\b\u0015\u0010\u0016R#\u0010\u0018\u001a\n \u001a*\u0004\u0018\u00010\u00190\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\b\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006\u001e"}, d2 = {"Lproduct/truckkz/api/RetroFitInstance;", "", "()V", "authorization", "Lproduct/truckkz/api/auth/AuthorizationService;", "getAuthorization", "()Lproduct/truckkz/api/auth/AuthorizationService;", "authorization$delegate", "Lkotlin/Lazy;", "brand", "Lproduct/truckkz/api/brands/BrandService;", "getBrand", "()Lproduct/truckkz/api/brands/BrandService;", "brand$delegate", "category", "Lproduct/truckkz/api/category/CategoryService;", "getCategory", "()Lproduct/truckkz/api/category/CategoryService;", "category$delegate", "product", "Lproduct/truckkz/api/products/ProductService;", "getProduct", "()Lproduct/truckkz/api/products/ProductService;", "product$delegate", "retrofit", "Lretrofit2/Retrofit;", "kotlin.jvm.PlatformType", "getRetrofit", "()Lretrofit2/Retrofit;", "retrofit$delegate", "app_debug"})
public final class RetroFitInstance {
    @org.jetbrains.annotations.NotNull
    private static final kotlin.Lazy retrofit$delegate = null;
    @org.jetbrains.annotations.NotNull
    private static final kotlin.Lazy authorization$delegate = null;
    @org.jetbrains.annotations.NotNull
    private static final kotlin.Lazy brand$delegate = null;
    @org.jetbrains.annotations.NotNull
    private static final kotlin.Lazy category$delegate = null;
    @org.jetbrains.annotations.NotNull
    private static final kotlin.Lazy product$delegate = null;
    @org.jetbrains.annotations.NotNull
    public static final product.truckkz.api.RetroFitInstance INSTANCE = null;
    
    private RetroFitInstance() {
        super();
    }
    
    private final retrofit2.Retrofit getRetrofit() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final product.truckkz.api.auth.AuthorizationService getAuthorization() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final product.truckkz.api.brands.BrandService getBrand() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final product.truckkz.api.category.CategoryService getCategory() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final product.truckkz.api.products.ProductService getProduct() {
        return null;
    }
}