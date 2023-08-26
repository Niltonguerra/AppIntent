package nilton.dionisio.app_gerenciamento_intent

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var btContato:Button;
    lateinit var btLocal:Button;
    lateinit var btSite:Button;
    lateinit var btNovaTela:Button;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btContato = findViewById(R.id.btContato)
        btLocal = findViewById(R.id.btLocal)
        btNovaTela = findViewById(R.id.btNovaTela)
        btSite = findViewById(R.id.btSite)


        btContato.setOnClickListener{exibirContatos()}

        btLocal.setOnClickListener{exibirLocal()}

        btSite.setOnClickListener{exibirSite()}

        btNovaTela.setOnClickListener{exibirNovaTela()}







    }

    private fun exibirNovaTela() {
        val intent:Intent = Intent(baseContext,Tela2Activity::class.java)
        startActivity(intent)
    }

    private fun exibirSite() {
            //val é uma variavel usada que logo será descartada
        val dados = Uri.parse("https://www.google.com")
        //essa faz uma intenção para abrir um aplicativo, aqui está fazendo a abertura de um site
        val intent:Intent = Intent(Intent.ACTION_VIEW,dados)
        startActivity(intent)
    }

    private fun exibirLocal() {
        //o terceiro parametro o '?z=19' é o zoom no map
        val dados= Uri.parse("geo:-23.663339956718456, -46.46012480331242?z=19")

        //faz uma pesquisa no google maps quando abrir o arquivo
        //val dados= Uri.parse("geo:0,0?z19&q=""fatec maua")

        val intent:Intent = Intent(Intent.ACTION_VIEW,dados)
        startActivity(intent)
    }

    private fun exibirContatos() {
        val dados= Uri.parse("content://contacts/people/2")
        val intent:Intent = Intent(Intent.ACTION_VIEW,dados)
        startActivity(intent)

    }
}