package cdu.zch.auth.mapper;

import cdu.zch.model.system.SysUserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 用户角色 Mapper 接口
 * </p>
 *
 * @author zch
 * @since 2023-06-14
 */
@Mapper
@Repository
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {

}
