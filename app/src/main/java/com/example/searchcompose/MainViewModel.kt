package com.example.searchcompose

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel: ViewModel() {

    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()


    private val _isSearching = MutableStateFlow(false)
    val isSearching = _isSearching.asStateFlow()

    private val _person = MutableStateFlow(listOf<Person>())




}

data class Person(
    val firstName:String,
    val lastName:String
){
    fun doesMatchSearchQuery(query:String):Boolean{
        val matchingCombinations = listOf(
            "$firstName$lastName",
            "$firstName $lastName",
            "${firstName.first()} ${lastName.first()}"
        )

        return matchingCombinations.any {
            it.contains(query, ignoreCase = true)
        }
    }
}

private val allPerson = listOf(

    Person(
        firstName = "Philipp",
        lastName = "Lackner"
    ),
    Person(
        firstName = "Asadbek",
        lastName = "Aminboyev"
    ),
    Person(
        firstName = "Furqat",
        lastName = "Aminov"
    ),
    Person(
        firstName = "Javlonbek",
        lastName = "Sharipov"
    ),


)