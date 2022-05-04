package ru.netology.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class TicketTest {
    Ticket ticket1 = new Ticket(1, 1299, "SVO", "KZN", 95);
    Ticket ticket2 = new Ticket(2, 2199, "VKO", "KZN", 95);

    TicketRepository repo = new TicketRepository();

    private void fillWithTickets(TicketRepository repo) {
        repo.save(ticket1);
        repo.save(ticket2);
    }

    @Test
    public void shouldAdd() {
        TicketManager manager = new TicketManager();

        fillWithTickets(manager.repository);

        Ticket ticket3 = new Ticket(3, 1099, "VKO", "KZN", 105);

        manager.add(ticket3);

        Ticket[] expected = {ticket1, ticket2, ticket3};
        Ticket[] actual = manager.repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortByPrice() {
        Ticket ticket3 = new Ticket(3, 1099, "VKO", "KZN", 105);

        Ticket [] expected = {ticket3, ticket1, ticket2};
        Ticket [] actual = {ticket1, ticket2, ticket3};

        Arrays.sort(actual);

        assertArrayEquals(expected, actual);


    }


    @Test
    public void shouldSave() {
        fillWithTickets(repo);
        Ticket[] expected = {ticket1, ticket2};
        Ticket[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        fillWithTickets(repo);

        Ticket[] expected = {ticket1};
        Ticket[] actual = repo.removeById(2);

        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldSearchByAirport() {
        TicketManager manager = new TicketManager();

        fillWithTickets(manager.repository);

        Ticket[] expected = {ticket1};
        Ticket[] actual = manager.searchByAirport("SVO", "KZN");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldUseNotFoundException() {
        fillWithTickets(repo);
        TicketRepository repo = new TicketRepository();

        assertThrows(NotFoundException.class, () -> repo.removeById(111));
    }
}
