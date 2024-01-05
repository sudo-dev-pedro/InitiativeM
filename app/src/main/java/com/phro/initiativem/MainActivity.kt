package com.phro.initiativem

import android.os.Build
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.phro.initiativem.ui.ui.theme.InitiativeMTheme

/** TO-DO:
 * - Remove XML to add the Compose
 * - Add a Search box to type the character name
 */
class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            InitiativeMTheme {
                Surface {
                    Search()
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun Search(modifier: Modifier = Modifier) {
        var text by remember { mutableStateOf("") }
        var active by remember { mutableStateOf(false) }

        Column(
            modifier = modifier
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
        ) {
            TextField(
                modifier = modifier
                    .fillMaxWidth()
                    .heightIn(min = 56.dp),
                value = "",
                onValueChange = {
                    text = it
                },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null
                    )
                },
                placeholder = {
                    Text("Character name...")
                }
            )
        }
    }
}