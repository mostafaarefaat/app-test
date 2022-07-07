package com.example.demo.restcontroller;

import com.example.demo.service.DownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class TestRestController {

	@Value("${app.version:v1}")
	private String version;

	@Autowired
	DownloadService downloadService;

	@GetMapping("/get")
	public String getMethod() {
		return "app rest connected new build " + version;
	}

	@GetMapping("/download")
	public void download() {
		downloadService.download();
	}


}
