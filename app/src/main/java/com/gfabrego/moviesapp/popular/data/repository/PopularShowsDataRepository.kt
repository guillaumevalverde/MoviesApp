package com.gfabrego.moviesapp.popular.data.repository

import com.gfabrego.moviesapp.popular.data.network.PopularShowsApiDataSource
import com.gfabrego.moviesapp.popular.domain.model.PageRequest
import com.gfabrego.moviesapp.popular.domain.model.PopularShowsResponse
import com.gfabrego.moviesapp.popular.domain.repository.PopularShowsRepository
import io.reactivex.Single

internal class PopularShowsDataRepository(private val popularShowsApiDataSource: PopularShowsApiDataSource) :
    PopularShowsRepository {

    override fun getPopularShows(pageRequest: PageRequest): Single<PopularShowsResponse> =
        when (pageRequest) {
            is PageRequest.Paged -> popularShowsApiDataSource.getPopularShows(pageRequest)
        }
}
