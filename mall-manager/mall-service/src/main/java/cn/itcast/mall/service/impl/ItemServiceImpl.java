package cn.itcast.mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.itcast.mall.common.domain.DataGridResult;
import cn.itcast.mall.domain.TbItem;
import cn.itcast.mall.domain.TbItemExample;
import cn.itcast.mall.mapper.TbItemMapper;
import cn.itcast.mall.service.ItemService;


/**
 * 商品管理Service
 * <p>Title: ItemServiceImpl</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.cn</p> 
 * @version 1.0
 */
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper itemMapper;
	
	@Override
	public TbItem getItemById(long itemId) {
		//根据商品id查询商品信息
		TbItem tbItem = itemMapper.selectByPrimaryKey(itemId);
		return tbItem;
	}

	@Override
	public DataGridResult getItemListDataGrid(int page, int rows) {
//		page： 页码 从1开始
//		rows:  记录
		PageHelper.startPage(page , rows);
//		执行查询
		TbItemExample example = new TbItemExample();
		List<TbItem> list = itemMapper.selectByExample(example);
//		分页结果
		PageInfo<TbItem> info = new PageInfo<>(list);
//		取总记录数
		long total = info.getTotal();
		DataGridResult result = new DataGridResult();
		// 6、设置返回结果
		result.setTotal(total);
		result.setRows(list);
		// 7、返回result
		return result;
		
		
		
		
		
		
		
		
		
	}

}
