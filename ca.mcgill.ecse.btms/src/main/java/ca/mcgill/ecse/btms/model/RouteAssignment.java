/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.1.5099.60569f335 modeling language!*/

package ca.mcgill.ecse.btms.model;
import java.sql.Date;
import java.util.*;

// line 40 "../../../../../BTMS.ump"
public class RouteAssignment
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //RouteAssignment Attributes
  private Date date;

  //RouteAssignment Associations
  private BusVehicle bus;
  private Route route;
  private BTMS bTMS;
  private List<DriverSchedule> driverSchedules;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public RouteAssignment(Date aDate, BusVehicle aBus, Route aRoute, BTMS aBTMS)
  {
    date = aDate;
    boolean didAddBus = setBus(aBus);
    if (!didAddBus)
    {
      throw new RuntimeException("Unable to create routeAssignment due to bus. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    boolean didAddRoute = setRoute(aRoute);
    if (!didAddRoute)
    {
      throw new RuntimeException("Unable to create routeAssignment due to route. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    boolean didAddBTMS = setBTMS(aBTMS);
    if (!didAddBTMS)
    {
      throw new RuntimeException("Unable to create assignment due to bTMS. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    driverSchedules = new ArrayList<DriverSchedule>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDate(Date aDate)
  {
    boolean wasSet = false;
    date = aDate;
    wasSet = true;
    return wasSet;
  }

  public Date getDate()
  {
    return date;
  }
  /* Code from template association_GetOne */
  public BusVehicle getBus()
  {
    return bus;
  }
  /* Code from template association_GetOne */
  public Route getRoute()
  {
    return route;
  }
  /* Code from template association_GetOne */
  public BTMS getBTMS()
  {
    return bTMS;
  }
  /* Code from template association_GetMany */
  public DriverSchedule getDriverSchedule(int index)
  {
    DriverSchedule aDriverSchedule = driverSchedules.get(index);
    return aDriverSchedule;
  }

  public List<DriverSchedule> getDriverSchedules()
  {
    List<DriverSchedule> newDriverSchedules = Collections.unmodifiableList(driverSchedules);
    return newDriverSchedules;
  }

  public int numberOfDriverSchedules()
  {
    int number = driverSchedules.size();
    return number;
  }

  public boolean hasDriverSchedules()
  {
    boolean has = driverSchedules.size() > 0;
    return has;
  }

  public int indexOfDriverSchedule(DriverSchedule aDriverSchedule)
  {
    int index = driverSchedules.indexOf(aDriverSchedule);
    return index;
  }
  /* Code from template association_SetOneToMany */
  public boolean setBus(BusVehicle aBus)
  {
    boolean wasSet = false;
    if (aBus == null)
    {
      return wasSet;
    }

    BusVehicle existingBus = bus;
    bus = aBus;
    if (existingBus != null && !existingBus.equals(aBus))
    {
      existingBus.removeRouteAssignment(this);
    }
    bus.addRouteAssignment(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToMany */
  public boolean setRoute(Route aRoute)
  {
    boolean wasSet = false;
    if (aRoute == null)
    {
      return wasSet;
    }

    Route existingRoute = route;
    route = aRoute;
    if (existingRoute != null && !existingRoute.equals(aRoute))
    {
      existingRoute.removeRouteAssignment(this);
    }
    route.addRouteAssignment(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToMany */
  public boolean setBTMS(BTMS aBTMS)
  {
    boolean wasSet = false;
    if (aBTMS == null)
    {
      return wasSet;
    }

    BTMS existingBTMS = bTMS;
    bTMS = aBTMS;
    if (existingBTMS != null && !existingBTMS.equals(aBTMS))
    {
      existingBTMS.removeAssignment(this);
    }
    bTMS.addAssignment(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfDriverSchedules()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public DriverSchedule addDriverSchedule(DriverSchedule.Shift aShift, Driver aDriver, BTMS aBTMS)
  {
    return new DriverSchedule(aShift, aDriver, this, aBTMS);
  }

  public boolean addDriverSchedule(DriverSchedule aDriverSchedule)
  {
    boolean wasAdded = false;
    if (driverSchedules.contains(aDriverSchedule)) { return false; }
    RouteAssignment existingAssignment = aDriverSchedule.getAssignment();
    boolean isNewAssignment = existingAssignment != null && !this.equals(existingAssignment);
    if (isNewAssignment)
    {
      aDriverSchedule.setAssignment(this);
    }
    else
    {
      driverSchedules.add(aDriverSchedule);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeDriverSchedule(DriverSchedule aDriverSchedule)
  {
    boolean wasRemoved = false;
    //Unable to remove aDriverSchedule, as it must always have a assignment
    if (!this.equals(aDriverSchedule.getAssignment()))
    {
      driverSchedules.remove(aDriverSchedule);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addDriverScheduleAt(DriverSchedule aDriverSchedule, int index)
  {  
    boolean wasAdded = false;
    if(addDriverSchedule(aDriverSchedule))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDriverSchedules()) { index = numberOfDriverSchedules() - 1; }
      driverSchedules.remove(aDriverSchedule);
      driverSchedules.add(index, aDriverSchedule);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveDriverScheduleAt(DriverSchedule aDriverSchedule, int index)
  {
    boolean wasAdded = false;
    if(driverSchedules.contains(aDriverSchedule))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDriverSchedules()) { index = numberOfDriverSchedules() - 1; }
      driverSchedules.remove(aDriverSchedule);
      driverSchedules.add(index, aDriverSchedule);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addDriverScheduleAt(aDriverSchedule, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    BusVehicle placeholderBus = bus;
    this.bus = null;
    if(placeholderBus != null)
    {
      placeholderBus.removeRouteAssignment(this);
    }
    Route placeholderRoute = route;
    this.route = null;
    if(placeholderRoute != null)
    {
      placeholderRoute.removeRouteAssignment(this);
    }
    BTMS placeholderBTMS = bTMS;
    this.bTMS = null;
    if(placeholderBTMS != null)
    {
      placeholderBTMS.removeAssignment(this);
    }
    for(int i=driverSchedules.size(); i > 0; i--)
    {
      DriverSchedule aDriverSchedule = driverSchedules.get(i - 1);
      aDriverSchedule.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "date" + "=" + (getDate() != null ? !getDate().equals(this)  ? getDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "bus = "+(getBus()!=null?Integer.toHexString(System.identityHashCode(getBus())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "route = "+(getRoute()!=null?Integer.toHexString(System.identityHashCode(getRoute())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "bTMS = "+(getBTMS()!=null?Integer.toHexString(System.identityHashCode(getBTMS())):"null");
  }
}