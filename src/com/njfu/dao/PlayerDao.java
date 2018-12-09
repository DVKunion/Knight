package com.njfu.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.njfu.entity.Player;

public class PlayerDao extends BaseDao{
	public static Player loginWithName(String account,String Password) throws SQLException {
		Player p = null;
		String sql = "select * from player where name = ? and password = ?";
		executeQuery(sql,account,Password);
		while(rs.next()){
			p = new Player();
			p.setId(rs.getInt(1));
			p.setAccount(rs.getString(2));
			p.setPassword(rs.getString(3));
			p.setPhonenum(rs.getString(4));
			p.setStation(rs.getInt(5));
			p.setGoldnum(rs.getInt(6));
			p.setDiamondnum(rs.getInt(7));
			p.setLv(rs.getInt(8));
			p.setEpx(rs.getInt(9));
			p.setSel(1);
			p.setHero();
		}
		return p;
	}
	public static Player loginWithPhone(String account,String Password) throws SQLException{
		Player p = new Player();
		String sql = "select * from player where phonenum = ? and password = ?";
		executeQuery(sql,account,Password);
		while(rs.next()){
			p.setId(rs.getInt(1));
			p.setAccount(rs.getString(2));
			p.setPassword(rs.getString(3));
			p.setPhonenum(rs.getString(4));
			p.setStation(rs.getInt(5));
			p.setGoldnum(rs.getInt(6));
			p.setDiamondnum(rs.getInt(7));
			p.setLv(rs.getInt(8));
			p.setEpx(rs.getInt(9));
			p.setSel(1);
			p.setHero();
		}
		return p;
	}
	public  static void addPlayer(Player p){
		String sql = "insert into Player (name,password,phonenum,station,goldnum,diamondnum,lv,epx) values (?,?,?,?,?,?,?,?)";
		executeUpdate(sql, p.getAccount(),p.getPassword(),p.getPhonenum(),p.getStation(),p.getGoldnum(),p.getDiamondnum(),p.getLv(),p.getEpx());
	}
	public static void deletePlayer(int id){
		String sql = "delete from Player where id = ?";
		executeUpdate(sql, id);
	}
	public static void updatePlayer(Player p){
		String sql = "update player set name = ?,password = ?,phonenum = ?,station = ?,goldnum = ?,diamondnum = ?,lv = ? ,epx = ? where id = ?";
		executeUpdate(sql, p.getAccount(),p.getPassword(),p.getPhonenum(),p.getStation(),p.getGoldnum(),p.getDiamondnum(),p.getLv(),p.getEpx(),p.getId());
	}
	public static void updateranklist(Player p,int id){
		String sql = "update rankelist set name = ?,Gold= ? where id = ?";
		executeUpdate(sql, p.getAccount(),p.getGoldnum(),id);
	}
	public static ArrayList<Player> showranklist() throws SQLException{
		ArrayList<Player> p = new ArrayList<>();
		String sql = "select * from rankelist order by Gold desc";
		executeQuery(sql);
		while(rs.next()){	
			Player p1 =new Player();
			p1.setId(rs.getInt(1));
			p1.setAccount(rs.getString(2));
			p1.setGoldnum(rs.getInt(3));
			p.add(p1);
		}
		return p;
	}
	public static List<Player> search(String name) throws SQLException{
		ArrayList<Player> list = new ArrayList<Player>();
		String sql = "select * from player where name like ?";
		executeQuery(sql,"%"+name+"%");
		while(rs.next()){
			Player p = new Player();
			p.setId(rs.getInt(1));
			p.setAccount(rs.getString(2));
			p.setId(rs.getInt(1));
			p.setAccount(rs.getString(2));
			p.setPassword(rs.getString(3));
			p.setPhonenum(rs.getString(4));
			p.setStation(rs.getInt(5));
			p.setGoldnum(rs.getInt(6));
			p.setDiamondnum(rs.getInt(7));
			p.setLv(rs.getInt(8));
			p.setEpx(rs.getInt(9));
			list.add(p);
		}
		return list;
	}
	public static boolean checkPlayer(Player p) throws SQLException{
		String sql = "select * from player";
		executeQuery(sql);
		while(rs.next()){
			if(rs.getString(2).equals(p.getAccount())){
				return false;
			}
			if(rs.getString(4).equals(p.getPhonenum())){
				return false;
			}
		}
		return true;
	}
	public static List<Player> showDatabase() throws SQLException{
		ArrayList<Player> list = new ArrayList<Player>();
		String sql = "select * from player";
		executeQuery(sql);
		while(rs.next()){
			Player p = new Player();
			p.setId(rs.getInt(1));
			p.setAccount(rs.getString(2));
			p.setPassword(rs.getString(3));
			p.setPhonenum(rs.getString(4));
			p.setStation(rs.getInt(5));
			p.setGoldnum(rs.getInt(6));
			p.setDiamondnum(rs.getInt(7));
			p.setLv(rs.getInt(8));
			p.setEpx(rs.getInt(9));
			list.add(p);
		}
		return list;
	}
	public static Player selectById(int id) throws SQLException{
		ArrayList<Player> list = new ArrayList<Player>();
		String sql = "select * from player where id = ?";
		executeQuery(sql, id);
		Player p = new Player();
		while(rs.next()){
			p.setId(rs.getInt(1));
			p.setAccount(rs.getString(2));
			p.setPassword(rs.getString(3));
			p.setPhonenum(rs.getString(4));
			p.setStation(rs.getInt(5));
			p.setGoldnum(rs.getInt(6));
			p.setDiamondnum(rs.getInt(7));
			p.setLv(rs.getInt(8));
			p.setEpx(rs.getInt(9));
			list.add(p);
		}
		return p;
	}
}
