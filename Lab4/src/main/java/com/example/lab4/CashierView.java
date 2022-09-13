package com.example.lab4;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.web.reactive.function.client.WebClient;

@Route(value = "/index2")
public class CashierView extends VerticalLayout {
    TextField all, b1000, b500, b100, b20, b10, b5, b1;
    Button cal;

    CashierView(){
        all = new TextField("เงินทอน");
        all.setPrefixComponent(new Span("$"));
        b1000 = new TextField();
        b500 = new TextField();
        b100 = new TextField();
        b20 = new TextField();
        b10 = new TextField();
        b5 = new TextField();
        b1 = new TextField();
        b1000.setEnabled(false);
        b500.setEnabled(false);
        b100.setEnabled(false);
        b20.setEnabled(false);
        b10.setEnabled(false);
        b5.setEnabled(false);
        b1.setEnabled(false);
        b1000.setPrefixComponent(new Span("$1000:"));
        b500.setPrefixComponent(new Span("$500:"));
        b100.setPrefixComponent(new Span("$100:"));
        b20.setPrefixComponent(new Span("$20:"));
        b10.setPrefixComponent(new Span("$10:"));
        b5.setPrefixComponent(new Span("$5:"));
        b1.setPrefixComponent(new Span("$1:"));
        cal = new Button("คำนวณเงินทอน");
        add(all, cal, b1000, b500, b100, b20, b10, b5, b1);

        cal.addClickListener(e -> {
            int num = Integer.parseInt(all.getValue());
            Change out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/getChange/"+Integer.parseInt(String.valueOf(num)))
                    .retrieve()
                    .bodyToMono(Change.class)
                    .block();
            b1000.setValue(String.valueOf(out.getB1000()));
            b500.setValue(String.valueOf(out.getB500()));
            b100.setValue(String.valueOf(out.getB100()));
            b20.setValue(String.valueOf(out.getB20()));
            b10.setValue(String.valueOf(out.getB10()));
            b5.setValue(String.valueOf(out.getB5()));
            b1.setValue(String.valueOf(out.getB1()));
        });
    }
}
