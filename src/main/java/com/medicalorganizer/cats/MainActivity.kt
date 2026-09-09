package com.medicalorganizer.cats

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.medicalorganizer.cats.ui.screens.HomeScreen
import com.medicalorganizer.cats.ui.theme.CatMedicalOrganizerTheme
import com.medicalorganizer.cats.ui.viewmodel.CatViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CatMedicalOrganizerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    val viewModel = CatViewModel()

                    NavHost(
                        navController = navController,
                        startDestination = "home"
                    ) {
                        composable("home") {
                            HomeScreen(
                                viewModel = viewModel,
                                onCatSelected = { cat ->
                                    viewModel.selectCat(cat)
                                    navController.navigate("cat_detail/${cat.id}")
                                },
                                onAddCatClick = {
                                    navController.navigate("add_cat")
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}
