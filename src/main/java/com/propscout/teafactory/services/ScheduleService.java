package com.propscout.teafactory.services;

import com.propscout.teafactory.models.entities.ScheduleItem;
import com.propscout.teafactory.repositories.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public List<ScheduleItem> getScheduleItems() {
        List<ScheduleItem> scheduleItems = new ArrayList<>();

        scheduleRepository.findAll().forEach(scheduleItems::add);

        return scheduleItems;
    }

    public Optional<ScheduleItem> getScheduleItemById(Long id) {

        return scheduleRepository.findById(id);

    }

    public boolean addScheduleItem(ScheduleItem scheduleItem) {

        Optional<ScheduleItem> optionalScheduleItem =
                scheduleRepository.findByMonthAndTime(scheduleItem.getMonth(), scheduleItem.getDaytime());

        if (optionalScheduleItem.isPresent()) {
            return false;
        }

        scheduleRepository.save(scheduleItem);

        return true;

    }

    public boolean updateScheduleItemById(ScheduleItem scheduleItem) {

        Optional<ScheduleItem> optionalScheduleItem = scheduleRepository.findById(scheduleItem.getId());

        if (optionalScheduleItem.isEmpty()) {
            return false;
        }

        ScheduleItem scheduleItemToUpdate = optionalScheduleItem.get();
        scheduleItemToUpdate.setCenter(scheduleItem.getCenter());
        scheduleItemToUpdate.setUser(scheduleItem.getUser());
        scheduleItemToUpdate.setDaytime(scheduleItem.getDaytime());
        scheduleItemToUpdate.setMonth(scheduleItem.getMonth());

        scheduleRepository.save(scheduleItemToUpdate);

        return true;
    }

    public void deleteScheduleItemById(Long id) {

        //Check if a schedule item with that ID exists
        if (!scheduleRepository.existsById(id)) {
            return;
        }

        //Delete the schedule item
        scheduleRepository.deleteById(id);

    }
}
