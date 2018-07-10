package com.hexa.controller;


import com.hexa.service.MockMapping;
import com.hexa.service.ServiceProvider;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ManageServiceController {

    @Autowired
    ServiceProvider serviceProvider;

    @ApiOperation("Return manage thymeleaf template")
    @RequestMapping(value = "/manage", method = RequestMethod.GET)
    public String manage(Model model) {
        List<MockMapping> mockMappings = serviceProvider.getServices();
        model.addAttribute("stubs", mockMappings);
        return "manage";
    }

    @ApiOperation("Delete mock service")
    @ResponseBody
    @RequestMapping(value = "/service/{uuid}", method = RequestMethod.DELETE)
    public void deleteService(@PathVariable("uuid") String uuid) {
        serviceProvider.deleteService(uuid);
    }

}
