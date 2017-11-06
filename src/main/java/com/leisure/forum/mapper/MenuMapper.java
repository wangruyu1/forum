package com.leisure.forum.mapper;

import com.leisure.forum.entity.Menu;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface MenuMapper extends Mapper<Menu> {
	List<Menu> queryByIds(@Param("ids") List<Long> ids);
}