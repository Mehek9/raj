import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { SignupService } from '../signup.service';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css'] // Corrected styleUrl to styleUrls
})
export class ForgotPasswordComponent implements OnInit {

  fg!:FormGroup;
  email!: string;
  otp!: string;
  newPassword!: string;
  otpSent: boolean = false;
  otpValidationSuccess = false;
  errorMessage!: string;
  submitted: boolean | undefined;
  constructor(private api: SignupService,private _router:Router, private toast: ToastrService,private formBuilder: FormBuilder) { }
  ngOnInit(): void {
    this.fg = this.formBuilder.group({
      email: ['', [Validators.required, Validators.email]],
      // Add more form controls as needed
      
    });
    
  }

  forgotPassword(): void {
    this.submitted=true;
    this.api.forgotPassword(this.email).subscribe(
      (resp: any) => {
        this.toast.success('Welcome ',"otp sent successfully" );
        console.log('OTP sent successfully',resp);
        
        this.otpSent = true;
        // Handle success (e.g., show message to user)
      },
      error => {
        console.error('Error sending OTP:', error);
        this.toast.error('Unexpected response format', 'Error sending OTP',{ timeOut: 2000 });
        console.error('Server Response:', error.error);
        // Handle error (e.g., display error message to user)
      }
    );
  }

  validateOTP(): void {
    this.api.validateOTP(this.email, this.otp).subscribe(
      (resp: any)=> {
        console.log('OTP validated successfully',resp);
        this.toast.success('Welcome ',"otp validated successfully" );
        this.otpValidationSuccess = true;

        // Proceed with password reset UI (e.g., show input fields for new password)
      },
      error => {
        console.error('Invalid OTP:', error);
        this.errorMessage = error.message;
        this.toast.error('Unexpected response format', 'invalid otp',{ timeOut: 2000 });
        // Handle invalid OTP (e.g., display error message to user)
      }
    );
  }

  resetPassword(): void {
    this.api.resetPassword(this.email, this.newPassword).subscribe(
      (resp: any) => {
        console.log('Password reset successfully',resp);
        this.toast.success('Welcome ',"reset Successful" );
        this._router.navigate(['login']);
        // Handle password reset success (e.g., show success message to user)
      },
      error => {
        console.error('Error resetting password:', error);
        this.toast.error('Unexpected response format', 'Login Failed',{ timeOut: 2000 });
        // Handle error (e.g., display error message to user)
      }
    );
  }
   


}
