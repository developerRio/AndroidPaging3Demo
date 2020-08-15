package com.originalstocks.pagination3demo.data

import androidx.lifecycle.ViewModelProvider
import com.originalstocks.pagination3demo.api.GithubService
import com.originalstocks.pagination3demo.model.ViewModelFactory

/**
 * Class that handles object creation.
 * Like this, objects can be passed as [parameters] in the constructors and then replaced for
 * testing, where needed.
 */
object Injection {

    /**
     * Creates an instance of [GithubRepository] based on the [GithubService] and a
     * [GithubLocalCache]
     */
    private fun provideGithubRepository(): GithubRepository {
        return GithubRepository(GithubService.create())
    }

    /**
     * Provides the [ViewModelProvider.Factory] that is then used to get a reference to
     * [ViewModel] objects.
     */
    fun provideViewModelFactory(): ViewModelProvider.Factory {
        return ViewModelFactory(provideGithubRepository())
    }
}
