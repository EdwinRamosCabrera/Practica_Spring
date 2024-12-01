package com.example.practica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.practica.model.Calculadora;
import jakarta.validation.Valid; // Desde Jakarta EE 9+

@Controller
public class CalculadoraController {

    // Mostrar el formulario de la calculadora
    @GetMapping("/calculator")
    public String showCalculatorForm(Model model) {
        model.addAttribute("calculator", new Calculadora()); // Objeto vacío para el formulario
        return "calculator-form";
    }

    // Procesar los datos del formulario
    @PostMapping("/calculate")
    public String calculate(@ModelAttribute Calculadora calculator, Model model) {
        double result = 0;

        // Realizar la operación según el valor seleccionado
        switch (calculator.getOperation()) {
            case "add":
                result = calculator.getNumber1() + calculator.getNumber2();
                break;
            case "subtract":
                result = calculator.getNumber1() - calculator.getNumber2();
                break;
            case "multiply":
                result = calculator.getNumber1() * calculator.getNumber2();
                break;
            case "divide":
                if (calculator.getNumber2() != 0) {
                    result = calculator.getNumber1() / calculator.getNumber2();
                } else {
                    model.addAttribute("error", "No se puede dividir por cero.");
                    return "calculator-form";
                }
                break;
            default:
                model.addAttribute("error", "Operación no válida.");
                return "calculator-form";
        }

        calculator.setResult(result);
        model.addAttribute("calculator", calculator); // Pasar el objeto actualizado
        return "calculator-result";
    }
}
