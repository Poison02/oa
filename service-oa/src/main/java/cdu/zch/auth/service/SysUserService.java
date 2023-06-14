package cdu.zch.auth.service;

import cdu.zch.model.system.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author zch
 * @since 2023-06-14
 */
public interface SysUserService extends IService<SysUser> {

    void updateStatus(Long id, Integer status);

}
