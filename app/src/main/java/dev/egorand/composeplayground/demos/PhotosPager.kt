package dev.egorand.composeplayground.demos

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import dev.egorand.composeplayground.ui.theme.ComposePlaygroundTheme

private val photoUrls = listOf(
  "https://images.unsplash.com/photo-1579282240050-352db0a14c21",
  "https://images.unsplash.com/photo-1583422409516-2895a77efded",
  "https://images.unsplash.com/flagged/photo-1570533136641-42082acf8d0c",
  "https://images.unsplash.com/photo-1523531294919-4bcd7c65e216",
  "https://images.unsplash.com/photo-1534001265532-393289eb8ed3",
  "https://images.unsplash.com/photo-1558642084-fd07fae5282e",
  "https://images.unsplash.com/photo-1529551739587-e242c564f727",
  "https://images.unsplash.com/photo-1610213989414-acc5773ba2c6",
  "https://images.unsplash.com/photo-1589708532758-ddd0753b0f2f",
)

@Composable
@OptIn(ExperimentalPagerApi::class)
fun PhotosPager() {
  Column(modifier = Modifier.fillMaxSize()) {
    val pagerState = rememberPagerState()
    HorizontalPager(
      count = photoUrls.size,
      state = pagerState,
      modifier = Modifier.weight(1f),
    ) { page ->
      AsyncImage(
        model = photoUrls[page],
        contentDescription = null,
        modifier = Modifier.fillMaxWidth(),
      )
    }
    HorizontalPagerIndicator(
      pagerState = pagerState,
      modifier = Modifier
        .align(CenterHorizontally)
        .padding(bottom = 16.dp),
    )
  }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
  ComposePlaygroundTheme {
    PhotosPager()
  }
}
