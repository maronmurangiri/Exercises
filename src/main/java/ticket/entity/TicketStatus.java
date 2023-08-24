package ticket.entity;

import jakarta.persistence.*;
@Entity
@Table(name = "ticket_status")
public class TicketStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "status_id")
    private int statusID;

    @Column(name = "status_name")
    private String statusName;

}
