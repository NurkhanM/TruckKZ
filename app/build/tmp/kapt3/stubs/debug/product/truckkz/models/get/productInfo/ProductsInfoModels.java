package product.truckkz.models.get.productInfo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b*\b\u0086\b\u0018\u00002\u00020\u0001Bu\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b\u0012\u0006\u0010\u0013\u001a\u00020\b\u00a2\u0006\u0002\u0010\u0014J\t\u0010\'\u001a\u00020\u0003H\u00c6\u0003J\t\u0010(\u001a\u00020\u0006H\u00c6\u0003J\u000f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bH\u00c6\u0003J\t\u0010*\u001a\u00020\bH\u00c6\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0001H\u00c6\u0003J\t\u0010,\u001a\u00020\u0006H\u00c6\u0003J\t\u0010-\u001a\u00020\bH\u00c6\u0003J\t\u0010.\u001a\u00020\u0003H\u00c6\u0003J\u0011\u0010/\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u00c6\u0003J\t\u00100\u001a\u00020\u000eH\u00c6\u0003J\t\u00101\u001a\u00020\u0006H\u00c6\u0003J\t\u00102\u001a\u00020\u0006H\u00c6\u0003J\u0091\u0001\u00103\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00062\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\b\b\u0002\u0010\u0013\u001a\u00020\bH\u00c6\u0001J\u0013\u00104\u001a\u00020\u00032\b\u00105\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00106\u001a\u00020\u0006H\u00d6\u0001J\t\u00107\u001a\u00020\bH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u000f\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR\u0011\u0010\u0010\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001aR\u0011\u0010\u0011\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001aR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001fR\u0011\u0010\u0013\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001c\u00a8\u00068"}, d2 = {"Lproduct/truckkz/models/get/productInfo/ProductsInfoModels;", "", "active", "", "characteristics", "clickNumber", "", "description", "", "favorite", "images", "", "Lproduct/truckkz/models/get/productInfo/Images;", "location", "Lproduct/truckkz/models/get/productInfo/Location;", "minimumBookingNumberDay", "price", "productId", "reviews", "title", "(ZLjava/lang/Object;ILjava/lang/String;ZLjava/util/List;Lproduct/truckkz/models/get/productInfo/Location;IIILjava/util/List;Ljava/lang/String;)V", "getActive", "()Z", "getCharacteristics", "()Ljava/lang/Object;", "getClickNumber", "()I", "getDescription", "()Ljava/lang/String;", "getFavorite", "getImages", "()Ljava/util/List;", "getLocation", "()Lproduct/truckkz/models/get/productInfo/Location;", "getMinimumBookingNumberDay", "getPrice", "getProductId", "getReviews", "getTitle", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_debug"})
public final class ProductsInfoModels {
    private final boolean active = false;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Object characteristics = null;
    private final int clickNumber = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String description = null;
    private final boolean favorite = false;
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<product.truckkz.models.get.productInfo.Images> images = null;
    @org.jetbrains.annotations.NotNull()
    private final product.truckkz.models.get.productInfo.Location location = null;
    private final int minimumBookingNumberDay = 0;
    private final int price = 0;
    private final int productId = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.Object> reviews = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String title = null;
    
    @org.jetbrains.annotations.NotNull()
    public final product.truckkz.models.get.productInfo.ProductsInfoModels copy(boolean active, @org.jetbrains.annotations.Nullable()
    java.lang.Object characteristics, int clickNumber, @org.jetbrains.annotations.NotNull()
    java.lang.String description, boolean favorite, @org.jetbrains.annotations.Nullable()
    java.util.List<product.truckkz.models.get.productInfo.Images> images, @org.jetbrains.annotations.NotNull()
    product.truckkz.models.get.productInfo.Location location, int minimumBookingNumberDay, int price, int productId, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends java.lang.Object> reviews, @org.jetbrains.annotations.NotNull()
    java.lang.String title) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public ProductsInfoModels(boolean active, @org.jetbrains.annotations.Nullable()
    java.lang.Object characteristics, int clickNumber, @org.jetbrains.annotations.NotNull()
    java.lang.String description, boolean favorite, @org.jetbrains.annotations.Nullable()
    java.util.List<product.truckkz.models.get.productInfo.Images> images, @org.jetbrains.annotations.NotNull()
    product.truckkz.models.get.productInfo.Location location, int minimumBookingNumberDay, int price, int productId, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends java.lang.Object> reviews, @org.jetbrains.annotations.NotNull()
    java.lang.String title) {
        super();
    }
    
    public final boolean component1() {
        return false;
    }
    
    public final boolean getActive() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getCharacteristics() {
        return null;
    }
    
    public final int component3() {
        return 0;
    }
    
    public final int getClickNumber() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDescription() {
        return null;
    }
    
    public final boolean component5() {
        return false;
    }
    
    public final boolean getFavorite() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<product.truckkz.models.get.productInfo.Images> component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<product.truckkz.models.get.productInfo.Images> getImages() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final product.truckkz.models.get.productInfo.Location component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final product.truckkz.models.get.productInfo.Location getLocation() {
        return null;
    }
    
    public final int component8() {
        return 0;
    }
    
    public final int getMinimumBookingNumberDay() {
        return 0;
    }
    
    public final int component9() {
        return 0;
    }
    
    public final int getPrice() {
        return 0;
    }
    
    public final int component10() {
        return 0;
    }
    
    public final int getProductId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.Object> component11() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.Object> getReviews() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component12() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTitle() {
        return null;
    }
}