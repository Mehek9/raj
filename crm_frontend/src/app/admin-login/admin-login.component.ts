import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { SignupService } from '../signup.service';

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrl: './admin-login.component.css'
})
export class AdminLoginComponent {

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
      'username': ['', Validators.required],
      'password': ['', Validators.required],
    });
  }

  validateadmin(values: any) {
    this.submitted = true;
  
    if (this.fg.valid) {
      console.log(values);
  
      this.api.validateadmin(values).subscribe(
        (resp: any) => {
          console.log(resp);
  
          if (resp.status === 'logged in') {
            // Handle successful login
          
            sessionStorage.setItem("id", resp.data.id);
            sessionStorage.setItem("username", resp.data.username);
            sessionStorage.setItem("password", resp.data.password);
            sessionStorage.setItem("role","A")
         
            this.toast.success('Welcome '+'Admin',"Login Successful" );
            this._router.navigate(['admin']);
          } else {
            console.error('Invalid response format:', resp);
            
            this.toast.error('Unexpected response format', 'Login Failed',{ timeOut: 2000 });
          }
        },
        (err) => {
          console.error('HTTP error:', err);
    
          this.toast.error('Invalid userid or password', 'Login Failed');
        }
      );
    }
  }
  
    }

 




