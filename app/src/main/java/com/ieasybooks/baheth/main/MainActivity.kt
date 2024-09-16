package com.ieasybooks.baheth.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ieasybooks.baheth.R
import dev.hotwire.turbo.activities.TurboActivity
import dev.hotwire.turbo.delegates.TurboActivityDelegate

class MainActivity : AppCompatActivity(), TurboActivity {
    override lateinit var delegate: TurboActivityDelegate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        delegate = TurboActivityDelegate(this, R.id.main_nav_host)

        supportActionBar?.hide()
    }
}
