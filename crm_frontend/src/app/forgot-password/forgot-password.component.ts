import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { SignupService } from '../signup.service';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css'] // Corrected styleUrl to styleUrls
})
export class ForgotPasswordComponent {
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

  reset() {
    this.submitted = true;
    
    if (this.fg.valid) {
      const email = this.fg.get('email')?.value; // Get the email value from the form
      const password = this.fg.get('password')?.value; // Get the password value from the form
  
      this.api.reset(email, password).subscribe(
        resp => {
          console.log(resp);
          alert("your password has been successfully reset")
          // this.toast.success('Reset successful');
          this._router.navigate(['login']);
        },
        error => {
          console.log(error);
          alert("Account Not found!!! RESET FAILED")
          // this.toast.error('Account Not Found', 'Reset Failed');
        }
      );
    }
  }
   
}
