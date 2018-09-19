package fr.TAA.ProjetWeekEnd;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;


enum level {Begginer,Advanced,Expert};

@Entity
public class Sport implements Serializable {
    
    @EmbeddedId
    private SportPK sportPK;
    
//    private boolean needwater;
//    private boolean needmountain;
    private Condition WeatherCondition;
    
    public Sport() {
        
    }
    
    public Sport(String name, level level, boolean needwater, boolean needmountain, Condition weatherCondition) {
        this.sportPK = new SportPK(name, level);
//        this.needwater = needwater;
//        this.needmountain = needmountain;
        WeatherCondition = weatherCondition;
    }
    
    public SportPK getSportPK() {
        return sportPK;
    }

    public void setSportPK(SportPK sportPK) {
        this.sportPK = sportPK;
    }

    public String getName() {
        return sportPK.getName();
    }

    public void setName(String name) {
        sportPK.setName(name);
    }
/*
    public boolean isNeedwater() {
        return needwater;
    }

    public void setNeedwater(boolean needwater) {
        this.needwater = needwater;
    }

    public boolean isNeedmountain() {
        return needmountain;
    }

    public void setNeedmountain(boolean needmountain) {
        this.needmountain = needmountain;
    }
*/
    @ManyToOne
    public Condition getWeatherCondition() {
        return WeatherCondition;
    }

    public void setWeatherCondition(Condition weatherCondition) {
        WeatherCondition = weatherCondition;
    }
    
    public boolean isPracticable(Weather weather) {
        return WeatherCondition.isFulfilled(weather);
    }
    
    
    

}