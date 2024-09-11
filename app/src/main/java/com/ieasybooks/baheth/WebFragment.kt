package com.ieasybooks.baheth

import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.browser.customtabs.CustomTabColorSchemeParams
import androidx.browser.customtabs.CustomTabsIntent
import androidx.browser.customtabs.CustomTabsIntent.SHARE_STATE_ON
import dev.hotwire.turbo.fragments.TurboWebFragment
import dev.hotwire.turbo.nav.TurboNavDestination
import dev.hotwire.turbo.nav.TurboNavGraphDestination

@TurboNavGraphDestination(uri = "turbo://fragment/web")
open class WebFragment : TurboWebFragment(), TurboNavDestination {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toolbarForNavigation()?.visibility = View.GONE
    }

    override fun shouldNavigateTo(newLocation: String): Boolean {
        return when (isNavigable(newLocation)) {
            true -> true
            else -> {
                launchCustomTab(newLocation)
                false
            }
        }
    }

    private fun isNavigable(location: String): Boolean {
        return location.startsWith("https://baheth.ieasybooks.com") &&
                !location.contains("active_storage") &&
                !location.contains("download")
    }

    private fun launchCustomTab(location: String) {
        val context = fragment.context ?: return
        val colorParams = CustomTabColorSchemeParams.Builder().build()

        CustomTabsIntent.Builder()
            .setShowTitle(true)
            .setShareState(SHARE_STATE_ON)
            .setUrlBarHidingEnabled(false)
            .setDefaultColorSchemeParams(colorParams)
            .build()
            .launchUrl(context, Uri.parse(location))
    }
}
