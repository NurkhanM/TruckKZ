package product.truckkz.windows.home;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00142\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0014\u0015B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0003J\u001c\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000fH\u0017J\u001c\u0010\u0010\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lproduct/truckkz/windows/home/TovarAdapterProduct;", "Landroidx/paging/PagingDataAdapter;", "Lproduct/truckkz/models/products/index/Data;", "Lproduct/truckkz/windows/home/TovarAdapterProduct$ImageViewHolder;", "mIClickListnear", "Lproduct/truckkz/interface/IClickListnearHomeFavorite;", "(Lproduct/truckkz/interface/IClickListnearHomeFavorite;)V", "getDateTime", "", "s", "", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "ImageViewHolder", "app_debug"})
public final class TovarAdapterProduct extends androidx.paging.PagingDataAdapter<product.truckkz.models.products.index.Data, product.truckkz.windows.home.TovarAdapterProduct.ImageViewHolder> {
    @org.jetbrains.annotations.NotNull()
    public static final product.truckkz.windows.home.TovarAdapterProduct.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    private static final androidx.recyclerview.widget.DiffUtil.ItemCallback<product.truckkz.models.products.index.Data> diffCallback = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public product.truckkz.windows.home.TovarAdapterProduct.ImageViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @android.annotation.SuppressLint(value = {"NewApi", "SetTextI18n", "UseCompatLoadingForDrawables"})
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    product.truckkz.windows.home.TovarAdapterProduct.ImageViewHolder holder, int position) {
    }
    
    @android.annotation.SuppressLint(value = {"SimpleDateFormat"})
    private final boolean getDateTime(java.lang.String s) {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lproduct/truckkz/windows/home/TovarAdapterProduct$ImageViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lproduct/truckkz/databinding/ItemTovarBinding;", "(Lproduct/truckkz/windows/home/TovarAdapterProduct;Lproduct/truckkz/databinding/ItemTovarBinding;)V", "app_debug"})
    public final class ImageViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        
        public ImageViewHolder(@org.jetbrains.annotations.NotNull()
        product.truckkz.databinding.ItemTovarBinding binding) {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lproduct/truckkz/windows/home/TovarAdapterProduct$Companion;", "", "()V", "diffCallback", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lproduct/truckkz/models/products/index/Data;", "getDiffCallback", "()Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.recyclerview.widget.DiffUtil.ItemCallback<product.truckkz.models.products.index.Data> getDiffCallback() {
            return null;
        }
    }
}