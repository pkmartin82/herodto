package com.pkm.hero.dto;

import java.util.Calendar;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.lang.time.DateUtils;

import com.pkm.hero.Constants;

@XmlRootElement
@XmlType(propOrder={"heroId", "heroName", "secretIdentity", 
		"numOthersWhoKnowSecret", "catchphrase", "universeId",
		"insertUser", "insertTime", "updateUser", "updateTime"})
public class Hero {

	private Integer heroId;
	private String heroName;
	private String secretIdentity;
	private Integer numOthersWhoKnowSecret;
	private String catchphrase;
	private Integer universeId;
	private String insertUser;
	private Date insertTime;
	private String updateUser;
	private Date updateTime;

	/**
	 * Constructors
	 */
	public Hero() {
		this.heroId = null;
		this.heroName = "Unknown Hero!";
		this.secretIdentity = "Unknown!";

		//  default the universe of this hero to the 616
		this.universeId = Constants.MARVEL_U_PROPER_ID;
	}

	public Hero(Integer heroId) {
		this();
		this.heroId = heroId;
	}
	
	public Hero(Integer heroId, String heroName) {
		this(heroId);
		this.heroName = heroName;
	}

	public Hero(Integer heroId, String heroName, String secretIdentity) {
		this(heroId, heroName);
		this.secretIdentity = secretIdentity;
	}

	/**
	 * To String!
	 */
	@Override
	public String toString() {
		String out = ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
		return (out);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((catchphrase == null) ? 0 : catchphrase.hashCode());
		result = prime * result + ((heroId == null) ? 0 : heroId.hashCode());
		result = prime * result + ((heroName == null) ? 0 : heroName.hashCode());
		result = prime * result + ((insertTime == null) ? 0 : insertTime.hashCode());
		result = prime * result + ((insertUser == null) ? 0 : insertUser.hashCode());
		result = prime * result + ((numOthersWhoKnowSecret == null) ? 0 : numOthersWhoKnowSecret.hashCode());
		result = prime * result + ((secretIdentity == null) ? 0 : secretIdentity.hashCode());
		result = prime * result + ((universeId == null) ? 0 : universeId.hashCode());
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result + ((updateUser == null) ? 0 : updateUser.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 * 
	 * Date comparison will be to the level of Seconds, not Milliseconds
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hero other = (Hero) obj;
		if (catchphrase == null) {
			if (other.catchphrase != null)
				return false;
		} else if (!catchphrase.equals(other.catchphrase))
			return false;
		if (heroId == null) {
			if (other.heroId != null)
				return false;
		} else if (!heroId.equals(other.heroId))
			return false;
		if (heroName == null) {
			if (other.heroName != null)
				return false;
		} else if (!heroName.equals(other.heroName))
			return false;
		if (insertTime == null) {
			if (other.insertTime != null)
				return false;
		} else {
			Date thisInsertTime = DateUtils.truncate(insertTime, Calendar.SECOND);
			Date otherInsertTime = DateUtils.truncate(other.insertTime, Calendar.SECOND);

			if (! thisInsertTime.equals(otherInsertTime)) {
				return false;
			}
		}
		if (insertUser == null) {
			if (other.insertUser != null)
				return false;
		} else if (!insertUser.equals(other.insertUser))
			return false;
		if (numOthersWhoKnowSecret == null) {
			if (other.numOthersWhoKnowSecret != null)
				return false;
		} else if (!numOthersWhoKnowSecret.equals(other.numOthersWhoKnowSecret))
			return false;
		if (secretIdentity == null) {
			if (other.secretIdentity != null)
				return false;
		} else if (!secretIdentity.equals(other.secretIdentity))
			return false;
		if (universeId == null) {
			if (other.universeId != null)
				return false;
		} else if (!universeId.equals(other.universeId))
			return false;
		if (updateTime == null) {
			if (other.updateTime != null)
				return false;
		} else {
			Date thisUpdateTime = DateUtils.truncate(updateTime, Calendar.SECOND);
			Date otherUpdateTime = DateUtils.truncate(other.updateTime, Calendar.SECOND);

			if (! thisUpdateTime.equals(otherUpdateTime)) {
				return false;
			}
		}
		if (updateUser == null) {
			if (other.updateUser != null)
				return false;
		} else if (!updateUser.equals(other.updateUser))
			return false;
		return true;
	}

	/**
	 * @return the heroId
	 */
	public Integer getHeroId() {
		return heroId;
	}

	/**
	 * @param heroId the heroId to set
	 */
	public void setHeroId(Integer heroId) {
		this.heroId = heroId;
	}

	/**
	 * @return the heroName
	 */
	public String getHeroName() {
		return heroName;
	}
	/**
	 * @param heroName the heroName to set
	 */
	public void setHeroName(String heroName) {
		this.heroName = heroName;
	}
	/**
	 * @return the secretIdentity
	 */
	public String getSecretIdentity() {
		return secretIdentity;
	}
	/**
	 * @param secretIdentity the secretIdentity to set
	 */
	public void setSecretIdentity(String secretIdentity) {
		this.secretIdentity = secretIdentity;
	}

	/**
	 * @return the numOthersWhoKnowSecret
	 */
	public Integer getNumOthersWhoKnowSecret() {
		return numOthersWhoKnowSecret;
	}

	/**
	 * @param numOthersWhoKnowSecret the numOthersWhoKnowSecret to set
	 */
	public void setNumOthersWhoKnowSecret(Integer numOthersWhoKnowSecret) {
		this.numOthersWhoKnowSecret = numOthersWhoKnowSecret;
	}

	/**
	 * @return the catchphrase
	 */
	public String getCatchphrase() {
		return catchphrase;
	}

	/**
	 * @param catchphrase the catchphrase to set
	 */
	public void setCatchphrase(String catchphrase) {
		this.catchphrase = catchphrase;
	}

	/**
	 * @return the universeId
	 */
	public Integer getUniverseId() {
		return universeId;
	}

	/**
	 * @param universeId the universeId to set
	 */
	public void setUniverseId(Integer universeId) {
		this.universeId = universeId;
	}

	/**
	 * @return the insertUser
	 */
	public String getInsertUser() {
		return insertUser;
	}

	/**
	 * @param insertUser the insertUser to set
	 */
	public void setInsertUser(String insertUser) {
		this.insertUser = insertUser;
	}

	/**
	 * @return the insertTime
	 */
	public Date getInsertTime() {
		return insertTime;
	}

	/**
	 * @param insertTime the insertTime to set
	 */
	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}

	/**
	 * @return the updateUser
	 */
	public String getUpdateUser() {
		return updateUser;
	}

	/**
	 * @param updateUser the updateUser to set
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	/**
	 * @return the updateTime
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * @param updateTime the updateTime to set
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	
}
