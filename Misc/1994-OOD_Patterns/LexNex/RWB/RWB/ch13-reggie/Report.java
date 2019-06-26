import java.util.*;

public class Report {
    public Report() {
    }

    Hashtable offeringToName = new Hashtable();

    public void populateMap() throws Exception {
        Collection schedules = Schedule.all();
        for (Iterator eachSchedule = schedules.iterator(); eachSchedule.hasNext();) 
        {
            Schedule schedule = (Schedule) eachSchedule.next();

            for (Iterator each = schedule.schedule.iterator(); each.hasNext(); ) 
	    {
                Offering offering = (Offering) each.next();
                populateMapFor(schedule, offering);
            }
        }
    }

    private void populateMapFor(Schedule schedule, Offering offering) {
        ArrayList list = (ArrayList) offeringToName.get(new Integer(offering.getId()));
        if (list == null) {
            list = new ArrayList();
            offeringToName.put(new Integer(offering.getId()), list);
        }
        list.add(schedule.name);
    }

    public void writeOffering(StringBuffer buffer, ArrayList list, Offering offering) 
    {
        buffer.append(offering.getCourse().getName() + " "
                    + offering.getDaysTimes() + "\n");

        for (Iterator iterator = list.iterator(); iterator.hasNext();)
	{
            String s = (String) iterator.next();
            buffer.append("\t" + s + "\n");
        }
    }

    public void write(StringBuffer buffer) throws Exception {
        populateMap();

        Enumeration enumeration = offeringToName.keys();
        while (enumeration.hasMoreElements()) {
           Integer offeringId = (Integer) enumeration.nextElement();
           ArrayList list = (ArrayList) offeringToName.get(offeringId);
           writeOffering(buffer, list, 
               Offering.find(offeringId.intValue()));
        }

        buffer.append("Number of scheduled offerings: ");
        buffer.append(offeringToName.size());
        buffer.append("\n");
    }
}
