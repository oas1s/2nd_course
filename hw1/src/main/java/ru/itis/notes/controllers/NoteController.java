package ru.itis.notes.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.notes.models.Note;

import java.util.ArrayList;
import java.util.List;

@Controller
public class NoteController {
    List<Note> notes = new ArrayList();
    List<Note> subNotes = new ArrayList();
    List<Note> searchNotes = new ArrayList();
    List<Integer> pagList = new ArrayList<>();

    @GetMapping("/notes/{var}")
    public String getNotes(Model model, @PathVariable(required = false) int var) {
        pagList.clear();
        if (var == 0) {
            return "redirect:/notes/1";
        }
        subNotes.clear();
        int end = var * 5;
        int start = end - 5;
        int pagPages = (int) notes.size() / 5 + 1;

        for (int i = 0; i < pagPages; i++) {
            pagList.add(i + 1);
        }

        if (end > notes.size()) {
            end = notes.size();
        }

        for (int i = start; i < end; i++) {
            if (notes.get(i) != null) {
                subNotes.add(notes.get(i));
            }
        }

        model.addAttribute("notes", subNotes);
        model.addAttribute("palest", pagList);
        return "notes";
    }

    @PostMapping("/addnotes")
    public String addNotes(@ModelAttribute Note singlenote) {
        if (!singlenote.getName().isEmpty()) {
            notes.add(singlenote);
        }
        return "addnote";
    }

    @GetMapping("/addnotes")
    public String addNotesShow() {
        return "addnote";
    }

    @PostMapping("/search")
    public String searchNotes(Model model, @RequestParam String searchName) {
        searchNotes.clear();
        pagList.clear();
        int pagPages = (int) pagList.size() / 5 + 1;
        for (int i = 0; i < pagPages; i++) {
            pagList.add(i + 1);
        }
        for (int i = 0; i < notes.size(); i++) {
            if (notes.get(i).getName().startsWith(searchName)) {
                searchNotes.add(notes.get(i));
            }
        }
        model.addAttribute("notes", searchNotes);
        model.addAttribute("palest", pagList);
        return "notes";
    }
    @GetMapping("/search1/{var}")
    public String searchNotes1(Model model, @RequestParam( name = "searchName", required = false) String searchName, @PathVariable(required = false) int var) {
        searchNotes.clear();
        pagList.clear();
        for (int i = 0; i < notes.size(); i++) {
            if (notes.get(i).getName().startsWith(searchName)) {
                searchNotes.add(notes.get(i));
            }
        }
        if (var == 0) {
            return "redirect:/search1/1";
        }
        subNotes.clear();
        int end = var * 5;
        int start = end - 5;
        int pagPages = (int) searchNotes.size() / 5 + 1;

        for (int i = 0; i < pagPages; i++) {
            pagList.add(i + 1);
        }

        if (end > searchNotes.size()) {
            end = searchNotes.size();
        }

        for (int i = start; i < end; i++) {
            if (searchNotes.get(i) != null) {
                subNotes.add(searchNotes.get(i));
            }
        }
        model.addAttribute("search",searchName);
        model.addAttribute("notes", subNotes);
        model.addAttribute("palest", pagList);
        return "search";
    }
}