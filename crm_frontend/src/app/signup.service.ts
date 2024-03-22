import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SignupService {
  BASEURL:string="http://localhost:8080/user/";
  ADMINURL:string="http://localhost:8082/admin/";
    constructor(private http:HttpClient)
     {
   
     }

     validateadmin(data:any){
       return this.http.post<any>(this.ADMINURL+"adminlogin",data);
    }

     register(data:any){
      return this.http.post<any>(this.BASEURL+"saveuser",data);
    }
    validate(data:any){
      return this.http.post<any>(this.BASEURL+"login",data);
    }
    reset(email: string, password: string){
      return this.http.put<any>(`${this.BASEURL}forgotpassword/${email}/${password}`, {});
  }
  forgotPassword(email:string): Observable<any>{
    return this.http.post(`${this.BASEURL}forgot-password`,{email},{ responseType: 'text' });
  }
  
  validateOTP(email: string, otp: string): Observable<any> {
    return this.http.post(`${this.BASEURL}validate-otp`,{email,otp},{ responseType: 'text' });
  }
  resetPassword(email: string, password: string): Observable<any> {
    return this.http.put(`${this.BASEURL}reset-password`, { email, password },{ responseType: 'text' });
  }

  getUsers(): Observable<any[]> {
    return this.http.get<any>(this.ADMINURL+"getuserdetails");
  }

  approveAccess(email: string): Observable<any> {
    return this.http.put<any>(`${this.ADMINURL}giveapproval/${email}`, {responseType: 'text'});
  }
  }
