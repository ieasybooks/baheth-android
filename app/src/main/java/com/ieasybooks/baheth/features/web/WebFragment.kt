package com.ieasybooks.baheth.features.web

import android.os.Bundle
import android.view.View
import com.ieasybooks.baheth.base.NavDestination
import dev.hotwire.turbo.fragments.TurboWebFragment
import dev.hotwire.turbo.nav.TurboNavGraphDestination

@TurboNavGraphDestination(uri = "turbo://fragment/web")
open class WebFragment : TurboWebFragment(), NavDestination {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toolbarForNavigation()?.visibility = View.GONE
    }
}
