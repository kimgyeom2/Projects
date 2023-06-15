package com.gy25m.coffeeground

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : AppCompatActivity() {

    val wv :WebView by lazy { findViewById(R.id.wv) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // webview의 기본설정
        wv.settings.javaScriptEnabled=true // 웹뷰 설정객체를 통해 js사용을 허용하도록 설정

        wv.webViewClient= WebViewClient() // 지금은 안써도됨 혹시모르니까 씀
        // 새로운 웹문서가 열릴때 기본 웹뷰는 새탭으로 열리기에 이 웹뷰가아니라 웹브라우저가 실행되면서 열림
        wv.webChromeClient= WebChromeClient() // alert나 confirm같은 팝업기능을 사용하도록

        // 웹뷰가 보여줄 웹문서(.html)로드하기
        // 웹문서가 있는 위치는 프로젝트안에 있거나 웹서버에 위치 할 수 있음
        // 프로젝트 안에있으면 서버문제가 있어도 구동되지만 업뎃할때 번거로움

        // 1. 프로젝트안에 assets 폴더안에 html문서 위치
        // wv.loadUrl("file:///android_asset/index.html")

        // 2. 닷홈 or AWS(아마존웹서버) 같은 웹서버에 html문서 위치
        // wv.loadUrl("http://gyeom2.dothome.co.kr")
        // wv.loadUrl("http://gyeom2.dothome.co.kr/ajax/05_ajax.html")
        wv.loadUrl("http://mrhisj23.dothome.co.kr/WebProjTeamC/")
    }

    override fun onBackPressed() {
        if(wv.canGoBack()) wv.goBack()
        else finish()
    }
}