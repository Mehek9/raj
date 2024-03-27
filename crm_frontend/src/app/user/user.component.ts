import { Component, NgZone } from '@angular/core';
import { SignupService } from '../signup.service';
declare global {
  interface Window {
    fwSettings: {
      widget_id: string;
    };
  }
}
@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrl: './user.component.css'
})
export class UserComponent {

  constructor(private ngZone: NgZone) {
    this.ngZone.runOutsideAngular(() => {
      window.fwSettings = {
        'widget_id':'1060000001082'
      };
      const script = document.createElement('script');
      script.type = 'text/javascript';
      script.async = true;
      script.src = 'https://ind-widget.freshworks.com/widgets/1060000001082.js';
      document.body.appendChild(script);
    });
  }
}


