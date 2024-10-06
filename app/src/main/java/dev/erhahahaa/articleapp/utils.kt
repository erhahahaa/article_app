package dev.erhahahaa.articleapp

import android.graphics.drawable.ColorDrawable

fun setDefaultAppBarColor(
  supportActionBar: androidx.appcompat.app.ActionBar?,
  window: android.view.Window,
  resources: android.content.res.Resources,
  theme: android.content.res.Resources.Theme
) {
  supportActionBar?.setBackgroundDrawable(
    ColorDrawable(
      resources.getColor(
        com.google.android.material.R.color.design_default_color_primary, theme
      )
    )
  )
  window.statusBarColor =
    resources.getColor(com.google.android.material.R.color.design_default_color_primary, theme)
}