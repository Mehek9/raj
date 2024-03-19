import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';

import { SignupService } from '../signup.service';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrl: './sidebar.component.css'
})
export class SidebarComponent implements OnInit {
  role: string | null = null;

  constructor() { }

  ngOnInit(): void {
    if (typeof sessionStorage !== 'undefined') {
      this.role = sessionStorage.getItem("role");
      console.log("role", this.role);
    }
  }
}
