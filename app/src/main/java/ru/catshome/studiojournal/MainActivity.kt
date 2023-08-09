package ru.catshome.studiojournal

import android.os.Bundle
import androidx.activity.ComponentActivity

import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import dagger.hilt.android.AndroidEntryPoint
import ru.catshome.studiojournal.ui.GroupViewModal
import ru.catshome.studiojournal.ui.StudioApp
import ru.catshome.studiojournal.ui.groupScreen
import ru.catshome.studiojournal.ui.theme.StudioJournalTheme
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
     //@Inject lateinit var vm: GroupViewModal
  //  @Inject lateinit var childViewModel: ChildViewModel
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
           StudioJournalTheme {
            // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //groupScreen()
                    //StudioApp(groupViewModal = vm)
                    StudioApp()

                }
            }
        }
    }
}
