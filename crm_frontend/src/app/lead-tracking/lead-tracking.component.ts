import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { SignupService } from '../signup.service';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-lead-tracking',
  templateUrl: './lead-tracking.component.html',
  styleUrl: './lead-tracking.component.css'
})
export class LeadTrackingComponent {
  
  category: string = '';
  status: string = '';
  leadsId: number = 0;
  newStatus: string = '';
  salesReps: any[] = [];
  contacts: any[] = [];
  leadTrackings: any[] = [];
  allLeadTrackings: any[] = [];

  constructor(private api: SignupService,  private _router:Router,private toast:ToastrService) {}

  segmentAndAssign() {
    const requestData = {
      category: this.category,
      status: this.status
    };
    this.api.segmentAndAssign(requestData).subscribe(
      response => {
        this.toast.success('Successfully Assigned ',"SalesPerson is Assigned!")
      },
      error => {
        this.toast.error('Already Assigned',"SalesPerson is Already There!")
      }
    );
  }

  getLeadTrackingsByContactId() {
    this.api.getLeadTrackingsByContactId(this.leadsId).subscribe(
      response => {
        this.leadTrackings = response;
      },
      error => {
        this.toast.error('NOT FOUND',"Please Retry!")
      }
    );
  }

  updateLeadTrackingStatus() {
    const requestData = {
      status: this.newStatus
    };
    this.api.updateLeadTrackingStatus(this.leadsId, requestData).subscribe(
      response => {
        this.toast.success('Successfull',"Status Updated")
      },
      error => {
      
     
         this.toast.error('Invalid',"DATA NOT FOUND")
      }
    );
  }

  getSalesRepresentativesByCategory() {
    this.api.getSalesRepresentativesByCategory(this.category).subscribe(
      response => {
        this.salesReps = response;
      },
      error => {
        this.toast.error('Invalid',"DATA NOT FOUND")
      }
    );
   
  }

  getContactsByCategory() {
    this.api.getContactsByCategory(this.category).subscribe(
      response => {
        this.contacts = response;
      },
      error => {
        this.toast.error('CANT FIND',"NO CONTACT FOUND")
      }
    );
  }

  getAllLeadTrackings() {
    this.api.getAllLeadTrackings().subscribe(
      response => {
        this.allLeadTrackings = response;
      },
      error => {
        this.toast.error('CANT FIND',"NO LEADS FOUND")
      }
    );
  }
  
}
