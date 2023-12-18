package com.phro.initiativem.ui.character

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.phro.initiativem.databinding.ActivityDetailCharacterBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailCharacterActivity : AppCompatActivity() {

    private lateinit var characterBinding: ActivityDetailCharacterBinding
    private lateinit var view: View
    // Realizando a injeção da minha VM na minha Activity
    /**
     * Doc do Koin:
     * The viewModel keyword helps declaring a factory instance of ViewModel.
     * This instance will be handled by internal ViewModelFactory
     * and reattach ViewModel instance if needed.
     */
//    private val detailViewModel: CharacterViewModel by viewModel()

    // Provendo a VM para o meu escopo.
    // Funciona sem, mas usar o Provider é uma recomendação da Google.
    private val detailViewModel by lazy {
        ViewModelProvider(this).get(CharacterViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        characterBinding = ActivityDetailCharacterBinding.inflate(layoutInflater)
        view = characterBinding.root
        setContentView(view)

        detailViewModel.getCharacterByName("Thanos")

        observeCharacterLiveData()
    }

    private fun observeCharacterLiveData() {
        detailViewModel.characterLiveData.observe(this) {

            if (it.isNotEmpty()) {
                characterBinding.txtName.text = it[0].name
                characterBinding.txtDescription.text = it[0].description
                Glide
                    .with(this)
                    .load(it[0].thumbnail.path + ".jpg")
                    .into(characterBinding.thumbnail)
            } else {
                val buildDialog = AlertDialog.Builder(this)
                    .setMessage("Tivemos um erro!")
                    .setNegativeButton("Close") { dialog, _ ->
                        dialog.dismiss()
                    }
                buildDialog.create().show()
            }
        }
    }
}