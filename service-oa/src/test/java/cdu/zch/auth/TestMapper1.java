package cdu.zch.auth;

import cdu.zch.auth.mapper.SysRoleMapper;
import cdu.zch.model.system.SysRole;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * @author Zch
 * @data 2023/6/12
 **/
@SpringBootTest
@MapperScan("cdu.zch.auth.mapper")
public class TestMapper1 {

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Test
    public void test1() {
        List<SysRole> list = sysRoleMapper.selectList(null);
        System.out.println(list);
    }

    @Test
    public void test2() {
        SysRole sysRole = new SysRole();
        sysRole.setRoleName("角色管理员");
        sysRole.setRoleCode("role");
        sysRole.setDescription("啊啊啊");
        int row = sysRoleMapper.insert(sysRole);
        System.out.println(row);
    }

    @Test
    public void test3() {
        SysRole sysRole = sysRoleMapper.selectById(9);
        sysRole.setRoleCode("3");
        int row = sysRoleMapper.updateById(sysRole);
        System.out.println(row);
    }

    @Test
    public void test4() {
//        int row = sysRoleMapper.deleteById(9);
//        System.out.println(row);

        int row = sysRoleMapper.deleteBatchIds(Arrays.asList(1, 2));
        System.out.println(row);
    }

    // 条件查询
    @Test
    public void test5() {
        // 创建QueryWrapper对象,调用方法封装条件
        QueryWrapper<SysRole> wrapper = new QueryWrapper<>();
        wrapper.eq("role_name", "管理员");
        // 调用方法实现查询
        List<SysRole> list = sysRoleMapper.selectList(wrapper);
        System.out.println(list);
    }

    @Test
    public void test6() {
        LambdaQueryWrapper<SysRole> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysRole::getRoleName, "管理员");
        List<SysRole> list = sysRoleMapper.selectList(wrapper);
        System.out.println(list);
    }


}
