package product.truckkz.`interface`

import android.view.View
import product.truckkz.databinding.ItemTovarBinding

interface IClickListnearHomeFavorite {
    fun clickListener(baseID: Int)
    fun clickListenerFavorite(baseID: Int, v: ItemTovarBinding, boolean: Boolean, pos: Int)
}