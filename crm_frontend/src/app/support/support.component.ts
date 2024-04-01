import { Component } from '@angular/core';
import { SignupService } from '../signup.service';

@Component({
  selector: 'app-support',
  templateUrl: './support.component.html',
  styleUrls: ['./support.component.css'] // Use styleUrls instead of styleUrl
})
export class SupportComponent {

  tickets!: any[];

  constructor(private ticketService: SignupService) {}

  ngOnInit(): void {
    this.getTickets();
  }

  getTickets() {
    this.ticketService.getAllTickets().subscribe(
      (response: any) => {
        this.tickets = response.map((ticket: any) => {
          // Map status and priority values to their corresponding text representations
          ticket.status = this.mapStatus(ticket.status);
          ticket.priority = this.mapPriority(ticket.priority);
          return ticket;
        });
      },
      error => {
        console.error('Error occurred:', error);
      }
    );
  }

  // Helper function to map status from numeric to text representation
  private mapStatus(statusCode: number): string {
    switch (statusCode) {
      case 1: return 'Open';
      case 2: return 'Pending';
      case 3: return 'Resolved';
      case 4: return 'Closed';
      case 5: return 'Waiting on Customer';
      default: return 'Unknown';
    }
  }

  // Helper function to map priority from numeric to text representation
  private mapPriority(priorityCode: number): string {
    switch (priorityCode) {
      case 1: return 'Low';
      case 2: return 'Medium';
      case 3: return 'High';
      case 4: return 'Urgent';
      case 5: return 'Immediate';
      default: return 'Unknown';
    }
  }

}
