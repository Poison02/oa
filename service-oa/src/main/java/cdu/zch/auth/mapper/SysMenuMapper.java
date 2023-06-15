package cdu.zch.auth.mapper;

import cdu.zch.model.system.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 菜单表 Mapper 接口
 * </p>
 *
 * @author zch
 * @since 2023-06-15
 */
@Mapper
@Repository
public interface SysMenuMapper extends BaseMapper<SysMenu> {

}
