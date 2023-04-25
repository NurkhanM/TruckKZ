package product.truckkz.windows.home;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010$\u001a\u00020%H\u0002J&\u0010&\u001a\u0004\u0018\u00010\'2\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0017J\b\u0010.\u001a\u00020%H\u0016J\u0010\u0010/\u001a\u00020\u000f2\u0006\u00100\u001a\u00020\u000fH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#\u00a8\u00061"}, d2 = {"Lproduct/truckkz/windows/home/HomeInfoFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lproduct/truckkz/databinding/FragmentHomeInfoBinding;", "adapter", "Lproduct/truckkz/windows/home/UpdateDataAdapter;", "getAdapter", "()Lproduct/truckkz/windows/home/UpdateDataAdapter;", "setAdapter", "(Lproduct/truckkz/windows/home/UpdateDataAdapter;)V", "binding", "getBinding", "()Lproduct/truckkz/databinding/FragmentHomeInfoBinding;", "callInfo", "", "getCallInfo", "()Ljava/lang/String;", "setCallInfo", "(Ljava/lang/String;)V", "indexShow", "", "isMoreState", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "viewModels", "Lproduct/truckkz/viewModels/HomeViewModels;", "getViewModels", "()Lproduct/truckkz/viewModels/HomeViewModels;", "setViewModels", "(Lproduct/truckkz/viewModels/HomeViewModels;)V", "callPhone", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "removeStartEnDChars", "str", "app_debug"})
public final class HomeInfoFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable
    private product.truckkz.databinding.FragmentHomeInfoBinding _binding;
    public androidx.recyclerview.widget.RecyclerView recyclerView;
    public product.truckkz.windows.home.UpdateDataAdapter adapter;
    public product.truckkz.viewModels.HomeViewModels viewModels;
    private boolean isMoreState = true;
    private int indexShow = 0;
    @org.jetbrains.annotations.NotNull
    private java.lang.String callInfo = "";
    
    public HomeInfoFragment() {
        super();
    }
    
    private final product.truckkz.databinding.FragmentHomeInfoBinding getBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.recyclerview.widget.RecyclerView getRecyclerView() {
        return null;
    }
    
    public final void setRecyclerView(@org.jetbrains.annotations.NotNull
    androidx.recyclerview.widget.RecyclerView p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final product.truckkz.windows.home.UpdateDataAdapter getAdapter() {
        return null;
    }
    
    public final void setAdapter(@org.jetbrains.annotations.NotNull
    product.truckkz.windows.home.UpdateDataAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final product.truckkz.viewModels.HomeViewModels getViewModels() {
        return null;
    }
    
    public final void setViewModels(@org.jetbrains.annotations.NotNull
    product.truckkz.viewModels.HomeViewModels p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCallInfo() {
        return null;
    }
    
    public final void setCallInfo(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @java.lang.Override
    @android.annotation.SuppressLint(value = {"SetTextI18n", "UseCompatLoadingForDrawables"})
    @org.jetbrains.annotations.Nullable
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void callPhone() {
    }
    
    private final java.lang.String removeStartEnDChars(java.lang.String str) {
        return null;
    }
    
    @java.lang.Override
    public void onDestroyView() {
    }
}