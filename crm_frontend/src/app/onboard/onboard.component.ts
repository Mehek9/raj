// onboard.component.ts
import { Component, OnInit } from '@angular/core';
import { SignupService } from '../signup.service';

@Component({
  selector: 'app-onboard',
  templateUrl: './onboard.component.html',
  styleUrls: ['./onboard.component.css'] // Note the correct property name 'styleUrls'
})
export class OnboardComponent implements OnInit {
  users!: any[];

  constructor(private api: SignupService) {}

  ngOnInit(): void {
    this.getUsers();
  }

  getUsers(): void {
    this.api.getUsers().subscribe(data => {
      this.users = data.map((user: any) => ({
        ...user,
        access: user.access ? 'Granted' : 'Denied'
      }));
    });
  }
}
