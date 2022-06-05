package dev.egorand.composeplayground.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalView
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun ComposePlaygroundTheme(
  darkTheme: Boolean = isSystemInDarkTheme(),
  // Dynamic color is available on Android 12+
  content: @Composable () -> Unit
) {
  val colors = if (darkTheme) darkColors() else lightColors()

  val view = LocalView.current
  if (!view.isInEditMode) {
    val systemUiController = rememberSystemUiController()
    SideEffect {
      systemUiController.setSystemBarsColor(
        color = colors.surface,
        darkIcons = !darkTheme,
      )
    }
  }

  MaterialTheme(
    colors = colors,
    content = content
  )
}
