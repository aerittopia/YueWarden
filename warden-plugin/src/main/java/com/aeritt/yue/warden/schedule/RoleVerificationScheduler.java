package com.aeritt.yue.warden.schedule;

import com.aeritt.yue.api.Scheduler;
import com.aeritt.yue.warden.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
public class RoleVerificationScheduler {
	private final RoleService roleService;

	@Autowired
	public RoleVerificationScheduler(RoleService roleService, Scheduler scheduler) {
		this.roleService = roleService;

		scheduler.scheduleAtFixedRate(this::verifyRoles, 0, 1, TimeUnit.HOURS, Optional.empty());
	}

	private void verifyRoles() {

	}
}
