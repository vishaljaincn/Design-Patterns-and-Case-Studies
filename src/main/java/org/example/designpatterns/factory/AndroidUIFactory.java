package org.example.designpatterns.factory;

import org.example.designpatterns.factory.components.button.AndroidButton;
import org.example.designpatterns.factory.components.menu.AndroidMenu;

public class AndroidUIFactory implements UIFactory {
    @Override
    public AndroidButton createButton() {
        return new AndroidButton();
    }

    @Override
    public AndroidMenu createMenu() {
        return new AndroidMenu();
    }
}
