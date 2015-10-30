/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.spring.core.htask.cinema.services;

import com.epam.spring.core.htask.cinema.models.Event;
import com.epam.spring.core.htask.cinema.models.Ticket;
import com.epam.spring.core.htask.cinema.models.User;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;

public class BookingService {

    List<Ticket> tickets;
    DiscountService discountService;

    public BookingService() {
        tickets = new CopyOnWriteArrayList<>();
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public DiscountService getDiscountService() {
        return discountService;
    }

    public void setDiscountService(DiscountService discountService) {
        this.discountService = discountService;
    }

    //Занятые места в зале 
    public Set<Integer> getLockSeatsForEvent(Event event) {
        if (tickets == null) {
            return null;
        }
        Set<Integer> lockSeats = new ConcurrentSkipListSet<>();
        for (Ticket ticket : tickets) {
            Event ev = ticket.getEvent();
            if (ev != null && ev.equals(event)) {
                lockSeats.add(ticket.getSeat());
            }
        }
        return lockSeats;
    }

    public float getTicketPrice(Event event, User user, int seat) {
        float basePrice = event.getBasePrice();
        float countDiscount = (user != null) ? discountService.verifyDiscount(user, event, tickets) : 0;
        return basePrice * (100 - countDiscount) / 100;
    }

    public float bookTicket(Event event, User user, Set<Integer> seats) {
        float sum = 0;
        Set<Integer> seatsLock = getLockSeatsForEvent(event);
            for (Integer seat : seats) {
                if (!seatsLock.contains(seat)) {
                    float price = getTicketPrice(event, user, seat);
                    Ticket newTicket = new Ticket(event, user, seat, price);
                    tickets.add(newTicket);
                    sum += price;
                }
            }
        return sum;
    }
}
