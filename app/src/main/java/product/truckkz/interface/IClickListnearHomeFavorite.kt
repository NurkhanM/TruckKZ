package product.truckkz.`interface`

import product.truckkz.databinding.ItemTovarBinding

interface IClickListnearHomeFavorite {
    fun clickListener(baseID: Int)
    fun clickListenerFavorite(baseID: Int, v: Any, boolean: Boolean, pos: Int)
}