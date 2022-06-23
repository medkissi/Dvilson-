package com.medkissi.satplayhometest.ui.presentation

import android.widget.GridLayout
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.medkissi.satplayhometest.R
import com.medkissi.satplayhometest.data.model.Entry
import com.medkissi.satplayhometest.data.model.Title

private const val TAG = "AlbumScreen"

@Composable
fun AlbumScreen(viewModel: AlbumViewModel = hiltViewModel()) {
    val state = viewModel.state.value

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        if (state.isLoading) {
            CircularProgressIndicator()
        }
        if (state.error != null) {
            Text(
                text = stringResource(R.string.error_message),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(8.dp)

            )

        }
        LazyColumn() {
            items(state.albums) { album ->
                AlbumItem(item = album)

            }

        }
    }


}

@Composable
fun AlbumItem(item: Entry) {
    Card(

        elevation = 4.dp,
        modifier = Modifier.padding(8.dp)

    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {

            AlbumImage(item.imImage.first().label, modifier = Modifier.weight(0.20f))
            AlbumDetails(
                title = item.title,
                descriptiom = item.imName.label,
                modifier = Modifier.weight(0.70f)
            )

        }

    }


}

@Composable
fun AlbumDetails(title: Title, descriptiom: String, modifier: Modifier) {
    Column(modifier = modifier) {
        Text(
            text = title.label,
            style = MaterialTheme.typography.h6
        )
        CompositionLocalProvider(
            LocalContentAlpha provides ContentAlpha.medium
        ) {
            Text(
                text = descriptiom,
                style = MaterialTheme.typography.body1
            )

            Text(
                text = descriptiom,
                style = MaterialTheme.typography.body1
            )

        }


    }
}

@Composable
fun AlbumImage(label: String, modifier: Modifier) {
    AsyncImage(
        model = label,
        contentDescription = "album image",
        contentScale = ContentScale.Crop,
        modifier = modifier
            .size(100.dp)
            .clip(MaterialTheme.shapes.medium)
    )

}
