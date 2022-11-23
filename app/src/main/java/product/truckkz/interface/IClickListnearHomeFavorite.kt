package product.truckkz.`interface`

import android.view.View

interface IClickListnearHomeFavorite {
    fun clickListener(baseID: Int)
    fun clickListenerFavorite(baseID: Int, v: View, boolean: Boolean, pos: Int)
}