package com.ayushi.Security;

import java.util.*;

import com.ayushi.Enum.Permission;
import com.ayushi.Enum.Role;

public class RolePermissionConfig {
	
	public static Map<Role, Set<Permission>>getRolePermission(){
		
		Map<Role, Set<Permission>>map= new HashMap<>();
		
		map.put(Role.ADMIN, new HashSet<>(Arrays.asList(Permission.ISSUE_VIEW,
				Permission.ISSUE_EDIT,
				Permission.ISSUE_CREATE,
				Permission.ISSUE_DELETE,
				Permission.ISSUE_ASSIGN,
				Permission.COMMENT_DELETE,
				Permission.WORKFLOW_TRANSACTION,
				Permission.USER_MANAGER
				)));
		
		map.put(Role.MANAGER, new HashSet<>(Arrays.asList(Permission.ISSUE_VIEW,
				Permission.ISSUE_EDIT,
				Permission.ISSUE_CREATE,
				Permission.ISSUE_ASSIGN,
				Permission.WORKFLOW_TRANSACTION)));
		
		map.put(Role.DEVELOPER, new HashSet<>(Arrays.asList(Permission.ISSUE_VIEW,
				Permission.ISSUE_EDIT,
				Permission.COMMENT_ADD)));
		
		map.put(Role.TESTER, new HashSet<>(Arrays.asList(Permission.ISSUE_VIEW,
				Permission.COMMENT_ADD)));
		
		return map;
				
	}

}
