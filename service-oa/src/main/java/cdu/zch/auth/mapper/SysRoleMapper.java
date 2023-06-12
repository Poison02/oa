package cdu.zch.auth.mapper;

import cdu.zch.model.system.SysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author Zch
 * @data 2023/6/12
 **/
@Mapper
@Repository
public interface SysRoleMapper extends BaseMapper<SysRole> {
}
