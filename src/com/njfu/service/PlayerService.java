package com.njfu.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import com.njfu.dao.PlayerDao;
import com.njfu.entity.Player;
import com.njfu.exception.PasswordIsNotRightException;
import com.njfu.exception.PhonenumIsNotRightException;
import com.njfu.exception.UserIsNotExistException;
import com.njfu.exception.UserNameIsNotRightException;

public class PlayerService {
	static String usernameRedex = "^[a-zA-Z][a-zA-Z0-9_]{2,15}$";
	static String passwordRedex = "^[a-zA-Z]\\w{3,17}$";
	static String phonenumRedex = "^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])[0-9]{8}$";
	public static Boolean registPlayer(String account,String Password1,String Password2,String Phonenum) throws Exception {
		boolean usernameIsRight = Pattern.matches(usernameRedex, account);
		boolean passwordIsRight = Pattern.matches(passwordRedex, Password1);
		boolean phonenumIsRight = Pattern.matches(phonenumRedex, Phonenum);
		Player p = new Player();
		if(usernameIsRight && passwordIsRight && Password1.equals(Password2)&& phonenumIsRight ){
			p.setAccount(account);
			p.setPassword(Password1);
			p.setPhonenum(Phonenum);
			if(PlayerDao.checkPlayer(p)){
				PlayerDao.addPlayer(p);
				return true;
			}
			else{
				return false;
			}
		}
		else if(usernameIsRight == false){
			throw new UserNameIsNotRightException("用户名错误!(英文开头且至少3个字符)");
		}
		else if(passwordIsRight == false){
			throw new PasswordIsNotRightException("密码错误!(英文开头且至少6个字符)");
		}
		else if(!Password1.equals(Password2)){
			throw new PasswordIsNotRightException("两次密码不一致！");
		}
		else if(phonenumIsRight == false){
			throw new PhonenumIsNotRightException("手机号码格式错误！");
		}
		else{
			throw new Exception("输入格式错误！");
		}
	}
	public static Player loginPlayer(String account,String Password) throws Exception{
		boolean usernameIsRight = Pattern.matches(usernameRedex, account);
		boolean passwordIsRight = Pattern.matches(passwordRedex, Password);
		boolean phonenumIsRight = Pattern.matches(phonenumRedex, account);
		if(usernameIsRight && passwordIsRight){
			Player p =null;
			JOptionPane.showMessageDialog(null,"登录中...");
			try{
				p = PlayerDao.loginWithName(account,Password);
				if(p == null){
					throw new UserIsNotExistException("密码错误或用户不存在！!");
				}
				else {
					JOptionPane.showMessageDialog(null,"登陆成功");
				}
			}catch(SQLException e){
				JOptionPane.showMessageDialog(null,e.getMessage());
			}
			return p;
		}
		else if(phonenumIsRight && passwordIsRight){
			Player p =null;
			JOptionPane.showMessageDialog(null,"登录中...");
			try{
				p = PlayerDao.loginWithPhone(account,Password);
				if(p == null){
					throw new UserIsNotExistException("密码错误或用户不存在！!");
				}
				else{
					JOptionPane.showMessageDialog(null,"登陆成功");
				}
			}catch(SQLException e){
				JOptionPane.showMessageDialog(null,e.getMessage());
			}
			return p;
		}
		else if(usernameIsRight == false && phonenumIsRight == false){
			throw new UserNameIsNotRightException("用户名格式错误!");
		}
		else if(passwordIsRight == false){
			throw new PasswordIsNotRightException("密码格式错误!");
		}
		else{
			throw new Exception("输入错误！");
		}
	}
	public static List<Player> showDatabase(){
		List<Player> list = null;
		try{
			list = PlayerDao.showDatabase();
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
		return list;	
	}
	public static void addPlayer(Player p){
		if(check(p))
			PlayerDao.addPlayer(p);
		else{
			JOptionPane.showMessageDialog(null,"输入有误");
		}
	}
	public static void updataPlayer(Player p){
		if(check(p))
			PlayerDao.updatePlayer(p);
		else{
			JOptionPane.showMessageDialog(null,"输入有误");
		}
	}
	public static void deletePlayer(int id){
		PlayerDao.deletePlayer(id);
	}
	public static Player selectById(int id){
		Player p = null;
		try {
			p=PlayerDao.selectById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}
	public static void updataRanklist(Player p,int id){
		PlayerDao.updateranklist(p,id);
	}
	public static ArrayList<Player> showranklist() throws SQLException{
		ArrayList<Player> p = new ArrayList<>();		
		p = PlayerDao.showranklist();
		return p;
	}
	public static List<Player> showsearch(String name){
		List<Player> list = null;
		try{
			list = PlayerDao.search(name);
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
		return list;	
	} 
	public static boolean check(Player p){
		boolean usernameIsRight = Pattern.matches(usernameRedex, p.getAccount());
		boolean passwordIsRight = Pattern.matches(passwordRedex, p.getPassword());
		boolean phonenumIsRight = Pattern.matches(phonenumRedex, p.getPhonenum());
		boolean stationIsRight = (p.getStation() == 1 || p.getStation() == 2 || p.getStation() == 0);
		boolean goldnumIsRight = (p.getGoldnum() >=0 && p.getGoldnum() <= 999999);	
		boolean diamnumIsRight = (p.getDiamondnum() >=0 && p.getDiamondnum() <= 999999);
		if( usernameIsRight&&passwordIsRight&&phonenumIsRight&&stationIsRight&&goldnumIsRight&&diamnumIsRight)
			return true;
		else return false;
		
	}

}
