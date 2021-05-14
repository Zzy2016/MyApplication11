package com.example.myapplication11;

public class SafeVarargsTest<S> {
    private S[] args;


    public SafeVarargsTest(S... args) {
        this.args = args;
    }
}
