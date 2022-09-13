package com.example.lab4;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Route(value = "/index1")
public class MathView extends VerticalLayout {
    private TextField t1, t2, ans;
    private Label l1;
    private Button plus, minus, multi, divide, mod, max;

    public MathView(){
        t1 = new TextField("Number 1");
        t2 = new TextField("Number 2");
        ans = new TextField("Answer");
        ans.setEnabled(false);
        plus = new Button("+");
        minus = new Button("-");
        multi = new Button("x");
        divide = new Button("/");
        mod = new Button("Mod");
        max = new Button("Max");
        l1 = new Label("Operator");
        HorizontalLayout h1 = new HorizontalLayout();
        h1.add(plus, minus, multi, divide, mod, max);
        add(t1, t2, l1, h1, ans);

        plus.addClickListener(e -> {
            double num1 = Double.parseDouble(t1.getValue());
            double num2 = Double.parseDouble(t2.getValue());

            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/plus/" + num1 + "/" + num2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
                    ans.setValue(out);
        });

        minus.addClickListener(e -> {
            double num1 = Double.parseDouble(t1.getValue());
            double num2 = Double.parseDouble(t2.getValue());

            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/minus/" + num1 + "/" + num2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            ans.setValue(out);
        });

        multi.addClickListener(e -> {
            double num1 = Double.parseDouble(t1.getValue());
            double num2 = Double.parseDouble(t2.getValue());

            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/multi/" + num1 + "/" + num2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            ans.setValue(out);
        });

        divide.addClickListener(e -> {
            double num1 = Double.parseDouble(t1.getValue());
            double num2 = Double.parseDouble(t2.getValue());

            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/divide/" + num1 + "/" + num2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            ans.setValue(out);
        });

        mod.addClickListener(e -> {
            double num1 = Double.parseDouble(t1.getValue());
            double num2 = Double.parseDouble(t2.getValue());

            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/mod/" + num1 + "/" + num2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            ans.setValue(out);
        });

        max.addClickListener(e -> {

            MultiValueMap<String, String> formData = new LinkedMultiValueMap<String, String>();
            formData.add("n1", t1.getValue());
            formData.add("n2", t2.getValue());

            String out = WebClient.create()
                    .post()
                    .uri("http://localhost:8080/max")
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                    .body(BodyInserters.fromFormData(formData))
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            ans.setValue(out);
        });
    }
}
