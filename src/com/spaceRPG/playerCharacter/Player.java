package com.spaceRPG.playerCharacter;

import java.util.ArrayList;

import com.spaceRPG.advancement.SkillTree;
import com.spaceRPG.items.Item;
import com.spaceRPG.overworld.entities.InteractiveEntity;
import com.spaceRPG.utils.Constants;
import com.spaceRPG.weapons.RangedOrMelee;
import com.spaceRPG.weapons.Weapon;
import com.spaceRPG.weapons.armor.Arms;
import com.spaceRPG.weapons.armor.Boots;
import com.spaceRPG.weapons.armor.Chestplate;
import com.spaceRPG.weapons.armor.Helmet;
import com.spaceRPG.weapons.armor.Leggings;
import com.spaceRPG.weapons.melee.MeleeWeapon;
import com.spaceRPG.weapons.ranged.RangedWeapon;

public class Player extends InteractiveEntity{

	private static final long serialVersionUID = -2226212653827695390L;
	
	//Stats
	//{{
	/**Player's strength*/
	private int str;
	private int strBonus;
	
	public void alterStrBonus(int alteration){
		strBonus += alteration;
	}
	
	public int getStr(){
		return str + strBonus;
	}
	
	/**Player's constitution*/
	private int con;
	private int conBonus;
	
	public void alterConBonus(int alteration){
		conBonus += alteration;
	}
	
	public int getCon(){
		return con + conBonus;
	}
	
	/**Player's agility*/
	private int agl;
	private int aglBonus;
	
	public void alterAglBonus(int alteration){
		aglBonus += alteration;
	}
	
	public int getAgl(){
		return agl + aglBonus;
	}
	
	/**Player's intelligence*/
	private int intel;
	private int intelBonus;
	
	public void alterIntelBonus(int alteration){
		intelBonus += alteration;
	}
	
	public int getIntel(){
		return intel + intelBonus;
	}
	
	/**Player's charisma*/
	private int cha;
	private int chaBonus;
	
	public void alterChaBonus(int alteration){
		chaBonus += alteration;
	}
	
	public int getCha(){
		return cha + chaBonus;
	}
	//}}
	
	//Skills
	//{{
	/**Computer skill*/
	private int comp;
	private int compBonus;
	
	public void alterCompBonus(int alteration){
		compBonus += alteration;
	}
	
	public int getComp(){
		return comp + compBonus;
	}
	
	/**Guns skill*/
	private int guns;
	private int gunsBonus;
	
	public void alterGunsBonus(int alteration){
		gunsBonus += alteration;
	}
	
	public int getGuns(){
		return guns + gunsBonus;
	}
	
	/**Explosives skill*/
	private int exp;
	private int expBonus;
	
	public void alterExpBonus(int alteration){
		expBonus += alteration;
	}
	
	public int getExp(){
		return exp + expBonus;
	}
	
	/**Melee skill*/
	private int melee;
	private int meleeBonus;
	
	public void alterMeleeBonus(int alteration){
		meleeBonus += alteration;
	}
	
	public int getMelee(){
		return melee + meleeBonus;
	}
	
	/**Armor skill*/
	private int armor;
	private int armorBonus;
	
	public void alterArmorBonus(int alteration){
		armorBonus += alteration;
	}
	
	public int getArmor(){
		return armor + armorBonus;
	}
	
	/**Medicine skill*/
	private int med;
	private int medBonus;
	
	public void alterMedBonus(int alteration){
		medBonus += alteration;
	}
	
	public int getMed(){
		return med + medBonus;
	}
	
	/**Interpersonal skill*/
	private int interpersonal;
	private int interpersonalBonus;
	
	public void alterInterpersonalBonus(int alteration){
		interpersonalBonus += alteration;
	}
	
	public int getInterpersonal(){
		return interpersonal + interpersonalBonus;
	}
	
	/**Casts skill*/
	private int casts;
	private int castsBonus;
	
	public void alterCastsBonus(int alteration){
		castsBonus += alteration;
	}
	
	public int getCasts(){
		return casts + castsBonus;
	}
//}}

	//Assorted other things
	//{{
	/**Total xp level*/
	private int xp;
	
	public void addXP(int addValue){
		xp += addValue;
	}
	
	/**Level*/
	private int level;
	
	public int getLevel(){
		return level;
	}
	
	double hp;
	
	public double getMaxHp(){
		return hp + hp * hpBonusPerc + hpBonus;
	}
	
	public double getHp(){
		return hp;
	}
	
	private double hpBonusPerc;
	private int hpBonus;
	
	private int hpRegen;
	
	public int getHpRegen(){
		return (int) (hpRegen + hpRegen * hpRegenBonusPerc + hpRegenBonus);
	}
	
	private double hpRegenBonusPerc;
	private int hpRegenBonus;
	
	private int energy;
	
	public int getEnergy(){
		return (int) (energy + energy * energyBonusPerc + energyBonus);
	}
	
	private double energyBonusPerc;
	private int energyBonus;
	
	private int energyRegen;
	
	public int getEnergyRegen(){
		return (int) (energyRegen + energyRegen * energyRegenBonusPerc + energyRegenBonus);
	}
	
	private double energyRegenBonusPerc;
	private int energyRegenBonus;
	
