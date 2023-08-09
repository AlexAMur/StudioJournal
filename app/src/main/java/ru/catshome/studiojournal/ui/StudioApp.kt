package ru.catshome.studiojournal.ui

import android.annotation.SuppressLint
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState

import androidx.navigation.compose.rememberNavController


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun StudioApp(childViewModel: ChildViewModel = viewModel(),
                studioNavController: NavHostController = rememberNavController( )
) {
    var selectedItem by remember {mutableStateOf(0)}
    val items = listOf(
        BottomItem.Children,
        BottomItem.Visit,
        BottomItem.Pay,
        BottomItem.Groups,
        BottomItem.Rate
    )


    Scaffold(
        bottomBar = {
            NavigationBar {
                items.forEachIndexed{index, bottomItem ->
                    NavigationBarItem(

                        selected = selectedItem === index,
                        onClick = { selectedItem = index
                                  studioNavController.navigate(bottomItem.route)},
                        icon = {
                            if (selectedItem === index) {
                                Icon(bottomItem.iconField, contentDescription = "")
                            } else {
                            }
                            Icon(bottomItem.iconOutline, contentDescription = "")
                        },
                        label = { Text(text = stringResource(id = bottomItem.resourceId))},
                       
                    )
                }
            }
                val navBackStackEntry by studioNavController.currentBackStackEntryAsState()

        }
    ) {
       navGraph(studioNavController = studioNavController)
    }
}
