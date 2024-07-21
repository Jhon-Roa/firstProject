package com.firstproject;

import com.firstproject.console.Initializer;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Initializer();
            }
        }); 
    }
}