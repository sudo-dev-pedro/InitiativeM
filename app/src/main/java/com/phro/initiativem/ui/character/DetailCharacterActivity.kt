package com.phro.initiativem.ui.character

import android.os.Build
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.phro.initiativem.ui.ui.theme.InitiativeMTheme

class DetailCharacterActivity : AppCompatActivity() {
    private val viewModel by lazy {
        ViewModelProvider(this)[CharacterViewModel::class.java]
    }

    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InitiativeMTheme {
                ShowContent(Modifier.fillMaxSize())
            }
        }
        viewModel.getCharacterByName("Thanos")
    }

    @RequiresApi(Build.VERSION_CODES.S)
    @Composable
    private fun ShowContent(modifier: Modifier = Modifier) {
        val characterState = viewModel.characterStateFlow.collectAsStateWithLifecycle()

        /**
         * Modifiers:
         * https://developer.android.com/jetpack/compose/modifiers-list?hl=pt-br
         */
        Surface(modifier = modifier) {
            Column(
                modifier = modifier.fillMaxWidth()
            ) {
                CharacterImage(
                    characterState.value?.get(0)?.thumbnail?.path
                        ?: "Loading..."
                )
                CharacterTitle(
                    characterTitle = characterState.value?.get(0)?.name
                        ?: "Loading..."
                )
                CharacterDescription(
                    characterDescription = characterState.value?.get(0)?.description
                        ?: "Loading..."
                )
            }
        }
    }

    @OptIn(ExperimentalGlideComposeApi::class)
    @Composable
    private fun CharacterImage(
        model: String,
        modifier: Modifier = Modifier
    ) {
        Box(
            modifier
                .fillMaxWidth()
                .padding(28.dp)
        ) {
            GlideImage(
                model = model,
                contentDescription = "Image",
                modifier = modifier
            ) {
                it.load("$model.jpg").circleCrop()
            }
        }
    }

    // Preview Parameter - https://foso.github.io/Jetpack-Compose-Playground/general/preview/previewparameter/
    @Composable
    private fun CharacterTitle(characterTitle: String, modifier: Modifier = Modifier) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .padding(
                    vertical = 12.dp,
                    horizontal = 12.dp,
                )
        ) {
            Text(
                style = MaterialTheme.typography.headlineMedium,
                text = characterTitle
            )
        }
    }

    @Composable
    private fun CharacterDescription(
        characterDescription: String,
        modifier: Modifier = Modifier
    ) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .padding(
                    vertical = 12.dp,
                    horizontal = 12.dp
                )
        ) {
            Text(
                text = characterDescription
            )
        }
    }

    @RequiresApi(Build.VERSION_CODES.S)
    @Preview(showBackground = true, apiLevel = 34)
    @Composable
    private fun Preview() {
        InitiativeMTheme {
            CharacterTitle(
                characterTitle = "Test"
            )
        }
    }

}