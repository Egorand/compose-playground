package dev.egorand.composeplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.egorand.composeplayground.demos.PhotosPager
import dev.egorand.composeplayground.ui.theme.ComposePlaygroundTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      ComposePlaygroundTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
          Demos.PhotosPager.composable()
        }
      }
    }
  }
}

enum class Demos(
  val label: String,
  val composable: @Composable () -> Unit,
) {
  PhotosPager(
    label = "Photos pager",
    composable = { PhotosPager() },
  ),
}
