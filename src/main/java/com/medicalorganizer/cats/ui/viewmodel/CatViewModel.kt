package com.medicalorganizer.cats.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.medicalorganizer.cats.data.model.Cat
import com.medicalorganizer.cats.data.model.MedicalFile
import com.medicalorganizer.cats.data.repository.CatRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class CatViewModel @Inject constructor(
    private val repository: CatRepository
) : ViewModel() {

    private val _allCats = MutableStateFlow<List<Cat>>(emptyList())
    val allCats: StateFlow<List<Cat>> = _allCats.asStateFlow()

    private val _currentCat = MutableStateFlow<Cat?>(null)
    val currentCat: StateFlow<Cat?> = _currentCat.asStateFlow()

    private val _medicalFiles = MutableStateFlow<List<MedicalFile>>(emptyList())
    val medicalFiles: StateFlow<List<MedicalFile>> = _medicalFiles.asStateFlow()

    private val _searchResults = MutableStateFlow<List<Cat>>(emptyList())
    val searchResults: StateFlow<List<Cat>> = _searchResults.asStateFlow()

    init {
        loadAllCats()
    }

    private fun loadAllCats() {
        viewModelScope.launch {
            repository.getAllCats().collect { cats ->
                _allCats.value = cats
            }
        }
    }

    fun selectCat(cat: Cat) {
        _currentCat.value = cat
        loadMedicalFiles(cat.id)
    }

    fun loadMedicalFiles(catId: Long) {
        viewModelScope.launch {
            repository.getMedicalFilesByCat(catId).collect { files ->
                _medicalFiles.value = files
            }
        }
    }

    fun addCat(cat: Cat) {
        viewModelScope.launch {
            repository.addCat(cat)
        }
    }

    fun updateCat(cat: Cat) {
        viewModelScope.launch {
            repository.updateCat(cat)
        }
    }

    fun deleteCat(cat: Cat) {
        viewModelScope.launch {
            repository.deleteCat(cat)
        }
    }

    fun addMedicalFile(medicalFile: MedicalFile) {
        viewModelScope.launch {
            repository.addMedicalFile(medicalFile)
        }
    }

    fun deleteMedicalFile(medicalFile: MedicalFile) {
        viewModelScope.launch {
            repository.deleteMedicalFile(medicalFile)
        }
    }

    fun searchCats(query: String) {
        viewModelScope.launch {
            repository.searchCats(query).collect { results ->
                _searchResults.value = results
            }
        }
    }
}
