package cn.itcast.mall.service;

import cn.itcast.mall.common.domain.DataGridResult;
import cn.itcast.mall.domain.TbItem;

public interface ItemService {

	TbItem getItemById(long itemId);

	DataGridResult getItemListDataGrid(int page, int rows);
}
