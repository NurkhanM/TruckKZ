package product.truckkz.api

import androidx.paging.PagingSource
import androidx.paging.PagingState
import product.truckkz.UserDate.TOKEN_USER
import product.truckkz.models.products.index.Data
import retrofit2.HttpException
import java.io.IOException

class SearchPaging
    (
    private val apiService: ApiService,
    private val map: HashMap<String, String>,
) : PagingSource<Int, Data>() {

    override fun getRefreshKey(state: PagingState<Int, Data>) = state.anchorPosition

    override suspend fun load(params: LoadParams<Int>):
            LoadResult<Int, Data> {
        val currentPage = params.key ?: 1

        return try {
            val response = apiService.getSortProducts("Bearer $TOKEN_USER", map, currentPage)
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