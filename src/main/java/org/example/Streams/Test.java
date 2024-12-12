package org.example.Streams;

class LastError<T> {
    private T lastError;

    void setError(T t) {
        lastError = t;
        System.out.println("LastError: setError");
    }
}

class StrLastError<S extends CharSequence> extends LastError<String> {
    public StrLastError(S s) {
    }

    void setError(S s) {
        System.out.println("StrLastError: setError");
    }
}

class Test {
    public static void main(String[] args) {
        String s = "5";
        System.out.println(1 + 10 + s + 1 + 10);
    }
}