package ru.itis.notes.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.notes.entity.NoteEntity;
import ru.itis.notes.models.Note;
import ru.itis.notes.repositories.NoteRepository;
import ru.itis.notes.service.NoteService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class NoteJpaController {

    @Autowired
    private NoteService noteService;

//    List<NoteEntity> notes = new ArrayList<>();
//    List<NoteEntity> subNotes = new ArrayList<>();
//    List<NoteEntity> searchNotes = new ArrayList<>();
//    List<Integer> pagList = new ArrayList<>();

    @GetMapping("/notes/{var}")
    public String getNotes(Model model, @PathVariable(required = false) int var) {
        List<NoteEntity> notes = new ArrayList<>();
        List<NoteEntity> subNotes = new ArrayList<>();
        List<NoteEntity> searchNotes = new ArrayList<>();
        List<Integer> pagList = new ArrayList<>();
        notes = noteService.findAll();
        Pageable page =  PageRequest.of(var,5);
        Page<NoteEntity> page1 = noteService.findallPag(page);
        subNotes = page1.toList();

        for (int i = 0; i <page1.getTotalPages(); i++) {
            pagList.add(i);
        }

        model.addAttribute("notes", subNotes);
        model.addAttribute("palest", pagList);
        return "notes";
    }

    @PostMapping("/addnotes")
    public String addNotes(@ModelAttribute NoteEntity singlenote) {
        if (!singlenote.getName().isEmpty()) {
            noteService.addNote(singlenote);
//            System.out.println(notes);
        }
        return "addnote";
    }

    @GetMapping("/addnotes")
    public String addNotesShow() {
        return "addnote";
    }

    @GetMapping("/search1/{var}")
    public String searchNotes1(Model model, @RequestParam( name = "searchName", required = false) String searchName, @PathVariable(required = false) int var) {
        List<NoteEntity> notes = new ArrayList<>();
        List<NoteEntity> subNotes = new ArrayList<>();
        List<NoteEntity> searchNotes = new ArrayList<>();
        List<Integer> pagList = new ArrayList<>();
        Pageable page = PageRequest.of(var,5);
        Page<NoteEntity> page1 = noteService.findByName(searchName,page);
        subNotes = page1.toList();

        for (int i = 0; i <page1.getTotalPages(); i++) {
            pagList.add(i);
        }


        model.addAttribute("search",searchName);
        model.addAttribute("notes", subNotes);
        model.addAttribute("palest", pagList);
        return "search";
    }
}