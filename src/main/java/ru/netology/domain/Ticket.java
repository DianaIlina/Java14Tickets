package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Ticket implements Comparable<Ticket> {
    private int id;
    private int price;
    private String airportDeparture;
    private String airportArrival;
    private int timeOfFlight;


    @Override
    public int compareTo(Ticket o) {
        //Ticket ticket = (Ticket) o;
        return this.price - o.price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return id == ticket.id && price == ticket.price && timeOfFlight == ticket.timeOfFlight && Objects.equals(airportDeparture, ticket.airportDeparture) && Objects.equals(airportArrival, ticket.airportArrival);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, airportDeparture, airportArrival, timeOfFlight);
    }
}
