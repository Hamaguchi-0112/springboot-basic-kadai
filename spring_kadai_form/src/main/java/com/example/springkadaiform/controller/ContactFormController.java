package com.example.springkadaiform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.springkadaiform.form.ContactForm;

@Controller
public class ContactFormController {

    @GetMapping("/form")
    public String form(Model model) {
       
        if (!model.containsAttribute("form")) {
            model.addAttribute("form", new ContactForm());
        }
        return "contactFormView";
    }

    @PostMapping("/confirm")
    public String confirm(RedirectAttributes redirectAttributes,
                          @Validated @ModelAttribute("form") ContactForm form,
                          BindingResult result) {

        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.form", result);
            redirectAttributes.addFlashAttribute("form", form);
            return "redirect:/form";
        }

        return "confirmView";
    }
}
