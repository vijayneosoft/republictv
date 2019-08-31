package com.neosoft.republictv.presentation.viewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.neosoft.republictv.domain.usecases.ListOfUsersUC
import com.neosoft.republictv.presentation.viewmodel.ListOfUsersVM
import javax.inject.Inject

/**
 * Created by Vijay on 30/8/19.
 */

class ViewModelFactory
@Inject
constructor(val mListOfUsersUC: ListOfUsersUC) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListOfUsersVM::class.java)) {
            return ListOfUsersVM(mListOfUsersUC) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}
