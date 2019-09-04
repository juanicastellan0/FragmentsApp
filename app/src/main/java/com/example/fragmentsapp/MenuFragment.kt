package com.example.fragmentsapp


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton


class MenuFragment : Fragment() {

    private val menuButtons: IntArray = intArrayOf(R.id.lantern, R.id.music, R.id.level)
    private val activeMenuButtons: IntArray = intArrayOf(R.drawable.linterna2, R.drawable.musica2, R.drawable.nivel2)
    private var activeButton = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val menu: View = inflater.inflate(R.layout.fragment_menu, container, false)

        var menuButton: ImageButton

        for (button in menuButtons) {
            menuButton = menu.findViewById(button)
            val actualButton: Int = button
            menuButton.setOnClickListener {
                when (activity) {
                    is MainActivity -> startActivity(
                        Intent(activity, ToolsActivity::class.java).putExtra("button", actualButton))
                    is ToolsActivity -> (activity as ToolsActivity).manageButton(button)
                }
            }
        }

        return menu
    }


}
