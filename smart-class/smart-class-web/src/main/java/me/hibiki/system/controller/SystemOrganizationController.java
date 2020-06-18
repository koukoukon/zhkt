package me.hibiki.system.controller;

import me.hibiki.system.domain.SystemOrganization;
import me.hibiki.system.service.SystemOrganizationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 高弘昆
 * @date 2020/6/18 14:07
 */
@RestController
@RequestMapping(path = "/admin/organization")
public class SystemOrganizationController {

    @Resource
    private SystemOrganizationService systemOrganizationService;
    @GetMapping(path = "/{organizationPid}")
    public List<SystemOrganization> listBySystemOrganizationPid(@PathVariable Integer organizationPid){
        return systemOrganizationService.listByOrganizationPidSystemOrganizations(organizationPid);
    }
}
