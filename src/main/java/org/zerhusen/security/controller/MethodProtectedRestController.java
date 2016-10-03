package org.zerhusen.security.controller;

import java.security.Principal;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("protected")
public class MethodProtectedRestController {

    /**
     * This is an example of some different kinds of granular restriction for endpoints. You can use the built-in SPEL expressions
     * in @PreAuthorize such as 'hasRole()' to determine if a user has access. Remember that the hasRole expression assumes a
     * 'ROLE_' prefix on all role names. So 'ADMIN' here is actually stored as 'ROLE_ADMIN' in database!
     **/
    @RequestMapping(method = RequestMethod.GET)
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> getProtectedGreeting() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userRole="";
                for (GrantedAuthority authority : auth.getAuthorities()) {
                    userRole = authority.getAuthority();
                }
                System.out.println("org.zerhusen.security.controller.MethodProtectedRestController.getProtectedGreeting()"+userRole+">>>>>>>");
        return ResponseEntity.ok("Greetings from admin protected method!");
    }

}