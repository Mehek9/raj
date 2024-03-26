import { ChangeDetectorRef, Component } from '@angular/core';

import { SignupService } from '../signup.service';

@Component({
  selector: 'app-ticketstatus',
  templateUrl: './ticketstatus.component.html',
  styleUrl: './ticketstatus.component.css'
})
export class TicketstatusComponent {

  tickets!: any[];
 
  constructor(private api: SignupService,  ) {}
 
 
  ngOnInit(): void {
    this.loadTickets();
  }
 
  loadTickets(): void {
    this.api.getAllTickets().subscribe(tickets => {
      this.tickets = tickets;
    });
 
  
}
}
