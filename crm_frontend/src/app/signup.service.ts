import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SignupService {
  BASEURL:string="http://localhost:8080/user/";
    constructor(private http:HttpClient)
     {
   
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
  }
