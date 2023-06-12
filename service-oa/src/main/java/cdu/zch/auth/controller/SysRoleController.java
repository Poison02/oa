package cdu.zch.auth.controller;

import cdu.zch.auth.service.SysRoleService;
import cdu.zch.model.system.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Zch
 * @data 2023/6/12
 **/
@RestController
@RequestMapping("/admin/system/sysRole")
public class SysRoleController {

    @Autowired
    private SysRoleService service;

    // 查询所有的角色
    @GetMapping("/findAll")
    public List<SysRole> findAll() {
        // 调用service方法
        List<SysRole> list = service.list();
        return list;
    }

}
