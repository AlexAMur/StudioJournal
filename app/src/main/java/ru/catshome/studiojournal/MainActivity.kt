package ru.catshome.studiojournal

import android.os.Bundle
import androidx.activity.ComponentActivity

import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import dagger.hilt.android.AndroidEntryPoint
import ru.catshome.studiojournal.ui.ChildViewModel
import ru.catshome.studiojournal.ui.addGroup
import ru.catshome.studiojournal.ui.newChildScreen
import ru.catshome.studiojournal.ui.newGroupScreen
import ru.catshome.studiojournal.ui.theme.StudioJournalTheme
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
   // private val mainViewModel by viewModels<MainViewModel>()
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

                ) {
                    newChildScreen()
                 //   newGroupScreen()
                }
            }
        }
    }
}
