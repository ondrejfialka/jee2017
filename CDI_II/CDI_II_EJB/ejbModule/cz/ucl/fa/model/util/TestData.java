package cz.ucl.fa.model.util;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import cz.ucl.fa.model.Holiday;

@ApplicationScoped
@Named
public class TestData {
    List<Holiday> allHolidays = new ArrayList<Holiday>();

    public TestData() {
        
    }

    public List<Holiday> getAllHolidays() {
        return allHolidays;
    }

    public Holiday getHolidayById(Long id) {
        for (Holiday h : allHolidays) {
            if (h.getId().equals(id)) {
                return h;
            }
        }

        return null;
    }
 
    
    @Inject
    private void initData() {
          
        Holiday h1 = new Holiday();
        h1.setId(1);
        h1.setName("Holiday 1");
        h1.setPrice(10.0d);
        allHolidays.add(h1);

        Holiday h2 = new Holiday();
        h2.setId(2);
        h2.setName("Holiday 2");
        h2.setPrice(15.0d);
        allHolidays.add(h2);

        Holiday h3 = new Holiday();
        h3.setId(3);
        h3.setName("Holiday 3");
        h3.setPrice(25.0d);
        allHolidays.add(h3);
    }
}
