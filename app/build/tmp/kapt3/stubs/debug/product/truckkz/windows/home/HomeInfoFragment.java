package product.truckkz.windows.home;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001f\u001a\u00020 H\u0002J&\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010\'\u001a\u0004\u0018\u00010(H\u0017J\u0010\u0010)\u001a\u00020\n2\u0006\u0010*\u001a\u00020\nH\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u00a8\u0006+"}, d2 = {"Lproduct/truckkz/windows/home/HomeInfoFragment;", "Landroidx/fragment/app/Fragment;", "()V", "adapter", "Lproduct/truckkz/windows/home/UpdateDataAdapter;", "getAdapter", "()Lproduct/truckkz/windows/home/UpdateDataAdapter;", "setAdapter", "(Lproduct/truckkz/windows/home/UpdateDataAdapter;)V", "callInfo", "", "getCallInfo", "()Ljava/lang/String;", "setCallInfo", "(Ljava/lang/String;)V", "indexShow", "", "isMoreState", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "viewModels", "Lproduct/truckkz/viewModels/HomeViewModels;", "getViewModels", "()Lproduct/truckkz/viewModels/HomeViewModels;", "setViewModels", "(Lproduct/truckkz/viewModels/HomeViewModels;)V", "callPhone", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "removeStartEnDChars", "str", "app_debug"})
public final class HomeInfoFragment extends androidx.fragment.app.Fragment {
    public androidx.recyclerview.widget.RecyclerView recyclerView;
    public product.truckkz.windows.home.UpdateDataAdapter adapter;
    public product.truckkz.viewModels.HomeViewModels viewModels;
    private boolean isMoreState = true;
    private int indexShow = 0;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String callInfo = "";
    private java.util.HashMap _$_findViewCache;
    
    public HomeInfoFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.recyclerview.widget.RecyclerView getRecyclerView() {
        return null;
    }
    
    public final void setRecyclerView(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final product.truckkz.windows.home.UpdateDataAdapter getAdapter() {
        return null;
    }
    
    public final void setAdapter(@org.jetbrains.annotations.NotNull()
    product.truckkz.windows.home.UpdateDataAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final product.truckkz.viewModels.HomeViewModels getViewModels() {
        return null;
    }
    
    public final void setViewModels(@org.jetbrains.annotations.NotNull()
    product.truckkz.viewModels.HomeViewModels p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCallInfo() {
        return null;
    }
    
    public final void setCallInfo(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @android.annotation.SuppressLint(value = {"SetTextI18n", "UseCompatLoadingForDrawables"})
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void callPhone() {
    }
    
    private final java.lang.String removeStartEnDChars(java.lang.String str) {
        return null;
    }
}