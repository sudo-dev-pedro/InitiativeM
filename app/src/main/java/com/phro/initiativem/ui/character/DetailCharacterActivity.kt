package com.phro.initiativem.ui.character

import android.os.Build
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
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
import com.example.myapplication.ui.theme.InitiativeMTheme

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

        Surface(
            modifier = modifier,
            color = MaterialTheme.colorScheme.background
        ) {
            CharacterTitle(characterTitle = characterState.value?.get(0)?.name ?: "Empty")
        }

    }

    // Preview Parameter - https://foso.github.io/Jetpack-Compose-Playground/general/preview/previewparameter/
    @Composable
    private fun CharacterTitle(characterTitle: String) {
        Surface(color = MaterialTheme.colorScheme.primary) {
            Text(
                text = characterTitle,
                /**
                 * https://developer.android.com/jetpack/compose/modifiers-list?hl=pt-br
                 */
                modifier = Modifier.padding(10.dp)
            )
        }
    }

    @RequiresApi(Build.VERSION_CODES.S)
    @Preview(showBackground = true)
    @Composable
    private fun Preview() {
        InitiativeMTheme {
            CharacterTitle(
                characterTitle = "Test"
            )
        }
    }


//    private fun observeCharacterLiveData() {
//        detailViewModel.characterLiveData.observe(this) {

//            if (it.isNotEmpty()) {
//                characterBinding.txtName.text = it[0].name
//                characterBinding.txtDescription.text = it[0].description
//                Glide
//                    .with(this)
//                    .load(it[0].thumbnail.path + ".jpg")
//                    .into(characterBinding.thumbnail)
//            } else {
//                val buildDialog = AlertDialog.Builder(this)
//                    .setMessage("Tivemos um erro!")
//                    .setNegativeButton("Close") { dialog, _ ->
//                        dialog.dismiss()
//                    }
//                buildDialog.create().show()
//            }
//        }
//    }
}