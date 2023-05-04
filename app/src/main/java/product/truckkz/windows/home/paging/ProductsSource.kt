package product.truckkz.windows.home.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.bumptech.glide.load.HttpException
import product.truckkz.data.retrofit.api.products.ProductService
import product.truckkz.models.products.index.Data
import java.io.IOException

class ProductsSource
    (
    private val apiService: ProductService,
    private val auth: String,
    private val allPro: HashMap<String, String>
) : PagingSource<Int, Data>() {

    override fun getRefreshKey(state: PagingState<Int, Data>) = state.anchorPosition

    override suspend fun load(params: LoadParams<Int>):
            LoadResult<Int, Data> {
        val currentPage = params.key ?: 1

        return try {
            val response = apiService.getCategoryProducts(auth, allPro, currentPage)
            val data = response.body()?.data ?: emptyList()
            val responseData = mutableListOf<Data>()
            responseData.addAll(data)

            LoadResult.Page(
                data = responseData,
                prevKey = if (currentPage == 1) null else currentPage - 1,
                nextKey = if (responseData.isEmpty()) null else currentPage + 1
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }

}