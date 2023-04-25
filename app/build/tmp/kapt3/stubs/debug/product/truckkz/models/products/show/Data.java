package product.truckkz.models.products.show;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u007f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0001\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\u0005\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0010\u001a\u00020\u0001\u0012\u0006\u0010\u0011\u001a\u00020\n\u0012\u0006\u0010\u0012\u001a\u00020\n\u0012\u0006\u0010\u0013\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u00a2\u0006\u0002\u0010\u0016J\t\u0010*\u001a\u00020\u0003H\u00c6\u0003J\t\u0010+\u001a\u00020\nH\u00c6\u0003J\t\u0010,\u001a\u00020\nH\u00c6\u0003J\t\u0010-\u001a\u00020\nH\u00c6\u0003J\t\u0010.\u001a\u00020\u0015H\u00c6\u0003J\u000f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003J\u000f\u00100\u001a\b\u0012\u0004\u0012\u00020\b0\u0005H\u00c6\u0003J\t\u00101\u001a\u00020\nH\u00c6\u0003J\t\u00102\u001a\u00020\u0001H\u00c6\u0003J\u000f\u00103\u001a\b\u0012\u0004\u0012\u00020\n0\u0005H\u00c6\u0003J\t\u00104\u001a\u00020\u000eH\u00c6\u0003J\t\u00105\u001a\u00020\nH\u00c6\u0003J\t\u00106\u001a\u00020\u0001H\u00c6\u0003J\u009d\u0001\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\u00052\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\u00012\b\b\u0002\u0010\u0011\u001a\u00020\n2\b\b\u0002\u0010\u0012\u001a\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u00c6\u0001J\u0013\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010;\u001a\u00020\u000eH\u00d6\u0001J\t\u0010<\u001a\u00020\nH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u000b\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u000f\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001dR\u0011\u0010\u0010\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001fR\u0011\u0010\u0011\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001dR\u0011\u0010\u0012\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001dR\u0011\u0010\u0013\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\u001dR\u0011\u0010\u0014\u001a\u00020\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010)\u00a8\u0006="}, d2 = {"Lproduct/truckkz/models/products/show/Data;", "", "brand", "Lproduct/truckkz/models/products/show/Brand;", "categories", "", "Lproduct/truckkz/models/products/show/Category;", "characteristics", "Lproduct/truckkz/models/products/show/Characteristic;", "created_at", "", "description", "gallery", "id", "", "img", "key", "price", "slug", "title", "user", "Lproduct/truckkz/models/products/show/User;", "(Lproduct/truckkz/models/products/show/Brand;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/Object;Ljava/util/List;ILjava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lproduct/truckkz/models/products/show/User;)V", "getBrand", "()Lproduct/truckkz/models/products/show/Brand;", "getCategories", "()Ljava/util/List;", "getCharacteristics", "getCreated_at", "()Ljava/lang/String;", "getDescription", "()Ljava/lang/Object;", "getGallery", "getId", "()I", "getImg", "getKey", "getPrice", "getSlug", "getTitle", "getUser", "()Lproduct/truckkz/models/products/show/User;", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class Data {
    @org.jetbrains.annotations.NotNull
    private final product.truckkz.models.products.show.Brand brand = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<product.truckkz.models.products.show.Category> categories = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<product.truckkz.models.products.show.Characteristic> characteristics = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String created_at = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.Object description = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<java.lang.String> gallery = null;
    private final int id = 0;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String img = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.Object key = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String price = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String slug = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String title = null;
    @org.jetbrains.annotations.NotNull
    private final product.truckkz.models.products.show.User user = null;
    
    public Data(@org.jetbrains.annotations.NotNull
    product.truckkz.models.products.show.Brand brand, @org.jetbrains.annotations.NotNull
    java.util.List<product.truckkz.models.products.show.Category> categories, @org.jetbrains.annotations.NotNull
    java.util.List<product.truckkz.models.products.show.Characteristic> characteristics, @org.jetbrains.annotations.NotNull
    java.lang.String created_at, @org.jetbrains.annotations.NotNull
    java.lang.Object description, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> gallery, int id, @org.jetbrains.annotations.NotNull
    java.lang.String img, @org.jetbrains.annotations.NotNull
    java.lang.Object key, @org.jetbrains.annotations.NotNull
    java.lang.String price, @org.jetbrains.annotations.NotNull
    java.lang.String slug, @org.jetbrains.annotations.NotNull
    java.lang.String title, @org.jetbrains.annotations.NotNull
    product.truckkz.models.products.show.User user) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final product.truckkz.models.products.show.Brand getBrand() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<product.truckkz.models.products.show.Category> getCategories() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<product.truckkz.models.products.show.Characteristic> getCharacteristics() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCreated_at() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.Object getDescription() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> getGallery() {
        return null;
    }
    
    public final int getId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getImg() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.Object getKey() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getPrice() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getSlug() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getTitle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final product.truckkz.models.products.show.User getUser() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final product.truckkz.models.products.show.Brand component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component12() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final product.truckkz.models.products.show.User component13() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<product.truckkz.models.products.show.Category> component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<product.truckkz.models.products.show.Characteristic> component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.Object component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> component6() {
        return null;
    }
    
    public final int component7() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.Object component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final product.truckkz.models.products.show.Data copy(@org.jetbrains.annotations.NotNull
    product.truckkz.models.products.show.Brand brand, @org.jetbrains.annotations.NotNull
    java.util.List<product.truckkz.models.products.show.Category> categories, @org.jetbrains.annotations.NotNull
    java.util.List<product.truckkz.models.products.show.Characteristic> characteristics, @org.jetbrains.annotations.NotNull
    java.lang.String created_at, @org.jetbrains.annotations.NotNull
    java.lang.Object description, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> gallery, int id, @org.jetbrains.annotations.NotNull
    java.lang.String img, @org.jetbrains.annotations.NotNull
    java.lang.Object key, @org.jetbrains.annotations.NotNull
    java.lang.String price, @org.jetbrains.annotations.NotNull
    java.lang.String slug, @org.jetbrains.annotations.NotNull
    java.lang.String title, @org.jetbrains.annotations.NotNull
    product.truckkz.models.products.show.User user) {
        return null;
    }
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return null;
    }
}