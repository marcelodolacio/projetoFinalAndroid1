package com.ilm.projetofinal.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ilm.projetofinal.R
import com.ilm.projetofinal.domain.LoginData
import com.ilm.projetofinal.domain.LoginResult
import com.ilm.projetofinal.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var viewmodelLogin: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt_Login.setOnClickListener {
            login();
        }

        tv_Cadastro.setOnClickListener {
            registro();
        }

        tv_esqueciSenha.setOnClickListener {
            esqueciSenha();
        }

        viewmodelLogin = LoginViewModel(application)
        viewmodelLogin.resultadoParaTela.observe(this) { resultado ->
            processarResultLogin(resultado)
        }
    }

    fun login(){

        val email = ti_Email.text.toString();
        val senha = ti_Senha.text.toString();

/*      CRIADO LoginViewModel
        if(email.isNotBlank() && senha.isNotBlank()){
            Toast.makeText(this, "FUNCIONOU",Toast.LENGTH_LONG).show();
        }

        val autenticacao = FirebaseAuth.getInstance();
        val operacao = autenticacao.signInWithEmailAndPassword(email,senha);
        operacao.addOnCompleteListener { resultado ->
            if(resultado.isSuccessful){
                // intents
                val navegaParaTelaPrincipal = Intent(this, HomeActivity::class.java);
                startActivity(navegaParaTelaPrincipal);
            }else{
                Toast.makeText(this, "Erro: Usuário ou senha inexistentes",Toast.LENGTH_LONG).show();
            }
        }
 */
        val data = LoginData(email, senha)
        viewmodelLogin.login(data)
    }

    fun processarResultLogin(res: LoginResult){
        //mensagem de erro para usuario atraves de Toast
        if(res.error != null) {
            Toast.makeText(this, res.error, Toast.LENGTH_LONG).show()
            return
        }

        val intentHome = Intent(this, HomeActivity::class.java)
        startActivity(intentHome)
        finish() //finalizar pilha! Evitar que, ao usuario clicar em voltar no aparelho, ele retorne para tela de login novamente
    }




    fun esqueciSenha(){
        val navegaParaEsqueciSenha = Intent(this, EsqueciSenhaActivity::class.java);
        startActivity(navegaParaEsqueciSenha);
    }

    fun registro(){
        val navegaParaTelaCadastro = Intent(this, CadastroActivity::class.java);
        startActivity(navegaParaTelaCadastro);
    }

}