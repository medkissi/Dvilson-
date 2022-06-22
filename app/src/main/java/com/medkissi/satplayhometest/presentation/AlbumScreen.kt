package com.medkissi.satplayhometest.presentation

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.medkissi.satplayhometest.data.model.Entry
import com.medkissi.satplayhometest.data.model.Title

private const val TAG = "AlbumScreen"

@Composable
fun AlbumScreen() {
    val viewModel: AlbumViewModel = hiltViewModel()

    LazyColumn() {
        items(viewModel.state.value) { album ->
            AlbumItem(item = album)

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

            AlbumImage(item.imImage.first().label, modifier = Modifier.weight(0.15f))
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
    )

}
