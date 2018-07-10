package com.hexa.controller;

import com.hexa.service.MockMapping;
import com.hexa.service.Service;
import com.hexa.service.ServiceProvider;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/service")
@Controller
public class ServiceCreatorController {

    @Autowired
    ServiceProvider serviceProvider;


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String service(Model model) {
        model.addAttribute(new Service());
        model.addAttribute("method", "GET");
        model.addAttribute("hosturl", "http://localhost:8080");
        return "service";
    }

    @ApiOperation("Create Service dynamic")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @PostMapping("/add")
    public String createService(@RequestBody Service requestBody) throws Exception {
        serviceProvider.createService(requestBody);
        return "service";
    }

    @ApiOperation("Get all mock APIs")
    @ResponseBody
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<MockMapping> getServices() {

        return serviceProvider.getServices();
    }
}