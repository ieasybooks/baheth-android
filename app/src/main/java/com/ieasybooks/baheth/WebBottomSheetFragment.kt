package com.ieasybooks.baheth

import android.os.Bundle
import android.view.View
import dev.hotwire.turbo.fragments.TurboWebBottomSheetDialogFragment
import dev.hotwire.turbo.nav.TurboNavGraphDestination

@TurboNavGraphDestination(uri = "turbo://fragment/web/bottom/sheet")
class WebBottomSheetFragment : TurboWebBottomSheetDialogFragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toolbarForNavigation()?.visibility = View.GONE
    }
}
