package coreservlets;

import javax.faces.model.*;
import java.util.*;
import java.io.*;

public class LocationBean implements Serializable {
  private String state;
  private String city;
  private boolean isCityListDisabled = true;

  public String getState() {
    return (state);
  }

  public void setState(String state) {
    this.state = state;
    isCityListDisabled = false;
  }

  public String getCity() {
    return(city);
  }

  public void setCity(String city) {
    this.city = city;
  }
  
  public boolean isCityListDisabled() {
    return(isCityListDisabled);
  }
  
  public List<SelectItem> getStates() {
    List<SelectItem> states = new ArrayList<SelectItem>();
    states.add(new SelectItem("--- Select State ---"));
    for(StateInfo stateData: StateInfo.getNearbyStates()) {
      states.add(new SelectItem(stateData.getStateName()));
    }
    return(states);
  }
  
  public SelectItem[] getCities() {
    SelectItem[] cities = { new SelectItem("--- Choose City ---")};
    if(!isCityListDisabled && (state != null)) {
      for(StateInfo stateData: StateInfo.getNearbyStates()) {
        if(state.equals(stateData.getStateName())) {
          cities = stateData.getCities();
          break;
        }
      }
    }
    return(cities);
  }
}
