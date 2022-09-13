package com.example.lab4;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "/calPage")
public class View extends VerticalLayout {
    private Button btn;
    public View(){
        btn = new Button("Submit");
        add(btn);
    }
}
