package com.njfu.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.njfu.entity.Player;
import com.njfu.service.PlayerService;

public class PlayerModel extends AbstractTableModel{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		//定义两个集合，一个用于装表头，一个用于装数据
		ArrayList rowData,columnNames;
		PlayerService playerService = new PlayerService();
		public PlayerModel(){
			columnNames = new ArrayList<>();
			columnNames.add("id");
			columnNames.add("账号");
			columnNames.add("密码");
			columnNames.add("手机");
			columnNames.add("状态");
			columnNames.add("金币");
			columnNames.add("钻石");
			columnNames.add("等级");
			columnNames.add("经验");
			//装数据
			List <Player> list = PlayerService.showDatabase();
			rowData = new ArrayList();
			
			for(int i = 0; i< list.size();i++){
				//新建一个集合---排序
				ArrayList array = new ArrayList();
				array.add(list.get(i).getId());
				array.add(list.get(i).getAccount());
				array.add(list.get(i).getPassword());
				array.add(list.get(i).getPhonenum());
				array.add(list.get(i).getStation());
				array.add(list.get(i).getGoldnum());
				array.add(list.get(i).getDiamondnum());
				array.add(list.get(i).getLv());
				array.add(list.get(i).getEpx());
				//将集合可添加到集合
				rowData.add(array);
			}
			
		}
		@Override
		public int getRowCount() {
			return this.rowData.size();
		}
		@Override
		public int getColumnCount() {
			return this.columnNames.size();
		}
		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			return ((ArrayList)this.rowData.get(rowIndex)).get(columnIndex);
		}
		@Override
		public String getColumnName(int column) {
			return (String) this.columnNames.get(column);
		}
	
}
