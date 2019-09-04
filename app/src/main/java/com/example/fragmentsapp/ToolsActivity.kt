package com.example.fragmentsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

class ToolsActivity : AppCompatActivity() {

    private var fragments: Map<Int, Fragment> = mapOf(
        R.id.lantern to LanternFragment(),
        R.id.music to MusicFragment(),
        R.id.level to LevelFragment())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tools)

        intent.extras?.getInt("button")?.let { manageButton(it) }
    }

    fun manageButton(button: Int) {
        val transaction = supportFragmentManager.beginTransaction()

        val bundle = Bundle().putInt("activeButton", button)
        /** MenuFragment().apply {  }(bundle) **/

        transaction.replace(R.id.tools,fragments[button] ?: error("Fragment not found"))
        transaction.commit()
    }
}
