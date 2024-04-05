import { Component, OnInit } from '@angular/core';
import { SignupService } from '../signup.service';

// Define the Ticket interface
interface Ticket {
  title: string;
  description: string;
  status: string;
}

@Component({
  selector: 'app-tickets',
  templateUrl: './tickets.component.html',
  styleUrls: ['./tickets.component.css']
})
export class TicketsComponent implements OnInit {
  tickets!: Ticket[];

  constructor(private api: SignupService) { }

  ngOnInit(): void {
    this.api.getAllTickets()
      .subscribe(tickets => this.tickets = tickets);
  }
}
