package org.example.AdderSubtractor;

public class Hello extends Hii{

    Hello(int x, String string) {
        super(x, string);
    }

    @Override
    void hi() {
        System.out.println("Hello");
    }

    public static void main(String[] args) {
        Hii hii = new Hello(5, "Hello");
        hii.hi();
        switch (2+3){
            case 2:
                System.out.println("nigga");
            case 5:
                System.out.println("httt");
        }
    }
}
