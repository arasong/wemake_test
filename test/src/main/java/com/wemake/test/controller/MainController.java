package com.wemake.test.controller;

import com.wemake.test.dto.RequestDto;
import com.wemake.test.dto.ResponseDto;
import com.wemake.test.service.MainService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @Autowired
    MainService mainService;

    @GetMapping(value="/")
    public String main(Model model) {
        model.addAttribute("request", new RequestDto());
        return "mainForm";
    }

    @PostMapping(value="/print")
    public @ResponseBody ResponseDto print(@RequestBody RequestDto requestDto) throws Exception {

        return mainService.mainService(requestDto.getUrl(), requestDto.getType(),requestDto.getUnit());
    }
}
