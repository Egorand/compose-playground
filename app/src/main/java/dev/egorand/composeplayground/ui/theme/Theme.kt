package dev.egorand.composeplayground.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

@Composable
fun ComposePlaygroundTheme(
  darkTheme: Boolean = isSystemInDarkTheme(),
  // Dynamic color is available on Android 12+
  content: @Composable () -> Unit
) {
  val colors = if (darkTheme) darkColors() else lightColors()
  MaterialTheme(
    colors = colors,
    content = content
  )
}
