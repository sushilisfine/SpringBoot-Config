package sg.com.ncs.brain.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignInController {

	@GetMapping("api/v1/verify-user")
	public Map<String, String> verifyUser() {
		Map<String, String> successMap = new HashMap<>();

		successMap.put("auth", "true");

		return successMap;
	}

	@GetMapping("verify-user")
	public Map<String, String> verifyUsers() {
		Map<String, String> successMap = new HashMap<>();

		successMap.put("auth", "true");

		return successMap;
	}
}
