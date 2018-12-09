package com.njfu.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.njfu.entity.Player;
import com.njfu.service.PlayerService;

public class RanklistModel extends AbstractTableModel{
	ArrayList rowData,columnNames;
	PlayerService playerService = new PlayerService();
	public RanklistModel (String name){
		columnNames = new ArrayList<>();
		columnNames.add("id");
		columnNames.add("�˺�");
		columnNames.add("����");
		columnNames.add("�ֻ�");
		columnNames.add("״̬");
		columnNames.add("���");
		columnNames.add("��ʯ");
		columnNames.add("�ȼ�");
		columnNames.add("����");
		//װ����
		List <Player> list = PlayerService.showsearch(name);
		rowData = new ArrayList();
		
		for(int i = 0; i< list.size();i++){
			//�½�һ������---����
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
			//�����Ͽ���ӵ�����
			rowData.add(array);
		}
		
	}
	public int getRowCount() {
		return this.rowData.size();
	}
	public int getColumnCount() {
		return this.columnNames.size();
	}
	public Object getValueAt(int rowIndex, int columnIndex) {
		return ((ArrayList)this.rowData.get(rowIndex)).get(columnIndex);
	}
	public String getColumnName(int column) {
		return (String) this.columnNames.get(column);
	}
}
