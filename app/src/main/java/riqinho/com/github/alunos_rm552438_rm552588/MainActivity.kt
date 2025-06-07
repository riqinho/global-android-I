package riqinho.com.github.alunos_rm552438_rm552588

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import android.content.Intent
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: ItemViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val toolbar : Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "GeoImpacto"

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val itemsAdapter = ItemsAdapter { item ->
            viewModel.removeItem(item)
        }
        recyclerView.adapter = itemsAdapter

        val button = findViewById<Button>(R.id.btn_incluir)
        val local = findViewById<EditText>(R.id.ipt_nome_local)
        val evento = findViewById<EditText>(R.id.ipt_evento)
        val impacto = findViewById<EditText>(R.id.ipt_impacto)
        val data = findViewById<EditText>(R.id.ipt_data)
        val pessoas = findViewById<EditText>(R.id.ipt_pessoas)

        button.setOnClickListener {
            if(local.text.isEmpty() || evento.text.isEmpty() || impacto.text.isEmpty() || data.text.isEmpty() || pessoas.text.isEmpty()){
                Toast.makeText(this, "Preencha todos os campos obrigatórios", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val item = ItemModel(
                local = local.text.toString(),
                evento = evento.text.toString(),
                impacto = impacto.text.toString(),
                data = data.text.toString(),
                qtd_pessoas = pessoas.text.toString()
            )

            viewModel.addItem(item)

            local.text.clear()
            evento.text.clear()
            impacto.text.clear()
            data.text.clear()
            pessoas.text.clear()
        }

        val viewModelFactory = ItemsViewModelFactory(application)
        viewModel = ViewModelProvider(this, viewModelFactory).get(ItemViewModel::class.java)

        viewModel.itemsLiveData.observe(this) { items ->
            itemsAdapter.updateItems(items)
        }

        val btnIntegrantes = findViewById<Button>(R.id.btn_integrantes)
        btnIntegrantes.setOnClickListener {
            val intent = Intent(this, IntegrantesActivity::class.java)
            startActivity(intent)
        }

        //adicional
        val campoBusca = findViewById<EditText>(R.id.ipt_busca)

        campoBusca.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val texto = s.toString().lowercase()
                val filtrados = viewModel.itemsLiveData.value?.filter {
                    it.local.lowercase().contains(texto)
                } ?: emptyList()
                itemsAdapter.updateItems(filtrados)
            }
            override fun afterTextChanged(s: Editable?) {}
        })
    }
}