//package ru.itis.sem.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import ru.itis.sem.models.Skill;
//import ru.itis.sem.models.User;
//import ru.itis.sem.repositories.SkillsRepository;
//import ru.itis.sem.utills.UserConverterUtill;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Controller
//public class SkillsController {
//
//    @Autowired
//    SkillsRepository skillsRepository;
//
//    @GetMapping("findBySkill")
//    public String getUsersBySkills(@RequestParam String skill, Model model){
//        List<Skill> skills = skillsRepository.findAllBySkill(skill);
//        List<Long> ids = new ArrayList<>();
//        for (int i = 0; i <skills.size() ; i++) {
//            ids.add(skills.get(i).getUser_id());
//        }
//        model.addAttribute("ids",ids);
//        return "user_skills";
//    }
//
//    @PostMapping("/addSkill")
//    public String addSkill(Skill skill, Authentication authentication){
//       User u =  UserConverterUtill.convertToUser(authentication);
//        skill.setUser_id(u.getId());
//        skillsRepository.save(skill);
//        return "redirect:/profile";
//    }
//}
