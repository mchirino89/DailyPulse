package com.geekingwithmauri.dailypulse

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform