package ru.catshome.studiojournal.ui

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import ru.catshome.studiojournal.R

sealed class BottomItem (val route: String, val iconField: ImageVector,  val iconOutline: ImageVector,  @StringRes val resourceId: Int) {

        object Children : BottomItem("children", Icons.Filled.Home, Icons.Outlined.Home , R.string.children)
        object Groups : BottomItem("groups",Icons.Filled.Home, Icons.Outlined.Home , R.string.groups)
        object Pay : BottomItem("pays",Icons.Filled.Home, Icons.Outlined.Home , R.string.pays)
        object Visit : BottomItem("visits", Icons.Filled.Home, Icons.Outlined.Home , R.string.visits)
        object Rate : BottomItem("rate", Icons.Filled.Home, Icons.Outlined.Home , R.string.rate)
    }

