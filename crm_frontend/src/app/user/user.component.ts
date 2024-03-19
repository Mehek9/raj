import { Component } from '@angular/core';
import { SignupService } from '../signup.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrl: './user.component.css'
})
export class UserComponent {

  uinfo:any;
  constructor(private api:SignupService) { }
  ngOnInit(): void {
    // this.api.getcustomerdetails(sessionStorage.getItem('id'))
    // .subscribe({
    //   next:resp=>this.uinfo=resp
    }
  }


