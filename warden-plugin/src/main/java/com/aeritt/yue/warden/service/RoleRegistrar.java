package com.aeritt.yue.warden.service;

import com.aeritt.yue.warden.config.role.RoleBindConfig;
import com.aeritt.yue.warden.model.RoleLanguageBinding;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleRegistrar {
	private final RoleBindConfig roleBindConfig;

	@Autowired
	private Guild guild;

	@Autowired
	public RoleRegistrar(RoleBindConfig roleBindConfig) {
		this.roleBindConfig = roleBindConfig;

		registerRoles();
	}

	public void registerRoles() {
		for (RoleLanguageBinding binding : roleBindConfig.getRoleLanguageBindings()) {
			Role role = guild.getRoleById(binding.getRoleId());
			if (role == null) continue;

			registerRole(role);
			registerLanguageRole(role, binding.getLanguageCode());
		}
	}

	private void registerRole(Role role) {

	}

	private void registerLanguageRole(Role role, String languageCode) {
	}
}
