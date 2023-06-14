package cdu.zch.auth.service;

import cdu.zch.model.system.SysRole;
import cdu.zch.vo.system.AssginRoleVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * @author Zch
 * @data 2023/6/12
 **/
public interface SysRoleService extends IService<SysRole> {

    /**
     * 根据用户获取角色数据
     * @param userId
     * @return
     */
    Map<String, Object> findRoleByUserId(Long userId);

    /**
     * 分配角色
     * @param assginRoleVo
     */
    void doAssign(AssginRoleVo assginRoleVo);

}
