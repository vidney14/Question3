package com.example.midterm3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.midterm3.ui.theme.Midterm3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Midterm3Theme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        @OptIn(ExperimentalMaterial3Api::class)
                        TopAppBar(title = { Text("Student List") })
                    }
                ) { innerPadding ->
                    // We pass the innerPadding to the StudentList to handle system bars
                    StudentList(
                        students = students,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

val students = listOf(
    "Alice", "Bob", "Charlie", "Dana", "Eric",
    "Fatima", "Grace", "Hiro", "Isabel", "Jack",
    "Karen", "Luis", "Maya", "Nate", "Olivia",
    "Priya", "Quinn", "Ravi", "Sara", "Tom"
)

@Composable
fun StudentList(
    students: List<String>,
    modifier: Modifier = Modifier
) {
    // LazyColumn IS THE SCROLLABLE CONTAINER.
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp) // Increased spacing
    ) {
        items(students) { student ->
            StudentItem(name = student)
        }
    }
}

@Composable
fun StudentItem(name: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Text(
            text = name,
            modifier = Modifier.padding(32.dp), // Increased padding to make items taller
            style = MaterialTheme.typography.headlineSmall // Larger font
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun StudentListPreview() {
    Midterm3Theme {
        StudentList(students = students)
    }
}
