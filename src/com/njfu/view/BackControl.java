package com.njfu.view;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableColumn;

import com.njfu.entity.Player;
import com.njfu.model.PlayerModel;
import com.njfu.model.RanklistModel;
import com.njfu.service.PlayerService;

public class BackControl extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JPanel jp1,jp2,jp3;
	JButton jb1,jb2,jb3,jb4;
	PlayerModel pm;
	RanklistModel rm;
	JTable jt;
	JTextField jf1;
	JScrollPane jsp;
	public BackControl(final Player p){
		this.setLayout(null);
		jf1 = new JTextField();
		jf1.setBounds(230, 10, 200, 30);
		pm = new PlayerModel();
		jt = new JTable(pm);
		jsp = new JScrollPane(jt);
		TableColumn Column3 = jt.getColumnModel().getColumn(3);
		Column3.setPreferredWidth(180);
		jsp.setBounds(0, 50, 700, 200);
		jp1 = new JPanel();
		jb1 = new JButton("添加");
		jb2 = new JButton("修改");
		jb3 = new JButton("删除");
		jb4 = new JButton("查询");
		jb1.setBounds(150, 300, 60, 30);
		jb2.setBounds(250, 300, 60, 30);
		jb3.setBounds(350, 300, 60, 30);
		jb4.setBounds(450, 300, 60, 30);
		jb1.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Player p1= new Player(); 
				new AddPlayer(p1,p);
				dispose();
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				
			}
			
		});
		jb2.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				int num = jt.getSelectedRow();
				if(num == -1){
					JOptionPane.showMessageDialog(null,"请选择要修改的数据");
				}
				else{
					int id =(int)pm.getValueAt(num, 0);
					int sta = (int)pm.getValueAt(num, 4);
					if(sta == 2){
						JOptionPane.showMessageDialog(null,"禁止管理员瞎jb互删");
					}
					else {
						Player p1 = new Player();
						p1=PlayerService.selectById(id);
						new UpdatePlayer(p1,p);
						dispose();
					}
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
				
			}
			
		});
		jb3.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				int num = jt.getSelectedRow();
				if(num == -1){
					JOptionPane.showMessageDialog(null,"请选择要删除的数据");
				}
				else{
					int id =(int)pm.getValueAt(num, 0);
					int sta = (int)pm.getValueAt(num, 4);
					if(id == p.getId()){
						JOptionPane.showMessageDialog(null,"自己扇自己你是sb么");
					}
					else if(sta == 2){
						JOptionPane.showMessageDialog(null,"禁止管理员瞎jb互删");
					}
					else{
						PlayerService.deletePlayer(id);
						pm = new PlayerModel();
						jt.setModel(pm);
					}
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				
			}
			
		});	
		jb4.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				String s = jf1.getText();
				rm = new RanklistModel(s);
				jt.setModel(rm);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				
			}
			
		});
		
		this.add(jb1);
		this.add(jb2);
		this.add(jb3);
		this.add(jb4);
		this.add(jsp);
		this.add(jf1);
		this.setVisible(true);
		this.setLocation(300,200);
		this.setSize(700, 400);
		this.setTitle("后台控制");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(new ImageIcon("image/logo/ulogo.png").getImage());
	}
}
