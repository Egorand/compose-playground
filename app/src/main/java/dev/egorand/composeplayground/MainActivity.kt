package dev.egorand.composeplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import dev.egorand.composeplayground.demos.PhotosPager
import dev.egorand.composeplayground.ui.theme.ComposePlaygroundTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      ComposePlaygroundTheme {
        Surface {
          var currentDemo by remember { mutableStateOf<Demo?>(null) }
          Scaffold(
            topBar = {
              TopAppBar(
                title = {
                  Text(currentDemo?.label ?: stringResource(R.string.app_name))
                },
                backgroundColor = MaterialTheme.colors.surface,
              )
            },
            modifier = Modifier.fillMaxSize(),
          ) { padding ->
            if (currentDemo != null) {
              currentDemo!!.composable()
            } else {
              LazyColumn(modifier = Modifier.padding(padding)) {
                items(Demo.values()) { demo ->
                  DemoRow(demo, onClick = { currentDemo = demo })
                }
              }
            }

            if (currentDemo != null) {
              BackHandler {
                currentDemo = null
              }
            }
          }
        }
      }
    }
  }
}

@Composable
fun DemoRow(
  demo: Demo,
  onClick: () -> Unit,
) {
  Row(
    verticalAlignment = CenterVertically,
    modifier = Modifier
      .fillMaxWidth()
      .clickable(onClick = onClick)
      .padding(16.dp),
  ) {
    Text(
      text = demo.label,
      style = MaterialTheme.typography.h5,
    )
  }
}

enum class Demo(
  val label: String,
  val composable: @Composable () -> Unit,
) {
  PhotosPager(
    label = "Photos pager",
    composable = { PhotosPager() },
  ),
}
