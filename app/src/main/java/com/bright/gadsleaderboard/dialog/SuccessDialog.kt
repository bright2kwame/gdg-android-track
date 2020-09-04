package com.bright.gadsleaderboard.dialog


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.Nullable
import androidx.fragment.app.DialogFragment
import com.bright.gadsleaderboard.BaseInterface
import com.bright.gadsleaderboard.R
import com.google.android.material.button.MaterialButton


class SuccessDialog : DialogFragment() {
    @Nullable
    override fun onCreateView(
        inflater: LayoutInflater,
        @Nullable container: ViewGroup?,
        @Nullable savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.success_dialog, container, false)
        dialog?.setTitle("")
        return view
    }
}