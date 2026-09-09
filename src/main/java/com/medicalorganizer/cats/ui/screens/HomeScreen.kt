package com.medicalorganizer.cats.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.medicalorganizer.cats.data.model.Cat
import com.medicalorganizer.cats.ui.viewmodel.CatViewModel

@Composable
fun HomeScreen(
    viewModel: CatViewModel,
    onCatSelected: (Cat) -> Unit,
    onAddCatClick: () -> Unit
) {
    val cats = viewModel.allCats.collectAsState().value

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = onAddCatClick,
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                Icon(Icons.Filled.Add, contentDescription = "Add Cat")
            }
        }
    ) { innerPadding ->
        if (cats.isEmpty()) {
            EmptyCatsScreen(onAddCatClick, Modifier.padding(innerPadding))
        } else {
            CatListScreen(cats, onCatSelected, Modifier.padding(innerPadding))
        }
    }
}

@Composable
fun CatListScreen(
    cats: List<Cat>,
    onCatSelected: (Cat) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            Text(
                text = "My Cats",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }
        items(cats) { cat ->
            CatCardItem(cat, onCatSelected)
        }
    }
}

@Composable
fun CatCardItem(
    cat: Cat,
    onCatSelected: (Cat) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.surfaceVariant,
                shape = RoundedCornerShape(12.dp)
            )
            .clickable { onCatSelected(cat) }
            .padding(16.dp)
    ) {
        Column {
            Text(
                text = cat.name,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            if (cat.breed.isNotEmpty()) {
                Text(
                    text = "Breed: ${cat.breed}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            if (cat.notes.isNotEmpty()) {
                Text(
                    text = cat.notes,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }
    }
}

@Composable
fun EmptyCatsScreen(
    onAddCatClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "No cats yet!",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Add your first cat to get started",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(top = 8.dp, bottom = 24.dp)
        )
        Button(onClick = onAddCatClick) {
            Text("Add First Cat")
        }
    }
}
