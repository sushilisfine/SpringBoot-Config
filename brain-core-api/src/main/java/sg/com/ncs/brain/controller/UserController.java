package sg.com.ncs.brain.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.com.ncs.brain.generic.exceptions.BadRequestException;
import sg.com.ncs.brain.generic.exceptions.handler.ErrorCodes;

@RestController
@RequestMapping("/api")
public class UserController {

	@PostMapping("v1/import_user")
	public void create(@RequestBody Map<String, Object> person) {

	}

	@GetMapping("test")
	public void test() {
		throw new BadRequestException("sushil", ErrorCodes.BAD_REQUEST);
	}
}
