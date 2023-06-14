package cdu.zch.auth.controller;

import cdu.zch.auth.service.SysRoleService;
import cdu.zch.auth.service.SysUserRoleService;
import cdu.zch.common.result.Result;
import cdu.zch.model.system.SysRole;
import cdu.zch.vo.system.AssginRoleVo;
import cdu.zch.vo.system.SysRoleQueryVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author Zch
 * @data 2023/6/12
 **/
@RestController
@RequestMapping("/admin/system/sysRole")
@Api(tags = "角色管理接口")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    // 1. 查询所有角色以及当前用户所属角色
    @ApiOperation(value = "根据用户获取角色数据")
    @GetMapping("/toAssign/{userId}")
    public Result toAssign(@PathVariable Long userId) {
        Map<String, Object> roleMap = sysRoleService.findRoleByUserId(userId);
        return Result.ok(roleMap);
    }

    // 2. 为用户分配角色
     @ApiOperation(value = "根据用户分配角色")
     @PostMapping("/doAssign")
     public Result doAssign(@RequestBody AssginRoleVo assginRoleVo) {
        sysRoleService.doAssign(assginRoleVo);
        return Result.ok();
    }

    @ApiOperation("查询所有角色")
    @GetMapping("/findAll")
    public Result findAll() {
        // 调用service方法
        List<SysRole> list = sysRoleService.list();
        return Result.ok(list);
    }

    // 条件分页查询 page当前页 limit 每页记录条数
    @ApiOperation("条件分页查询")
    @GetMapping("/{page}/{limit}")
    public Result pageQueryRole(@PathVariable Long page,
                                @PathVariable Long limit,
                                SysRoleQueryVo sysRoleQueryVo) {
        // 调用service方法实现
        // 1. 创建page对象，传递分页相关参数
        Page<SysRole> pageParam = new Page<>(page, limit);
        // 封装条件，判断条件是否为空，不为空进行封装
        LambdaQueryWrapper<SysRole> wrapper = new LambdaQueryWrapper<>();
        String roleName = sysRoleQueryVo.getRoleName();
        if (! StringUtils.isEmpty(roleName)) {
            // 疯转
            wrapper.like(SysRole::getRoleName, roleName);
        }
        IPage<SysRole> endPage = sysRoleService.page(pageParam, wrapper);
        return Result.ok(endPage);
    }

    // 添加角色
    @ApiOperation("添加角色")
    @PostMapping("/save")
    public Result save(@RequestBody SysRole sysRole) {
        // 调用service方法
        boolean isOk = sysRoleService.save(sysRole);
        if (isOk) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    // 修改角色
    @ApiOperation("根据id查询")
    @GetMapping("/get/{id}")
    public Result get(@PathVariable Long id) {
        SysRole sysRole = sysRoleService.getById(id);
        return Result.ok(sysRole);
    }

    @ApiOperation("修改角色")
    @PutMapping("/update")
    public Result update(@RequestBody SysRole sysRole) {
        // 调用service方法
        boolean isOk = sysRoleService.updateById(sysRole);
        if (isOk) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    // 根据id删除
    @ApiOperation("根据id删除")
    @DeleteMapping("/remove/{id}")
    public Result remove(@PathVariable Long id) {
        boolean isOK = sysRoleService.removeById(id);
        if (isOK) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    // 批量删除
    @ApiOperation("批量删除")
    @DeleteMapping("/batchRemove")
    public Result batchRemove(@RequestBody List<Long> idList) {
        boolean isOk = sysRoleService.removeByIds(idList);
        if (isOk) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

}
