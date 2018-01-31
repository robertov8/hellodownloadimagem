package br.com.livroandroid.hellodownloadimagem

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dialog = ProgressDialog.show(this, "Download",
                "Fazendo o download da iamgem, por favor aguarde...", false, true)

        Thread {
            val URL = "http://livroandroid.com.br/site/imgs/livro_android.png"
            // Download da imagem
            val bitmap = Download.downloadBitMap(URL)
            runOnUiThread {
                // Atualiza o ImageView
                img.setImageBitmap(bitmap)
                // Fecha o dialog
                dialog.dismiss()
            }
        }.start()
    }
}
