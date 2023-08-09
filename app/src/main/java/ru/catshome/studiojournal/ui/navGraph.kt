package ru.catshome.studiojournal.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun navGraph(studioNavController: NavHostController){
    NavHost(navController = studioNavController, startDestination = BottomItem.Children.route) {
        composable(route = BottomItem.Children.route) {
            ChildContent(studioNavController)
        }
        composable(route = BottomItem.Visit.route) {
            visitScreen()
        }
        composable(route = BottomItem.Pay.route) {
            paysScreen()
        }
        composable(route = BottomItem.Groups.route) {backStrackEntry->
          val groupViewModal = hiltViewModel<GroupViewModal>()
            groupScreen(groupViewModal)
        }
        composable(route = BottomItem.Rate.route) {
            rateScreen()
        }

    }
}