	private double energyCostBonus;
	private double energyCostBonusPerc;
	
	private double attackSpeedBonusPerc;
	private double meleeAttackSpeedBonusPerc;
	private double rangedAttackSpeedBonusPerc;
	
	private int attackBonus;
	
	private int meleeAttackBonus;
	
	private int rangedAttackBonus;
	
	private double damageBonus;
	
	private double rangedDamageBonus;
	
	private double meleeDamageBonus;

	//}}
	
	//Inventory
	//{{
	private Arms playerArms;
	
	public void equipArms(Arms newArms){
		if(playerArms != null){
			inventory.add(playerArms);
			
			}
		playerArms = newArms;
		}
	private Chestplate playerChestplate;
	
	public void equipChestplate(Chestplate newChestplate){
		if(playerChestplate != null){
			inventory.add(playerChestplate);
			
			}
		playerChestplate = newChestplate;
		}
	private Helmet playerHelmet;
	
	public void equipHelmet(Helmet newHelmet){
		if(playerHelmet != null){
			inventory.add(playerHelmet);
			
			}
		playerHelmet = newHelmet;
		}
	private Leggings playerLeggings;
	
	public void equipLeggings(Leggings newLeggings){
		if(playerLeggings != null){
			inventory.add(playerLeggings);
			
			}
		playerLeggings = newLeggings;
		}
	private Boots playerBoots;
	
	public void equipBoots(Boots newBoots){
		if(playerBoots != null){
			inventory.add(playerBoots);
			
			}
		playerBoots = newBoots;
		}
	
	
	
	//}}
	
	@Override
	public double getAttackSpeed(){
				double d = 0;
				if(this.getWeapon() != null){
					if(this.getWeapon().getWeaponType() == RangedOrMelee.MELEE){
						d = ((MeleeWeapon)getWeapon()).getAttackSpeed() + Constants.getStatModifier(str) / 10;
						d += d * attackSpeedBonusPerc;
						d += d * meleeAttackSpeedBonusPerc;
					}
					else if(this.getWeapon().getWeaponType() == RangedOrMelee.RANGED){
						d = ((RangedWeapon)getWeapon()).getFireRate();
						d += d * attackSpeedBonusPerc;
						d += d * rangedAttackSpeedBonusPerc;
					}
				}
				return d;

	}
	
	ArrayList<Item> inventory = new ArrayList<Item>();
	private Weapon weapon;
	
	public Player(int str, int con, int agl, int intel, int cha, int comp, int guns, int exp, 
			int melee, int armor, int med, int inter, int cast){
		this.str = str;
		this.con = con;
		this.agl = agl;
		this.intel = intel;
		this.cha = cha;
		this.comp = comp;
		this.guns = guns;
		this.exp = exp;
		this.melee = melee;
		this.armor = armor;
		this.med = med;
		this.armor = armor;
		this.interpersonal = inter;
		this.casts = cast;
	}
	
	public void adjustPercentage(int adjustedStat, double percentage){
		switch(adjustedStat){
		case(Constants.ENERGY_POOL): energyBonusPerc += percentage;
		case(Constants.ENERGY_REGEN): energyRegenBonusPerc += percentage;
		case(Constants.ENERGY_COST): energyCostBonusPerc += percentage;
		}
	}
	
	public void adjustNumber(int adjustedStat, int adjustment){
		switch(adjustedStat){
		case(Constants.ENERGY_REGEN): energyRegenBonus += adjustment;
		}
	}

	public void announce(int announcementCode){
		//TODO Add call to armor, weapons, and all other possible equipment
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		if(this.weapon != null){
			this.inventory.add(this.weapon);
		}
		this.weapon = weapon;
	}
	
	@Override
	public int getArmorRating(){
		int i = 0;
		if(this.playerChestplate != null){
			i += this.playerChestplate.getProtection();
		}
		
		if(this.playerArms != null){
			i += this.playerArms.getProtection();
		}
		
		if(this.playerLeggings != null){
			i += this.playerLeggings.getProtection();
		}
		
		if(this.playerBoots!= null){
			i += this.playerBoots.getProtection();
		}
		
		if(this.playerHelmet != null){
			i += this.playerHelmet.getProtection();
		}
		
		
		return i;
		
	}
	
	public void checkAllBonuses(){
		
	}
	
	public void clearAllBonuses(){
		//Stats
		//{{
		strBonus = 0;
		conBonus = 0;
		aglBonus = 0;
		intelBonus = 0;
		chaBonus = 0;
		//}}
		
		//Skills
		//{{
		compBonus = 0;
		gunsBonus = 0;
		expBonus = 0;
		meleeBonus = 0;
		armorBonus = 0;
		medBonus = 0;
		interpersonalBonus = 0;
		castsBonus = 0;
		//}}

		hpBonusPerc = 0;
		hpBonus = 0;
		hpRegenBonusPerc = 0;
		hpRegenBonus = 0;
		energyBonusPerc = 0;
		energyBonus = 0;
		energyRegenBonusPerc = 0;
		energyRegenBonus = 0;
		attackBonus = 0;
		meleeAttackBonus = 0;
		rangedAttackBonus = 0;
		damageBonus = 0;
		rangedDamageBonus = 0;
		meleeDamageBonus = 0;
	}
	
	private SkillTree skillTree = new SkillTree();
}
