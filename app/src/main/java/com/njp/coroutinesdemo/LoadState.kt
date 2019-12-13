package com.njp.coroutinesdemo

sealed class LoadState(val msg: String = "") {
    class Loading : LoadState()
    class Success : LoadState()
    class Fail(msg: String) : LoadState(msg)
}