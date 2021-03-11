package com.example.kot

public interface Command<T> {
    fun execute():T
}