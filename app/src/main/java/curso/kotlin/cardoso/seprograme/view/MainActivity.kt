package curso.kotlin.cardoso.seprograme.view

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.android.material.snackbar.Snackbar
import curso.kotlin.cardoso.seprograme.R
import curso.kotlin.cardoso.seprograme.data.MeusCompromissos
import curso.kotlin.cardoso.seprograme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    var listaDeCompromissos = mutableListOf<MeusCompromissos>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        var trabalho = MeusCompromissos(
            nomeCompromissos = "Trabalho",
            dataCompromissos = 8 / 30 / 2023,
            horaCompromissos = "10:30"
        )

        incluirCompromisso(trabalho)

        var curso = MeusCompromissos(
            nomeCompromissos =  "Curso",
            dataCompromissos = 8 / 30 / 2023,
            horaCompromissos = "16:30"
        )

        var academia = MeusCompromissos(
            nomeCompromissos = "academia",
            dataCompromissos = 8 / 30 / 2023,
            horaCompromissos = "19:30"
        )

        incluirCompromisso(academia)

        var reuniao = MeusCompromissos(
            nomeCompromissos = "reunião",
            dataCompromissos = 8 / 30 / 2023,
            horaCompromissos = "20:30"
        )

        incluirCompromisso(reuniao)

        deletarCompromissoByObjeto(curso)

        // incluirCompromisso(curso)

         //Lista - Itens - ID (PK) únicos - Ordem - Detalhes - Incluir
         //Log.v("AppKotlin""1 Meu Compromisso ${trabalho.nomeCompromissos} ${trabalho.dataCompromissos} ${trabalho.horaCompromissos}")
         //Log.v("AppKotlin""2 Meu Compromisso ${curso.nomeCompromissos} ${curso.dataCompromissos} ${curso.horaCompromissos}")

        //deletarCompromisso(numeroCompromissos = 1)
        alterarCompromisso(numeroCompromissos = 2)



        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

    fun nomeDoMetodo() : Boolean{

        return true

    }

    //CRUD - Create - Retrieve - Update - Delete
    //SQL  - Insert - Select - Update - Delete from comrpomissos WHERE id = deletarCompromissosByID
    fun incluirCompromisso(meusCompromissos: MeusCompromissos) {

       Log.e(
           "AppKotlin" ,
           "Objeto: Meu compromisso ${meusCompromissos.nomeCompromissos} ${meusCompromissos.dataCompromissos} ${meusCompromissos.horaCompromissos}"
       )

        listaDeCompromissos.add(meusCompromissos)
        listarCompromisso()

    }

    fun deletarCompromissoByID(numeroCompromissos: Int){

        //Regra de Negócio
        Log.i("AppKotlin" ,"Compromisso da lista #$numeroCompromissos deletado com sucesso." )

    }

    fun deletarCompromissoByObjeto(meusCompromissos: MeusCompromissos ) {

        //Regra de Negócio
        Log.i("AppKotlin" ,"Compromisso da lista #${meusCompromissos.nomeCompromissos} deletado com sucesso." )

        listaDeCompromissos.remove(meusCompromissos)
        listarCompromisso()


    }

    fun alterarCompromisso(numeroCompromissos: Int){

        //Regra de Negócio -> Buscar o registro do Compromisso ID #numeroCompromisso-> Buscar na Lista -> Collection -> ArrayList
        Log.i("AppKotlin" ,"Compromisso da lista #$numeroCompromissos alterado com sucesso." )


    }

    fun listarCompromisso(){

        var contador = listaDeCompromissos.size;

        Log.i("ListaCompromisso" ,"# $contador registro(s) encontrado(s) na lista de Compromissos" )


    }

    //TODO: incluir novos métodos - adcionar, Deletar, Listar/ver algo

}