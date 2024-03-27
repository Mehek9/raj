import { Component, NgZone, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';
import { SignupService } from './signup.service';
 

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent  implements OnInit{
  [x: string]: any;
 
selectedUserType: any;
onUserTypeChange() {
throw new Error('Method not implemented.');
}
onNavigate(arg0: any) {
throw new Error('Method not implemented.');
}
  title = 'crm_frontend';

  search: any;
  cats: any;
 
  constructor(
    private _router:Router, 
    private api:SignupService, 
    private route:ActivatedRoute,

    ) 
    { }
  
  // Use a getter method to get the role value
  get role(): string | null {
    return sessionStorage.getItem("role");
  }
 
  ngOnInit(): void {
    
    if (!this.role) {
    }
    console.log("role", this.role)
    this.route.queryParams.subscribe(p => this.search = p['search'])
   
    }
    logout() {
      sessionStorage.removeItem("role");
      this._router.navigate(['/']);
    }
    login(role: string) {
      if (role === null) {
        sessionStorage.setItem("role", "null");
      } else {
        sessionStorage.setItem("role", role);
      }
 
    }
    }

    



