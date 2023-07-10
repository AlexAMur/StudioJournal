package ru.catshome.studiojournal.ui

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun customButton(label: String,
                 modifier: Modifier,
                 colors: ButtonColors = ButtonDefaults.buttonColors(),
                 onClick:()->Unit
)
{
    Button(onClick = onClick,
        colors = colors
    ) {
        Text(text = label)

    }
}