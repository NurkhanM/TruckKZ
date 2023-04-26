package product.truckkz.windows.home;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J&\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0017J\b\u0010*\u001a\u00020+H\u0016J\u001a\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020#2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\b\u0010.\u001a\u00020+H\u0002J\b\u0010/\u001a\u00020+H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\u0019X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\u0019X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u00060"}, d2 = {"Lproduct/truckkz/windows/home/HomeFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lproduct/truckkz/databinding/FragmentHomeBinding;", "activityBinding", "Lproduct/truckkz/databinding/ActivityMainBinding;", "adapterCategory", "Lproduct/truckkz/windows/home/TovarAdapterCategory;", "adapterProduct", "Lproduct/truckkz/windows/home/TovarAdapterProduct;", "adapterProduct2", "Lproduct/truckkz/windows/home/TovarAdapterProduct2;", "arrayRecomend", "Ljava/util/ArrayList;", "Lproduct/truckkz/models/TestRecomendModel;", "binding", "getBinding", "()Lproduct/truckkz/databinding/FragmentHomeBinding;", "map", "Ljava/util/HashMap;", "", "preferencesUSERSTATUS", "Landroid/content/SharedPreferences;", "recyclerViewCategory", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerViewProduct", "getRecyclerViewProduct", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerViewProduct", "(Landroidx/recyclerview/widget/RecyclerView;)V", "recyclerViewProduct2", "viewModel", "Lproduct/truckkz/viewModels/HomeViewModels;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "", "onViewCreated", "view", "rfCategory", "rfProduct", "app_debug"})
public final class HomeFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable
    private product.truckkz.databinding.FragmentHomeBinding _binding;
    @org.jetbrains.annotations.Nullable
    private product.truckkz.databinding.ActivityMainBinding activityBinding;
    private androidx.recyclerview.widget.RecyclerView recyclerViewCategory;
    public androidx.recyclerview.widget.RecyclerView recyclerViewProduct;
    private androidx.recyclerview.widget.RecyclerView recyclerViewProduct2;
    private product.truckkz.windows.home.TovarAdapterCategory adapterCategory;
    private product.truckkz.windows.home.TovarAdapterProduct adapterProduct;
    private product.truckkz.windows.home.TovarAdapterProduct2 adapterProduct2;
    @org.jetbrains.annotations.NotNull
    private java.util.ArrayList<product.truckkz.models.TestRecomendModel> arrayRecomend;
    @org.jetbrains.annotations.NotNull
    private final java.util.HashMap<java.lang.String, java.lang.String> map = null;
    private product.truckkz.viewModels.HomeViewModels viewModel;
    private android.content.SharedPreferences preferencesUSERSTATUS;
    
    public HomeFragment() {
        super();
    }
    
    private final product.truckkz.databinding.FragmentHomeBinding getBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.recyclerview.widget.RecyclerView getRecyclerViewProduct() {
        return null;
    }
    
    public final void setRecyclerViewProduct(@org.jetbrains.annotations.NotNull
    androidx.recyclerview.widget.RecyclerView p0) {
    }
    
    @java.lang.Override
    @android.annotation.SuppressLint(value = {"UseCompatLoadingForDrawables", "NotifyDataSetChanged"})
    @org.jetbrains.annotations.Nullable
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void rfProduct() {
    }
    
    private final void rfCategory() {
    }
    
    @java.lang.Override
    public void onDestroyView() {
    }
}