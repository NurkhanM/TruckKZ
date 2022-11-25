package product.truckkz.windows.home;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J&\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020\'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0017J\b\u0010,\u001a\u00020-H\u0002J\b\u0010.\u001a\u00020-H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0014X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u001a\u0010\u001c\u001a\u00020\u0014X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\u001a\u0010\u001f\u001a\u00020\u0014X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0016\"\u0004\b!\u0010\u0018R\u000e\u0010\"\u001a\u00020#X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006/"}, d2 = {"Lproduct/truckkz/windows/home/HomeFragment;", "Landroidx/fragment/app/Fragment;", "()V", "adapterCategory", "Lproduct/truckkz/windows/home/TovarAdapterCategory;", "adapterProduct", "Lproduct/truckkz/windows/home/TovarAdapterProduct;", "adapterProduct2", "Lproduct/truckkz/windows/home/TovarAdapterProduct2;", "adapterRecomend", "Lproduct/truckkz/windows/home/TovarAdapterRecomend;", "arrayRecomend", "Ljava/util/ArrayList;", "Lproduct/truckkz/models/TestRecomendModel;", "map", "Ljava/util/HashMap;", "", "preferencesUSERSTATUS", "Landroid/content/SharedPreferences;", "recyclerViewCategory", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerViewCategory", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerViewCategory", "(Landroidx/recyclerview/widget/RecyclerView;)V", "recyclerViewProduct", "getRecyclerViewProduct", "setRecyclerViewProduct", "recyclerViewProduct2", "getRecyclerViewProduct2", "setRecyclerViewProduct2", "recyclerViewRecomend", "getRecyclerViewRecomend", "setRecyclerViewRecomend", "viewModel", "Lproduct/truckkz/viewModels/HomeViewModels;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "rfCategory", "", "rfProduct", "app_debug"})
public final class HomeFragment extends androidx.fragment.app.Fragment {
    public androidx.recyclerview.widget.RecyclerView recyclerViewRecomend;
    public androidx.recyclerview.widget.RecyclerView recyclerViewCategory;
    public androidx.recyclerview.widget.RecyclerView recyclerViewProduct;
    public androidx.recyclerview.widget.RecyclerView recyclerViewProduct2;
    private product.truckkz.windows.home.TovarAdapterRecomend adapterRecomend;
    private product.truckkz.windows.home.TovarAdapterCategory adapterCategory;
    private product.truckkz.windows.home.TovarAdapterProduct adapterProduct;
    private product.truckkz.windows.home.TovarAdapterProduct2 adapterProduct2;
    private java.util.ArrayList<product.truckkz.models.TestRecomendModel> arrayRecomend;
    private final java.util.HashMap<java.lang.String, java.lang.String> map = null;
    private product.truckkz.viewModels.HomeViewModels viewModel;
    private android.content.SharedPreferences preferencesUSERSTATUS;
    private java.util.HashMap _$_findViewCache;
    
    public HomeFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.recyclerview.widget.RecyclerView getRecyclerViewRecomend() {
        return null;
    }
    
    public final void setRecyclerViewRecomend(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.recyclerview.widget.RecyclerView getRecyclerViewCategory() {
        return null;
    }
    
    public final void setRecyclerViewCategory(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.recyclerview.widget.RecyclerView getRecyclerViewProduct() {
        return null;
    }
    
    public final void setRecyclerViewProduct(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.recyclerview.widget.RecyclerView getRecyclerViewProduct2() {
        return null;
    }
    
    public final void setRecyclerViewProduct2(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @android.annotation.SuppressLint(value = {"UseCompatLoadingForDrawables", "NotifyDataSetChanged"})
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void rfProduct() {
    }
    
    private final void rfCategory() {
    }
}