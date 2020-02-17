package ru.itis.notes.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class NoteController {
    List notes = new ArrayList();
    @GetMapping("/notes")
    public String getNotes(Model model){
        model.addAttribute("notes", notes);
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
