import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { SignupService } from '../signup.service';
 
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit{
  submitted = false;

  fg!: FormGroup;

  constructor(
    private fb: FormBuilder,
    private api: SignupService,
    private _router: Router,
    private toast: ToastrService
  ) {
    this.createForm();
  }
  ngOnInit(): void {}

  createForm() {
    this.fg = this.fb.group({
      'email': ['', Validators.required],
      'password': ['', Validators.required],
    });
  }

  validate(values: any) {
    this.submitted = true;
  
    if (this.fg.valid) {
      console.log(values);
  
      this.api.validate(values).subscribe(
        (resp: any) => {
          console.log(resp);
  
          if (resp.status === 'logged in') {
            // Handle successful login
          
            sessionStorage.setItem("id", resp.data.id);
            sessionStorage.setItem("email", resp.data.email);
            sessionStorage.setItem("firstname", resp.data.firstname);
            
            alert('login succesfull');
            this._router.navigate(['home']);
          } else {
            console.error('Invalid response format:', resp);
            this.toast.error('Unexpected response format', 'Login Failed');
          }
        },
        (err) => {
          console.error('HTTP error:', err);
        alert('Invalid email or password');
        }
      );
    }
  }
  
    }

 
