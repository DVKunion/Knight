package com.njfu.entity;

public class commonData {
	private String Name;	//���֣�
	private String Profession; //ְҵ
	private int LV;			//�ȼ��ӳɣ�
	private long Health_Point;	//Ѫ����
	private long Mana_Point;	//������
	private int remagic; 
	private int remagicnum;
	private int Attack_Damage;	//�����˺���
	private int Ability_Power;	//�����˺�;
	private int Armor_Num;	//�����ԣ�
	private int Magic_Resist;	//ħ�����ԣ�
	private double Miss_Attack_Pecent; //����miss��
	private double Miss_Attacked_Percent; //�ر�miss��
	private double Voilent_Pecent;//������
	private String Hitting_Rating;	//��������;
	private int Experience_Pecent;//����ֵ;
	private int speed;			//�ƶ��ٶ�;
	private int tspeed;
	private int cdA,cdArel;
	private int dis;  			//��������
	public int [] cdS = {};
	public int [] cdSrel = {};
	public int [] mananum = {};
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getLV() {
		return LV;
	}
	public void setLV(int lV) {
		LV = lV;
	}
	public long getHealth_Point() {
		return Health_Point;
	}
	public void setHealth_Point(long health_Point) {
		Health_Point = health_Point;
	}
	public long getMana_Point() {
		return Mana_Point;
	}
	public void setMana_Point(long mana_Point) {
		Mana_Point = mana_Point;
	}
	public int getAttack_Damage() {
		return Attack_Damage;
	}
	public void setAttack_Damage(int attack_Damage) {
		Attack_Damage = attack_Damage;
	}
	public int getAbility_Power() {
		return Ability_Power;
	}
	public void setAbility_Power(int ability_Power) {
		Ability_Power = ability_Power;
	}
	public int getArmor_Num() {
		return Armor_Num;
	}
	public void setArmor_Num(int armor_Num) {
		Armor_Num = armor_Num;
	}
	public int getMagic_Resist() {
		return Magic_Resist;
	}
	public void setMagic_Resist(int magic_Resist) {
		Magic_Resist = magic_Resist;
	}
	public double getMiss_Attack_Pecent() {
		return Miss_Attack_Pecent;
	}
	public void setMiss_Attack_Pecent(double miss_Attack_Pecent) {
		Miss_Attack_Pecent = miss_Attack_Pecent;
	}
	public double getMiss_Attacked_Percent() {
		return Miss_Attacked_Percent;
	}
	public void setMiss_Attacked_Percent(double miss_Attacked_Percent) {
		Miss_Attacked_Percent = miss_Attacked_Percent;
	}
	public double getVoilent_Pecent() {
		return Voilent_Pecent;
	}
	public void setVoilent_Pecent(double voilent_Pecent) {
		Voilent_Pecent = voilent_Pecent;
	}
	public String getHitting_Rating() {
		return Hitting_Rating;
	}
	public void setHitting_Rating(String hitting_Rating) {
		Hitting_Rating = hitting_Rating;
	}
	public int getExperience_Pecent() {
		return Experience_Pecent;
	}
	public void setExperience_Pecent(int experience_Pecent) {
		Experience_Pecent = experience_Pecent;
	}
	public String getProfession() {
		return Profession;
	}
	public void setProfession(String profession) {
		Profession = profession;	
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getDis() {
		return dis;
	}
	public void setDis(int dis) {
		this.dis = dis;
	}
	public int getTspeed() {
		return tspeed;
	}
	public void setTspeed(int tspeed) {
		this.tspeed = tspeed;
	}
	public int getCd() {
		return cdA;
	}
	public void setCd(int cdA) {
		this.cdA = cdA;
	}
	public int getCdrel() {
		return cdArel;
	}
	public void setCdrel(int cdrel) {
		this.cdArel = cdrel;
	}
	public int getRemagic() {
		return remagic;
	}
	public void setRemagic(int remagic) {
		this.remagic = remagic;
	}
	public int getRemagicnum() {
		return remagicnum;
	}
	public void setRemagicnum(int remagicnum) {
		this.remagicnum = remagicnum;
	}

}
