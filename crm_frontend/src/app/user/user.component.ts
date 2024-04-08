import { Component, NgZone, OnInit } from '@angular/core';
import { SignupService } from '../signup.service';
import { ToastrService } from 'ngx-toastr';


declare global {
  interface Window {
    fwSettings: {
      widget_id: string;
    };
  }
}
@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrl: './user.component.css'
})
export class UserComponent implements OnInit {
  searchType: string = " ";
  searchValue: string = " ";
  fromDate: Date | undefined;
  toDate: Date | undefined;
  Contacts: any[] = [];// Assuming you have a Contact model defined
  userId: number | undefined;
  currentPage: number = 1;
  pageSize: number = 5; // Adjusted the page size to 5
  totalRecords: number = 0;
  selectedFormat: string = 'csv'; // Default selected format
  fetchingData: boolean = false; // Indicates whether data is being fetched
  fetchedData: boolean = false; // Indicates whether data has been fetched successfully


  constructor(private ngZone: NgZone,private api: SignupService,  private toast: ToastrService) {
    this.ngZone.runOutsideAngular(() => {
      window.fwSettings = {
        'widget_id':'1060000001082'
      };
      const script = document.createElement('script');
      script.type = 'text/javascript';
      script.async = true;
      script.src = 'https://ind-widget.freshworks.com/widgets/1060000001082.js';
      document.body.appendChild(script);
    });
  }
  ngOnInit(): void {
    const userIdFromStorage = sessionStorage.getItem('id');
    if (userIdFromStorage) {
      this.userId = +userIdFromStorage; // Convert to number
    } else {
      // Handle the case where userId is not found in session storage
      console.error('User ID not found in session storage');
    }
  }
  searchContacts(): void {
    if (this.searchType === 'date') {
      // Handle search by date logic here
    } else {
      // Handle search by category or country logic here
      if (this.userId && this.searchType && this.searchValue) {
        this.api.segmentContacts(this.userId, this.searchType, this.searchValue)
          .subscribe((Contacts: any[]) => {
            this.Contacts = Contacts;
          });
      } else {
        console.error('Invalid search parameters');
      }
    }
  }
  
}


