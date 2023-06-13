package com.ieasybooks.baheth

import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import dev.hotwire.turbo.config.TurboPathConfiguration
import dev.hotwire.turbo.session.TurboSessionNavHostFragment
import kotlin.reflect.KClass

class MainSessionNavHost : TurboSessionNavHostFragment() {
    override var sessionName = "main"
    override var startLocation = "https://baheth.ieasybooks.com"

    override val registeredFragments: List<KClass<out Fragment>>
        get() = listOf(
            WebFragment::class
        )

    override val registeredActivities: List<KClass<out AppCompatActivity>>
        get() = listOf()

    override val pathConfigurationLocation: TurboPathConfiguration.Location
        get() = TurboPathConfiguration.Location(assetFilePath = "json/configuration.json")

    override fun onSessionCreated() {
        super.onSessionCreated()
        session.webView.settings.userAgentString = customUserAgent(session.webView)
    }

    private fun customUserAgent(webView: WebView): String {
        return "Turbo Native Android ${webView.settings.userAgentString}"
    }
}
