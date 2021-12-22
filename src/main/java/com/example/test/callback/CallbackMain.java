package com.example.test.callback;

public class CallbackMain {

    public static void main(String[] args) {
        Callback cal = new Callback() {
            @Override
            public void done(int n) {
                System.out.println("Callback");
            }
        };

    }

}
