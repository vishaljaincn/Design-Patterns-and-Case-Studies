package org.example.CustomOptional;

import lombok.Getter;

@Getter
public class Utils<U> {
    private final U value;

    public Utils(U value) {
        this.value = value;
    }

    public <T> T identity(T value) {
        return value;
    }
    public U getValue() {
        return value;
    }

    public static void main(String[] args) {
        Utils numericUtils = new Utils(123);
        Utils stringutil = new Utils("Hello");
        System.out.println(numericUtils.getValue()); // Output: 123
        System.out.println(stringutil.getValue()); // Output: Hello
//        Utils<String> utils = new Utils<>("Hello");
//        String result = utils.identity("World");
//        System.out.println(result); // Output: World
//
//        // Using MyOptional
//        MyOptional<String> optionalValue = MyOptional.of("Hello");
//        System.out.println(optionalValue.get()); // Output: Hello
//
//        MyOptional<String> emptyValue = MyOptional.empty();
//        System.out.println(emptyValue.isPresent()); // Output: false
    }

}
