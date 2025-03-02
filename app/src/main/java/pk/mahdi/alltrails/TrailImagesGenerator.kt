package com.adammcneilly.alltrails

object TrailImagesGenerator {
    private val images = listOf(
        R.drawable.boardwalk,
        R.drawable.path,
        R.drawable.trail,
        R.drawable.valley,
    )

    fun generate(): List<Int> = images.shuffled()
}
