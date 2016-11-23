package boots.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="sport")
public class Sport implements Serializable{

		@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="sport_id")
		private int sportId;
		@Column(name="sport_name",length=45)
		private String sportName;
		@Column(name="sport_team",length=45)
		private String sportTeam;
		@Temporal(TemporalType.DATE)
		@Column(name="date_register")
		private Date dateRegister;
		@Column(name="world_cup")
		private boolean worldCup;
		
		public Sport(String sportName, String sportTeam, Date dateRegister, boolean worldCup) {
			super();
			this.sportName = sportName;
			this.sportTeam = sportTeam;
			this.dateRegister = dateRegister;
			this.worldCup = worldCup;
		}
		
		public Sport(){
			this("","",new Date(),false);
		}

		public int getSportId() {
			return sportId;
		}

		public void setSportId(int sportId) {
			this.sportId = sportId;
		}

		public String getSportName() {
			return sportName;
		}

		public void setSportName(String sportName) {
			this.sportName = sportName;
		}

		public String getSportTeam() {
			return sportTeam;
		}

		public void setSportTeam(String sportTeam) {
			this.sportTeam = sportTeam;
		}

		public Date getDateRegister() {
			return dateRegister;
		}

		public void setDateRegister(Date dateRegister) {
			this.dateRegister = dateRegister;
		}

		public boolean isWorldCup() {
			return worldCup;
		}

		public void setWorldCup(boolean worldCup) {
			this.worldCup = worldCup;
		}

		@Override
		public String toString() {
			return "Sport [sportId=" + sportId + ", sportName=" + sportName + ", sportTeam=" + sportTeam
					+ ", dateRegister=" + dateRegister + ", worldCup=" + worldCup + "]";
		}
		
		
		
		
	
}
