package com.aeritt.yue.warden.service;

import com.aeritt.yue.api.model.UserProfile;
import com.aeritt.yue.warden.api.type.RoleCause;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
	private final Guild guild;

	@Autowired
	public RoleService(Guild guild) {
		this.guild = guild;
	}

	public void addRole(UserProfile userProfile, String roleId, RoleCause reason) {
		Member member = guild.getMemberById(userProfile.getId());
		if (member == null) return;

		Role role = guild.getRoleById(roleId);
		if (role == null) return;

		guild.addRoleToMember(member, role).queue();
	}

	public void removeRole(UserProfile userProfile, String roleId, RoleCause reason) {
		Member member = guild.getMemberById(userProfile.getId());
		if (member == null) return;

		Role role = guild.getRoleById(roleId);
		if (role == null) return;

		guild.removeRoleFromMember(member, role).queue();
	}
}
