@file:OptIn(ExperimentalFoundationApi::class)

package com.istudio.materialapp.modules.ui_swipabletabrows

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.TabRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextOverflow
import com.istudio.materialapp.R

data class TabData(val title : String)

@Composable
fun TabContent() {

    val items = listOf(
        TabData(title = "Tab-1"),
        TabData(title = "Tab-2"),
        TabData(title = "Tab-3")
    )

    var selectedTabIndex by remember { mutableIntStateOf(0) }
    var pagerState = rememberPagerState { items.size }

    // This block will be triggered whenever our selected index is changed
    LaunchedEffect(selectedTabIndex) {
        pagerState.animateScrollToPage(selectedTabIndex)
    }

    LaunchedEffect(pagerState.currentPage,pagerState.isScrollInProgress) {
        // When the current page changes in pager  - update the selected Index Tab
        if(!pagerState.isScrollInProgress){
            selectedTabIndex = pagerState.currentPage
        }
    }

    Column( modifier = Modifier.fillMaxSize() ) {

        PrimaryTabRow(selectedTabIndex = selectedTabIndex) {
            items.forEachIndexed { index, tabData ->
                Tab(
                    // This tells that if the current tab is selected or not:-> Because we need to tell somehow the tab is selected( condition: selected tab is equal to current index that's looped)
                    selected = selectedTabIndex == index,
                    // On click update the selected index
                    onClick = { selectedTabIndex = index },
                    // Set the text composable
                    text = { Text(text = items[index].title) }
                )
            }
        }

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) { index ->

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {

                Text(text = items[index].title)

            }

        }
    }


}