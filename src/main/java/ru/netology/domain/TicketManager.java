package ru.netology.domain;

import java.util.Arrays;

public class TicketManager {
    TicketRepository repository = new TicketRepository();

    public void add(Ticket ticket) {
        repository.save(ticket);
    }

    public Ticket[] searchByAirport(String from, String to) {
        Ticket[] found = new Ticket[0];

        for (Ticket ticket : repository.findAll()) {
            if (from == ticket.getAirportDeparture() && to == ticket.getAirportArrival()) {
                int length = found.length + 1;
                Ticket[] tmp = new Ticket[length];
                System.arraycopy(found, 0, tmp, 0, found.length);
                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = ticket;
                found = tmp;
            }
        }
        Arrays.sort(found);
        return found;
    }
}
