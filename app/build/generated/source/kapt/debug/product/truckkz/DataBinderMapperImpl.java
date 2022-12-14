package product.truckkz;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(0);

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(2);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    result.add(new gun0912.tedimagepicker.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(24);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "album");
      sKeys.put(2, "background");
      sKeys.put(3, "buttonBackground");
      sKeys.put(4, "buttonDrawableOnly");
      sKeys.put(5, "buttonGravity");
      sKeys.put(6, "buttonText");
      sKeys.put(7, "buttonTextColor");
      sKeys.put(8, "duration");
      sKeys.put(9, "imageCountFormat");
      sKeys.put(10, "isAlbumOpened");
      sKeys.put(11, "isOpened");
      sKeys.put(12, "isSelected");
      sKeys.put(13, "items");
      sKeys.put(14, "media");
      sKeys.put(15, "mediaCountText");
      sKeys.put(16, "selectType");
      sKeys.put(17, "selectedAlbum");
      sKeys.put(18, "selectedNumber");
      sKeys.put(19, "showButton");
      sKeys.put(20, "showZoom");
      sKeys.put(21, "text");
      sKeys.put(22, "textColor");
      sKeys.put(23, "uri");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(0);
  }
}
