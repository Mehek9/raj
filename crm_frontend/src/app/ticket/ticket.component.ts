import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { SignupService } from '../signup.service';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';


@Component({
  selector: 'app-ticket',
  templateUrl: './ticket.component.html',
  styleUrl: './ticket.component.css'
})
export class TicketComponent {

  ticketForm: FormGroup;
 
 
 
    constructor(private fb: FormBuilder, private api: SignupService,private _router: Router,
      private toast: ToastrService) {
      this.ticketForm = this.fb.group({
        title: ['', Validators.required],
        description: ['', Validators.required],
        status: ['OPEN']
      });
    }
   
    onSubmit(): void {
      if (this.ticketForm.valid) {
        const ticketData = this.ticketForm.value;
        this.api.createTicket(ticketData).subscribe(
          (createdTicket) => {
            console.log(ticketData);
            console.log('Ticket created successfully:', createdTicket);
            this.toast.success('Thank you',"Ticket raised Successful" );
            this.ticketForm.reset();
            this._router.navigate(['support'])
          },
          (error) => {
            console.error('Error creating ticket:', error);
          }
        );
      } else {
        console.error('Invalid form data');
      }
    }
}
