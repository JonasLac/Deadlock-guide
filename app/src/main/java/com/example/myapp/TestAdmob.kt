package com.example.myapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.nativead.NativeAd
import com.google.android.gms.ads.nativead.NativeAdOptions
import com.squareup.picasso.Picasso

class TestAdmob : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_admob)

        // Inicializar o Mobile Ads SDK
        MobileAds.initialize(this)

        // Configurar o AdLoader
        val adLoader = AdLoader.Builder(
            this,
            "ca-app-pub-2104181702379477/3804519887"
        ) // ID de anúncio de teste
            .forNativeAd { nativeAd: NativeAd ->
                // Chamar o método para popular o layout com os dados do anúncio
                populateNativeAdView(nativeAd)
            }
            .withAdListener(object : com.google.android.gms.ads.AdListener() {
                override fun onAdFailedToLoad(adError: com.google.android.gms.ads.LoadAdError) {
                    // Logar o erro de carregamento
                    println("Falha ao carregar o anúncio: ${adError.message}")
                }
            })
            .withNativeAdOptions(NativeAdOptions.Builder().build())
            .build()

        // Carregar o anúncio
        adLoader.loadAd(AdRequest.Builder().build())
    }

    // Método para popular o layout com os dados do anúncio nativo
    private fun populateNativeAdView(nativeAd: NativeAd) {
        // Encontrar as views
        val headlineView = findViewById<TextView>(R.id.ad_headline)
        val imageView = findViewById<ImageView>(R.id.ad_image)
        val bodyView = findViewById<TextView>(R.id.ad_body)

        // Configurar os dados do anúncio
        headlineView.text = nativeAd.headline
        bodyView.text = nativeAd.body

        // Carregar a imagem do anúncio usando Picasso (ou outro método)
        val image = nativeAd.images.firstOrNull()?.uri
        if (image != null) {
            Picasso.get().load(image).into(imageView)
        }
    }
}
