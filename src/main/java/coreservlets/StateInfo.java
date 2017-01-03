package coreservlets;

import javax.faces.model.*;

public class StateInfo {
  private String stateName;
  private SelectItem[] cities;

  public StateInfo(String stateName, SelectItem...cities) {
    this.stateName = stateName;
    this.cities = cities;
  }
  
  public String getStateName() {
    return(stateName);
  }
  
  public SelectItem[] getCities() {
    return(cities);
  }
  
  private static StateInfo[] nearbyStates = 
    { new StateInfo("Maryland", 
                    new SelectItem("<i>unknown</i>",
                                   "--- Choose City ---"),
                    new SelectItem("635815", "Baltimore"),
                    new SelectItem("57907", "Frederick"),
                    new SelectItem("57698", "Gaithersburg"),
                    new SelectItem("57402", "Rockville")),
      new StateInfo("Virginia", 
                    new SelectItem("<i>unknown</i>",
                                   "--- Choose City ---"),
                    new SelectItem("438415", "Virginia Beach"),
                    new SelectItem("231954", "Norfolk"),
                    new SelectItem("218968", "Chesapeake"),
                    new SelectItem("195965", "Arlington")),
      new StateInfo("Pennsylvania", 
                     new SelectItem("<i>unknown</i>",
                                    "--- Choose City ---"),
                    new SelectItem("1463281", "Philadelphia"),
                    new SelectItem("316718", "Pittsburgh"),
                    new SelectItem("106992", "Allentown"),
                    new SelectItem("102612", "Erie")),
      new StateInfo("New Jersey", 
                    new SelectItem("<i>unknown</i>",
                                   "--- Choose City ---"),
                    new SelectItem("280666", "Newark"),
                    new SelectItem("239614", "Jersey City"),
                    new SelectItem("149843", "Paterson"),
                    new SelectItem("125809", "Elizabeth")),
      new StateInfo("New York", 
                    new SelectItem("<i>unknown</i>",
                                   "--- Choose City ---"),
                    new SelectItem("8143197", "New York"),
                    new SelectItem("279745", "Buffalo"),
                    new SelectItem("211091", "Rochester"),
                    new SelectItem("196425", "Yonkers"))};

  public static StateInfo[] getNearbyStates() {
    return(nearbyStates);
  }
}
