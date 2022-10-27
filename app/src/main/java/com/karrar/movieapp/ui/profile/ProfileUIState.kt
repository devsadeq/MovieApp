package com.karrar.movieapp.ui.profile

data class ProfileUIState (
    val avatarPath: String = "",
    val name: String = "",
    val username: String = "",
    val isLoading: Boolean = false,
    val isLoggedIn: Boolean = false,
    val isFail: Boolean = false,
    val isSuccess: Boolean = true,
)