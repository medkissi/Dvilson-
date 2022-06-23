package com.medkissi.satplayhometest.ui.albumscreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.medkissi.satplayhometest.R
import com.medkissi.satplayhometest.data.model.Entry
import com.medkissi.satplayhometest.data.model.Title

private const val TAG = "AlbumScreen"

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AlbumScreen(viewModel: AlbumViewModel = hiltViewModel()) {
    val state = viewModel.state.value
    val searchState = remember { mutableStateOf(TextFieldValue("")) }
    val searchText = searchState.value.text

    Column(modifier = Modifier.padding(vertical = 16.dp)) {
        SearchBar(state = searchState, modifier = Modifier.padding(horizontal = 16.dp))
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

            LazyColumn(modifier = Modifier.align(Alignment.TopCenter)) {
                items(state.albums.filter {
                    it.imName.label.contains(
                        searchText,
                        ignoreCase = true
                    ) || it.imArtist.label.contains(
                        searchText, ignoreCase = true
                    )
                }, key = { it.id.attributes.imId }) { album ->
                    AlbumItem(item = album, modifier = Modifier.animateItemPlacement())

                }

            }
        }

    }


}

@Composable
fun AlbumItem(item: Entry,modifier:Modifier) {


    Card(

        elevation = 4.dp,
        modifier = modifier.padding(8.dp)

    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {

            AlbumImage(item.imImage.first().label, modifier = Modifier.weight(0.30f))
            Spacer(modifier = Modifier.width(8.dp))
            AlbumDetails(
                title = item.title,
                descriptiom = item.imArtist.label,
                itemCount = item.imItemCount.label,
                modifier = Modifier
                    .weight(0.70f)
                    .alignByBaseline()
            )


        }

    }


}

@Composable
fun AlbumDetails(title: Title, descriptiom: String, itemCount: String, modifier: Modifier) {
    Column(modifier = modifier) {
        Text(
            text = title.label,
            style = MaterialTheme.typography.h6,
            maxLines = 3,
            overflow = TextOverflow.Ellipsis

        )
        CompositionLocalProvider(
            LocalContentAlpha provides ContentAlpha.medium
        ) {
            Text(
                text = descriptiom,
                style = MaterialTheme.typography.body1
            )
            Text(
                text = "$itemCount Song",
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
            .size(120.dp)
            .clip(MaterialTheme.shapes.medium)
    )

}

@Composable
fun SearchBar(modifier: Modifier, state: MutableState<TextFieldValue>) {

    TextField(
        value = state.value,
        onValueChange = { newValue ->
            state.value = newValue
        },
        placeholder = { Text(text = "Search") },
        leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = null) },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.surface
        ),
        singleLine = true,
        modifier = modifier
            .heightIn(56.dp)
            .fillMaxWidth()

    )


}

