package cdu.zch.auth;

import cdu.zch.auth.mapper.SysRoleMapper;
import cdu.zch.auth.service.SysRoleService;
import cdu.zch.model.system.SysRole;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @author Zch
 * @data 2023/6/12
 **/
@SpringBootTest
@MapperScan("cdu.zch.auth.mapper")
public class TestMapper2 {

    @Resource
    private SysRoleService service;

    @Test
    public void test1() {
        List<SysRole> list = service.list();
        System.out.println(list);
    }



}
