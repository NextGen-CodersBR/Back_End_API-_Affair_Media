package com.Illusion0DEV.API.Controller;

import ch.qos.logback.core.model.Model;

import com.Illusion0DEV.Application.Utils.Rest_Exception;
import com.Illusion0DEV.Domain.Entities.tb_int_interest;
import com.Illusion0DEV.Domain.Entities.tb_pht_photo;
import com.Illusion0DEV.Domain.Entities.tb_usr_user;
import com.Illusion0DEV.Domain.Interface.Service.file_service;
import com.Illusion0DEV.Domain.Interface.Service.interest_service;
import com.Illusion0DEV.Domain.Interface.Service.photo_service;
import com.Illusion0DEV.Domain.Interface.Service.user_service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@RestController
public class user_controller {

    @Autowired
    public user_service user_service;

    @Autowired
    public photo_service photo_service;

    @Autowired
    public interest_service interest_service;

    @Autowired
    public file_service file_service;

    @NotNull
    @RequestMapping("/api/signup")
    public String sign_up(HttpServletRequest request, Model model, @ModelAttribute tb_usr_user user,
                          @RequestParam("photo") MultipartFile[] photoFiles,
                          @RequestParam("interest_tag") String interest_tag,
                          HttpSession session) {
        List<String> messages = new ArrayList<>();
        tb_usr_user current_user = (tb_usr_user) session.getAttribute("usr_user");

        if (current_user == null) {
            return "redirect:/";
        }

        try {
            if (user.get_usr_first_name() == null || user.get_usr_last_name() == null) {
                throw new Rest_Exception("First name and last name are required.");
            }
            current_user.set_usr_first_name(user.get_usr_first_name());
            current_user.set_usr_last_name(user.get_usr_last_name());
            current_user.set_usr_birthday(user.get_usr_birthday());
            current_user.set_usr_gender(user.get_usr_gender());

            for (MultipartFile photo_file : photoFiles) {
                if (photo_file.isEmpty()) continue;

                file_service.save_image(photo_file);
                String photoPath = "/Upload/image/" + photo_file.getOriginalFilename();

                tb_pht_photo photo = new tb_pht_photo();
                photo.set_pht_link(photoPath);
                photo.set_pht_user(current_user);
                photo_service.add_photo(photo);
            }

            List<tb_int_interest> interests = interest_service.find(interest_tag);
            current_user.set_usr_interest(interests);
            current_user.set_usr_first_login(true);

            user_service.save_or_update(current_user);
            messages.add("Sign-up successful!");

        } catch (Exception e) {
            if (e instanceof Rest_Exception) {
                messages.add(e.getMessage());
            } else {
                messages.add("An error occurred during sign-up.");
            }
        }

        return "redirect:/home";
    }

    @NotNull
    @PostMapping("/api/sign_in")
    public String sign_in(@RequestParam("email") String email,
                          @RequestParam("password") String password,
                          HttpSession session) {
        try {
            tb_usr_user user = user_service.find_user_by_email(email);

            if (user == null) {
                throw new Rest_Exception("Email not found");
            }

            Optional<tb_usr_user> user_by_password = user_service.find_user_by_password(password);
            if (user_by_password.isEmpty() || !user_by_password.get().get_usr_email().equals(user.get_usr_email())) {
                throw new Rest_Exception("Incorrect password");
            }

            session.setAttribute("usr_user", user);

            return "redirect:/home";

        } catch (Rest_Exception e) {
            return "redirect:/?error=" + e.getMessage();
        }
    }

    @NotNull
    @GetMapping("/api/sign_out")
    public String sign_out(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
