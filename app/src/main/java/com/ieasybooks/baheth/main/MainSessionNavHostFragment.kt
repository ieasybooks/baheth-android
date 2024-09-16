package com.ieasybooks.baheth.main

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.ieasybooks.baheth.features.web.WebBottomSheetFragment
import com.ieasybooks.baheth.features.web.WebFragment
import com.ieasybooks.baheth.util.HOME_URL
import com.ieasybooks.baheth.util.customUserAgent
import com.ieasybooks.baheth.util.initDayNightTheme
import dev.hotwire.turbo.config.TurboPathConfiguration
import dev.hotwire.turbo.session.TurboSessionNavHostFragment
import kotlin.reflect.KClass

class MainSessionNavHostFragment : TurboSessionNavHostFragment() {
    override var sessionName = "main"

    override var startLocation = HOME_URL

    override val registeredFragments: List<KClass<out Fragment>>
        get() = listOf(
            WebFragment::class,
            WebBottomSheetFragment::class
        )

    override val registeredActivities: List<KClass<out AppCompatActivity>>
        get() = listOf()

    override val pathConfigurationLocation: TurboPathConfiguration.Location
        get() = TurboPathConfiguration.Location(
            assetFilePath = "json/configuration.json",
            remoteFileUrl = "${startLocation}/configurations/android-v1.json"
        )

    override fun onSessionCreated() {
        super.onSessionCreated()

        session.webView.settings.userAgentString = session.webView.customUserAgent
        session.webView.initDayNightTheme()
    }
}
