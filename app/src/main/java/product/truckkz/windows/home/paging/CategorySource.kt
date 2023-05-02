package product.truckkz.windows.home.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.bumptech.glide.load.HttpException
import product.truckkz.data.retrofit.api.category.CategoryService
import product.truckkz.models.category.Children
import java.io.IOException

class CategorySource
    (
    private val apiService: CategoryService,
) : PagingSource<Int, Children>() {

    override fun getRefreshKey(state: PagingState<Int, Children>) = state.anchorPosition

    override suspend fun load(params: LoadParams<Int>):
            LoadResult<Int, Children> {
        val currentPage = params.key ?: 1

        return try {
            val response = apiService.getCategoryPaging(currentPage)
            val data = response.body()?.data?.get(0)?.children ?: emptyList()
            val responseData = mutableListOf<Children>()
            responseData.add(Children(
                children = emptyList(),
                created_at = "",
                description = "",
                id = 0,
                img = "",
                name = "Все категории",
                parent_id = -1,
                slug = ""
            ))
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