package ru.itis.notes.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class NoteController {
    List notes = new ArrayList();
    List pagNotes = new ArrayList();
    int pagPages = 0;
    @GetMapping("/notes/{var}")
    public String getNotes(Model model, @PathVariable(required = false) int var){
        if (var == 0) {
            return "redirect:notes/1";
        }
        pagNotes.clear();
        int end = var*5;
        int start = end-5;

        if (end>notes.size()) {
            end = notes.size();
        }

        for (int i = start; i <end; i++) {
            if (notes.get(i) != null) {
                pagNotes.add(notes.get(i));
            }
        }

        model.addAttribute("notes", pagNotes);
    return "notes";
    }

    @PostMapping("/addnotes")
    public String addNotes(@RequestParam String singlenote){
        if (!singlenote.isEmpty()) {
            notes.add(singlenote);
        }
        return "addnote";
    }

    @GetMapping("/addnotes")
    public String addNotesShow(){
        return "addnote";
    }
}
