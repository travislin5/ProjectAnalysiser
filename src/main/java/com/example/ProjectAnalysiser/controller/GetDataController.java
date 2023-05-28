package com.example.ProjectAnalysiser.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProjectAnalysiser.tool.DataStructurFactory;

@RestController
@RequestMapping("/getdata")
public class GetDataController {
	@PostMapping("/json")
	public String getDataJson(@RequestBody String className) {

		System.out.println(className);

		return DataStructurFactory.eachRootStrucJson("CRUDOrderDetailsController");

	}
}
