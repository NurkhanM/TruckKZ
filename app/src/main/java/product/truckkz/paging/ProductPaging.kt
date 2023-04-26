package product.truckkz.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import product.truckkz.api.products.ProductService
import product.truckkz.models.products.index.Data
import retrofit2.HttpException
import java.io.IOException

class ProductPaging
    (
    private val apiService: ProductService,
    private val auth: String
) : PagingSource<Int, Data>() {

    override fun getRefreshKey(state: PagingState<Int, Data>) = state.anchorPosition

    override suspend fun load(params: LoadParams<Int>):
            LoadResult<Int, Data> {
        val currentPage = params.key ?: 1

        return try {
            val response = apiService.getProduct(auth)
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